package pl.piomin.services.transaction.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthCoinbase;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;

import pl.piomin.services.transaction.model.Contract;
import pl.piomin.services.transaction.model.DisbursementModel;
import pl.piomin.services.transaction.services.CentralSchemeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/scheme")
public class CentralContractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CentralContractController.class);
    public static final BigInteger GAS_PRICE = BigInteger.valueOf(1L);
    public static final BigInteger GAS_LIMIT = BigInteger.valueOf(21_000L);
/*    
    //@Value("${contract-service.url}")
    //String url;
    @Autowired
    Web3j web3j;
    @Autowired
    RestTemplate template;
    Credentials credentials;
    
    @PostConstruct
    public void init() throws IOException, CipherException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {    	
    	EthCoinbase coinbase = web3j.ethCoinbase().send();
    	EthAccounts accounts = web3j.ethAccounts().send();
    	for (int i = 1; i < accounts.getAccounts().size(); i++) {
    		EthGetTransactionCount transactionCount = web3j.ethGetTransactionCount(coinbase.getAddress(), DefaultBlockParameterName.LATEST).send();
            Transaction transaction = Transaction.createEtherTransaction(coinbase.getAddress(), transactionCount.getTransactionCount(), GAS_PRICE, GAS_LIMIT, accounts.getAccounts().get(i), BigInteger.valueOf(25_000_000_000L));
            web3j.ethSendTransaction(transaction).send();
            EthGetBalance balance = web3j.ethGetBalance(accounts.getAccounts().get(i), DefaultBlockParameterName.LATEST).send();
        	LOGGER.info("Balance: address={}, amount={}", accounts.getAccounts().get(i), balance.getBalance().longValue());
		}
    }
*/

    @Autowired
    CentralSchemeService service;
    
///centralScheme/schemeName
    @GetMapping(value="/schemename/{address}")
    //@RequestMapping("{address}")
    public String getSchemeName(@PathVariable String address) {
    	System.out.println("Inside getSchemeName() in controller address = "+address);
    	return service.getSchemeName(address);
    }

    @GetMapping(value="/schemeamount/{address}")
    //@RequestMapping("{address}")
    public String getSchemeAmount(@PathVariable String address) {
    	System.out.println("Inside getSchemeAmount() in controller");
    	return ""+service.getSchemeAmount(address);
    }
    
    @PostMapping(path = "/create")
    public Contract createContract(@RequestBody Contract newContract) throws Exception {
    	System.out.println("Inside createContract()");
    	return service.createCentralScheme(newContract);
    }

    @PostMapping(path = "/disburseAmountToState")
    public DisbursementModel disburseAmountToState(@RequestBody DisbursementModel newDisbursementModel) throws Exception {
    	System.out.println("Inside createContract()");
    	return service.disburseAmountToState(newDisbursementModel);
    }

    @GetMapping(value="/getDisbursementAmount")
    //@RequestMapping("{address}")
    public DisbursementModel getDisbursementAmount(@RequestBody DisbursementModel newDisbursementModel) {
    	System.out.println("Inside getSchemeAmount() in controller");
    	return service.getdisburseAmountToState(newDisbursementModel);
    }
    
    @PostMapping(path = "/reverseBalanceAmountFromState")
    public DisbursementModel reverseBalanceAmountFromState(@RequestBody DisbursementModel newDisbursementModel) throws Exception {
    	System.out.println("Inside reverseBalanceAmountFromState() in controller");
    	return service.reverseBalanceAmountFromState(newDisbursementModel);
    }


    @GetMapping(value="/getReverseBalanceAmountFromState")
    //@RequestMapping("{address}")
    public DisbursementModel getReverseBalanceAmountFromState(@RequestBody DisbursementModel newDisbursementModel) {
    	System.out.println("Inside getDisbursementAmount() in controller");
    	return service.getReverseBalanceAmountFromState(newDisbursementModel);
    }

    @PostMapping(path = "/disburseAmountToIndividual")
    public DisbursementModel disburseAmountToIndividual(@RequestBody DisbursementModel newDisbursementModel) throws Exception {
    	System.out.println("Inside disburseAmountToIndividual() in controller");
    	return service.disburseAmountToIndividual(newDisbursementModel);
    }

}
