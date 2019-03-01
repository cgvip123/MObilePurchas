package com.cg.mobilepurchase.dao;

import java.time.LocalDate;

import com.cg.mobilepurchase.bean.Customer;
import com.cg.mobilepurchase.bean.Mobile;
import com.cg.mobilepurchase.util.CollectionConnection;

public class MobileAndPurchaseDao implements IMobileAndPurchaseDao
{
	Mobile mobile1 = new Mobile(1001,"Nokia Lumia 520",8000,20);
	Mobile mobile2 = new Mobile(1002,"Samsung Galaxy IV",38000,40);
	Mobile mobile3 = new Mobile(1003,"Sony xperia C",15000,30);
	
	static int purchaseId = 0;
	
	private  void initCollection()
	{
		CollectionConnection.getMobilesCollection().put(mobile1.getMobileId(), mobile1);
		CollectionConnection.getMobilesCollection().put(mobile2.getMobileId(), mobile2);
		CollectionConnection.getMobilesCollection().put(mobile3.getMobileId(), mobile3);
	}	
	
	@Override
	public boolean mobileQuantityValidate(int quantity) //Checks For Valid Mobile Quantity i.e. Should be Greater Than 0
	{
		boolean isvalidQuantity=false;
		if(quantity>0)
		{
			isvalidQuantity=true;
		}
		return isvalidQuantity;
	}
	
	@Override
	public boolean mobileIdValidate(int mobileId) //Checks For Valid Mobile Id
	{
		boolean isValidMobileId = false;
		for(Mobile mobile : CollectionConnection.getMobilesCollection().values())
		{
			if(mobile.getMobileId()==mobileId && String.valueOf(mobileId).length()==4)
			{
				isValidMobileId=true;
			}
		}
		return isValidMobileId;
	}
	
	public int generatePurchaseId()
	{
		purchaseId+=1;
		return purchaseId;
	}
	
	// Customer Service Related Methods
	@Override
	public void purchase(int mobileId,String customerName,String mailId,long phoneNo) 
	{
		Mobile selectedMobile=null;
		LocalDate purchaseDate = LocalDate.now();
		showMobileDetails();
		if(mobileIdValidate(mobileId))
		{
			for(Mobile mobile : CollectionConnection.getMobilesCollection().values())
			{
				if(mobile.getMobileId()==mobileId)
				{
					selectedMobile=mobile;
				}
			}
		}
		if(selectedMobile!=null)
		{
			Customer customer = new Customer(customerName,mailId,phoneNo);
			CollectionConnection.getPurchaseCollection().put(generatePurchaseId(),customer);
			Mobile mobile = CollectionConnection.getMobilesCollection().get(mobileId);
			int oldQuantity = mobile.getQuantity();
			int newQuantity=oldQuantity;
			newQuantity-=1;
			mobile.setQuantity(newQuantity);
			CollectionConnection.getMobilesCollection().replace(mobileId,mobile);
			
		}
		
	}
	@Override
	public void showMobileDetails()
	{
		int itemNo=1;
		for(Mobile m : CollectionConnection.getMobilesCollection().values())
		{
			System.out.println(itemNo+":     |     "+m.getMobileId()+"     |     "+m.getMobileName()+"     |     "+m.getPrice()+"     |     "+m.getQuantity());
			System.out.println();
			itemNo+=1;
		}
	}

	@Override
	public void searchMobileByPriceRange(double minRange,double maxRange)
	{
		for(Mobile m : CollectionConnection.getMobilesCollection().values())
		{
			int itemNo=1;
			if(m.getPrice()>=minRange && m.getPrice()<=maxRange)
			{
				System.out.println(itemNo+":     |     "+m.getMobileId()+"     |     "+m.getMobileName()+"     |     "+m.getPrice()+"     |     "+m.getQuantity());
			}
			System.out.println();
			itemNo+=1;
		}
	}
	
	// Administrator Service Related Methods
	@Override
	public void addNewMobile(Mobile mobile) 
	{
		CollectionConnection.getMobilesCollection().put(mobile.getMobileId(), mobile);
	}

	@Override
	public void deleteMobileById(int mobileId)
	{
		CollectionConnection.getMobilesCollection().remove(mobileId);
	}

	@Override
	public void updateQuantity(int choice, int mobileId, int quantity) 
	{
		if(choice == 1)
		{
			Mobile mobile = CollectionConnection.getMobilesCollection().get(mobileId);
			int oldQuantity = mobile.getQuantity();
			int newQuantity=oldQuantity;
			newQuantity+=quantity;
			mobile.setQuantity(newQuantity);
			CollectionConnection.getMobilesCollection().replace(mobileId,mobile);
		}
		else if(choice == 2)
		{
			Mobile mobile = CollectionConnection.getMobilesCollection().get(mobileId);
			int oldQuantity = mobile.getQuantity();
			int newQuantity=oldQuantity;
			newQuantity-=quantity;
			mobile.setQuantity(newQuantity);
			CollectionConnection.getMobilesCollection().replace(mobileId,mobile);
		}
		else
		{
			System.err.println("!!! Enter Correct Choice");
		}
	}

	
}