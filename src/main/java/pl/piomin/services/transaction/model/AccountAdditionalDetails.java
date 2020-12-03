package pl.piomin.services.transaction.model;

import java.util.List;

public class AccountAdditionalDetails
{
	public String modeOfOperation;
	public String accountName;
	public List<Object> jointCustomerDetails;
	public List<Object> mandateDetails;
	public String postingRestriction;

	public String getModeOfOperation()
	{
		return modeOfOperation;
	}

	public void setModeOfOperation(String modeOfOperation)
	{
		this.modeOfOperation = modeOfOperation;
	}

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public List<Object> getJointCustomerDetails()
	{
		return jointCustomerDetails;
	}

	public void setJointCustomerDetails(List<Object> jointCustomerDetails)
	{
		this.jointCustomerDetails = jointCustomerDetails;
	}

	public List<Object> getMandateDetails()
	{
		return mandateDetails;
	}

	public void setMandateDetails(List<Object> mandateDetails)
	{
		this.mandateDetails = mandateDetails;
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