package pl.piomin.services.transaction.model;

public class TransferModel
{
	private String fromAccount;
	private String toAccount;
	private Integer Amount;
	private String currency;
	public String getFromAccount()
	{
		return fromAccount;
	}
	public void setFromAccount(String fromAccount)
	{
		this.fromAccount = fromAccount;
	}
	public String getToAccount()
	{
		return toAccount;
	}
	public void setToAccount(String toAccount)
	{
		this.toAccount = toAccount;
	}
	public Integer getAmount()
	{
		return Amount;
	}
	public void setAmount(Integer amount)
	{
		Amount = amount;
	}
	public String getCurrency()
	{
		return currency;
	}
	public void setCurrency(String currency)
	{
		this.currency = currency;
	}
	
	
}
