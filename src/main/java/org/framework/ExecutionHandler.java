package org.framework;

import org.framework.ContractTester.ContractCall;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/** Esegue la transazione su EVM e converte i fallimenti in asserzioni JUnit */
class ExecutionHandler implements TransactionHandler {
    
    @Override
    public Object handleRequest(final ContractCall call, final String expectedReason) throws Exception {
        if (expectedReason != null) {
            executeNegativeTest(call, expectedReason);
            return null;
        }
        else
            return call.execute();  // TransactionReceipt
    }

    private void executeNegativeTest(final ContractCall call, final String expectedReason) {
        try {

            call.execute();
            fail("Test has failed: revert expected but the transaction has been successful.");

        } catch (Exception e) {
            String errorMessage = (e.getMessage() != null) ? e.getMessage() : "";
            
            boolean isRevert = errorMessage.contains("revert") || 
                               errorMessage.contains("status: 0x0") ||
                               errorMessage.contains("exceeds block gas limit");
            
            assertTrue(isRevert, "Captured Exception doesn't seem a revert.\nMessage: " + errorMessage + "\n");

            if (expectedReason != null && !expectedReason.isEmpty()) {
                
                String decodedReason = decodeRevertReason(errorMessage);
                
                if (decodedReason != null) {
                    assertEquals(expectedReason, decodedReason, 
                        "Revert reason not equal with decoded error from EVM.\n");
                } else {
                    assertTrue(errorMessage.contains(expectedReason), 
                        "Revert happened, but not for expected reason.\nExpected: '" + expectedReason + "', Found: " + decodedReason + "\n");
                }
            }
        }
    }

    private String decodeRevertReason(final String errorMessage) { 

        String errorSignature = "0x08c379a0";
        int index = errorMessage.indexOf(errorSignature);
        
        // Estrazione JSON grezzo
        if (index == -1) {
            String reasonKey = "\"reason\":\"";
            int reasonIndex = errorMessage.indexOf(reasonKey);
            if (reasonIndex != -1) {
                int start = reasonIndex + reasonKey.length();
                int end = errorMessage.indexOf("\"", start);
                if (end != -1) {
                    return errorMessage.substring(start, end);
                }
            }
            return null; // Nessun payload trovato
        }

        try {
            
            String hexData = errorMessage.substring(index).split("[^a-fA-F0-9x]")[0];
            
            String payload = hexData.substring(10);
            
            // L'ABI padding è a blocchi di 64 caratteri (32 byte):
            // - Blocco 1 [0-64]:     Offset dei dati (0x20)
            // - Blocco 2 [64-128]:   Lunghezza della stringa
            // - Blocco 3 [128 - fine]: I caratteri effettivi della stringa
            
            String lengthHex = payload.substring(64, 128);
            int stringLength = Integer.parseInt(lengthHex, 16);
            String dataHex = payload.substring(128, 128 + (stringLength * 2));
            
            // Conversione da esadecimale ad ASCII
            StringBuilder reason = new StringBuilder();
            for (int i = 0; i < dataHex.length(); i += 2) {
                String str = dataHex.substring(i, i + 2);
                reason.append((char) Integer.parseInt(str, 16));
            }
            
            return reason.toString();
            
        } catch (Exception e) {
            return null;
        }
    }

}