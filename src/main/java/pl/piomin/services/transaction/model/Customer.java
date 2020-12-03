package pl.piomin.services.transaction.model;

import java.util.List;

public class Customer
{

	private String branchCode;
	private String customerId;
	private String title;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String countryOfResidency;
	private Identification identification;
	private String kycCheckRequired;
	private List<Address> addresses;
	private List<PhoneNumber> phoneNumbers;
	private List<EmailAddress> emailAddresses;
	private FatcaDetails fatcaDetails;

	public String getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}
	public String getBranchCode()
	{
		return branchCode;
	}
	public void setBranchCode(String branchCode)
	{
		this.branchCode = branchCode;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getCountryOfResidency()
	{
		return countryOfResidency;
	}
	public void setCountryOfResidency(String countryOfResidency)
	{
		this.countryOfResidency = countryOfResidency;
	}

	public Identification getIdentification()
	{
		return identification;
	}

	public void setIdentification(Identification identification)
	{
		this.identification = identification;
	}
	public String getKycCheckRequired()
	{
		return kycCheckRequired;
	}
	public void setKycCheckRequired(String kycCheckRequired)
	{
		this.kycCheckRequired = kycCheckRequired;
	}

	public List<Address> getAddresses()
	{
		return addresses;
	}

	public void setAddresses(List<Address> addresses)
	{
		this.addresses = addresses;
	}

	public List<PhoneNumber> getPhoneNumbers()
	{
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers)
	{
		this.phoneNumbers = phoneNumbers;
	}

	public List<EmailAddress> getEmailAddresses()
	{
		return emailAddresses;
	}

	public void setEmailAddresses(List<EmailAddress> emailAddresses)
	{
		this.emailAddresses = emailAddresses;
	}

	public FatcaDetails getFatcaDetails()
	{
		return fatcaDetails;
	}

	public void setFatcaDetails(FatcaDetails fatcaDetails)
	{
		this.fatcaDetails = fatcaDetails;
	}

}

