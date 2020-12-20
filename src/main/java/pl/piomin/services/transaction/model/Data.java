package pl.piomin.services.transaction.model;

import java.util.List;

public class Data
{
    private String schemeName;
    private Integer schemeAmount;
    private List<CharityDetail> charityDetails;
	public String getSchemeName()
	{
		return schemeName;
	}
	public void setSchemeName(String schemeName)
	{
		this.schemeName = schemeName;
	}
	public Integer getSchemeAmount()
	{
		return schemeAmount;
	}
	public void setSchemeAmount(Integer schemeAmount)
	{
		this.schemeAmount = schemeAmount;
	}
	public List<CharityDetail> getCharityDetails()
	{
		return charityDetails;
	}
	public void setCharityDetails(List<CharityDetail> charityDetails)
	{
		this.charityDetails = charityDetails;
	}
    
}
