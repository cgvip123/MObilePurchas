package com.cg.mobilepurchase.main;

import java.util.Scanner;

import com.cg.mobilepurchase.bean.Administrator;
import com.cg.mobilepurchase.service.AdminService;
import com.cg.mobilepurchase.service.CustomerService;
import com.cg.mobilepurchase.service.IAdminInterface;
import com.cg.mobilepurchase.service.ICustomerInterface;
import com.cg.mobilepurchase.util.CollectionConnection;

public class Main
{
	public static void main(String args[])
	{
		int choice=1;
		int customerChoice=1;
		int adminChoice=1;
		
		String userName="";
		String password="";
		
		int mobileId=0;
		String mobileName="";
		double price=0.0;
		int quantity=0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("MAIN MENU");
			System.out.println("=========");
			System.out.println();
			System.out.println("Please Select The Type Of Service");
			System.out.println("---------------------------------");
			System.out.println();
			System.out.println("Press 1: Customer     Press 2: Administrator     Press 3: Exit");
			
			choice = scanner.nextInt();
			
			switch(choice)
			{
				case 1:	ICustomerInterface customerInterface = new CustomerService();
						System.out.println("1: Purchase     2: Show Mobile Details     3: Search Mobile By Price Range     4: Exit");
						customerChoice = scanner.nextInt();
						switch(customerChoice)
						{
							case 1: System.out.println("Welcome To Mobile Purchase");
									System.out.println("====================================================================================");
									System.out.println("Item No     |     Mobile Id     |     Mobile Name     |     Price     |     Quantity");
									System.out.println("------------------------------------------------------------------------------------");
									System.out.println("Enter The Mobile Id Of The Mobile You Want To Purchase");
								    mobileId = scanner.nextInt();
								    customerInterface.purchase(mobileId);
									break;
							case 2: System.out.println("====================================================================================");
									System.out.println("Item No     |     Mobile Id     |     Mobile Name     |     Price     |     Quantity");
									System.out.println("------------------------------------------------------------------------------------");
									customerInterface.showMobileDetails();
									break;
							case 3: System.out.println("====================================================================================");
									System.out.println("Enter minimum range");
									double minRange = scanner.nextDouble();
									System.out.println("Enter maximum range");
									double maxRange = scanner.nextDouble();
									customerInterface.searchMobileByPriceRange(minRange,maxRange);
									break;
							case 4: System.out.println("Exiting...!! Thanks for using the Application.");
						    		System.exit(0);
						    		break;
						  default : System.out.println("Exiting...!! Thanks for using the Application.");
						    		System.exit(0);
						    		break;
						}
						break;
				
				case 2:	Administrator admin = new Administrator(); 
						System.out.println("Enter UserName");
						userName = scanner.next();
						if(admin.getUserName().equals(userName))
						{
							System.out.println("Enter Password");
							password = scanner.next();
							if(admin.getPassword().equals(password))
							{
								System.out.println("Welcome "+admin.getUserName());
								System.out.println("================");
								IAdminInterface adminInterface = new AdminService();
								System.out.println();
								System.out.println("1: Add New Mobile     2: Delete Mobile By Id     3. Update Mobile Quantity     4. Exit");
								adminChoice = scanner.nextInt();
								switch(adminChoice)
								{
									case 1: System.out.println("========================");
											System.out.println("Enter Mobile Id");
											mobileId = scanner.nextInt();
											System.out.println("Enter Mobile Name");
											mobileName = scanner.next();
											System.out.println("Enter Mobile Price");
											price = scanner.nextDouble();
											System.out.println("Enter Mobile Quantity");
											quantity = scanner.nextInt();
											adminInterface.addNewMobile(mobileId,mobileName,price,quantity);
											break;
									
									case 2: System.out.println("========================");
											System.out.println("Enter Mobile Id to delete");
											mobileId = scanner.nextInt();
											adminInterface.deleteMobileById(mobileId);
											break;
									
									case 3: System.out.println("Enter Mobile Id");
											mobileId = scanner.nextInt();
											System.out.println("============================================");
											System.out.println("1: To Add Quantity     2: To Delete Quantity");
											choice = scanner.nextInt();
											System.out.println("============================================");
											System.out.println("Enter Quantity");
											quantity = scanner.nextInt();
											adminInterface.updateQuantity(choice,mobileId,quantity);
											break;
									
									case 4: System.out.println("Exiting...!! Thanks for using the Application.");
								    		System.exit(0);
								    		break;
								  
									default: System.out.println("Exiting...!! Thanks for using the Application.");
								    		System.exit(0);
								    		break;
								}
							}
							else
							{
								System.err.println("!!! Wrong Password");
							}
						}
						else
						{
							System.err.println("!!! Enter Valid User Name");
						}
						break;
				
				case 3: System.out.println("Exiting...!! Thanks for using the Application.");
					    System.exit(0);
						break;
				
				default: System.out.println("Enter correct choice!");
						 System.out.println("Exiting...!! Thanks for using the Application.");
					     System.exit(0);
						 break;
			}
			System.out.println();
		}
	}
}