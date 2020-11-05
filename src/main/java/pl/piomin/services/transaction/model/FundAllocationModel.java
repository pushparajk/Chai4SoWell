package pl.piomin.services.transaction.model;

public class FundAllocationModel {
	private String centralAddress; 
	private int stateId;
	private int sanctionedAmount;
	private int returnedAmount;
	private String stateContractAddress;
	private String schemeName;
	
	public String getStateContractAddress() {
		return stateContractAddress;
	}
	public void setStateContractAddress(String stateContractAddress) {
		this.stateContractAddress = stateContractAddress;
	}
	public String getCentralAddress() {
		return centralAddress;
	}
	public void setCentralAddress(String address) {
		this.centralAddress = address;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getSanctionedAmount() {
		return sanctionedAmount;
	}
	public void setSanctionedAmount(int disbursementAmount) {
		this.sanctionedAmount = disbursementAmount;
	}

	public int getReturnedAmount() {
		return returnedAmount;
	}
	public void setReturnedAmount(int returnedAmount) {
		this.returnedAmount = returnedAmount;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

}
