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
public class SimplePonzi extends Contract {
    public static final String BINARY = "60806040526000600155348015601457600080fd5b506103b0806100246000396000f3fe6080604052600436106100295760003560e01c80638d68cf591461002e578063b2667cd014610038575b600080fd5b610036610063565b005b34801561004457600080fd5b5061004d6101be565b60405161005a91906101dd565b60405180910390f35b60006064600a6001546100769190610227565b6100809190610298565b60015461008d91906102c9565b90508034116100d1576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016100c89061035a565b60405180910390fd5b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555034600181905550600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16146101ba578073ffffffffffffffffffffffffffffffffffffffff166108fc349081150290604051600060405180830381858888f193505050501580156101b8573d6000803e3d6000fd5b505b5050565b60015481565b6000819050919050565b6101d7816101c4565b82525050565b60006020820190506101f260008301846101ce565b92915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000610232826101c4565b915061023d836101c4565b925082820261024b816101c4565b91508282048414831517610262576102616101f8565b5b5092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601260045260246000fd5b60006102a3826101c4565b91506102ae836101c4565b9250826102be576102bd610269565b5b828204905092915050565b60006102d4826101c4565b91506102df836101c4565b92508282019050808211156102f7576102f66101f8565b5b92915050565b600082825260208201905092915050565b7f496e76657374696d656e746f20696e73756666696369656e7465000000000000600082015250565b6000610344601a836102fd565b915061034f8261030e565b602082019050919050565b6000602082019050818103600083015261037381610337565b905091905056fea2646970667358221220d4c42008a2b1fa57586861bf0e93d03a212e04fc245c82116556fbf91f8369e764736f6c634300081e0033\n";

    private static String librariesLinkedBinary;

    public static final String FUNC_SENDFUNDS = "sendFunds";

    public static final String FUNC_CURRENTINVESTMENT = "currentInvestment";

    @Deprecated
    protected SimplePonzi(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SimplePonzi(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SimplePonzi(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SimplePonzi(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> sendFunds(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_SENDFUNDS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<BigInteger> currentInvestment() {
        final Function function = new Function(FUNC_CURRENTINVESTMENT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static SimplePonzi load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new SimplePonzi(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SimplePonzi load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SimplePonzi(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SimplePonzi load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new SimplePonzi(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SimplePonzi load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SimplePonzi(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SimplePonzi> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SimplePonzi.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<SimplePonzi> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SimplePonzi.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<SimplePonzi> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SimplePonzi.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<SimplePonzi> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SimplePonzi.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
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
