package pl.piomin.services.transaction.model;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class CentralContract extends Contract {
    private static final String BINARY = "60c0604052600a60808190527f54657374536368656d650000000000000000000000000000000000000000000060a090815261003e91600091906100e2565b5061271060015534801561005157600080fd5b506040516105013803806105018339810180604052604081101561007457600080fd5b81019080805164010000000081111561008c57600080fd5b8201602081018481111561009f57600080fd5b81516401000000008111828201871017156100b957600080fd5b5050602091820151815191945092506100d891600091908501906100e2565b506001555061017d565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061012357805160ff1916838001178555610150565b82800160010185558215610150579182015b82811115610150578251825591602001919060010190610135565b5061015c929150610160565b5090565b61017a91905b8082111561015c5760008155600101610166565b90565b6103758061018c6000396000f3fe608060405234801561001057600080fd5b50600436106100a5576000357c01000000000000000000000000000000000000000000000000000000009004806375fb9c551161007857806375fb9c55146101525780638dd4fe421461016f5780639111e38114610177578063a178965014610194576100a5565b806328b449ac146100aa57806342124db6146100e15780635b98ef8814610110578063684d9b551461012d575b600080fd5b6100cd600480360360408110156100c057600080fd5b5080359060200135610211565b604080519115158252519081900360200190f35b6100fe600480360360208110156100f757600080fd5b5035610223565b60408051918252519081900360200190f35b6100fe6004803603602081101561012657600080fd5b5035610235565b6101506004803603604081101561014357600080fd5b5080359060200135610247565b005b6100fe6004803603602081101561016857600080fd5b5035610289565b6100fe61029b565b6100fe6004803603602081101561018d57600080fd5b50356102a1565b61019c6102b3565b6040805160208082528351818301528351919283929083019185019080838360005b838110156101d65781810151838201526020016101be565b50505050905090810190601f1680156102035780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b60009182526004602052604082205590565b60046020526000908152604090205481565b60036020526000908152604090205481565b60028054600181019091557f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace0182905560009182526003602052604090912055565b60009081526004602052604090205490565b60015490565b60009081526003602052604090205490565b60008054604080516020601f600260001961010060018816150201909516949094049384018190048102820181019092528281526060939092909183018282801561033f5780601f106103145761010080835404028352916020019161033f565b820191906000526020600020905b81548152906001019060200180831161032257829003601f168201915b505050505090509056fea165627a7a723058209de50f3132d754597aa9c6990786d3ebc75a5e6944643e53c56db0c9fca13e140029";

    public static final String FUNC_REVERSEBALANCEAMOUNTFROMSTATE = "reverseBalanceAmountFromState";

    public static final String FUNC_BALANCEAMOUNT = "balanceAmount";

    public static final String FUNC_SANCTIONEDAMOUNT = "sanctionedAmount";

    public static final String FUNC_DISBURSEAMOUNTTOSTATE = "disburseAmountToState";

    public static final String FUNC_GETBALANCEAMOUNT = "getBalanceAmount";

    public static final String FUNC_GETSCHEMEAMOUNT = "getSchemeAmount";

    public static final String FUNC_GETDISBURSEMENTAMOUNT = "getDisbursementAmount";

    public static final String FUNC_GETSCHEMENAME = "getSchemeName";

    public static final Event SENT_EVENT = new Event("Sent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected CentralContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CentralContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CentralContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CentralContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> reverseBalanceAmountFromState(BigInteger stateId, BigInteger reverseAmount) {
        final Function function = new Function(
                FUNC_REVERSEBALANCEAMOUNTFROMSTATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(stateId), 
                new org.web3j.abi.datatypes.generated.Uint256(reverseAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceAmount(BigInteger param0) {
        final Function function = new Function(FUNC_BALANCEAMOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> sanctionedAmount(BigInteger param0) {
        final Function function = new Function(FUNC_SANCTIONEDAMOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> disburseAmountToState(BigInteger _stateId, BigInteger _amount) {
        final Function function = new Function(
                FUNC_DISBURSEAMOUNTTOSTATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_stateId), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getBalanceAmount(BigInteger _stateId) {
        final Function function = new Function(FUNC_GETBALANCEAMOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_stateId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getSchemeAmount() {
        final Function function = new Function(FUNC_GETSCHEMEAMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getDisbursementAmount(BigInteger _stateId) {
        final Function function = new Function(FUNC_GETDISBURSEMENTAMOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_stateId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getSchemeName() {
        final Function function = new Function(FUNC_GETSCHEMENAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public List<SentEventResponse> getSentEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SENT_EVENT, transactionReceipt);
        ArrayList<SentEventResponse> responses = new ArrayList<SentEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SentEventResponse typedResponse = new SentEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.__schemeName = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.__schemeAmount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SentEventResponse> sentEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, SentEventResponse>() {
            @Override
            public SentEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SENT_EVENT, log);
                SentEventResponse typedResponse = new SentEventResponse();
                typedResponse.log = log;
                typedResponse.__schemeName = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.__schemeAmount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SentEventResponse> sentEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SENT_EVENT));
        return sentEventFlowable(filter);
    }

    @Deprecated
    public static CentralContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CentralContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CentralContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CentralContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CentralContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CentralContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CentralContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CentralContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CentralContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _schemeName, BigInteger _schemeAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_schemeName), 
                new org.web3j.abi.datatypes.generated.Uint256(_schemeAmount)));
        return deployRemoteCall(CentralContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<CentralContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _schemeName, BigInteger _schemeAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_schemeName), 
                new org.web3j.abi.datatypes.generated.Uint256(_schemeAmount)));
        return deployRemoteCall(CentralContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CentralContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _schemeName, BigInteger _schemeAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_schemeName), 
                new org.web3j.abi.datatypes.generated.Uint256(_schemeAmount)));
        return deployRemoteCall(CentralContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CentralContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _schemeName, BigInteger _schemeAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_schemeName), 
                new org.web3j.abi.datatypes.generated.Uint256(_schemeAmount)));
        return deployRemoteCall(CentralContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class SentEventResponse extends BaseEventResponse {
        public String __schemeName;

        public BigInteger __schemeAmount;
    }
}
