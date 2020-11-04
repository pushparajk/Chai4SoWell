package pl.piomin.services.transaction.model;

public class Contract {
	private String schemeName;
	private int schemeAmount;
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

}
