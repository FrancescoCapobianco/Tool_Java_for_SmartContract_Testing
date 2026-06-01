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
public class Authorization extends Contract {
    public static final String BINARY = "6080604052348015600e575f5ffd5b5060035f5f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f208190555061057a8061005e5f395ff3fe608060405234801561000f575f5ffd5b5060043610610060575f3560e01c806301e882081461006457806356709f6c146100945780636b5a56581461009e57806383c1cd8a146100a8578063d8ded14b146100d8578063e4d2769e146100f4575b5f5ffd5b61007e60048036038101906100799190610408565b6100fe565b60405161008b919061044b565b60405180910390f35b61009c610112565b005b6100a6610196565b005b6100c260048036038101906100bd9190610408565b61021a565b6040516100cf919061044b565b60405180910390f35b6100f260048036038101906100ed919061048e565b61025f565b005b6100fc610326565b005b5f602052805f5260405f205f915090505481565b6001805f5f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20541015610193576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161018a90610526565b60405180910390fd5b50565b6003805f5f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20541015610217576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161020e90610526565b60405180910390fd5b50565b5f5f5f8373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f20549050919050565b6003805f5f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205410156102e0576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016102d790610526565b60405180910390fd5b815f5f8573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f2081905550505050565b6002805f5f3373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205410156103a7576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161039e90610526565b60405180910390fd5b50565b5f5ffd5b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f6103d7826103ae565b9050919050565b6103e7816103cd565b81146103f1575f5ffd5b50565b5f81359050610402816103de565b92915050565b5f6020828403121561041d5761041c6103aa565b5b5f61042a848285016103f4565b91505092915050565b5f819050919050565b61044581610433565b82525050565b5f60208201905061045e5f83018461043c565b92915050565b61046d81610433565b8114610477575f5ffd5b50565b5f8135905061048881610464565b92915050565b5f5f604083850312156104a4576104a36103aa565b5b5f6104b1858286016103f4565b92505060206104c28582860161047a565b9150509250929050565b5f82825260208201905092915050565b7f5065726d697373696f6e206e6f74206772616e746564210000000000000000005f82015250565b5f6105106017836104cc565b915061051b826104dc565b602082019050919050565b5f6020820190508181035f83015261053d81610504565b905091905056fea2646970667358221220737f2144ff4b19ff8811754c52759e95a668124d3f3a181cfaef6afddf5b4f6964736f6c634300081e0033\n";

    private static String librariesLinkedBinary;

    public static final String FUNC_FUNCTIONLEVEL1 = "functionLevel1";

    public static final String FUNC_FUNCTIONLEVEL2 = "functionLevel2";

    public static final String FUNC_FUNCTIONLEVEL3 = "functionLevel3";

    public static final String FUNC_GETPERMISSION = "getPermission";

    public static final String FUNC_PERMISSIONS = "permissions";

    public static final String FUNC_SETPERMISSION = "setPermission";

    @Deprecated
    protected Authorization(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Authorization(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Authorization(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Authorization(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> functionLevel1() {
        final Function function = new Function(
                FUNC_FUNCTIONLEVEL1, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> functionLevel2() {
        final Function function = new Function(
                FUNC_FUNCTIONLEVEL2, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> functionLevel3() {
        final Function function = new Function(
                FUNC_FUNCTIONLEVEL3, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getPermission(String _user) {
        final Function function = new Function(FUNC_GETPERMISSION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _user)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> permissions(String param0) {
        final Function function = new Function(FUNC_PERMISSIONS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setPermission(String _user, BigInteger _level) {
        final Function function = new Function(
                FUNC_SETPERMISSION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _user), 
                new org.web3j.abi.datatypes.generated.Uint256(_level)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Authorization load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new Authorization(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Authorization load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Authorization(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Authorization load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new Authorization(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Authorization load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Authorization(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Authorization> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Authorization.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    public static RemoteCall<Authorization> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Authorization.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Authorization> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Authorization.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Authorization> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Authorization.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
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
