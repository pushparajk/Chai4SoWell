package pl.piomin.services.transaction.model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class StateContract extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516104493803806104498339810180604052608081101561003357600080fd5b81019080805164010000000081111561004b57600080fd5b8201602081018481111561005e57600080fd5b815164010000000081118282018710171561007857600080fd5b5050602082015160409092018051919492939164010000000081111561009d57600080fd5b820160208101848111156100b057600080fd5b81516401000000008111828201871017156100ca57600080fd5b5050602091820151865191945092506100e99160009190870190610110565b5060018390558151610102906002906020850190610110565b5060035550600455506101ab565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061015157805160ff191683800117855561017e565b8280016001018555821561017e579182015b8281111561017e578251825591602001919060010190610163565b5061018a92915061018e565b5090565b6101a891905b8082111561018a5760008155600101610194565b90565b61028f806101ba6000396000f3fe608060405234801561001057600080fd5b506004361061007e577c01000000000000000000000000000000000000000000000000000000006000350463293b3d318114610083578063448e5fd01461009d57806358d3e10f146100a557806372a60447146100ad5780637ac9dd86146100cc578063a178965014610149575b600080fd5b61008b610151565b60408051918252519081900360200190f35b61008b610157565b61008b61015d565b6100ca600480360360208110156100c357600080fd5b5035610163565b005b6100d461016f565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561010e5781810151838201526020016100f6565b50505050905090810190601f16801561013b5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6100d4610202565b60015490565b60035490565b60045490565b60048054919091039055565b60028054604080516020601f60001961010060018716150201909416859004938401819004810282018101909252828152606093909290918301828280156101f85780601f106101cd576101008083540402835291602001916101f8565b820191906000526020600020905b8154815290600101906020018083116101db57829003601f168201915b5050505050905090565b60008054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156101f85780601f106101cd576101008083540402835291602001916101f856fea165627a7a72305820cdde84dcadde71744ccd63e378301739c3d9e5d139c57aafc9fe7f33251e6ba20029";

    public static final String FUNC_GETSCHEMESANCTIONEDAMOUNT = "getSchemeSanctionedAmount";

    public static final String FUNC_GETSTATEID = "getStateId";

    public static final String FUNC_GETBALANCEAMOUNT = "getBalanceAmount";

    public static final String FUNC_DISBURSEAMOUNTTOINDIVIDUAL = "disburseAmountToIndividual";

    public static final String FUNC_GETCENTRALCONTRACTADDRESS = "getcentralContractAddress";

    public static final String FUNC_GETSCHEMENAME = "getSchemeName";

    @Deprecated
    protected StateContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected StateContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected StateContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected StateContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> getSchemeSanctionedAmount() {
        final Function function = new Function(FUNC_GETSCHEMESANCTIONEDAMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getStateId() {
        final Function function = new Function(FUNC_GETSTATEID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getBalanceAmount() {
        final Function function = new Function(FUNC_GETBALANCEAMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> disburseAmountToIndividual(BigInteger _amount) {
        final Function function = new Function(
                FUNC_DISBURSEAMOUNTTOINDIVIDUAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getcentralContractAddress() {
        final Function function = new Function(FUNC_GETCENTRALCONTRACTADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getSchemeName() {
        final Function function = new Function(FUNC_GETSCHEMENAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static StateContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new StateContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static StateContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new StateContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static StateContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new StateContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static StateContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new StateContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<StateContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _schemeName, BigInteger _schemeSanctionedAmount, String _centralContractAddress, BigInteger _stateId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_schemeName), 
                new org.web3j.abi.datatypes.generated.Uint256(_schemeSanctionedAmount), 
                new org.web3j.abi.datatypes.Utf8String(_centralContractAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_stateId)));
        return deployRemoteCall(StateContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<StateContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _schemeName, BigInteger _schemeSanctionedAmount, String _centralContractAddress, BigInteger _stateId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_schemeName), 
                new org.web3j.abi.datatypes.generated.Uint256(_schemeSanctionedAmount), 
                new org.web3j.abi.datatypes.Utf8String(_centralContractAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_stateId)));
        return deployRemoteCall(StateContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<StateContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _schemeName, BigInteger _schemeSanctionedAmount, String _centralContractAddress, BigInteger _stateId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_schemeName), 
                new org.web3j.abi.datatypes.generated.Uint256(_schemeSanctionedAmount), 
                new org.web3j.abi.datatypes.Utf8String(_centralContractAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_stateId)));
        return deployRemoteCall(StateContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<StateContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _schemeName, BigInteger _schemeSanctionedAmount, String _centralContractAddress, BigInteger _stateId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_schemeName), 
                new org.web3j.abi.datatypes.generated.Uint256(_schemeSanctionedAmount), 
                new org.web3j.abi.datatypes.Utf8String(_centralContractAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_stateId)));
        return deployRemoteCall(StateContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
