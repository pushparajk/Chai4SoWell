package pl.piomin.services.transaction.services;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCoinbase;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import pl.piomin.services.transaction.model.CentralContract;
import pl.piomin.services.transaction.model.Contract;
import pl.piomin.services.transaction.model.DisbursementContract;
import pl.piomin.services.transaction.model.DisbursementModel;
import pl.piomin.services.transaction.model.DonationContract;
import pl.piomin.services.transaction.model.DonationModel;
import pl.piomin.services.transaction.model.FundAllocationModel;
import pl.piomin.services.transaction.model.StateContract;
import pl.piomin.services.transaction.repository.CentralSchemeRepository;

@Service
public class CentralSchemeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CentralSchemeService.class);
    public static final BigInteger GAS_PRICE = BigInteger.valueOf(1L);
    public static final BigInteger GAS_LIMIT = BigInteger.valueOf(21_000L);
    public static final String PASSWORD = "123456";
    //public static final String PRIVATEKEY = "0x8f2a55949038a9610f50fb23b5883af3b4ecb3c3bb792cbcefbd1542c692be63";
    //Credentials creds = Credentials.create(PRIVATEKEY);
    Credentials credentials;
	private Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"));
	private Admin web3j_1 = Admin.build(new HttpService("http://localhost:8545"));
    //private Web3j web3j =Web3j.build(new HttpService("https://rinkeby.infura.io/v3/9a1801c2a628443ea980b15e138e35ab"));
    private List<String> contracts = new ArrayList<>();
    
    //@Value("${contract-service.url}")
    //String url;
    @Autowired
    RestTemplate template;
	@Autowired
	CentralSchemeRepository centralSchemeRepository;

    @PostConstruct
    public void init() throws IOException, CipherException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
    	System.out.println("inside PostConstruct ");
    	String file = WalletUtils.generateLightNewWalletFile(PASSWORD, null);
    	credentials = WalletUtils.loadCredentials(PASSWORD, file);
    	System.out.println("Credentials created: file={"+file+"}, address={"+credentials .getAddress()+"}");
    	LOGGER.info("Credentials created: file={}, address={}", file, credentials.getAddress());
    	EthCoinbase coinbase = web3j.ethCoinbase().send();

    	EthGetTransactionCount transactionCount = web3j.ethGetTransactionCount(coinbase.getAddress(), DefaultBlockParameterName.LATEST).send();
    	Transaction transaction = Transaction.createEtherTransaction(coinbase.getAddress(), transactionCount.getTransactionCount(), BigInteger.valueOf(20_000_000_000L), BigInteger.valueOf(21_000), credentials.getAddress(),BigInteger.valueOf(25_000_000_000_000_000L));
    	web3j.ethSendTransaction(transaction).send();
    	EthGetBalance balance = web3j.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
    	System.out.println("Balance: {}"+balance.getBalance().longValue());
    	LOGGER.info("Balance: {}", balance.getBalance().longValue());

    	
    		
    	//EthCoinbase coinbase = web3j.ethCoinbase().send();
    	//EthAccounts accounts = web3j.ethAccounts().send();
    	//System.out.println("Size = "+accounts.getResult().size());
    	//for (int i = 1; i < accounts.getAccounts().size(); i++) {
    		/* EthGetTransactionCount transactionCount = web3j.ethGetTransactionCount(coinbase.getAddress(), DefaultBlockParameterName.LATEST).send();
            Transaction transaction = Transaction.createEtherTransaction(coinbase.getAddress(), transactionCount.getTransactionCount(), GAS_PRICE, GAS_LIMIT, accounts.getAccounts().get(i), BigInteger.valueOf(25_000_000_000L));
            web3j.ethSendTransaction(transaction).send();
            EthGetBalance balance = web3j.ethGetBalance(accounts.getAccounts().get(i), DefaultBlockParameterName.LATEST).send();
            */
    		//EthGetBalance balance = web3j.ethGetBalance(accounts.getAccounts().get(i), DefaultBlockParameterName.LATEST).send();
    		//System.out.println("address = "+accounts.getAccounts().get(i)+" Amount = "+balance.getBalance().longValue());
        	//LOGGER.info("Balance: address={}, amount={}", accounts.getAccounts().get(i), balance.getBalance().longValue());
		//}
    }

	public String getSchemeName(String address) {
		// TODO Auto-generated method stub
		
		System.out.println("Inside getSchemeName address = "+address);
		String schemeName=null;
		try {
			CentralContract actualContract=CentralContract.load(address, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
		
		
			System.out.println("Is it valid "+actualContract.isValid());
			schemeName=actualContract.getSchemeName().send().toString();
			System.out.println("schemeName = "+schemeName);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schemeName;
	}

	
	public int getSchemeAmount(String address) {
		// TODO Auto-generated method stub
		System.out.println("Inside getSchemeAmount address = "+address);
		CentralContract actualContract;
		BigInteger schemeAmount=null;
		try {
			actualContract=CentralContract.load(address, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
			 schemeAmount=actualContract.getSchemeAmount().send();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
			System.out.println("Scheme Amount  = "+schemeAmount.intValue());
    	
		return schemeAmount.intValue();
	}

		public int getBalanceAmount(String address, int stateId) {
			// TODO Auto-generated method stub
			System.out.println("Inside getSchemeAmount address = "+address);
			CentralContract actualContract=null;
			int balanceAmount=0;
			try {
				 actualContract=CentralContract.load(address, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
				  balanceAmount = actualContract.getBalanceAmount(BigInteger.valueOf(stateId)).send().intValue();
			}catch(Exception e) {
				e.printStackTrace();
				
			}			
			
			
			
				System.out.println("Returned balanceAmount for state 33  = "+balanceAmount);
			return balanceAmount;
		}

		public FundAllocationModel getdisburseAmountToState(FundAllocationModel newFundAllocationModel) {
			// TODO Auto-generated method stub
			String address=newFundAllocationModel.getCentralAddress();
			int stateId=newFundAllocationModel.getStateId();
			System.out.println("Inside getSchemeAmount address = "+address);
			CentralContract actualContract=null;
			int balanceAmount=0;
			try {
				 actualContract=CentralContract.load(address, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
  			     balanceAmount = actualContract.getDisbursementAmount(BigInteger.valueOf(stateId)).send().intValue();
			}catch(Exception e) {
				e.printStackTrace();
				
			}			
				System.out.println("Returned balanceAmount for state 33  = "+balanceAmount);
				newFundAllocationModel.setSanctionedAmount(balanceAmount);
			return newFundAllocationModel;
		}
		
			public FundAllocationModel disburseAmountToState(FundAllocationModel newFundAllocationModel ) {
				// TODO Auto-generated method stub
				String address=newFundAllocationModel.getCentralAddress();
				int stateId=newFundAllocationModel.getStateId();
				int disbursementAmount=newFundAllocationModel.getSanctionedAmount();
				System.out.println("Inside disburseAmountToState address = "+address);
				CentralContract actualContract;
				boolean status=true;
				try {
					 actualContract=CentralContract.load(address, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
					 TransactionReceipt transactionReceipt = actualContract.disburseAmountToState(BigInteger.valueOf(stateId), BigInteger.valueOf(disbursementAmount)).send();
				//CentralContract contract = CentralContract.deploy(web3j,credentials,BigInteger.valueOf(501_000L), BigInteger.valueOf(501_000L),newContract.getSchemeName().toString(),BigInteger.valueOf(newContract.getSchemeAmount())).send();
				String schemeName=actualContract.getSchemeName().send().toString();
				StateContract stateContract= StateContract.deploy(web3j, credentials, BigInteger.valueOf(501_000L), BigInteger.valueOf(501_000L), BigInteger.valueOf(disbursementAmount), address, BigInteger.valueOf(stateId)).send();
				newFundAllocationModel.setStateContractAddress(stateContract.getContractAddress());
				newFundAllocationModel.setCentralAddress(address);
				}catch(Exception e) {
					e.printStackTrace();
					status=false;
				}
				
					//TransactionReceipt transactionReceipt = actualContract.setSchemeAmount(BigInteger.valueOf(1000)).send();
			    	//disburseAmountToState(BigInteger.valueOf(33), BigInteger.valueOf(1000)).send();
			    return newFundAllocationModel;
			}

			public FundAllocationModel disburseToBeneficiary(FundAllocationModel newFundAllocationModel ) {
				// TODO Auto-generated method stub
				String address=newFundAllocationModel.getStateContractAddress();
				int stateId=newFundAllocationModel.getStateId();
				int disbursementAmount=newFundAllocationModel.getSanctionedAmount();
				System.out.println("Inside disburseAmountToState address = "+address);
				CentralContract actualContract;
				boolean status=true;
				try {
					 actualContract=CentralContract.load(address, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
					 TransactionReceipt transactionReceipt = actualContract.disburseAmountToState(BigInteger.valueOf(stateId), BigInteger.valueOf(disbursementAmount)).send();
				//CentralContract contract = CentralContract.deploy(web3j,credentials,BigInteger.valueOf(501_000L), BigInteger.valueOf(501_000L),newContract.getSchemeName().toString(),BigInteger.valueOf(newContract.getSchemeAmount())).send();
				String schemeName=actualContract.getSchemeName().send().toString();
				newFundAllocationModel.setSchemeName(schemeName);
				StateContract stateContract= StateContract.deploy(web3j, credentials, BigInteger.valueOf(501_000L), BigInteger.valueOf(501_000L),  BigInteger.valueOf(disbursementAmount), address, BigInteger.valueOf(stateId)).send();
				}catch(Exception e) {
					e.printStackTrace();
					status=false;
				}
				
					//TransactionReceipt transactionReceipt = actualContract.setSchemeAmount(BigInteger.valueOf(1000)).send();
			    	//disburseAmountToState(BigInteger.valueOf(33), BigInteger.valueOf(1000)).send();
			    return newFundAllocationModel;
			}

			
			public DisbursementModel disburseAmountToIndividual(DisbursementModel newDisbursementModel) {
				String stateAddress=newDisbursementModel.getStateContractAddress();
				String bankCode=newDisbursementModel.getBankCode();
				String accountNumber=newDisbursementModel.getAccountNumber();
				String identificationNumber=newDisbursementModel.getIdentificationNumber();
				int disbursementAmount=newDisbursementModel.getDisbursementAmount();
				// TODO Auto-generated method stub
				System.out.println("Inside disburseAmountToIndividual address = "+stateAddress);
				boolean status=true;
				StateContract stateContract;
				try {
					stateContract=StateContract.load(stateAddress, web3j, credentials, BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
					System.out.println("stateContract = "+stateContract.isValid());
					TransactionReceipt transactionReceipt =stateContract.disburseAmountToIndividual(BigInteger.valueOf(disbursementAmount)).send();
					System.out.println("transactionReceipt inside disburseAmountToIndividual = "+transactionReceipt.isStatusOK());	
					DisbursementContract disbursementContract = DisbursementContract.deploy(web3j,credentials,BigInteger.valueOf(501_000L), BigInteger.valueOf(501_000L),stateAddress,identificationNumber,bankCode,accountNumber,BigInteger.valueOf(disbursementAmount)).send();
					System.out.println("disbursementContract is valid ="+disbursementContract.isValid());
					System.out.println("disbursementContract  address ="+disbursementContract.getContractAddress());
					newDisbursementModel.setDisbursementAddress(disbursementContract.getContractAddress());
					/* Later add the code for deploying the individual disbursement contract */
				}catch(Exception e) {
					e.printStackTrace();
					status=false;
				}
				
			    return newDisbursementModel;	
			}

			
			
				public FundAllocationModel reverseBalanceAmountFromState(FundAllocationModel newFundAllocationModel) {
					String address=newFundAllocationModel.getCentralAddress();
					int stateId=newFundAllocationModel.getStateId();
					int returnedAmount=newFundAllocationModel.getReturnedAmount();
					// TODO Auto-generated method stub
					System.out.println("Inside getSchemeAmount address = "+address);
					boolean status=true;
					CentralContract actualContract;
					try {
						actualContract=CentralContract.load(address, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
					TransactionReceipt transactionReceipt =actualContract.reverseBalanceAmountFromState(BigInteger.valueOf(stateId), BigInteger.valueOf(returnedAmount)).send();
					}catch(Exception e) {
						e.printStackTrace();
						status=false;
					}
						//TransactionReceipt transactionReceipt = actualContract.setSchemeAmount(BigInteger.valueOf(1000)).send();
								//disburseAmountToState(BigInteger.valueOf(33), BigInteger.valueOf(1000)).send();
				    return newFundAllocationModel;	
				}

		public FundAllocationModel getReverseBalanceAmountFromState(FundAllocationModel newFundAllocationModel) {
			// TODO Auto-generated method stub
			String address=newFundAllocationModel.getCentralAddress();
			int stateId=newFundAllocationModel.getStateId();
			System.out.println("Inside getSchemeAmount address = "+address);
			CentralContract actualContract=null;
			int balanceAmount=0;
			try {
				 actualContract=CentralContract.load(address, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
  			     balanceAmount = actualContract.getBalanceAmount(BigInteger.valueOf(stateId)).send().intValue();
  			     newFundAllocationModel.setReturnedAmount(balanceAmount);
			}catch(Exception e) {
				e.printStackTrace();
				
			}			
				System.out.println("Returned balanceAmount for state   = "+balanceAmount);
			return newFundAllocationModel;
		}
		
		public FundAllocationModel getStateSchemeDetails(FundAllocationModel newFundAllocationModel) {
			// TODO Auto-generated method stub
			String address=newFundAllocationModel.getStateContractAddress();
			System.out.println("Inside getStateSchemeAmount address = "+address);
			StateContract actualContract=null;
			CentralContract centralActualContract=null;
			int balanceAmount=0;
			try {
				 actualContract=StateContract.load(address, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
				  balanceAmount = actualContract.getBalanceAmount().send().intValue();
				  System.out.println("getStateSchemeAmount amount = "+balanceAmount);
				  newFundAllocationModel.setReturnedAmount(balanceAmount);
				  newFundAllocationModel.setSanctionedAmount(actualContract.getSchemeSanctionedAmount().send().intValue());
				  newFundAllocationModel.setStateId(actualContract.getStateId().send().intValue());
				  System.out.println("actualContract.getcentralContractAddress().send() = "+actualContract.getcentralContractAddress().send());
				  newFundAllocationModel.setCentralAddress(actualContract.getcentralContractAddress().send());
				  centralActualContract=CentralContract.load(actualContract.getcentralContractAddress().send(), web3j, credentials, BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
				  String schemeName=StringUtils.newStringUsAscii(centralActualContract.getSchemeName().send().clone()).trim();
				  newFundAllocationModel.setSchemeName(schemeName);

			}catch(Exception e) {
				e.printStackTrace();
				
			}			
			return newFundAllocationModel;
		}
		
		public FundAllocationModel setStateSchemeName(FundAllocationModel newFundAllocationModel) {
			// TODO Auto-generated method stub
			String address=newFundAllocationModel.getStateContractAddress();
			System.out.println("Inside getStateSchemeAmount address = "+address);
			StateContract actualContract=null;
			CentralContract centralActualContract=null;
			int balanceAmount=0;
			try {
				 actualContract=StateContract.load(address, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
				  balanceAmount = actualContract.getBalanceAmount().send().intValue();
				  System.out.println("getStateSchemeAmount amount = "+balanceAmount);
				  newFundAllocationModel.setReturnedAmount(balanceAmount);
				  centralActualContract=CentralContract.load(actualContract.getcentralContractAddress().send(), web3j, credentials, BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
				  newFundAllocationModel.setSchemeName(centralActualContract.getSchemeName().send().toString());
				  newFundAllocationModel.setSanctionedAmount(actualContract.getSchemeSanctionedAmount().send().intValue());
				  newFundAllocationModel.setStateId(actualContract.getStateId().send().intValue());
					
					//System.out.println("Scheme Name = "+schemeDetails.get(0));
					//System.out.println("schemeSanctionedAmount = "+schemeDetails.get(1));
					//System.out.println("State ID = "+schemeDetails.get(2));

			}catch(Exception e) {
				e.printStackTrace();
				
			}			
			return newFundAllocationModel;
		}

		
		
	public Contract createCentralScheme(Contract newContract) throws Exception  {
		System.out.println("Inside createCentralScheme service.....");
	    String accountNumber=newContract.getAccountNumber();
		String accountName=newContract.getAccountName();
		String bankCode=newContract.getBankcode();
		String schemeName=newContract.getSchemeName();
		int schemeAmount=newContract.getSchemeAmount();
		newContract.setSchemeBalanceAmount(schemeAmount);
		String schemeDetails=newContract.getSchemeDetails(); // THis value to be storead in local DB
		List<byte[]> inputParams=new ArrayList<>();
		inputParams.add(stringToBytes32(schemeName).getValue());
		inputParams.add(stringToBytes32(accountNumber).getValue());
		inputParams.add(stringToBytes32(accountName).getValue());
		inputParams.add(stringToBytes32(bankCode).getValue());
		
    	System.out.println("credentials.getAddress() "+credentials.getAddress());
    	System.out.println("newContract.getSchemeName() = "+newContract.getSchemeName());
    	System.out.println("newContract.getSchemeAmount()"+newContract.getSchemeAmount()+" "+accountNumber+" "+accountName+" "+bankCode);
    	//Transactionfee contract = Transactionfee.deploy(web3j, credentials, GAS_PRICE, GAS_LIMIT, receiverCredentials.getAddress(), BigInteger.valueOf(newContract.getFee())).send();
    	EthGetBalance balance = web3j.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
    	System.out.println("Balance before deploying the contract: {}"+balance.getBalance().longValue());
    	//CentralContract contract = CentralContract.deploy(web3j,credentials,new CustomizedGasProvider(),newContract.getSchemeName().toString(),BigInteger.valueOf(newContract.getSchemeAmount())).send();
    	//PersonalUnlockAccount personalUnlockAccount = web3j_1.personalUnlockAccount(credentials.getAddress(), PASSWORD).send();//
    	
    	//System.out.println("From personalUnlockAccount.hasError() = "+personalUnlockAccount.getError().getMessage());

    	
    	//CentralContract contract = CentralContract.deploy(web3j,credentials,BigInteger.valueOf(501_000L), BigInteger.valueOf(501_000L),newContract.getSchemeName().toString(),BigInteger.valueOf(newContract.getSchemeAmount()),accountNumber,accountName,bankCode).send();
    	//CentralContract contract = CentralContract.deploy(web3j, credentials, BigInteger.valueOf(501_000L), BigInteger.valueOf(501_000L),newContract.getSchemeName().toString(),BigInteger.valueOf(newContract.getSchemeAmount()),accountName).send();
    	CentralContract contract = CentralContract.deploy(web3j, credentials, BigInteger.valueOf(501_000L), BigInteger.valueOf(501_000L),inputParams,BigInteger.valueOf(schemeAmount)).send();
    	//CentralContract actualContract=CentralContract.load(contract.getContractAddress(), web3j, credentials , BigInteger.valueOf(521_000L), BigInteger.valueOf(521_000L));
    	newContract.setCentralContractAddress(contract.getContractAddress());
    	
    	System.out.println("contract.isValid() = "+contract.isValid());
    	LOGGER.info("New contract deployed: address={}", contract.getContractAddress());    	
    	//		CentralContract contract = CentralContract.deploy(web3j, receiverCredentials, GAS_PRICE, GAS_LIMIT, "TestScheme",BigInteger.valueOf(12345L)).send();
    	//System.out.println("Is account unlocked = "+personalUnlockAccount.accountUnlocked());
    	
    	System.out.println("******** Scheme Amount : {}"+contract.getSchemeAmount().send());
    	System.out.println("********* Scheme Name: {}"+contract.getSchemeName().send()); 																																																																																	   	
   	
    	contracts.add(contract.getContractAddress());

    	//TransactionReceipt transactionReceipt = contract.setSchemeName("DummyScheme").send();
    	//System.out.println("******** status of transaction= "+transactionReceipt.isStatusOK());

		TransactionReceipt transactionReceipt = contract.disburseAmountToState(BigInteger.valueOf(33), BigInteger.valueOf(1000)).send();
		System.out.println("transactionReceipt for disbursement status = "+transactionReceipt.isStatusOK());

		transactionReceipt = contract.reverseBalanceAmountFromState(BigInteger.valueOf(33), BigInteger.valueOf(1000)).send();
		System.out.println("transactionReceipt for reversal status = "+transactionReceipt.isStatusOK());


    	Optional<TransactionReceipt> tr = contract.getTransactionReceipt();
    	if (tr.isPresent()) {
    		LOGGER.info("Transaction receipt: from={}, to={}, gas={}", tr.get().getFrom(), tr.get().getTo(), tr.get().getGasUsed().intValue());
    	}
		centralSchemeRepository.save(newContract);
    	return newContract;
	
	}

	public Contract getCentralSchemeDetails(Contract contractModel) {
		// TODO Auto-generated method stub
		String centralContractAddress=contractModel.getCentralContractAddress();
		try {
			CentralContract actualContract=CentralContract.load(centralContractAddress, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
			System.out.println("actualContract is valid = "+actualContract.isValid());
			//String schemeName=actualContract.getSchemeName().send().toString();
			//String accountNumber=actualContract.getAccountNumber().send().toString();
			//String accountName=actualContract.getAccountName().send().toString();
			//String bankCode=actualContract.getBankcode().send().toString();
			int schemeAmount=actualContract.getSchemeAmount().send().intValue();
			String schemeName=StringUtils.newStringUsAscii(actualContract.getSchemeName().send().clone()).trim();
			String accountNumber=StringUtils.newStringUsAscii(actualContract.getAccountNumber().send().clone()).trim();
			String accountName=StringUtils.newStringUsAscii(actualContract.getAccountName().send().clone()).trim();
			String bankCode=StringUtils.newStringUsAscii(actualContract.getBankcode().send().clone()).trim();
			int schemeBalanceAmount=actualContract.getSchemeBalanceAmount().send().intValue();
			
			contractModel.setSchemeName(schemeName);
			contractModel.setSchemeAmount(schemeAmount);
			contractModel.setAccountName(accountName);
			contractModel.setAccountNumber(accountNumber);
			contractModel.setBankcode(bankCode);
			contractModel.setSchemeBalanceAmount(schemeBalanceAmount);
		}catch(Exception e) {
			e.printStackTrace();
			
		}			
		return contractModel;
	}

	public DisbursementModel getDisbursementDetails(DisbursementModel newDisbursementModel) {
		String disbursementContractAddress=newDisbursementModel.getDisbursementAddress();
		try {
			//CentralContract actualContract=CentralContract.load(disbursementContractAddress, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
			DisbursementContract actualContract = DisbursementContract.load(disbursementContractAddress, web3j, credentials, BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L)); 
			System.out.println("actualContract is valid = "+actualContract.isValid());
			String stateContractAddress=actualContract.getStateContractAddress().send();
			String identificationNumber=actualContract.getIdentificationNumber().send();
			String bankCode=actualContract.getBankCode().send();
			String accountNumber=actualContract.getAccountNumber().send();
			int disbursementAmount=actualContract.getDisbursementAmount().send().intValue();
			newDisbursementModel.setStateContractAddress(stateContractAddress);
			newDisbursementModel.setIdentificationNumber(identificationNumber);
			newDisbursementModel.setBankCode(bankCode);
			newDisbursementModel.setAccountNumber(accountNumber);
			newDisbursementModel.setDisbursementAmount(disbursementAmount);
		}catch(Exception e) {
			e.printStackTrace();
			
		}			

		return newDisbursementModel;
	}

	public static Bytes32 stringToBytes32(String string) {
        byte[] byteValue = string.getBytes();
        byte[] byteValueLen32 = new byte[32];
        System.arraycopy(byteValue, 0, byteValueLen32, 0, byteValue.length);
        return new Bytes32(byteValueLen32);
    }

	public DonationModel makeDonation(DonationModel newDonationModel) {
		// TODO Auto-generated method stub
	    String centralAddress=newDonationModel.getCentralAddress();
		String donationAddress;
		String identificationNo=newDonationModel.getIdentificationNo();
		String taxIdentificationNo=newDonationModel.getTaxIdentificationNo();
		String donorAccountNo=newDonationModel.getDonorAccountNo();
		String donorAccountName=newDonationModel.getDonorAccountName();
		String donorBankCode=newDonationModel.getDonorBankCode();
	    int donationAmount=newDonationModel.getDonationAmount();
	    
		List<byte[]> inputParams=new ArrayList<>();
		//inputParams.add(stringToBytes32(centralAddress).getValue());
		inputParams.add(stringToBytes32(identificationNo).getValue());
		inputParams.add(stringToBytes32(taxIdentificationNo).getValue());
		inputParams.add(stringToBytes32(donorAccountNo).getValue());
		inputParams.add(stringToBytes32(donorAccountName).getValue());
		inputParams.add(stringToBytes32(donorBankCode).getValue());
		try{
			DonationContract donationContract = DonationContract.deploy(web3j, credentials, BigInteger.valueOf(501_000L), BigInteger.valueOf(501_000L),centralAddress,inputParams,BigInteger.valueOf(donationAmount)).send();
			newDonationModel.setDonationAddress(donationContract.getContractAddress());
			System.out.println("Donation contract created :"+newDonationModel.getCentralAddress());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return newDonationModel;
	}
	
	
}
