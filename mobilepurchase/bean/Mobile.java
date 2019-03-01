package com.cg.mobilepurchase.bean;

public class Mobile 
{
	private int mobileId;
	
	private String mobileName;
	private double price;
	private int quantity;
	
	public Mobile(int mobileId, String mobileName, double price, int quantity) 
	{
		this.setMobileId(mobileId);
		this.setMobileName(mobileName);
		this.setPrice(price);
		this.setQuantity(quantity);
	}
	
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public String getMobileName() {
		return mobileName;
	}
	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() 
	{
		return "Mobile [mobileId=" + mobileId + ", mobileName=" + mobileName + ", price=" + price + ", quantity=" + quantity + "]";
	}
}
