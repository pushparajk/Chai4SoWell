package pl.piomin.services.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "donation")
public class DonationModel {
	
	@Id
	String donationAddress;
	String centralAddress;
	String firstName;
	String LastName;
	String identificationNo;
	String taxIdentificationNo;
	String donorAccountNo;
	String donorAccountName;
	String donorBankCode;
	Integer donationAmount;


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
