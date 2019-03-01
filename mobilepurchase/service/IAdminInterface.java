package com.cg.mobilepurchase.service;

public interface IAdminInterface 
{
	void deleteMobileById(int mobileId);
	void addNewMobile(int mobileId,String mobileName,double price,int quantity);
	void updateQuantity(int choice,int mobileId,int quantity);
}
