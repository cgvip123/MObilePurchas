package com.cg.mobilepurchase.util;

import java.util.HashMap;
import java.util.Map;

import com.cg.mobilepurchase.bean.Customer;
import com.cg.mobilepurchase.bean.Mobile;

public class CollectionConnection 
{
	static Map<Integer,Mobile> mobilesCollection = new HashMap<>();
	static Map<Integer,Customer> purchaseCollection= new HashMap<>();

	public static Map<Integer,Customer> getPurchaseCollection()
	{
		return purchaseCollection;
	}

	public static Map<Integer, Mobile> getMobilesCollection() 
	{
		return mobilesCollection;
	}
}
