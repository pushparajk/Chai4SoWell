package pl.piomin.services.transaction.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MLResponse
{
    @JsonProperty("PREDICTED_STATUS") 
    public String pREDICTED_STATUS;
    @JsonProperty("COULD_BE_FRAUD") 
    public double cOULDBEFRAUD;
    @JsonProperty("FRAUD") 
    public double fRAUD;
    @JsonProperty("NORMAL") 
    public double nORMAL;
    @JsonProperty("SUSPECT") 
    public double sUSPECT;
	public String getpREDICTED_STATUS()
	{
		return pREDICTED_STATUS;
	}
	public void setpREDICTED_STATUS(String pREDICTED_STATUS)
	{
		this.pREDICTED_STATUS = pREDICTED_STATUS;
	}
	public double getcOULDBEFRAUD()
	{
		return cOULDBEFRAUD;
	}
	public void setcOULDBEFRAUD(double cOULDBEFRAUD)
	{
		this.cOULDBEFRAUD = cOULDBEFRAUD;
	}
	public double getfRAUD()
	{
		return fRAUD;
	}
	public void setfRAUD(double fRAUD)
	{
		this.fRAUD = fRAUD;
	}
	public double getnORMAL()
	{
		return nORMAL;
	}
	public void setnORMAL(double nORMAL)
	{
		this.nORMAL = nORMAL;
	}
	public double getsUSPECT()
	{
		return sUSPECT;
	}
	public void setsUSPECT(double sUSPECT)
	{
		this.sUSPECT = sUSPECT;
	}
    
    
}