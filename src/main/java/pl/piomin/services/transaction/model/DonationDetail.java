package pl.piomin.services.transaction.model;

public class DonationDetail
{
    private String disbursementAddress;
    private String firstName;
    private String lastName;
    private String contractStatus;
	public String getDisbursementAddress()
	{
		return disbursementAddress;
	}
	public void setDisbursementAddress(String disbursementAddress)
	{
		this.disbursementAddress = disbursementAddress;
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
	public String getContractStatus()
	{
		return contractStatus;
	}
	public void setContractStatus(String contractStatus)
	{
		this.contractStatus = contractStatus;
	}
    
}
