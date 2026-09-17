package com.cgi.client;

import java.util.Scanner;

import com.cgi.bean.Customer;
import com.cgi.business.CustomerBusiness;
import com.cgi.dao.CustomerDAO;

import java.util.logging.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomerApplication {
	
	private static final Logger logger = Logger.getLogger(CustomerDAO.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		CustomerBusiness business = new CustomerBusiness();
		
		logger.info("Welcome to Customer Application");
		
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		logger.info("Current Date & Time : " + now.format(formatter));

		while (true) {

			logger.info("\n<----- MENU ----->");
			logger.info("1. CREATE NEW CUSTOMER");
			logger.info("2. UPDATE CUSTOMER BY ID");
			logger.info("3. DELETE CUSTOMER BY ID");
			logger.info("4. LIST ALL CUSTOMERS");
			logger.info("5. GET CUSTOMERS BY ADDRESS");
			logger.info("6. EXIT");

			System.out.print("Enter your choice ---> ");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				logger.info("Create Customer Option Selected ");
				
				System.out.println("Enter Customer ID : ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Name : ");
				String name = sc.nextLine();

				System.out.print("Enter Address : ");
				String address = sc.nextLine();

				Customer customer = new Customer(id, name, address);

				business.addCustomer(customer);
				break;

			case 2:
				
				logger.info("Update Customer Option Selected ");

				System.out.print("Enter Id : ");
				int updateId = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter New Name : ");
				String updateName = sc.nextLine();

				System.out.print("Enter New Address : ");
				String updateAddress = sc.nextLine();

				Customer updateCustomer =
						new Customer(updateId, updateName, updateAddress);

				business.updateCustomer(updateCustomer);
				break;

			case 3:
				
				logger.info("Delete Customer Option Selected");

				System.out.print("Enter Id to Delete : ");
				int deleteId = sc.nextInt();

				business.deleteCustomer(deleteId);
				break;

			case 4:
				
				logger.info("List Customers Option Selected");

				business.listCustomers();
				break;
				
			case 5:
			    logger.info("Get Customer By Address Option Selected");
			    System.out.print("Enter Address : ");
			    sc.nextLine(); // consume leftover newline
			    address = sc.nextLine();
			    business.getDetailsByAddress(address);
			    break;
			
			   
			 case 6:
				 logger.info("Application Closed");
				 sc.close();
				 System.exit(0);

			default:

				logger.warning("Invalid Choice");
			}
		}
	}
}


