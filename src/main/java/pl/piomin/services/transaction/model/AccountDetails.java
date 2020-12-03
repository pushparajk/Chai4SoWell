package pl.piomin.services.transaction.model;

public class AccountDetails
{
	private String customerId;
	private String customerName;
	private String branchCode;
	private String productId;
	private String productDescription;
	private String accountName;
	private String accountOwnership;
	private String modeOfOperation;
	private String postingRestriction;

	public String getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
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

	public String getProductDescription()
	{
		return productDescription;
	}

	public void setProductDescription(String productDescription)
	{
		this.productDescription = productDescription;
	}

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public String getAccountOwnership()
	{
		return accountOwnership;
	}

	public void setAccountOwnership(String accountOwnership)
	{
		this.accountOwnership = accountOwnership;
	}

	public String getModeOfOperation()
	{
		return modeOfOperation;
	}

	public void setModeOfOperation(String modeOfOperation)
	{
		this.modeOfOperation = modeOfOperation;
	}

	public String getPostingRestriction()
	{
		return postingRestriction;
	}

	public void setPostingRestriction(String postingRestriction)
	{
		this.postingRestriction = postingRestriction;
	}

}
