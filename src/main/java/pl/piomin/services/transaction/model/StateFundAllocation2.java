package pl.piomin.services.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stateFundAllocation")
public class StateFundAllocation2 {

	@Id
	private String stateContractAddress;
	private String centralAddress; 
	private int stateId;
	private int sanctionedAmount;
	private int returnedAmount;
	private String schemeName;
	private Contract contract;
	
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
