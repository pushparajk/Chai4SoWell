package pl.piomin.services.transaction.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.piomin.services.transaction.model.AccountAdditionalDetails;
import pl.piomin.services.transaction.model.AccountCreation;
import pl.piomin.services.transaction.model.AccountCreationResponse;
import pl.piomin.services.transaction.model.Address;
import pl.piomin.services.transaction.model.Amount;
import pl.piomin.services.transaction.model.BaseEquivalent;
import pl.piomin.services.transaction.model.Customer;
import pl.piomin.services.transaction.model.CustomerResponse;
import pl.piomin.services.transaction.model.EmailAddress;
import pl.piomin.services.transaction.model.FatcaDetails;
import pl.piomin.services.transaction.model.FinancialPosting;
import pl.piomin.services.transaction.model.Identification;
import pl.piomin.services.transaction.model.IndividualDisbursement;
import pl.piomin.services.transaction.model.OAuthTokenResponse;
import pl.piomin.services.transaction.model.PhoneNumber;
import pl.piomin.services.transaction.model.PostingEntry;
import pl.piomin.services.transaction.model.TransferModel;
import pl.piomin.services.transaction.utils.TransactionContants;

@Component
public class FFDCService
{


	private static final String DEBITCREDIT = "DEBITCREDIT";

	private static final String BEARER = "Bearer ";

	private static final String SOLE = "SOLE";

	private static final String EMPTY = "";

	private static final String C00 = "C00";

	private static final String C01 = "C01";

	private static final String FUND_TRANSFER = "Fund Transfer";

	private static final String DEBIT = "DEBIT";

	private static final String CREDIT = "CREDIT";


	/** The rest template. */
	@Autowired
	private RestTemplate restTemplate;

	/** The Constant X_REQUEST_ID. */
	private static final String X_REQUEST_ID = "X-Request-ID";

	//private static final String AUTHORIZATION = "Authorization";

	/** The Constant CHANNEL_TYPE. */
	private static final String CHANNEL_TYPE = "X-finastra-channel-type";

	/** The Constant IDEMPOTENCY_KEY. */
	private static final String IDEMPOTENCY_KEY = "Idempotency-Key";

