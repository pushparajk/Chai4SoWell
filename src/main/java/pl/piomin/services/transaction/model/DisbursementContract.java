package pl.piomin.services.transaction.model;

import java.math.BigInteger;
import java.util.Arrays;
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
public class DisbursementContract extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50604051610574380380610574833981018060405260a081101561003357600080fd5b81019080805164010000000081111561004b57600080fd5b8201602081018481111561005e57600080fd5b815164010000000081118282018710171561007857600080fd5b5050929190602001805164010000000081111561009457600080fd5b820160208101848111156100a757600080fd5b81516401000000008111828201871017156100c157600080fd5b505092919060200180516401000000008111156100dd57600080fd5b820160208101848111156100f057600080fd5b815164010000000081118282018710171561010a57600080fd5b5050929190602001805164010000000081111561012657600080fd5b8201602081018481111561013957600080fd5b815164010000000081118282018710171561015357600080fd5b50506020918201518751919450925061017291600091908801906101bc565b5083516101869060019060208701906101bc565b50825161019a9060029060208601906101bc565b5081516101ae9060039060208501906101bc565b506004555061025792505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106101fd57805160ff191683800117855561022a565b8280016001018555821561022a579182015b8281111561022a57825182559160200191906001019061020f565b5061023692915061023a565b5090565b61025491905b808211156102365760008155600101610240565b90565b61030e806102666000396000f3fe608060405234801561001057600080fd5b5060043610610073577c010000000000000000000000000000000000000000000000000000000060003504635b50ac0481146100785780637a95afb1146100f5578063c229841b1461010f578063cba8388d14610117578063cf2ac24d1461011f575b600080fd5b610080610127565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100ba5781810151838201526020016100a2565b50505050905090810190601f1680156100e75780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6100fd6101bd565b60408051918252519081900360200190f35b6100806101c3565b610080610223565b610080610284565b60008054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156101b35780601f10610188576101008083540402835291602001916101b3565b820191906000526020600020905b81548152906001019060200180831161019657829003601f168201915b5050505050905090565b60045490565b60018054604080516020601f600260001961010087891615020190951694909404938401819004810282018101909252828152606093909290918301828280156101b35780601f10610188576101008083540402835291602001916101b3565b60038054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156101b35780601f10610188576101008083540402835291602001916101b3565b60028054604080516020601f60001961010060018716150201909416859004938401819004810282018101909252828152606093909290918301828280156101b35780601f10610188576101008083540402835291602001916101b356fea165627a7a723058207b915feedb3ade70c02e6625c5bda25f7f30d9189076de3b93bddcd19d9561b60029";

    public static final String FUNC_GETSTATECONTRACTADDRESS = "getStateContractAddress";

    public static final String FUNC_GETDISBURSEMENTAMOUNT = "getDisbursementAmount";

    public static final String FUNC_GETIDENTIFICATIONNUMBER = "getIdentificationNumber";

    public static final String FUNC_GETACCOUNTNUMBER = "getAccountNumber";

    public static final String FUNC_GETBANKCODE = "getBankCode";

    @Deprecated
    protected DisbursementContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DisbursementContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DisbursementContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DisbursementContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> getStateContractAddress() {
        final Function function = new Function(FUNC_GETSTATECONTRACTADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getDisbursementAmount() {
        final Function function = new Function(FUNC_GETDISBURSEMENTAMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getIdentificationNumber() {
        final Function function = new Function(FUNC_GETIDENTIFICATIONNUMBER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getAccountNumber() {
        final Function function = new Function(FUNC_GETACCOUNTNUMBER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getBankCode() {
        final Function function = new Function(FUNC_GETBANKCODE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static DisbursementContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DisbursementContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DisbursementContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DisbursementContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DisbursementContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DisbursementContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DisbursementContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DisbursementContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DisbursementContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _stateContractAddress, String _identificationNumber, String _bankCode, String _accountNumber, BigInteger _disbursementAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_stateContractAddress), 
                new org.web3j.abi.datatypes.Utf8String(_identificationNumber), 
                new org.web3j.abi.datatypes.Utf8String(_bankCode), 
                new org.web3j.abi.datatypes.Utf8String(_accountNumber), 
                new org.web3j.abi.datatypes.generated.Uint256(_disbursementAmount)));
        return deployRemoteCall(DisbursementContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<DisbursementContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _stateContractAddress, String _identificationNumber, String _bankCode, String _accountNumber, BigInteger _disbursementAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_stateContractAddress), 
                new org.web3j.abi.datatypes.Utf8String(_identificationNumber), 
                new org.web3j.abi.datatypes.Utf8String(_bankCode), 
                new org.web3j.abi.datatypes.Utf8String(_accountNumber), 
                new org.web3j.abi.datatypes.generated.Uint256(_disbursementAmount)));
        return deployRemoteCall(DisbursementContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<DisbursementContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _stateContractAddress, String _identificationNumber, String _bankCode, String _accountNumber, BigInteger _disbursementAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_stateContractAddress), 
                new org.web3j.abi.datatypes.Utf8String(_identificationNumber), 
                new org.web3j.abi.datatypes.Utf8String(_bankCode), 
                new org.web3j.abi.datatypes.Utf8String(_accountNumber), 
                new org.web3j.abi.datatypes.generated.Uint256(_disbursementAmount)));
        return deployRemoteCall(DisbursementContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<DisbursementContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _stateContractAddress, String _identificationNumber, String _bankCode, String _accountNumber, BigInteger _disbursementAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_stateContractAddress), 
                new org.web3j.abi.datatypes.Utf8String(_identificationNumber), 
                new org.web3j.abi.datatypes.Utf8String(_bankCode), 
                new org.web3j.abi.datatypes.Utf8String(_accountNumber), 
                new org.web3j.abi.datatypes.generated.Uint256(_disbursementAmount)));
        return deployRemoteCall(DisbursementContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
