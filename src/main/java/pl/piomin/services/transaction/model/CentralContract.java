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
import org.web3j.abi.datatypes.generated.Bytes32;
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
    private static final String BINARY = "608060405261271060015534801561001657600080fd5b506040516103cd3803806103cd8339810180604052604081101561003957600080fd5b81019080805164010000000081111561005157600080fd5b8201602081018481111561006457600080fd5b815185602082028301116401000000008211171561008157600080fd5b5050602090910151815191935091508290600090811061009d57fe5b602090810290910101516000556001818155825183919081106100bc57fe5b602090810290910101516002908155825183919081106100d857fe5b602090810290910101516003908155825183919081106100f457fe5b6020908102909101015160045550506102bb806101126000396000f3fe608060405234801561001057600080fd5b50600436106100c6576000357c01000000000000000000000000000000000000000000000000000000009004806375fb9c551161008e57806375fb9c551461017b5780638dd4fe42146101985780639111e381146101a0578063a1789650146101bd578063cba8388d146101c5578063e9e09f80146101cd576100c6565b806328b449ac146100cb57806342124db6146101025780635b98ef8814610131578063638dc2b51461014e578063684d9b5514610156575b600080fd5b6100ee600480360360408110156100e157600080fd5b50803590602001356101d5565b604080519115158252519081900360200190f35b61011f6004803603602081101561011857600080fd5b50356101e7565b60408051918252519081900360200190f35b61011f6004803603602081101561014757600080fd5b50356101f9565b61011f61020b565b6101796004803603604081101561016c57600080fd5b5080359060200135610211565b005b61011f6004803603602081101561019157600080fd5b5035610253565b61011f610265565b61011f600480360360208110156101b657600080fd5b503561026b565b61011f61027d565b61011f610283565b61011f610289565b60009182526007602052604082205590565b60076020526000908152604090205481565b60066020526000908152604090205481565b60035490565b60058054600181019091557f036b6384b5eca791c62761152d0c79bb0604c104a5fb6f4eb0703f3154bb3db00182905560009182526006602052604090912055565b60009081526007602052604090205490565b60015490565b60009081526006602052604090205490565b60005490565b60025490565b6004549056fea165627a7a72305820be729c9f9835b6c241a359bf1cc484bcc57dc7d7fece776adb26fc7e657a73400029";

    public static final String FUNC_REVERSEBALANCEAMOUNTFROMSTATE = "reverseBalanceAmountFromState";

    public static final String FUNC_BALANCEAMOUNT = "balanceAmount";

    public static final String FUNC_SANCTIONEDAMOUNT = "sanctionedAmount";

    public static final String FUNC_GETACCOUNTNAME = "getAccountName";

    public static final String FUNC_DISBURSEAMOUNTTOSTATE = "disburseAmountToState";

    public static final String FUNC_GETBALANCEAMOUNT = "getBalanceAmount";

    public static final String FUNC_GETSCHEMEAMOUNT = "getSchemeAmount";

    public static final String FUNC_GETDISBURSEMENTAMOUNT = "getDisbursementAmount";

    public static final String FUNC_GETSCHEMENAME = "getSchemeName";

    public static final String FUNC_GETACCOUNTNUMBER = "getAccountNumber";

    public static final String FUNC_GETBANKCODE = "getBankcode";

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

    public RemoteFunctionCall<byte[]> getAccountName() {
        final Function function = new Function(FUNC_GETACCOUNTNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
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

    public RemoteFunctionCall<byte[]> getSchemeName() {
        final Function function = new Function(FUNC_GETSCHEMENAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> getAccountNumber() {
        final Function function = new Function(FUNC_GETACCOUNTNUMBER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> getBankcode() {
        final Function function = new Function(FUNC_GETBANKCODE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
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

    public static RemoteCall<CentralContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, List<byte[]> _schemeDetails, BigInteger _schemeAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_schemeDetails, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_schemeAmount)));
        return deployRemoteCall(CentralContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<CentralContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, List<byte[]> _schemeDetails, BigInteger _schemeAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_schemeDetails, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_schemeAmount)));
        return deployRemoteCall(CentralContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CentralContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> _schemeDetails, BigInteger _schemeAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_schemeDetails, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_schemeAmount)));
        return deployRemoteCall(CentralContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CentralContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> _schemeDetails, BigInteger _schemeAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_schemeDetails, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_schemeAmount)));
        return deployRemoteCall(CentralContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class SentEventResponse extends BaseEventResponse {
        public String __schemeName;

        public BigInteger __schemeAmount;
    }
}
