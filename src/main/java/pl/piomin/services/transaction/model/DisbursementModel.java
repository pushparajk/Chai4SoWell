package pl.piomin.services.transaction.model;

public class DisbursementModel {

	String identificationNumber;
	String bankCode;
	String accountNumber;
	int disbursementAmount;
	int stateId;
	String disbursementAddress;
	
	public String getDisbursementAddress() {
		return disbursementAddress;
	}
	public void setDisbursementAddress(String disbursementAddress) {
		this.disbursementAddress = disbursementAddress;
	}
	String stateContractAddress;
	public String getStateContractAddress() {
		return stateContractAddress;
	}
	public void setStateContractAddress(String stateContractAddress) {
		this.stateContractAddress = stateContractAddress;
	}
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getDisbursementAmount() {
		return disbursementAmount;
	}
	public void setDisbursementAmount(int disbursementAmount) {
		this.disbursementAmount = disbursementAmount;
	}

	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
}
