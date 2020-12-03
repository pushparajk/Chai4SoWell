package pl.piomin.services.transaction.model;

public class PostingEntry
{
	public String accountId;
	public Amount amount;
	public BaseEquivalent baseEquivalent;
	public int exchangeRate;
	public String blockReference;
	public String chequeNumber;
	public String creditDebitIndicator;
	public String narrative;
	public String postingType;

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public Amount getAmount()
	{
		return amount;
	}

	public void setAmount(Amount amount)
	{
		this.amount = amount;
	}

	public BaseEquivalent getBaseEquivalent()
	{
		return baseEquivalent;
	}

	public void setBaseEquivalent(BaseEquivalent baseEquivalent)
	{
		this.baseEquivalent = baseEquivalent;
	}

	public int getExchangeRate()
	{
		return exchangeRate;
	}

	public void setExchangeRate(int exchangeRate)
	{
		this.exchangeRate = exchangeRate;
	}

	public String getBlockReference()
	{
		return blockReference;
	}

	public void setBlockReference(String blockReference)
	{
		this.blockReference = blockReference;
	}

	public String getChequeNumber()
	{
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber)
	{
		this.chequeNumber = chequeNumber;
	}

	public String getCreditDebitIndicator()
	{
		return creditDebitIndicator;
	}

	public void setCreditDebitIndicator(String creditDebitIndicator)
	{
		this.creditDebitIndicator = creditDebitIndicator;
	}

	public String getNarrative()
	{
		return narrative;
	}

	public void setNarrative(String narrative)
	{
		this.narrative = narrative;
	}

	public String getPostingType()
	{
		return postingType;
	}

	public void setPostingType(String postingType)
	{
		this.postingType = postingType;
	}

}
