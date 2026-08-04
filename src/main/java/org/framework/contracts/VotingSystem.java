package org.framework.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public class VotingSystem extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50604051610a84380380610a848339818101604052810190610032919061015e565b336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505061019e565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b600061012b82610100565b9050919050565b61013b81610120565b811461014657600080fd5b50565b60008151905061015881610132565b92915050565b60008060408385031215610175576101746100fb565b5b600061018385828601610149565b925050602061019485828601610149565b9150509250929050565b6108d7806101ad6000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c80630121b93f1461006757806375043ebb14610083578063affc06701461008d578063c631b29214610097578063f33930d9146100a1578063f52bccad146100bf575b600080fd5b610081600480360381019061007c91906106bb565b6100dd565b005b61008b6101fa565b005b61009561030c565b005b61009f6104a0565b005b6100a9610634565b6040516100b69190610767565b60405180910390f35b6100c761065a565b6040516100d491906107a3565b60405180910390f35b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166338db6dd3336040518263ffffffff1660e01b815260040161013891906107df565b600060405180830381600087803b15801561015257600080fd5b505af1158015610166573d6000803e3d6000fd5b50505050600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166327686c1d826040518263ffffffff1660e01b81526004016101c59190610809565b600060405180830381600087803b1580156101df57600080fd5b505af11580156101f3573d6000803e3d6000fd5b5050505050565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610288576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161027f90610881565b60405180910390fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166375043ebb6040518163ffffffff1660e01b8152600401600060405180830381600087803b1580156102f257600080fd5b505af1158015610306573d6000803e3d6000fd5b50505050565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461039a576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161039190610881565b60405180910390fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663affc06706040518163ffffffff1660e01b8152600401600060405180830381600087803b15801561040457600080fd5b505af1158015610418573d6000803e3d6000fd5b50505050600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663affc06706040518163ffffffff1660e01b8152600401600060405180830381600087803b15801561048657600080fd5b505af115801561049a573d6000803e3d6000fd5b50505050565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461052e576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161052590610881565b60405180910390fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663c631b2926040518163ffffffff1660e01b8152600401600060405180830381600087803b15801561059857600080fd5b505af11580156105ac573d6000803e3d6000fd5b50505050600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663c631b2926040518163ffffffff1660e01b8152600401600060405180830381600087803b15801561061a57600080fd5b505af115801561062e573d6000803e3d6000fd5b50505050565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080fd5b6000819050919050565b61069881610685565b81146106a357600080fd5b50565b6000813590506106b58161068f565b92915050565b6000602082840312156106d1576106d0610680565b5b60006106df848285016106a6565b91505092915050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b600061072d610728610723846106e8565b610708565b6106e8565b9050919050565b600061073f82610712565b9050919050565b600061075182610734565b9050919050565b61076181610746565b82525050565b600060208201905061077c6000830184610758565b92915050565b600061078d82610734565b9050919050565b61079d81610782565b82525050565b60006020820190506107b86000830184610794565b92915050565b60006107c9826106e8565b9050919050565b6107d9816107be565b82525050565b60006020820190506107f460008301846107d0565b92915050565b61080381610685565b82525050565b600060208201905061081e60008301846107fa565b92915050565b600082825260208201905092915050565b7f4e6f74206f776e65722100000000000000000000000000000000000000000000600082015250565b600061086b600a83610824565b915061087682610835565b602082019050919050565b6000602082019050818103600083015261089a8161085e565b905091905056fea2646970667358221220fd20b46e02a78eb82791cbd21a3b790d2adbe30ae83fd07cb289f8d90f99c28c64736f6c634300081e0033\n";

    private static String librariesLinkedBinary;

    public static final String FUNC_ADDCANDIDATE = "addCandidate";

    public static final String FUNC_CLOSEVOTING = "closeVoting";

    public static final String FUNC_OPENVOTING = "openVoting";

    public static final String FUNC_VOTE = "vote";

    public static final String FUNC_RECORDER = "recorder";

    public static final String FUNC_TRACKER = "tracker";

    @Deprecated
    protected VotingSystem(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected VotingSystem(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected VotingSystem(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected VotingSystem(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addCandidate() {
        final Function function = new Function(
                FUNC_ADDCANDIDATE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> closeVoting() {
        final Function function = new Function(
                FUNC_CLOSEVOTING, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> openVoting() {
        final Function function = new Function(
                FUNC_OPENVOTING, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> vote(BigInteger candidateId) {
        final Function function = new Function(
                FUNC_VOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(candidateId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> recorder() {
        final Function function = new Function(FUNC_RECORDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> tracker() {
        final Function function = new Function(FUNC_TRACKER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static VotingSystem load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new VotingSystem(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static VotingSystem load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new VotingSystem(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static VotingSystem load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new VotingSystem(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static VotingSystem load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new VotingSystem(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<VotingSystem> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, String _trackerAddress,
            String _recorderAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _trackerAddress), 
                new org.web3j.abi.datatypes.Address(160, _recorderAddress)));
        return deployRemoteCall(VotingSystem.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<VotingSystem> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider,
            String _trackerAddress, String _recorderAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _trackerAddress), 
                new org.web3j.abi.datatypes.Address(160, _recorderAddress)));
        return deployRemoteCall(VotingSystem.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<VotingSystem> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, String _trackerAddress,
            String _recorderAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _trackerAddress), 
                new org.web3j.abi.datatypes.Address(160, _recorderAddress)));
        return deployRemoteCall(VotingSystem.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<VotingSystem> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit,
            String _trackerAddress, String _recorderAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _trackerAddress), 
                new org.web3j.abi.datatypes.Address(160, _recorderAddress)));
        return deployRemoteCall(VotingSystem.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
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
