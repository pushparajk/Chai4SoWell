package pl.piomin.services.transaction.model;

import java.util.List;

public class FinancialPosting
{
	private boolean forcePostIndicator;
	private List<PostingEntry> postingEntries;
	private String sourceBranchCode;
	private String sourceId;
	private String transactionReference;
	private String valueDate;

	public boolean isForcePostIndicator()
	{
		return forcePostIndicator;
	}

	public void setForcePostIndicator(boolean forcePostIndicator)
	{
		this.forcePostIndicator = forcePostIndicator;
	}

	public List<PostingEntry> getPostingEntries()
	{
		return postingEntries;
	}

	public void setPostingEntries(List<PostingEntry> postingEntries)
	{
		this.postingEntries = postingEntries;
	}

	public String getSourceBranchCode()
	{
		return sourceBranchCode;
	}

	public void setSourceBranchCode(String sourceBranchCode)
	{
		this.sourceBranchCode = sourceBranchCode;
	}

	public String getSourceId()
	{
		return sourceId;
	}

	public void setSourceId(String sourceId)
	{
		this.sourceId = sourceId;
	}

	public String getTransactionReference()
	{
		return transactionReference;
	}

	public void setTransactionReference(String transactionReference)
	{
		this.transactionReference = transactionReference;
	}

	public String getValueDate()
	{
		return valueDate;
	}

	public void setValueDate(String valueDate)
	{
		this.valueDate = valueDate;
	}

}



