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
import pl.piomin.services.transaction.model.DonationModel;
import pl.piomin.services.transaction.model.FundAllocationModel;
import pl.piomin.services.transaction.services.CentralSchemeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/scheme")
public class CentralContractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CentralContractController.class);
    public static final BigInteger GAS_PRICE = BigInteger.valueOf(1L);
    public static final BigInteger GAS_LIMIT = BigInteger.valueOf(21_000L);

    @Autowired
    CentralSchemeService service;
    
    @GetMapping(value="/schemename/{address}")
    public String getSchemeName(@PathVariable String address) {
    	System.out.println("Inside getSchemeName() in controller address = "+address);
    	return service.getSchemeName(address);
    }

    @GetMapping(value="/schemeamount/{address}")
    public String getSchemeAmount(@PathVariable String address) {
    	System.out.println("Inside getSchemeAmount() in controller");
    	return ""+service.getSchemeAmount(address);
    }
    
    @PostMapping(path = "/create")
    public Contract createContract(@RequestBody Contract newContract) throws Exception {
    	System.out.println("Inside createContract()");
    	return service.createCentralScheme(newContract);
    }

    @GetMapping(value="/getCentralSchemeDetails")
    //@RequestMapping("{address}")
    public Contract getCentralSchemeDetails(@RequestBody Contract ContractModel) {
    	System.out.println("Inside getSchemeAmount() in controller");
    	return service.getCentralSchemeDetails(ContractModel);
    }

    
    @PostMapping(path = "/disburseAmountToState")
    public FundAllocationModel disburseAmountToState(@RequestBody FundAllocationModel newDisbursementModel) throws Exception {
    	System.out.println("Inside createContract()");
    	return service.disburseAmountToState(newDisbursementModel);
    }

    
    @PostMapping(path = "/reverseBalanceAmountFromState")
    public FundAllocationModel reverseBalanceAmountFromState(@RequestBody FundAllocationModel newDisbursementModel) throws Exception {
    	System.out.println("Inside reverseBalanceAmountFromState() in controller");
    	return service.reverseBalanceAmountFromState(newDisbursementModel);
    }


    @GetMapping(value="/getReverseBalanceAmountFromState")
    public FundAllocationModel getReverseBalanceAmountFromState(@RequestBody FundAllocationModel newDisbursementModel) {
    	System.out.println("Inside getDisbursementAmount() in controller");
    	return service.getReverseBalanceAmountFromState(newDisbursementModel);
    }

    @GetMapping(value="/getStateSchemeDetails")
    public FundAllocationModel getStateSchemeDetails(@RequestBody FundAllocationModel newFundAllocationModel) {
    	System.out.println("Inside getDisbursementAmount() in controller");
    	return service.getStateSchemeDetails(newFundAllocationModel);
    }
    
    @PostMapping(path = "/disburseAmountToIndividual")
    public DisbursementModel disburseAmountToIndividual(@RequestBody DisbursementModel newDisbursementModel) throws Exception {
    	System.out.println("Inside disburseAmountToIndividual() in controller");
    	return service.disburseAmountToIndividual(newDisbursementModel);
    }

    @GetMapping(value="/getDisbursementDetails")
    public DisbursementModel getDisbursementDetails(@RequestBody DisbursementModel newDisbursementModel) {
    	System.out.println("Inside getDisbursementAmount() in controller");
    	return service.getDisbursementDetails(newDisbursementModel);
    }

    @PostMapping(path = "/makeDonation")
    public DonationModel  makeDonation(@RequestBody DonationModel newDonationModel) throws Exception {
    	System.out.println("Inside disburseAmountToIndividual() in controller");
    	return service.makeDonation(newDonationModel);
    }


}
