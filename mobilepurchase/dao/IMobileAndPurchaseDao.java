package com.cg.mobilepurchase.dao;

import com.cg.mobilepurchase.bean.Mobile;

public interface IMobileAndPurchaseDao 
{
	void addNewMobile(Mobile m); 
	void deleteMobileById(int mobileId);
	void updateQuantity(int choice,int mobileId,int quantity);
	
	boolean mobileQuantityValidate(int quantity);
	boolean mobileIdValidate(int mobileId); 
	void purchase(int mobileId,String customerName,String mailId,long phoneNo);
	void showMobileDetails();
	void searchMobileByPriceRange(double minRange,double maxRange);
}
