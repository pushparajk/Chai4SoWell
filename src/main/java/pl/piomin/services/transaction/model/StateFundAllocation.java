package pl.piomin.services.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stateFundAllocation")
public class StateFundAllocation {

	@Id
	private String stateContractAddress;
	private String centralAddress; 
	private Integer stateId;
	private Integer sanctionedAmount;
	private Integer schemeBalanceAmount;
	private Integer returnedAmount;
	private String schemeName;

	public Integer getSchemeBalanceAmount()
	{
		return schemeBalanceAmount;
	}

	public void setSchemeBalanceAmount(Integer schemeBalanceAmount)
	{
		this.schemeBalanceAmount = schemeBalanceAmount;
	}

	public String getStateContractAddress()
	{
		return stateContractAddress;
	}

	public void setStateContractAddress(String stateContractAddress)
	{
		this.stateContractAddress = stateContractAddress;
	}

	public String getCentralAddress()
	{
		return centralAddress;
	}

	public void setCentralAddress(String centralAddress)
	{
		this.centralAddress = centralAddress;
	}

	public Integer getStateId()
	{
		return stateId;
	}

	public void setStateId(Integer stateId)
	{
		this.stateId = stateId;
	}

	public Integer getSanctionedAmount()
	{
		return sanctionedAmount;
	}

	public void setSanctionedAmount(Integer sanctionedAmount)
	{
		this.sanctionedAmount = sanctionedAmount;
	}

	public Integer getReturnedAmount()
	{
		return returnedAmount;
	}

	public void setReturnedAmount(Integer returnedAmount)
	{
		this.returnedAmount = returnedAmount;
	}

	public String getSchemeName()
	{
		return schemeName;
	}

	public void setSchemeName(String schemeName)
	{
		this.schemeName = schemeName;
	}
	


}