	public ResponseEntity<OAuthTokenResponse> getToken()
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add(TransactionContants.GRANT_TYPE, TransactionContants.CLIENT_CREDENTIALS);
		map.add(TransactionContants.CLIENT_SECRET, TransactionContants.CLIENT_SECRET_VAL);
		map.add(TransactionContants.CLIENT_ID, TransactionContants.CLIENT_ID_VAL);
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
		ResponseEntity<OAuthTokenResponse> oAuthTokenResponse = restTemplate.exchange(TransactionContants.FFDC_TOKEN_URL, HttpMethod.POST, entity, OAuthTokenResponse.class);
		return oAuthTokenResponse;
	}

	public AccountCreationResponse createAccount(Customer insertcustomer)
	{

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
		String uuid = UUID.randomUUID().toString();
		headers.add(X_REQUEST_ID, uuid);
		headers.add(TransactionContants.AUTHORIZATION, BEARER + getToken().getBody().getAccess_token().toString());//B2B token
		headers.add(IDEMPOTENCY_KEY, TransactionContants.IDEMPOTENCY_KEY_VALUE);

		AccountCreation setAccountCreation = setAccountCreation(insertcustomer);
		String writeValueAsString = null;
		try
		{
			writeValueAsString = new ObjectMapper().writeValueAsString(setAccountCreation);
		}
		catch (JsonProcessingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpEntity<String> entity = new HttpEntity<String>(writeValueAsString, headers);
		ResponseEntity<AccountCreationResponse> response = restTemplate.exchange(TransactionContants.FFDC_ACCOUNT_CREATE, HttpMethod.POST, entity, AccountCreationResponse.class);
		return response.getBody();
	}

	
	public String checkCustomer(IndividualDisbursement individualDisbursement){
		 DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy"); 
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE.toString());
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("gender", individualDisbursement.getGender());
		map.add("dob", dateFormat.format(individualDisbursement.getDob()));
		map.add("is_employed", individualDisbursement.getIsEmployed());
		map.add("income", individualDisbursement.getIncome());
		map.add("amount", individualDisbursement.getDisbursementAmount().toString());
		map.add("txn_date",  dateFormat.format(new Date()));
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<String> response = restTemplate.exchange(TransactionContants.ML_URL, HttpMethod.POST, entity, String.class);
		return response.getBody();
	}
	public Customer createCustomer(Customer insertcustomer)
	{

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
		String uuid = UUID.randomUUID().toString();
		headers.add(X_REQUEST_ID, uuid);
		headers.add(TransactionContants.AUTHORIZATION, BEARER + getToken().getBody().getAccess_token().toString());//B2B token
		headers.add(IDEMPOTENCY_KEY, TransactionContants.IDEMPOTENCY_KEY_VALUE);

		Customer customer = setCustomer(insertcustomer);
		String writeValueAsString = null;
		try
		{
			writeValueAsString = new ObjectMapper().writeValueAsString(customer);
		}
		catch (JsonProcessingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpEntity<String> entity = new HttpEntity<String>(writeValueAsString, headers);
		ResponseEntity<CustomerResponse> response = restTemplate.exchange(TransactionContants.FFDC_CUSTOMER_CREATE, HttpMethod.POST, entity, CustomerResponse.class);
		customer.setCustomerId(response.getBody().getCustomerId());
		return customer;
	}

	public String FundTransfer(TransferModel transferModel)
	{

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
		String uuid = UUID.randomUUID().toString();
		headers.add(X_REQUEST_ID, uuid);
		headers.add(TransactionContants.AUTHORIZATION, BEARER + getToken().getBody().getAccess_token().toString());//B2B token
		headers.add(IDEMPOTENCY_KEY, TransactionContants.IDEMPOTENCY_KEY_VALUE);

		FinancialPosting financialPostingReq = setFinancialPosting(transferModel);
		String writeValueAsString = null;
		try
		{
			writeValueAsString = new ObjectMapper().writeValueAsString(financialPostingReq);
		}
		catch (JsonProcessingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpEntity<String> entity = new HttpEntity<String>(writeValueAsString, headers);
		ResponseEntity<String> response = restTemplate.exchange(TransactionContants.FFDC_FIN_POSTING, HttpMethod.POST, entity, String.class);

		return response.getBody().toString();
	}

	private AccountCreation setAccountCreation(Customer insertcustomer)
	{
		AccountCreation account = new AccountCreation();
		account.setCustomerId(insertcustomer.getCustomerId());
		account.setBranchCode(insertcustomer.getBranchCode());
		account.setProductId(TransactionContants.PRODUCT_ID);
		account.setAccountOwnership(SOLE);

		AccountAdditionalDetails accountAdditionalDetails = new AccountAdditionalDetails();
		accountAdditionalDetails.setAccountName(insertcustomer.getFirstName() + " " + insertcustomer.getLastName());
		accountAdditionalDetails.setModeOfOperation(SOLE);
		accountAdditionalDetails.setPostingRestriction(DEBITCREDIT);
		accountAdditionalDetails.setJointCustomerDetails(new ArrayList<Object>());
		accountAdditionalDetails.setMandateDetails(new ArrayList<Object>());
		return account;

	}

	private FinancialPosting setFinancialPosting(TransferModel transferModel)
	{
		FinancialPosting financialPosting = new FinancialPosting();
		financialPosting.setForcePostIndicator(true);
		financialPosting.setSourceBranchCode(TransactionContants.BRANCH_CODE);
		financialPosting.setValueDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		financialPosting.setTransactionReference(UUID.randomUUID().toString());
		financialPosting.setSourceId("FFDC");
		PostingEntry postingEntry = new PostingEntry();
		List<PostingEntry> postingEntries = new ArrayList<>();
		//Debit
		postingEntry.setAccountId(transferModel.getToAccount()); 
		postingEntry.setExchangeRate(1);
		postingEntry.setAmount(new Amount(transferModel.getCurrency(), transferModel.getAmount()));
		postingEntry.setBaseEquivalent(new BaseEquivalent(transferModel.getCurrency(), transferModel.getAmount()));
		postingEntry.setBlockReference(EMPTY);
		postingEntry.setChequeNumber(EMPTY);
		postingEntry.setCreditDebitIndicator(DEBIT);
		postingEntry.setPostingType(C00);
		postingEntry.setNarrative(FUND_TRANSFER);
		postingEntries.add(postingEntry);
		
		//Credit
		postingEntry = new PostingEntry();
		postingEntry.setAccountId(transferModel.getFromAccount());
		postingEntry.setExchangeRate(1);
		postingEntry.setAmount(new Amount(transferModel.getCurrency(), transferModel.getAmount()));
		postingEntry.setBaseEquivalent(new BaseEquivalent(transferModel.getCurrency(), transferModel.getAmount()));
		postingEntry.setBlockReference(EMPTY);
		postingEntry.setChequeNumber(EMPTY);
		postingEntry.setCreditDebitIndicator(CREDIT);
		postingEntry.setPostingType(C01);
		postingEntry.setNarrative(FUND_TRANSFER);
		postingEntries.add(postingEntry);
		
		financialPosting.setPostingEntries(postingEntries);

		return financialPosting;
	}
	private Customer setCustomer(Customer insertcustomer)
	{
		Customer customer = new Customer();
		customer.setFirstName(insertcustomer.getFirstName());
		customer.setLastName(insertcustomer.getLastName());
		customer.setBranchCode(TransactionContants.BRANCH_CODE);
		customer.setTitle("Mr");
		customer.setDateOfBirth("1989-05-01");
		customer.setGender("MALE");
		customer.setCountryOfResidency("US");

		Identification identification = new Identification();
		identification.setId(insertcustomer.getIdentification().getId());
		identification.setType("CCPT");

		customer.setIdentification(identification);
		customer.setKycCheckRequired("CORE-DEFINED");

		Address addres = new Address();
		addres.setAddressType("BUSINESS");
		addres.setBuildingNumber("109");
		addres.setCountry("US");
		addres.setLine1("Starbucks Branch");
		addres.setLine2("201 Powell Street");
		addres.setLine3(EMPTY);
		addres.setLine4("San Francisco");
		addres.setLine5("CA");
		addres.setPostalCode("94102");
		List<Address> addressList = new ArrayList<>();
		addressList.add(addres);
		customer.setAddresses(addressList);

		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setType("MOBILE");
		phoneNumber.setNumber("0044 01753 573244");
		List<PhoneNumber> phoneNumberList = new ArrayList<>();
		phoneNumberList.add(phoneNumber);
		customer.setPhoneNumbers(phoneNumberList);

		EmailAddress emailAddress = new EmailAddress();
		emailAddress.setType("HOME");
		emailAddress.setAddress("OfficeAdmin@OfficeAddress.com");
		List<EmailAddress> emailAddressList = new ArrayList<>();
		emailAddressList.add(emailAddress);
		customer.setEmailAddresses(emailAddressList);

		FatcaDetails fatcaDetails = new FatcaDetails();
		fatcaDetails.setTin("234581");
		fatcaDetails.setUSResident(true);
		fatcaDetails.setUSTaxResident(true);

		customer.setFatcaDetails(fatcaDetails);
		return customer;
	}

}
