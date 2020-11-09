package pl.piomin.services.transaction.model;

public class Contract {
	private String schemeName;
	private int schemeAmount;
	private String centralContractAddress;
    private String accountNumber;
	private String accountName;
	private String bankcode;
	private String schemeDetails;
	private int schemeBalanceAmount;

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
	public int getSchemeAmount() {
		return schemeAmount;
	}
	public void setSchemeAmount(int schemeAmount) {
		this.schemeAmount = schemeAmount;
	}
	public String getCentralContractAddress() {
		return centralContractAddress;
	}
	public void setCentralContractAddress(String centralContractAddress) {
		this.centralContractAddress = centralContractAddress;
	}
	public int getSchemeBalanceAmount() {
		return schemeBalanceAmount;
	}
	public void setSchemeBalanceAmount(int schemeBalanceAmount) {
		this.schemeBalanceAmount = schemeBalanceAmount;
	}

}
