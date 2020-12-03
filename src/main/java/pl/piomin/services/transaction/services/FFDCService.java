package pl.piomin.services.transaction.services;

import java.util.ArrayList;
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
import pl.piomin.services.transaction.model.Customer;
import pl.piomin.services.transaction.model.CustomerResponse;
import pl.piomin.services.transaction.model.EmailAddress;
import pl.piomin.services.transaction.model.FatcaDetails;
import pl.piomin.services.transaction.model.Identification;
import pl.piomin.services.transaction.model.OAuthTokenResponse;
import pl.piomin.services.transaction.model.PhoneNumber;

@Component
public class FFDCService
{

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
		map.add("grant_type", "client_credentials");
		map.add("client_secret", "04d00400-27f3-4d92-a1f4-16cc809e174f");
		map.add("client_id", "2ebd0a3a-3d10-4ae3-85bf-826b00930b4a");
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
		ResponseEntity<OAuthTokenResponse> oAuthTokenResponse = restTemplate.exchange("https://api.preprod.fusionfabric.cloud/login/v1/sandbox/oidc/token", HttpMethod.POST, entity, OAuthTokenResponse.class);
		return oAuthTokenResponse;
	}

	public AccountCreationResponse createAccount(Customer insertcustomer)
	{

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
		String uuid = UUID.randomUUID().toString();
		headers.add(X_REQUEST_ID, uuid);
		headers.add("Authorization", "Bearer " + getToken().getBody().getAccess_token().toString());//B2B token
		headers.add(IDEMPOTENCY_KEY, "44991089");

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
		ResponseEntity<AccountCreationResponse> response = restTemplate.exchange("https://api.preprod.fusionfabric.cloud/retail-banking/current-and-savings-account/onboarding/v1/accounts/currentsavings", HttpMethod.POST, entity, AccountCreationResponse.class);
		return response.getBody();
	}

	public Customer createCustomer(Customer insertcustomer)
	{

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
		String uuid = UUID.randomUUID().toString();
		headers.add(X_REQUEST_ID, uuid);
		headers.add("Authorization", "Bearer " + getToken().getBody().getAccess_token().toString());//B2B token
		headers.add(IDEMPOTENCY_KEY, "44991089");

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
		ResponseEntity<CustomerResponse> response = restTemplate.exchange("https://api.preprod.fusionfabric.cloud/retail-banking/customers/v1/personal-customers", HttpMethod.POST, entity, CustomerResponse.class);
		customer.setCustomerId(response.getBody().getCustomerId());
		return customer;
	}

	private AccountCreation setAccountCreation(Customer insertcustomer)
	{
		AccountCreation account = new AccountCreation();
		account.setCustomerId(insertcustomer.getCustomerId());
		account.setBranchCode(insertcustomer.getBranchCode());
		account.setProductId("01010DEFAULTUSD");
		account.setAccountOwnership("SOLE");

		AccountAdditionalDetails accountAdditionalDetails = new AccountAdditionalDetails();
		accountAdditionalDetails.setAccountName(insertcustomer.getFirstName() + " " + insertcustomer.getLastName());
		accountAdditionalDetails.setModeOfOperation("SOLE");
		accountAdditionalDetails.setPostingRestriction("DEBITCREDIT");
		accountAdditionalDetails.setJointCustomerDetails(new ArrayList<Object>());
		accountAdditionalDetails.setMandateDetails(new ArrayList<Object>());
		return account;

	}
	private Customer setCustomer(Customer insertcustomer)
	{
		Customer customer = new Customer();
		customer.setFirstName(insertcustomer.getFirstName());
		customer.setLastName(insertcustomer.getLastName());
		customer.setBranchCode("00000001");
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
		addres.setLine3("");
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
