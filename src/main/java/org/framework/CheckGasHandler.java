package org.framework;

import org.framework.ContractTester.ContractCall;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import java.math.BigInteger;

class CheckGasHandler implements TransactionHandler {
    
    private final TransactionHandler next;
    private final ContractGasProvider gasProvider;
    private BigInteger maxGasAllowed;

    public CheckGasHandler(final TransactionHandler node, final ContractGasProvider gasProvider) {
        this.next = node;
        this.gasProvider = gasProvider;
        maxGasAllowed = null;
    }

    public void setMaxGasAllowed(BigInteger gas) {
        this.maxGasAllowed = gas;
    }

    @Override
    public Object handleRequest(final ContractCall call, final String expectedReason) throws Exception {

        Object result = null;
        if (this.next != null)
            result = this.next.handleRequest(call, expectedReason);

        // Controllo Gas su TransactionReceipt:
        if (this.maxGasAllowed != null && result instanceof TransactionReceipt) {
            TransactionReceipt receipt = (TransactionReceipt) result;
            BigInteger gasUsed = receipt.getGasUsed();

            if (gasUsed.compareTo(this.maxGasAllowed) > 0)
                throw new AssertionError("Gas consumption exceed! Used: " + gasUsed + ", Allowed: " + this.maxGasAllowed);
        }

        return result;
        
    }

}