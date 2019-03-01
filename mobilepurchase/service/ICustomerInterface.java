package com.cg.mobilepurchase.service;

public interface ICustomerInterface 
{
	void purchase(int mobileId);
	void showMobileDetails();
	void searchMobileByPriceRange(double minRange,double maxRange);
	
}
