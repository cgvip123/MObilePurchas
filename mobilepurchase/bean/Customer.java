package com.cg.mobilepurchase.bean;

public class Customer
{
	private String cName;
	private String emailId;
	private long phoneNo;
	
	public Customer(String cName, String emailId, long phoneNo) 
	{
		this.setcName(cName);
		this.setEmailId(emailId);
		this.setPhoneNo(phoneNo);
	}
	public String getcName()
	{
		return cName;
	}
	public void setcName(String cName) 
	{
		this.cName = cName;
	}
	public String getEmailId()
	{
		return emailId;
	}
	
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}
	public long getPhoneNo()
	{
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) 
	{
		this.phoneNo = phoneNo;
	}
	
	
}
