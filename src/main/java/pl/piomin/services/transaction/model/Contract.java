package pl.piomin.services.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contract")
public class Contract {

	@Id
	private String centralContractAddress;
	private String schemeName;
	private Integer schemeAmount;
	private String accountNumber;
	private String accountName;
	private String bankcode;
	private String schemeDetails;
	private Integer schemeBalanceAmount;

	public String getSchemeDetails() {
		return schemeDetails;
	}
	public void setSchemeDetails(String schemeDetails) {
		this.schemeDetails = schemeDetails;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getBankcode() {
		return bankcode;
	}
	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public Integer getSchemeAmount()
	{
		return schemeAmount;
	}

	public void setSchemeAmount(Integer schemeAmount)
	{
		this.schemeAmount = schemeAmount;
	}
	public String getCentralContractAddress() {
		return centralContractAddress;
	}
	public void setCentralContractAddress(String centralContractAddress) {
		this.centralContractAddress = centralContractAddress;
	}

	public Integer getSchemeBalanceAmount()
	{
		return schemeBalanceAmount;
	}

	public void setSchemeBalanceAmount(Integer schemeBalanceAmount)
	{
		this.schemeBalanceAmount = schemeBalanceAmount;
	}

}
