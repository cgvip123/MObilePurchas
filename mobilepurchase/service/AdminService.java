package com.cg.mobilepurchase.service;

import java.util.Scanner;

import com.cg.mobilepurchase.bean.Mobile;
import com.cg.mobilepurchase.dao.IMobileAndPurchaseDao;
import com.cg.mobilepurchase.dao.MobileAndPurchaseDao;

public class AdminService implements IAdminInterface
{
	int choice;
 
	Scanner scanner = new Scanner(System.in);
	
	Mobile mobile;
	IMobileAndPurchaseDao mobileAndPurchaseDao;
	@Override
	public void addNewMobile(int mobileId,String mobileName,double price,int quantity) 
	{
		boolean isValidQuantity = mobileAndPurchaseDao.mobileQuantityValidate(quantity);
		if(isValidQuantity)
		{
			mobile = new Mobile(mobileId, mobileName, price, quantity);
			mobileAndPurchaseDao = new MobileAndPurchaseDao();
			mobileAndPurchaseDao.addNewMobile(mobile);
		}
		else
		{
			System.out.println("Enter Valid Quantity");
		}
	}
	
	@Override
	public void deleteMobileById(int mobileId)
	{
		boolean isValidMobileId=false;
		isValidMobileId = mobileAndPurchaseDao.mobileIdValidate(mobileId);
		if(isValidMobileId)
		{
			mobileAndPurchaseDao = new MobileAndPurchaseDao();
			mobileAndPurchaseDao.deleteMobileById(mobileId);
		}
	}

	@Override
	public void updateQuantity(int choice,int mobileId,int quantity) 
	{
		if(mobileAndPurchaseDao.mobileQuantityValidate(quantity))
		{
			if(mobileAndPurchaseDao.mobileIdValidate(mobileId))
			{
				mobileAndPurchaseDao = new MobileAndPurchaseDao();
				mobileAndPurchaseDao.updateQuantity(choice, mobileId, quantity);
			}
			else 
			{
				System.out.println("Enter Valid MobileId");
			}
		}
		else 
		{
			System.out.println("Enter Valid Mobile Quantity");
		}
	}
	
}
