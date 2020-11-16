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
    private static final String BINARY = "608060405234801561001057600080fd5b506040516103793803806103798339810180604052606081101561003357600080fd5b81516020830180519193928301929164010000000081111561005457600080fd5b8201602081018481111561006757600080fd5b815164010000000081118282018710171561008157600080fd5b50506020918201516000869055815191945092506100a591600191908501906100b2565b506002555060035561014d565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100f357805160ff1916838001178555610120565b82800160010185558215610120579182015b82811115610120578251825591602001919060010190610105565b5061012c929150610130565b5090565b61014a91905b8082111561012c5760008155600101610136565b90565b61021d8061015c6000396000f3fe608060405234801561001057600080fd5b5060043610610073577c01000000000000000000000000000000000000000000000000000000006000350463293b3d318114610078578063448e5fd01461009257806358d3e10f1461009a57806372a60447146100a25780637ac9dd86146100c1575b600080fd5b61008061013e565b60408051918252519081900360200190f35b610080610144565b61008061014a565b6100bf600480360360208110156100b857600080fd5b5035610150565b005b6100c961015c565b6040805160208082528351818301528351919283929083019185019080838360005b838110156101035781810151838201526020016100eb565b50505050905090810190601f1680156101305780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b60005490565b60025490565b60035490565b60038054919091039055565b60018054604080516020601f600260001961010087891615020190951694909404938401819004810282018101909252828152606093909290918301828280156101e75780601f106101bc576101008083540402835291602001916101e7565b820191906000526020600020905b8154815290600101906020018083116101ca57829003601f168201915b505050505090509056fea165627a7a72305820cbb34e0369cd13d41fd1f5309536ff41dcc86f55691e72bc8c1a65ac453039cf0029";

    public static final String FUNC_GETSCHEMESANCTIONEDAMOUNT = "getSchemeSanctionedAmount";

    public static final String FUNC_GETSTATEID = "getStateId";

    public static final String FUNC_GETBALANCEAMOUNT = "getBalanceAmount";

    public static final String FUNC_DISBURSEAMOUNTTOINDIVIDUAL = "disburseAmountToIndividual";

    public static final String FUNC_GETCENTRALCONTRACTADDRESS = "getcentralContractAddress";

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

    public static RemoteCall<StateContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger _schemeSanctionedAmount, String _centralContractAddress, BigInteger _stateId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_schemeSanctionedAmount), 
                new org.web3j.abi.datatypes.Utf8String(_centralContractAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_stateId)));
        return deployRemoteCall(StateContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<StateContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger _schemeSanctionedAmount, String _centralContractAddress, BigInteger _stateId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_schemeSanctionedAmount), 
                new org.web3j.abi.datatypes.Utf8String(_centralContractAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_stateId)));
        return deployRemoteCall(StateContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<StateContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _schemeSanctionedAmount, String _centralContractAddress, BigInteger _stateId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_schemeSanctionedAmount), 
                new org.web3j.abi.datatypes.Utf8String(_centralContractAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_stateId)));
        return deployRemoteCall(StateContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<StateContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _schemeSanctionedAmount, String _centralContractAddress, BigInteger _stateId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_schemeSanctionedAmount), 
                new org.web3j.abi.datatypes.Utf8String(_centralContractAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_stateId)));
        return deployRemoteCall(StateContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
