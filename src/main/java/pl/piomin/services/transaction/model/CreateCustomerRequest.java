package pl.piomin.services.transaction.model;

public class CreateCustomerRequest
{

	private String title;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String country;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String addressLine4;
	private String addressLine5;
	private String postalCode;
	private boolean isUSResident;
	private boolean isUSTaxResident;
	private String tin;
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
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	public String getAddressLine1()
	{
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2()
	{
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2)
	{
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3()
	{
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3)
	{
		this.addressLine3 = addressLine3;
	}
	public String getAddressLine4()
	{
		return addressLine4;
	}
	public void setAddressLine4(String addressLine4)
	{
		this.addressLine4 = addressLine4;
	}
	public String getAddressLine5()
	{
		return addressLine5;
	}
	public void setAddressLine5(String addressLine5)
	{
		this.addressLine5 = addressLine5;
	}
	public String getPostalCode()
	{
		return postalCode;
	}
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}
	public boolean isUSResident()
	{
		return isUSResident;
	}
	public void setUSResident(boolean isUSResident)
	{
		this.isUSResident = isUSResident;
	}
	public boolean isUSTaxResident()
	{
		return isUSTaxResident;
	}
	public void setUSTaxResident(boolean isUSTaxResident)
	{
		this.isUSTaxResident = isUSTaxResident;
	}
	public String getTin()
	{
		return tin;
	}
	public void setTin(String tin)
	{
		this.tin = tin;
	}

}

