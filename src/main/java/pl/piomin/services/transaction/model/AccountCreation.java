package pl.piomin.services.transaction.model;

public class AccountCreation
{
	public String customerId;
	public String branchCode;
	public String productId;
	public String accountOwnership;
	public AccountAdditionalDetails accountAdditionalDetails;

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

	public String getProductId()
	{
		return productId;
	}

	public void setProductId(String productId)
	{
		this.productId = productId;
	}

	public String getAccountOwnership()
	{
		return accountOwnership;
	}

	public void setAccountOwnership(String accountOwnership)
	{
		this.accountOwnership = accountOwnership;
	}

	public AccountAdditionalDetails getAccountAdditionalDetails()
	{
		return accountAdditionalDetails;
	}

	public void setAccountAdditionalDetails(AccountAdditionalDetails accountAdditionalDetails)
	{
		this.accountAdditionalDetails = accountAdditionalDetails;
	}

}

