package pl.piomin.services.transaction.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharityDetail
{
    private String stateContractAddress;
    private String homeName;
    private Integer allocateAmount;
    private Integer schemeBalanceAmount;
    private String contractStatus;
    @JsonProperty("disbursementDetails") 
    private List<DisbursementDetail> disbursementDetails;

	public String getStateContractAddress()
	{
		return stateContractAddress;
	}
	public void setStateContractAddress(String stateContractAddress)
	{
		this.stateContractAddress = stateContractAddress;
	}
	public String getHomeName()
	{
		return homeName;
	}
	public void setHomeName(String homeName)
	{
		this.homeName = homeName;
	}
	public Integer getAllocateAmount()
	{
		return allocateAmount;
	}
	public void setAllocateAmount(Integer allocateAmount)
	{
		this.allocateAmount = allocateAmount;
	}
	public Integer getSchemeBalanceAmount()
	{
		return schemeBalanceAmount;
	}
	public void setSchemeBalanceAmount(Integer schemeBalanceAmount)
	{
		this.schemeBalanceAmount = schemeBalanceAmount;
	}
	public String getContractStatus()
	{
		return contractStatus;
	}
	public void setContractStatus(String contractStatus)
	{
		this.contractStatus = contractStatus;
	}
	public List<DisbursementDetail> getDisbursementDetails()
	{
		return disbursementDetails;
	}
	public void setDisbursementDetails(List<DisbursementDetail> disbursementDetails)
	{
		this.disbursementDetails = disbursementDetails;
	}
    
    
}
