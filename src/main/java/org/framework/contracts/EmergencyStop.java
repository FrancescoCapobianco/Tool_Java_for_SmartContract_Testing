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
public class EmergencyStop extends Contract {
    public static final String BINARY = "6080604052348015600e575f5ffd5b50335f5f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506105988061005b5f395ff3fe608060405234801561000f575f5ffd5b5060043610610060575f3560e01c80631865c57d14610064578063893d20e814610082578063a69df4b5146100a0578063a6f9dae1146100aa578063a9e966b7146100c6578063f83d08ba146100e2575b5f5ffd5b61006c6100ec565b60405161007991906103cb565b60405180910390f35b61008a6100f5565b6040516100979190610423565b60405180910390f35b6100a861011c565b005b6100c460048036038101906100bf919061046a565b6101b3565b005b6100e060048036038101906100db91906104bf565b610283565b005b6100ea61031b565b005b5f600154905090565b5f5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146101aa576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016101a190610544565b60405180910390fd5b5f600281905550565b5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610241576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161023890610544565b60405180910390fd5b805f5f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610311576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161030890610544565b60405180910390fd5b8060018190555050565b5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146103a9576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016103a090610544565b60405180910390fd5b6001600281905550565b5f819050919050565b6103c5816103b3565b82525050565b5f6020820190506103de5f8301846103bc565b92915050565b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f61040d826103e4565b9050919050565b61041d81610403565b82525050565b5f6020820190506104365f830184610414565b92915050565b5f5ffd5b61044981610403565b8114610453575f5ffd5b50565b5f8135905061046481610440565b92915050565b5f6020828403121561047f5761047e61043c565b5b5f61048c84828501610456565b91505092915050565b61049e816103b3565b81146104a8575f5ffd5b50565b5f813590506104b981610495565b92915050565b5f602082840312156104d4576104d361043c565b5b5f6104e1848285016104ab565b91505092915050565b5f82825260208201905092915050565b7f4e6f74206f776e657221000000000000000000000000000000000000000000005f82015250565b5f61052e600a836104ea565b9150610539826104fa565b602082019050919050565b5f6020820190508181035f83015261055b81610522565b905091905056fea2646970667358221220e78861c5f2c1dbc4888a0e40397292eb070adcf75aef1e3661f399dfbe48518064736f6c634300081e0033\n";

    private static String librariesLinkedBinary;

    public static final String FUNC_CHANGEOWNER = "changeOwner";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_GETSTATE = "getState";

    public static final String FUNC_LOCK = "lock";

    public static final String FUNC_SETSTATE = "setState";

    public static final String FUNC_UNLOCK = "unlock";

    @Deprecated
    protected EmergencyStop(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EmergencyStop(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected EmergencyStop(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected EmergencyStop(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<TransactionReceipt> lock() {
        final Function function = new Function(
                FUNC_LOCK, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setState(BigInteger _value) {
        final Function function = new Function(
                FUNC_SETSTATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> unlock() {
        final Function function = new Function(
                FUNC_UNLOCK, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static EmergencyStop load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new EmergencyStop(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static EmergencyStop load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EmergencyStop(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static EmergencyStop load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new EmergencyStop(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static EmergencyStop load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new EmergencyStop(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<EmergencyStop> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EmergencyStop.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<EmergencyStop> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EmergencyStop.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<EmergencyStop> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EmergencyStop.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<EmergencyStop> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EmergencyStop.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
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
