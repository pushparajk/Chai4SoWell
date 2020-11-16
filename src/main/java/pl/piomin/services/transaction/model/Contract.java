package pl.piomin.services.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bchain")
public class Contract {

	@Id
	private String id;
	private String schemeName;
	private int schemeAmount;
	private int balanceAmount;
	private String centralContractAddress;
	
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
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
