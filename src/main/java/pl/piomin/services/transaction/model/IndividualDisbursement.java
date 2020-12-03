package pl.piomin.services.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "individualFundAllocation")
public class IndividualDisbursement {

	@Id
	String disbursementAddress;
	String identificationNumber;
	String bankCode;
	String accountNumber;
	String firstName;
	String lastName;
	Integer disbursementAmount;
	Integer stateId;
	String stateContractAddress;

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getDisbursementAddress() {
		return disbursementAddress;
	}
	public void setDisbursementAddress(String disbursementAddress) {
		this.disbursementAddress = disbursementAddress;
	}

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

	public Integer getDisbursementAmount()
	{
		return disbursementAmount;
	}

	public void setDisbursementAmount(Integer disbursementAmount)
	{
		this.disbursementAmount = disbursementAmount;
	}

	public Integer getStateId()
	{
		return stateId;
	}

	public void setStateId(Integer stateId)
	{
		this.stateId = stateId;
	}
}
