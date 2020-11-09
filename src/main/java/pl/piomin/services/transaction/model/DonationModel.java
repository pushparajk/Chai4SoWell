package pl.piomin.services.transaction.model;

public class DonationModel {
	
    String centralAddress;
	String donationAddress;
	String identificationNo;
	String taxIdentificationNo;
	String donorAccountNo;
	String donorAccountName;
	String donorBankCode;
    int donationAmount;
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
	public int getDonationAmount() {
		return donationAmount;
	}
	public void setDonationAmount(int donationAmount) {
		this.donationAmount = donationAmount;
	}


	

}
