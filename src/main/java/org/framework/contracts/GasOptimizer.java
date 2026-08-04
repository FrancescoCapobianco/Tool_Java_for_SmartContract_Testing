package org.framework.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/LFDT-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.8.0.
 */
@SuppressWarnings("rawtypes")
@Generated("org.web3j.codegen.SolidityFunctionWrapperGenerator")
public class GasOptimizer extends Contract {
    public static final String BINARY = "6080604052348015600f57600080fd5b506102958061001f6000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c80632ddbd13a146100465780632fbf2e0014610064578063bf0e640014610080575b600080fd5b61004e61009c565b60405161005b919061013b565b60405180910390f35b61007e60048036038101906100799190610187565b6100a2565b005b61009a60048036038101906100959190610187565b6100e6565b005b60005481565b600080819055506000600190505b8181116100e257806000808282546100c891906101e3565b9250508190555080806100da90610217565b9150506100b0565b5050565b600080600190505b82811161011657808261010191906101e3565b9150808061010e90610217565b9150506100ee565b50806000819055505050565b6000819050919050565b61013581610122565b82525050565b6000602082019050610150600083018461012c565b92915050565b600080fd5b61016481610122565b811461016f57600080fd5b50565b6000813590506101818161015b565b92915050565b60006020828403121561019d5761019c610156565b5b60006101ab84828501610172565b91505092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b60006101ee82610122565b91506101f983610122565b9250828201905080821115610211576102106101b4565b5b92915050565b600061022282610122565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8203610254576102536101b4565b5b60018201905091905056fea2646970667358221220f34dcec1f244d8815ed410fbf62957d1a75febc50814b64f3b5fa57ae538744f64736f6c634300081e0033\n";

    private static String librariesLinkedBinary;

    public static final String FUNC_EXPENSIVESUM = "expensiveSum";

    public static final String FUNC_OPTIMIZEDSUM = "optimizedSum";

    public static final String FUNC_TOTAL = "total";

    @Deprecated
    protected GasOptimizer(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected GasOptimizer(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected GasOptimizer(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected GasOptimizer(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> expensiveSum(BigInteger n) {
        final Function function = new Function(
                FUNC_EXPENSIVESUM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(n)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> optimizedSum(BigInteger n) {
        final Function function = new Function(
                FUNC_OPTIMIZEDSUM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(n)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> total() {
        final Function function = new Function(FUNC_TOTAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static GasOptimizer load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new GasOptimizer(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static GasOptimizer load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new GasOptimizer(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static GasOptimizer load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new GasOptimizer(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static GasOptimizer load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new GasOptimizer(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<GasOptimizer> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(GasOptimizer.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<GasOptimizer> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(GasOptimizer.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<GasOptimizer> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(GasOptimizer.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<GasOptimizer> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(GasOptimizer.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }
}
