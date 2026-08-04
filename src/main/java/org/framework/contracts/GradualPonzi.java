package org.framework.contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
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
public class GradualPonzi extends Contract {
    public static final String BINARY = "6080604052348015600f57600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506002339080600181540180825580915050600190039060005260206000200160009091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506108bc806100c26000396000f3fe6080604052600436106100555760003560e01c80636ebcf6071461005a5780637d2026af146100975780638a4660fe146100d4578063a69df4b5146100ff578063e8b5e51f14610116578063f83d08ba14610120575b600080fd5b34801561006657600080fd5b50610081600480360381019061007c9190610535565b610137565b60405161008e919061057b565b60405180910390f35b3480156100a357600080fd5b506100be60048036038101906100b991906105c2565b61014f565b6040516100cb91906105fe565b60405180910390f35b3480156100e057600080fd5b506100e961018e565b6040516100f6919061057b565b60405180910390f35b34801561010b57600080fd5b50610114610199565b005b61011e610231565b005b34801561012c57600080fd5b5061013561043b565b005b60036020528060005260406000206000915090505481565b6002818154811061015f57600080fd5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b66038d7ea4c6800081565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610227576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161021e90610676565b60405180910390fd5b6000600181905550565b600060015414610276576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161026d90610708565b60405180910390fd5b66038d7ea4c680003410156102c0576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016102b790610774565b60405180910390fd5b6000600280549050346102d391906107f2565b905060005b600280549050811015610386578160036000600284815481106102fe576102fd610823565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282546103729190610852565b9250508190555080806001019150506102d8565b506002339080600181540180825580915050600190039060005260206000200160009091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055503373ffffffffffffffffffffffffffffffffffffffff167fc3f75dfc78f6efac88ad5abb5e606276b903647d97b2a62a1ef89840a658bbc334604051610430919061057b565b60405180910390a250565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146104c9576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016104c090610676565b60405180910390fd5b60018081905550565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000610502826104d7565b9050919050565b610512816104f7565b811461051d57600080fd5b50565b60008135905061052f81610509565b92915050565b60006020828403121561054b5761054a6104d2565b5b600061055984828501610520565b91505092915050565b6000819050919050565b61057581610562565b82525050565b6000602082019050610590600083018461056c565b92915050565b61059f81610562565b81146105aa57600080fd5b50565b6000813590506105bc81610596565b92915050565b6000602082840312156105d8576105d76104d2565b5b60006105e6848285016105ad565b91505092915050565b6105f8816104f7565b82525050565b600060208201905061061360008301846105ef565b92915050565b600082825260208201905092915050565b7f4e6f74206f776e65722100000000000000000000000000000000000000000000600082015250565b6000610660600a83610619565b915061066b8261062a565b602082019050919050565b6000602082019050818103600083015261068f81610653565b9050919050565b7f54686520636f6e747261637420697320696e20656d657267656e63792073746f60008201527f7020737461746500000000000000000000000000000000000000000000000000602082015250565b60006106f2602783610619565b91506106fd82610696565b604082019050919050565b60006020820190508181036000830152610721816106e5565b9050919050565b7f496e73756666696369656e7420696e766573746d656e74000000000000000000600082015250565b600061075e601783610619565b915061076982610728565b602082019050919050565b6000602082019050818103600083015261078d81610751565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b60006107fd82610562565b915061080883610562565b92508261081857610817610794565b5b828204905092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b600061085d82610562565b915061086883610562565b92508282019050808211156108805761087f6107c3565b5b9291505056fea2646970667358221220fbe7c837f0853ffd49859192627205257b499c950ea453ae221690d77099955b64736f6c634300081e0033\n";

    private static String librariesLinkedBinary;

    public static final String FUNC_INVEST = "invest";

    public static final String FUNC_LOCK = "lock";

    public static final String FUNC_UNLOCK = "unlock";

    public static final String FUNC__BALANCES = "_balances";

    public static final String FUNC__INVESTORS = "_investors";

    public static final String FUNC_MINIMUM_INVESTMENT = "MINIMUM_INVESTMENT";

    public static final Event INVESTED_EVENT = new Event("Invested", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected GradualPonzi(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected GradualPonzi(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected GradualPonzi(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected GradualPonzi(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> invest(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_INVEST, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> lock() {
        final Function function = new Function(
                FUNC_LOCK, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static List<InvestedEventResponse> getInvestedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(INVESTED_EVENT, transactionReceipt);
        ArrayList<InvestedEventResponse> responses = new ArrayList<InvestedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InvestedEventResponse typedResponse = new InvestedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.investor = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static InvestedEventResponse getInvestedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(INVESTED_EVENT, log);
        InvestedEventResponse typedResponse = new InvestedEventResponse();
        typedResponse.log = log;
        typedResponse.investor = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<InvestedEventResponse> investedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getInvestedEventFromLog(log));
    }

    public Flowable<InvestedEventResponse> investedEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INVESTED_EVENT));
        return investedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> unlock() {
        final Function function = new Function(
                FUNC_UNLOCK, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> _balances(String param0) {
        final Function function = new Function(FUNC__BALANCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> _investors(BigInteger param0) {
        final Function function = new Function(FUNC__INVESTORS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> MINIMUM_INVESTMENT() {
        final Function function = new Function(FUNC_MINIMUM_INVESTMENT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static GradualPonzi load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new GradualPonzi(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static GradualPonzi load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new GradualPonzi(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static GradualPonzi load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new GradualPonzi(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static GradualPonzi load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new GradualPonzi(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<GradualPonzi> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(GradualPonzi.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    public static RemoteCall<GradualPonzi> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(GradualPonzi.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<GradualPonzi> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(GradualPonzi.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<GradualPonzi> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(GradualPonzi.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
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

    public static class InvestedEventResponse extends BaseEventResponse {
        public String investor;

        public BigInteger amount;
    }
}
