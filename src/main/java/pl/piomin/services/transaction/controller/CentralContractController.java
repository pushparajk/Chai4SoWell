package pl.piomin.services.transaction.controller;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.services.transaction.model.AccountCreationResponse;
import pl.piomin.services.transaction.model.Bank;
import pl.piomin.services.transaction.model.Contract;
import pl.piomin.services.transaction.model.ContractSummary;
import pl.piomin.services.transaction.model.CreateCustomerRequest;
import pl.piomin.services.transaction.model.DonationModel;
import pl.piomin.services.transaction.model.IndividualDisbursement;
import pl.piomin.services.transaction.model.MLResponse;
import pl.piomin.services.transaction.model.State;
import pl.piomin.services.transaction.model.StateFundAllocation;
import pl.piomin.services.transaction.model.TreeResponse;
import pl.piomin.services.transaction.services.CentralSchemeService;


@CrossOrigin
@RestController
@RequestMapping("/scheme")
public class CentralContractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CentralContractController.class);
    public static final BigInteger GAS_PRICE = BigInteger.valueOf(1L);
    public static final BigInteger GAS_LIMIT = BigInteger.valueOf(21_000L);

    @Autowired
    CentralSchemeService service;
    //comment added
	@PostMapping(path = "/createCentralScheme")
    public Contract createContract(@RequestBody Contract newContract) throws Exception {
		System.out.println("Inside createCentralScheme()");
    	return service.createCentralScheme(newContract);
    }

    @GetMapping(value="/getCentralSchemeDetails")
	public List<Contract> getCentralSchemeDetails()
	{
		System.out.println("Inside getCentralSchemeDetails() in controller");
		return service.getCentralSchemeDetails();
	}

	@GetMapping(value = "/getSchemeSummary")
	public List<ContractSummary> getSchemeSummary()
	{
		System.out.println("Inside getSchemeSummary() in controller");
		return service.getSchemeSummary();
	}

	@GetMapping(value = "/getSchemeHierarchyDetails/{centralContractAddress}")
	public TreeResponse getSchemeHierarchyDetails(@PathVariable("centralContractAddress") String centralContractAddress)
	{
		System.out.println("Inside getCentralSchemeDetails() in controller");
		return service.getSchemeHierarchyDetails(centralContractAddress);
    }

	
	@GetMapping(value = "/getCentralSchemeDetails/{centralContractAddress}")
	public Contract getCentralSchemeDetails(@PathVariable("centralContractAddress") String centralContractAddress)
	{
		System.out.println("Inside getCentralSchemeDetails() in controller");
		return service.getCentralSchemeDetails(centralContractAddress);
    }
	
	

	@GetMapping(value = "/getCharityHouseList")
	public List<State> getCharityHouseList()
	{
		System.out.println("Inside getStateList() in controller");
		return service.getStateList();
	}
	
    
    @PostMapping(path = "/stateList")
    public String insertStateList( @RequestBody List<State> state) throws Exception {
		System.out.println("Inside disburseAmountToState()");
    	return service.insertStateList(state);
    }
    

	@GetMapping(value = "/getBankList")
	public List<Bank> getBankDetails()
	{
		System.out.println("Inside getBankList() in controller");
		return service.getBankDetails();
	}

    
    @PostMapping(path = "/disburseAmountToState")
    public StateFundAllocation disburseAmountToState(@Valid @RequestBody StateFundAllocation newDisbursementModel) throws Exception {
		System.out.println("Inside disburseAmountToState()");
    	return service.disburseAmountToState(newDisbursementModel);
    }

    
    @PostMapping(path = "/reverseBalanceAmountFromState")
	public Contract reverseBalanceAmountFromState(@RequestBody StateFundAllocation newDisbursementModel) throws Exception
	{
    	System.out.println("Inside reverseBalanceAmountFromState() in controller");
    	return service.reverseBalanceAmountFromState(newDisbursementModel);
    }


    @GetMapping(value="/getReverseBalanceAmountFromState")
    public StateFundAllocation getReverseBalanceAmountFromState(@RequestBody StateFundAllocation newDisbursementModel) {
		System.out.println("Inside getReverseBalanceAmountFromState() in controller");
    	return service.getReverseBalanceAmountFromState(newDisbursementModel);
    }

    @GetMapping(value="/getStateSchemeDetails")
	public List<StateFundAllocation> getStateSchemeDetails()
	{
		System.out.println("Inside getStateSchemeDetails() in controller");
		return service.getStateSchemeDetails();
    }
    
	@GetMapping(value = "/getStateSchemeDetails/{stateContractAddress}")
	public StateFundAllocation getStateSchemeDetails(@PathVariable("stateContractAddress") String stateContractAddress)
	{
		System.out.println("Inside getStateSchemeDetails() in controller");
		return service.getStateSchemeDetails(stateContractAddress);
	}

	@GetMapping(value = "/getStateSchemeDetailsByCentralContract/{centralContractAddress}")
	public List<StateFundAllocation> getStateSchemeDetailsByCentralContract(@PathVariable("centralContractAddress") String centralContractAddress)
	{
		System.out.println("Inside getStateSchemeDetailsByCentralContract() in controller");
		return service.getStateSchemeDetailsByCentralContract(centralContractAddress);
	}

    @PostMapping(path = "/disburseAmountToIndividual")
    public IndividualDisbursement disburseAmountToIndividual( @Valid @RequestBody IndividualDisbursement newDisbursementModel) throws Exception {
    	System.out.println("Inside disburseAmountToIndividual() in controller");
    	return service.disburseAmountToIndividual(newDisbursementModel);
    }

    @GetMapping(value="/getDisbursementDetails")
	public List<IndividualDisbursement> getDisbursementDetails()
	{
    	System.out.println("Inside getDisbursementAmount() in controller");
		return service.getDisbursementDetails();
    }

	@PostMapping(value = "/CreateCustomer")
	public AccountCreationResponse createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest)
	{
		System.out.println("Inside createCustomer() in controller");
		return service.createCustomer(createCustomerRequest);
	}
	
	@PostMapping(value = "/CheckCustomer")
	public MLResponse checkCustomer(@RequestBody IndividualDisbursement individualDisbursement)
	{
		System.out.println("Inside checkCustomer() in controller");
		return service.checkCustomer(individualDisbursement);
	}

	@GetMapping(value = "/getDisbursementDetailsByStateContract/{stateContractAddress}")
	public List<IndividualDisbursement> getDisbursementDetailsByStateContract(@Valid @PathVariable("stateContractAddress") String stateContractAddress)
	{
		System.out.println("Inside getDisbursementDetailsByStateContract() in controller");
		return service.getIndividualDisbursementByStateContract(stateContractAddress);
	}

	@GetMapping(value = "/getDisbursementDetails/{disbursementAddress}")
	public IndividualDisbursement getDisbursementDetails(@PathVariable("disbursementAddress") String disbursementAddress)
	{
		System.out.println("Inside getDisbursementAmount() in controller");
		return service.getDisbursementDetails(disbursementAddress);
	}

    @PostMapping(path = "/makeDonation")
    public DonationModel  makeDonation(@RequestBody DonationModel newDonationModel) throws Exception {
    	System.out.println("Inside disburseAmountToIndividual() in controller");
    	return service.makeDonation(newDonationModel);
    }

	@GetMapping(value = "/getDonationDetails")
	public List<DonationModel> getDonationDetails()
	{
		System.out.println("Inside getDonationList() in controller");
		return service.getDonationList();
	}
	@GetMapping(value = "/verifyStateContract/{stateAddress}")
	public StateFundAllocation verifyStateContract(@PathVariable("stateAddress") String stateAddress)
	{
		return service.verifyStateContract(stateAddress);
	}
	
	@GetMapping(value = "/verifyIndividualContract/{disbursementAddress}")
	public IndividualDisbursement verifyIndividualContract(@PathVariable("disbursementAddress") String disbursementAddress)
	{
		return service.verifyIndividualDisburementContract(disbursementAddress);
	}

	

}
