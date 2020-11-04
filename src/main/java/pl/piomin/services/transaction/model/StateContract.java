package pl.piomin.services.transaction.model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
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
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class StateContract extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060405161025a38038061025a8339810180604052608081101561003357600080fd5b81019080805164010000000081111561004b57600080fd5b8201602081018481111561005e57600080fd5b815164010000000081118282018710171561007857600080fd5b5050602082015160409092018051919492939164010000000081111561009d57600080fd5b820160208101848111156100b057600080fd5b81516401000000008111828201871017156100ca57600080fd5b5050602091820151865191945092506100e99160009190870190610114565b5060018390558151610102906002906020850190610114565b506003555050600154600455506101af565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061015557805160ff1916838001178555610182565b82800160010185558215610182579182015b82811115610182578251825591602001919060010190610167565b5061018e929150610192565b5090565b6101ac91905b8082111561018e5760008155600101610198565b90565b609d806101bd6000396000f3fe6080604052348015600f57600080fd5b50600436106044577c0100000000000000000000000000000000000000000000000000000000600035046372a6044781146049575b600080fd5b606360048036036020811015605d57600080fd5b50356065565b005b6004805491909103905556fea165627a7a72305820700dae4e45128ffe1db444886034de82d98734f2e397145af26335c76e7451190029";

    public static final String FUNC_DISBURSEAMOUNTTOINDIVIDUAL = "disburseAmountToIndividual";

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

    public RemoteFunctionCall<TransactionReceipt> disburseAmountToIndividual(BigInteger _amount) {
        final Function function = new Function(
                FUNC_DISBURSEAMOUNTTOINDIVIDUAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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
