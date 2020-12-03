package pl.piomin.services.transaction.model;

import java.util.Date;

public class AccountCreationResponse
{
	private AccountDetails accountDetails;
	private String accountId;
	private Date createDateTime;

	public AccountDetails getAccountDetails()
	{
		return accountDetails;
	}

	public void setAccountDetails(AccountDetails accountDetails)
	{
		this.accountDetails = accountDetails;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public Date getCreateDateTime()
	{
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime)
	{
		this.createDateTime = createDateTime;
	}

}
