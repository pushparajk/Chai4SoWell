package pl.piomin.services.transaction.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "individualFundAllocation")
public class IndividualDisbursement {

	@Id
	private String disbursementAddress;
	@NotNull
	private String identificationNumber;
	@NotNull
	private String bankCode;
	@NotNull
	private String accountNumber;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private Integer disbursementAmount;
	@NotNull
	private Integer stateId;
	@NotNull
	private String stateContractAddress;
	@NotNull
	private Date dob;
	@NotNull
	private String income;
	@NotNull
	private String gender;	
	private String contractStatus;
	@NotNull
	private String isEmployed;
	private Date createdDate;

	
	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public Date getDob()
	{
		return dob;
	}

	public void setDob(Date dob)
	{
		this.dob = dob;
	}

	public String getIncome()
	{
		return income;
	}

	public void setIncome(String income)
	{
		this.income = income;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getIsEmployed()
	{
		return isEmployed;
	}

	public void setIsEmployed(String isEmployed)
	{
		this.isEmployed = isEmployed;
	}

	public String getContractStatus()
	{
		return contractStatus;
	}

	public void setContractStatus(String contractStatus)
	{
		this.contractStatus = contractStatus;
	}

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
