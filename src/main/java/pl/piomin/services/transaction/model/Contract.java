package pl.piomin.services.transaction.model;

public class Contract {
	private String schemeName;
	private int schemeAmount;
	private int balanceAmount;
	private String centralContractAddress;
	
	public int getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
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

}
