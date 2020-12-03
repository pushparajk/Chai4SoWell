package pl.piomin.services.transaction.model;

public class FatcaDetails
{
	public boolean isUSResident;
	public boolean isUSTaxResident;
	public String tin;

	public boolean isUSResident()
	{
		return isUSResident;
	}

	public void setUSResident(boolean isUSResident)
	{
		this.isUSResident = isUSResident;
	}

	public boolean isUSTaxResident()
	{
		return isUSTaxResident;
	}

	public void setUSTaxResident(boolean isUSTaxResident)
	{
		this.isUSTaxResident = isUSTaxResident;
	}

	public String getTin()
	{
		return tin;
	}

	public void setTin(String tin)
	{
		this.tin = tin;
	}

}

