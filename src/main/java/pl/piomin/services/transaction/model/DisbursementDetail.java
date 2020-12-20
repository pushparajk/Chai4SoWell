package pl.piomin.services.transaction.model;

public class DisbursementDetail
{
    private String disbursementAddress;
    private String firstName;
    private String lastName;
    private String contractStatus;
    private Integer disbursementAmount;
    
    
	public Integer getDisbursementAmount()
	{
		return disbursementAmount;
	}
	public void setDisbursementAmount(Integer disbursementAmount)
	{
		this.disbursementAmount = disbursementAmount;
	}
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
