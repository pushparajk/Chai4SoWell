package pl.piomin.services.transaction.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contract")
public class ContractSummary extends Contract
{

	private Integer noOfSchemes;
	private String totalAmount;

	public Integer getNoOfSchemes()
	{
		return noOfSchemes;
	}

	public void setNoOfSchemes(Integer noOfScheme)
	{
		this.noOfSchemes = noOfScheme;
	}

	public String getTotalAmount()
	{
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount)
	{
		this.totalAmount = totalAmount;
	}


}
