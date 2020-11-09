package pl.piomin.services.transaction.model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
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
public class DonationContract extends Contract {
    private static final String BINARY = "608060405261271060065534801561001657600080fd5b5060405161046f38038061046f8339810180604052606081101561003957600080fd5b81019080805164010000000081111561005157600080fd5b8201602081018481111561006457600080fd5b815164010000000081118282018710171561007e57600080fd5b5050929190602001805164010000000081111561009a57600080fd5b820160208101848111156100ad57600080fd5b81518560208202830111640100000000821117156100ca57600080fd5b5050602091820151855191945092506100e99160009190860190610181565b508160008151811015156100f957fe5b6020908102909101015160019081558251839190811061011557fe5b6020908102909101015160029081558251839190811061013157fe5b6020908102909101015160039081558251839190811061014d57fe5b6020908102909101015160049081558251839190811061016957fe5b602090810290910101516005556006555061021c9050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106101c257805160ff19168380011785556101ef565b828001600101855582156101ef579182015b828111156101ef5782518255916020019190600101906101d4565b506101fb9291506101ff565b5090565b61021991905b808211156101fb5760008155600101610205565b90565b6102448061022b6000396000f3fe608060405234801561001057600080fd5b506004361061009a576000357c010000000000000000000000000000000000000000000000000000000090048063bfa34c6f11610078578063bfa34c6f146100c9578063c73703cb146100d1578063c8099509146100d9578063cea57505146101565761009a565b806335d846b21461009f57806359be7e99146100b95780636b67d2e2146100c1575b600080fd5b6100a761015e565b60408051918252519081900360200190f35b6100a7610164565b6100a761016a565b6100a7610170565b6100a7610176565b6100e161017c565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561011b578181015183820152602001610103565b50505050905090810190601f1680156101485780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6100a7610212565b60055490565b60065490565b60035490565b60015490565b60045490565b60008054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156102085780601f106101dd57610100808354040283529160200191610208565b820191906000526020600020905b8154815290600101906020018083116101eb57829003601f168201915b5050505050905090565b6002549056fea165627a7a72305820d58ecfc828d2b384714d5c446b09134c9fa711822c760fd41c836f8a0cd0793d0029";

    public static final String FUNC_GETDONORBANKCODE = "getDonorBankCode";

    public static final String FUNC_GETDONATIONAMOUNT = "getDonationAmount";

    public static final String FUNC_GETDONORACCOUNTNO = "getDonorAccountNo";

    public static final String FUNC_GETIDENTIFICATIONNO = "getIdentificationNo";

    public static final String FUNC_GETDONORACCOUNTNAME = "getDonorAccountName";

    public static final String FUNC_GETCENTRALADDRESS = "getCentralAddress";

    public static final String FUNC_GETTAXIDENTIFICATIONNO = "getTaxIdentificationNo";

    @Deprecated
    protected DonationContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DonationContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DonationContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DonationContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<byte[]> getDonorBankCode() {
        final Function function = new Function(FUNC_GETDONORBANKCODE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> getDonationAmount() {
        final Function function = new Function(FUNC_GETDONATIONAMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> getDonorAccountNo() {
        final Function function = new Function(FUNC_GETDONORACCOUNTNO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> getIdentificationNo() {
        final Function function = new Function(FUNC_GETIDENTIFICATIONNO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> getDonorAccountName() {
        final Function function = new Function(FUNC_GETDONORACCOUNTNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<String> getCentralAddress() {
        final Function function = new Function(FUNC_GETCENTRALADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<byte[]> getTaxIdentificationNo() {
        final Function function = new Function(FUNC_GETTAXIDENTIFICATIONNO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    @Deprecated
    public static DonationContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DonationContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DonationContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DonationContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DonationContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DonationContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DonationContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DonationContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DonationContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _centralAddress, List<byte[]> _donationContractDetails, BigInteger _donationAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_centralAddress), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_donationContractDetails, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_donationAmount)));
        return deployRemoteCall(DonationContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<DonationContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _centralAddress, List<byte[]> _donationContractDetails, BigInteger _donationAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_centralAddress), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_donationContractDetails, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_donationAmount)));
        return deployRemoteCall(DonationContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<DonationContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _centralAddress, List<byte[]> _donationContractDetails, BigInteger _donationAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_centralAddress), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_donationContractDetails, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_donationAmount)));
        return deployRemoteCall(DonationContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<DonationContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _centralAddress, List<byte[]> _donationContractDetails, BigInteger _donationAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_centralAddress), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_donationContractDetails, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_donationAmount)));
        return deployRemoteCall(DonationContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
