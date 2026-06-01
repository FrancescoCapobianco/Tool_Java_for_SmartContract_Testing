package org.framework.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
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
public class SecureVault extends Contract {
    public static final String BINARY = "6080604052348015600f57600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060008060146101000a81548160ff021916908315150217905550610886806100796000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c806362f690391161005b57806362f69039146100ec5780638380edb7146100f65780638da5cb5b14610114578063b6b55f25146101325761007d565b806312065fe01461008257806327e235e3146100a05780632e1a7d4d146100d0575b600080fd5b61008a61014e565b604051610097919061046e565b60405180910390f35b6100ba60048036038101906100b591906104ec565b610195565b6040516100c7919061046e565b60405180910390f35b6100ea60048036038101906100e59190610545565b6101ad565b005b6100f46102d7565b005b6100fe610382565b60405161010b919061058d565b60405180910390f35b61011c610395565b60405161012991906105b7565b60405180910390f35b61014c60048036038101906101479190610545565b6103b9565b005b6000600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905090565b60016020528060005260406000206000915090505481565b600060149054906101000a900460ff166101fc576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016101f39061062f565b60405180910390fd5b80600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054101561027e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016102759061069b565b60405180910390fd5b80600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282546102cd91906106ea565b9250508190555050565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610365576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161035c9061076a565b60405180910390fd5b6001600060146101000a81548160ff021916908315150217905550565b600060149054906101000a900460ff1681565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600081116103fc576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016103f3906107fc565b60405180910390fd5b80600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082825461044b919061081c565b9250508190555050565b6000819050919050565b61046881610455565b82525050565b6000602082019050610483600083018461045f565b92915050565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006104b98261048e565b9050919050565b6104c9816104ae565b81146104d457600080fd5b50565b6000813590506104e6816104c0565b92915050565b60006020828403121561050257610501610489565b5b6000610510848285016104d7565b91505092915050565b61052281610455565b811461052d57600080fd5b50565b60008135905061053f81610519565b92915050565b60006020828403121561055b5761055a610489565b5b600061056984828501610530565b91505092915050565b60008115159050919050565b61058781610572565b82525050565b60006020820190506105a2600083018461057e565b92915050565b6105b1816104ae565b82525050565b60006020820190506105cc60008301846105a8565b92915050565b600082825260208201905092915050565b7f4c61206361737361666f72746520652720636869757361000000000000000000600082015250565b60006106196017836105d2565b9150610624826105e3565b602082019050919050565b600060208201905081810360008301526106488161060c565b9050919050565b7f466f6e646920696e73756666696369656e746900000000000000000000000000600082015250565b60006106856013836105d2565b91506106908261064f565b602082019050919050565b600060208201905081810360008301526106b481610678565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b60006106f582610455565b915061070083610455565b9250828203905081811115610718576107176106bb565b5b92915050565b7f536f6c6f206c2761646d696e2070756f2073626c6f6363617265000000000000600082015250565b6000610754601a836105d2565b915061075f8261071e565b602082019050919050565b6000602082019050818103600083015261078381610747565b9050919050565b7f4c27696d706f72746f206465766520657373657265206d616767696f7265206460008201527f69207a65726f0000000000000000000000000000000000000000000000000000602082015250565b60006107e66026836105d2565b91506107f18261078a565b604082019050919050565b60006020820190508181036000830152610815816107d9565b9050919050565b600061082782610455565b915061083283610455565b925082820190508082111561084a576108496106bb565b5b9291505056fea26469706673582212205cb8864972c25ac02b437a356cd54d1a1c50ce05414b7d888f0ac77c96fcec8264736f6c634300081e0033\n";

    private static String librariesLinkedBinary;

    public static final String FUNC_DEPOSIT = "deposit";

    public static final String FUNC_UNLOCKVAULT = "unlockVault";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_BALANCES = "balances";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_ISUNLOCKED = "isUnlocked";

    public static final String FUNC_OWNER = "owner";

    @Deprecated
    protected SecureVault(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SecureVault(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SecureVault(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SecureVault(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> deposit(BigInteger _amount) {
        final Function function = new Function(
                FUNC_DEPOSIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> unlockVault() {
        final Function function = new Function(
                FUNC_UNLOCKVAULT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw(BigInteger _amount) {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balances(String param0) {
        final Function function = new Function(FUNC_BALANCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getBalance() {
        final Function function = new Function(FUNC_GETBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> isUnlocked() {
        final Function function = new Function(FUNC_ISUNLOCKED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static SecureVault load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new SecureVault(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SecureVault load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SecureVault(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SecureVault load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new SecureVault(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SecureVault load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SecureVault(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SecureVault> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SecureVault.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    public static RemoteCall<SecureVault> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SecureVault.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<SecureVault> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SecureVault.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<SecureVault> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SecureVault.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
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
