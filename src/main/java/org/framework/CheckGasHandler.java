package org.framework;

import org.framework.ContractTester.ContractCall;
import org.web3j.tx.gas.ContractGasProvider;

/** Anello della catena. */
public class CheckGasHandler implements TransactionHandler {
    
    private final TransactionHandler next;
    private final ContractGasProvider gasProvider;

    public CheckGasHandler(final TransactionHandler node, final ContractGasProvider gasProvider) {
        this.next = node;
        this.gasProvider = gasProvider;
    }

    @Override
    public void handleRequest(final ContractCall call, final String expectedReason) throws Exception {

        // Da aggiungere ancora: eventuale logica di controllo preventiva sul Gas.

        if (this.next != null)
            this.next.handleRequest(call, expectedReason);
        
    }

}