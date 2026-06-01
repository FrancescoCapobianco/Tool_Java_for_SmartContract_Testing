package org.framework.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
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
public class Migration extends Contract {
    public static final String BINARY = "6080604052348015600e575f5ffd5b50335f5f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506106f68061005b5f395ff3fe60806040526004361061004d575f3560e01c80631865c57d14610120578063893d20e81461014a57806395b8f90e14610174578063a6f9dae11461019c578063a9e966b7146101c457610054565b3661005457005b5f60025f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff165f3660405161009d929190610491565b5f60405180830381855af49150503d805f81146100d5576040519150601f19603f3d011682016040523d82523d5f602084013e6100da565b606091505b505090508061011e576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161011590610503565b60405180910390fd5b005b34801561012b575f5ffd5b506101346101ec565b6040516101419190610539565b60405180910390f35b348015610155575f5ffd5b5061015e6101f5565b60405161016b9190610591565b60405180910390f35b34801561017f575f5ffd5b5061019a600480360381019061019591906105d8565b61021c565b005b3480156101a7575f5ffd5b506101c260048036038101906101bd91906105d8565b6102ed565b005b3480156101cf575f5ffd5b506101ea60048036038101906101e5919061062d565b6103bd565b005b5f600154905090565b5f5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146102aa576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016102a1906106a2565b60405180910390fd5b8060025f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461037b576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610372906106a2565b60405180910390fd5b805f5f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461044b576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610442906106a2565b60405180910390fd5b8060018190555050565b5f81905092915050565b828183375f83830152505050565b5f6104788385610455565b935061048583858461045f565b82840190509392505050565b5f61049d82848661046d565b91508190509392505050565b5f82825260208201905092915050565b7f44656c656761746563616c6c206661696c6564000000000000000000000000005f82015250565b5f6104ed6013836104a9565b91506104f8826104b9565b602082019050919050565b5f6020820190508181035f83015261051a816104e1565b9050919050565b5f819050919050565b61053381610521565b82525050565b5f60208201905061054c5f83018461052a565b92915050565b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f61057b82610552565b9050919050565b61058b81610571565b82525050565b5f6020820190506105a45f830184610582565b92915050565b5f5ffd5b6105b781610571565b81146105c1575f5ffd5b50565b5f813590506105d2816105ae565b92915050565b5f602082840312156105ed576105ec6105aa565b5b5f6105fa848285016105c4565b91505092915050565b61060c81610521565b8114610616575f5ffd5b50565b5f8135905061062781610603565b92915050565b5f60208284031215610642576106416105aa565b5b5f61064f84828501610619565b91505092915050565b7f4e6f74206f776e657221000000000000000000000000000000000000000000005f82015250565b5f61068c600a836104a9565b915061069782610658565b602082019050919050565b5f6020820190508181035f8301526106b981610680565b905091905056fea26469706673582212209e5e9489fcb6e76935da19c60ece695aef8b33dc9967b056fd259d9ff0491b9e64736f6c634300081e0033\n";

    private static String librariesLinkedBinary;

    public static final String FUNC_CHANGEOWNER = "changeOwner";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_GETSTATE = "getState";

    public static final String FUNC_SETSTATE = "setState";

    public static final String FUNC_UPDATEREFERENCE = "updateReference";

    @Deprecated
    protected Migration(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Migration(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Migration(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Migration(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> changeOwner(String _newOwner) {
        final Function function = new Function(
                FUNC_CHANGEOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getOwner() {
        final Function function = new Function(FUNC_GETOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getState() {
        final Function function = new Function(FUNC_GETSTATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setState(BigInteger _value) {
        final Function function = new Function(
                FUNC_SETSTATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateReference(String _newContractAddress) {
        final Function function = new Function(
                FUNC_UPDATEREFERENCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _newContractAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Migration load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new Migration(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Migration load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Migration(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Migration load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new Migration(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Migration load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Migration(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Migration> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Migration.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Migration> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Migration.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<Migration> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Migration.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<Migration> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Migration.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
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
