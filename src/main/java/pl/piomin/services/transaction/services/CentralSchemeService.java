package pl.piomin.services.transaction.services;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthCoinbase;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import pl.piomin.services.transaction.controller.CentralContractController;
import pl.piomin.services.transaction.model.CentralContract;
import pl.piomin.services.transaction.model.Contract;
import pl.piomin.services.transaction.model.DisbursementModel;
import pl.piomin.services.transaction.model.StateContract;

@Service
public class CentralSchemeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CentralSchemeService.class);
    public static final BigInteger GAS_PRICE = BigInteger.valueOf(1L);
    public static final BigInteger GAS_LIMIT = BigInteger.valueOf(21_000L);
    public static final String PASSWORD = "123456";
    //public static final String PRIVATEKEY = "0x8f2a55949038a9610f50fb23b5883af3b4ecb3c3bb792cbcefbd1542c692be63";
    //Credentials creds = Credentials.create(PRIVATEKEY);
    Credentials credentials;
    private Web3j web3j =Web3j.build(new HttpService("http://localhost:8545"));
    private Admin web3j_1 = Admin.build(new HttpService("http://localhost:8545"));
    //private Web3j web3j =Web3j.build(new HttpService("https://rinkeby.infura.io/v3/9a1801c2a628443ea980b15e138e35ab"));
    private List<String> contracts = new ArrayList<>();
    
    //@Value("${contract-service.url}")
    //String url;
    @Autowired
    RestTemplate template;
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
		/*//File fileJson=new File("C:\\Users\\720214\\OneDrive - Finastra\\Finastra\\Innovation\\BlockChain\\blockchain-transaction\\transaction-service\\UTC--2020-11-02T12-00-44.713730700Z--8fe810dc14161a14704e1374fff6c33e0b63217d.json");
    	String file = WalletUtils.generateLightNewWalletFile(PASSWORD, null);
    	Credentials credentialsRead = WalletUtils.loadCredentials(PASSWORD, file);
    	//Credentials credentialsRead = WalletUtils.loadCredentials(PASSWORD, fileJson);
    	LOGGER.info("Credentials created: file={}, address={}", file, credentialsRead.getAddress());
    	EthCoinbase coinbase = web3j.ethCoinbase().send();
		EthGetTransactionCount transactionCount = web3j.ethGetTransactionCount(coinbase.getAddress(), DefaultBlockParameterName.LATEST).send();
        Transaction transaction = Transaction.createEtherTransaction(coinbase.getAddress(), transactionCount.getTransactionCount(), GAS_PRICE, GAS_LIMIT, credentialsRead.getAddress(), BigInteger.valueOf(250_000_000_000_000L));
        web3j.ethSendTransaction(transaction).send();
        EthGetBalance balance1 = web3j.ethGetBalance(credentialsRead.getAddress(), DefaultBlockParameterName.LATEST).send();
        System.out.println("Balance after transfer: {}"+balance1.getBalance().longValue());
		*/
		//CentralContract actualContract=CentralContract.load(address, web3j, credentialsRead , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
			CentralContract actualContract=CentralContract.load(address, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
		
		
			System.out.println("Is it valid "+actualContract.isValid());
			schemeName=actualContract.getSchemeName().send();
			BigInteger schemeAmount=actualContract.getSchemeAmount().send();
			System.out.println("schemeName = "+schemeName);
			System.out.println("Scheme Amount  = "+schemeAmount.intValue());
			
			schemeAmount = actualContract.getBalanceAmount(BigInteger.valueOf(33)).send();
			System.out.println("Returned Amount for state 33  = "+schemeAmount.intValue());
			schemeAmount = actualContract.getDisbursementAmount(BigInteger.valueOf(33)).send();
			System.out.println("Sanctioned Amount for state 33  = "+schemeAmount.intValue());
	    	//TransactionReceipt transactionReceipt = actualContract.disburseAmountToState(BigInteger.valueOf(33), BigInteger.valueOf(1000)).send();
			//TransactionReceipt transactionReceipt = actualContract.setSchemeAmount(BigInteger.valueOf(1000)).send();
					//disburseAmountToState(BigInteger.valueOf(33), BigInteger.valueOf(1000)).send();
	    	

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
		/* //File fileJson=new File("C:\\Users\\720214\\OneDrive - Finastra\\Finastra\\Innovation\\BlockChain\\blockchain-transaction\\transaction-service\\UTC--2020-11-02T12-00-44.713730700Z--8fe810dc14161a14704e1374fff6c33e0b63217d.json");
    	String file = WalletUtils.generateLightNewWalletFile(PASSWORD, null);
    	Credentials credentialsRead = WalletUtils.loadCredentials(PASSWORD, file);
    	//Credentials credentialsRead = WalletUtils.loadCredentials(PASSWORD, fileJson);
    	LOGGER.info("Credentials created: file={}, address={}", file, credentialsRead.getAddress());
    	EthCoinbase coinbase = web3j.ethCoinbase().send();
		EthGetTransactionCount transactionCount = web3j.ethGetTransactionCount(coinbase.getAddress(), DefaultBlockParameterName.LATEST).send();
        Transaction transaction = Transaction.createEtherTransaction(coinbase.getAddress(), transactionCount.getTransactionCount(), GAS_PRICE, GAS_LIMIT, credentialsRead.getAddress(), BigInteger.valueOf(250_000_000_000_000L));
        web3j.ethSendTransaction(transaction).send();
        EthGetBalance balance1 = web3j.ethGetBalance(credentialsRead.getAddress(), DefaultBlockParameterName.LATEST).send();
        System.out.println("Balance after transfer: {}"+balance1.getBalance().longValue());
		*/
		//CentralContract actualContract=CentralContract.load(address, web3j, credentialsRead , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
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
				//schemeAmount = actualContract.getDisbursementAmount(BigInteger.valueOf(33)).send();
				//System.out.println("Sanctioned Amount for state 33  = "+schemeAmount.intValue());
		    	//TransactionReceipt transactionReceipt = actualContract.disburseAmountToState(BigInteger.valueOf(33), BigInteger.valueOf(1000)).send();
				//TransactionReceipt transactionReceipt = actualContract.setSchemeAmount(BigInteger.valueOf(1000)).send();
						//disburseAmountToState(BigInteger.valueOf(33), BigInteger.valueOf(1000)).send();
		    	
			return balanceAmount;
		}

		public DisbursementModel getdisburseAmountToState(DisbursementModel newDisbursementModel) {
			// TODO Auto-generated method stub
			String address=newDisbursementModel.getCentralAddress();
			int stateId=newDisbursementModel.getStateId();
			System.out.println("Inside getSchemeAmount address = "+address);
			CentralContract actualContract=null;
			int balanceAmount=0;
			try {
				 actualContract=CentralContract.load(address, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
  			     balanceAmount = actualContract.getDisbursementAmount(BigInteger.valueOf(stateId)).send().intValue();
  			     newDisbursementModel.setDisbursementAmount(balanceAmount);
			}catch(Exception e) {
				e.printStackTrace();
				
			}			
				System.out.println("Returned balanceAmount for state 33  = "+balanceAmount);
			return newDisbursementModel;
		}
		
			public DisbursementModel disburseAmountToState(DisbursementModel newDisbursementModel ) {
				// TODO Auto-generated method stub
				String address=newDisbursementModel.getCentralAddress();
				int stateId=newDisbursementModel.getStateId();
				int disbursementAmount=newDisbursementModel.getDisbursementAmount();
				System.out.println("Inside getSchemeAmount address = "+address);
				CentralContract actualContract;
				boolean status=true;
				try {
					 actualContract=CentralContract.load(address, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
					 TransactionReceipt transactionReceipt = actualContract.disburseAmountToState(BigInteger.valueOf(stateId), BigInteger.valueOf(disbursementAmount)).send();
				//CentralContract contract = CentralContract.deploy(web3j,credentials,BigInteger.valueOf(501_000L), BigInteger.valueOf(501_000L),newContract.getSchemeName().toString(),BigInteger.valueOf(newContract.getSchemeAmount())).send();
				String schemeName=actualContract.getSchemeName().send();
				StateContract stateContract= StateContract.deploy(web3j, credentials, BigInteger.valueOf(501_000L), BigInteger.valueOf(501_000L), schemeName, BigInteger.valueOf(disbursementAmount), address, BigInteger.valueOf(stateId)).send();
				System.out.println("stateContract.isValid() = "+stateContract.isValid());
				System.out.println("stateContract address = "+stateContract.getContractAddress());
				}catch(Exception e) {
					e.printStackTrace();
					status=false;
				}
				
					//TransactionReceipt transactionReceipt = actualContract.setSchemeAmount(BigInteger.valueOf(1000)).send();
			    	//disburseAmountToState(BigInteger.valueOf(33), BigInteger.valueOf(1000)).send();
			    return newDisbursementModel;
			}

			public DisbursementModel disburseAmountToIndividual(DisbursementModel newDisbursementModel) {
				String stateAddress=newDisbursementModel.getStateContractAddress();
				int stateId=newDisbursementModel.getStateId();
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
					/* Later add the code for deploying the individual disbursement contract */
				}catch(Exception e) {
					e.printStackTrace();
					status=false;
				}
				newDisbursementModel.setStateContractAddress(stateAddress);
			    return newDisbursementModel;	
			}

			
			
				public DisbursementModel reverseBalanceAmountFromState(DisbursementModel newDisbursementModel) {
					String address=newDisbursementModel.getCentralAddress();
					int stateId=newDisbursementModel.getStateId();
					int disbursementAmount=newDisbursementModel.getDisbursementAmount();
					// TODO Auto-generated method stub
					System.out.println("Inside getSchemeAmount address = "+address);
					boolean status=true;
					CentralContract actualContract;
					try {
						actualContract=CentralContract.load(address, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
					TransactionReceipt transactionReceipt =actualContract.reverseBalanceAmountFromState(BigInteger.valueOf(stateId), BigInteger.valueOf(disbursementAmount)).send();
					}catch(Exception e) {
						e.printStackTrace();
						status=false;
					}
						//TransactionReceipt transactionReceipt = actualContract.setSchemeAmount(BigInteger.valueOf(1000)).send();
								//disburseAmountToState(BigInteger.valueOf(33), BigInteger.valueOf(1000)).send();
				    return newDisbursementModel;	
				}

		public DisbursementModel getReverseBalanceAmountFromState(DisbursementModel newDisbursementModel) {
			// TODO Auto-generated method stub
			String address=newDisbursementModel.getCentralAddress();
			int stateId=newDisbursementModel.getStateId();
			System.out.println("Inside getSchemeAmount address = "+address);
			CentralContract actualContract=null;
			int balanceAmount=0;
			try {
				 actualContract=CentralContract.load(address, web3j, credentials , BigInteger.valueOf(510_000L), BigInteger.valueOf(510_000L));
  			     balanceAmount = actualContract.getBalanceAmount(BigInteger.valueOf(stateId)).send().intValue();
  			     newDisbursementModel.setReturnedAmount(balanceAmount);
			}catch(Exception e) {
				e.printStackTrace();
				
			}			
				System.out.println("Returned balanceAmount for state   = "+balanceAmount);
			return newDisbursementModel;
		}
		
	public Contract createCentralScheme(Contract newContract) throws Exception  {
		System.out.println("Inside createCentralScheme service.....");
		
    	System.out.println("credentials.getAddress() "+credentials.getAddress());
    	System.out.println("newContract.getSchemeName() = "+newContract.getSchemeName());
    	System.out.println("newContract.getSchemeAmount()"+newContract.getSchemeAmount());
    	//Transactionfee contract = Transactionfee.deploy(web3j, credentials, GAS_PRICE, GAS_LIMIT, receiverCredentials.getAddress(), BigInteger.valueOf(newContract.getFee())).send();
    	EthGetBalance balance = web3j.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
    	System.out.println("Balance before deploying the contract: {}"+balance.getBalance().longValue());
    	//CentralContract contract = CentralContract.deploy(web3j,credentials,new CustomizedGasProvider(),newContract.getSchemeName().toString(),BigInteger.valueOf(newContract.getSchemeAmount())).send();
    	//PersonalUnlockAccount personalUnlockAccount = web3j_1.personalUnlockAccount(credentials.getAddress(), PASSWORD).send();//
    	
    	//System.out.println("From personalUnlockAccount.hasError() = "+personalUnlockAccount.getError().getMessage());

    	
    	CentralContract contract = CentralContract.deploy(web3j,credentials,BigInteger.valueOf(501_000L), BigInteger.valueOf(501_000L),newContract.getSchemeName().toString(),BigInteger.valueOf(newContract.getSchemeAmount())).send();
    	
    	//CentralContract actualContract=CentralContract.load(contract.getContractAddress(), web3j, credentials , BigInteger.valueOf(521_000L), BigInteger.valueOf(521_000L));
    	
    	
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
    	return newContract;
	
	}

	
}
