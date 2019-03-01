package com.cg.mobilepurchase.service;

import java.util.Scanner;
import java.util.regex.*;

import com.cg.mobilepurchase.dao.IMobileAndPurchaseDao;

public class CustomerService implements ICustomerInterface
{
	Scanner scanner = new Scanner(System.in);
	IMobileAndPurchaseDao mobileAndPurchaseDao;
	
	@Override
	public void purchase(int mobileId)
	{
		String customerName="";
		String emailId = "";
		long phoneNo=0;
		if(mobileAndPurchaseDao.mobileIdValidate(mobileId))
		{
			System.out.println("Enter Customer Name");
			customerName = scanner.nextLine();
			boolean isValidName = new CustomerService().customerNameValidate(customerName);
			if(isValidName)
			{
				System.out.println("Enter Mail Id");
				emailId = scanner.nextLine();
				boolean isValidEmail = new CustomerService().customerEmailIdValidate(emailId);
				if(isValidEmail)
				{
					System.out.println("Enter Phone No");
					phoneNo = scanner.nextLong();
					boolean isValidPhoneNo = new CustomerService().customerPhoneNoValidate(phoneNo);
					if(isValidPhoneNo)
					{
						mobileAndPurchaseDao.purchase(mobileId, customerName, emailId, phoneNo);
					}
					else
					{
						System.out.println("Enter Phone No");
					}
				}
				else
				{
					System.out.println("Enter Valid Email");
				}
			}
			else
			{
				System.out.println("Enter Valid Name");
			}
		}
		else
		{
			System.out.println("Enter Valid Mobile Id");
		}
	}

	@Override
	public void showMobileDetails() 
	{
		mobileAndPurchaseDao.showMobileDetails();
		
	}

	@Override
	public void searchMobileByPriceRange(double minRange,double maxRange) 
	{
		mobileAndPurchaseDao.searchMobileByPriceRange(minRange,maxRange);
	}
	
	public boolean customerNameValidate(String customerName)
	{
		Pattern pattern = Pattern.compile("^[A-Z][a-z]{1,20}");
		boolean isValidName=false;
		isValidName = pattern.matcher(customerName).matches();
		return isValidName;
	}
	
	public boolean customerEmailIdValidate(String emailId)
	{
		Pattern pattern = Pattern.compile("[a-z0-9]+@\\.[a-z][a-z]+$");
		boolean isValidEmail=false;
		isValidEmail = pattern.matcher(emailId).matches();
		return isValidEmail;
	}
	public boolean customerPhoneNoValidate(long phoneNo)
	{
		boolean isValidPhoneNo = false;
		Pattern pattern = Pattern.compile("[0-9]{10}");
		isValidPhoneNo = pattern.matcher(String.valueOf(phoneNo)).matches();
		return isValidPhoneNo;
	}
	
}
