package pl.piomin.services.transaction.model;

public class DisbursementModel {
	private String centralAddress; 
	private int stateId;
	private int disbursementAmount;
	private int returnedAmount;
	private String stateContractAddress;
	
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
	public int getDisbursementAmount() {
		return disbursementAmount;
	}
	public void setDisbursementAmount(int disbursementAmount) {
		this.disbursementAmount = disbursementAmount;
	}

	public int getReturnedAmount() {
		return returnedAmount;
	}
	public void setReturnedAmount(int returnedAmount) {
		this.returnedAmount = returnedAmount;
	}

}
