package pl.piomin.services.transaction.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "donation")
public class DonationModel {
	
	@Id
	private String donationAddress;
	private String centralAddress;
	private String firstName;
	private String LastName;
	private String identificationNo;
	private String taxIdentificationNo;
	private String donorAccountNo;
	private String donorAccountName;
	private String donorBankCode;
	private Integer donationAmount;
	private Date createdDate;
	


	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
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
		return LastName;
	}

	public void setLastName(String lastName)
	{
		LastName = lastName;
	}
	public String getCentralAddress() {
		return centralAddress;
	}
	public void setCentralAddress(String centralAddress) {
		this.centralAddress = centralAddress;
	}
	public String getDonationAddress() {
		return donationAddress;
	}
	public void setDonationAddress(String donationAddress) {
		this.donationAddress = donationAddress;
	}
	public String getIdentificationNo() {
		return identificationNo;
	}
	public void setIdentificationNo(String identificationNo) {
		this.identificationNo = identificationNo;
	}
	public String getTaxIdentificationNo() {
		return taxIdentificationNo;
	}
	public void setTaxIdentificationNo(String taxIdentificationNo) {
		this.taxIdentificationNo = taxIdentificationNo;
	}
	public String getDonorAccountNo() {
		return donorAccountNo;
	}
	public void setDonorAccountNo(String donorAccountNo) {
		this.donorAccountNo = donorAccountNo;
	}
	public String getDonorAccountName() {
		return donorAccountName;
	}
	public void setDonorAccountName(String donorAccountName) {
		this.donorAccountName = donorAccountName;
	}
	public String getDonorBankCode() {
		return donorBankCode;
	}
	public void setDonorBankCode(String donorBankCode) {
		this.donorBankCode = donorBankCode;
	}

	public Integer getDonationAmount()
	{
		return donationAmount;
	}

	public void setDonationAmount(Integer donationAmount)
	{
		this.donationAmount = donationAmount;
	}


	

}
