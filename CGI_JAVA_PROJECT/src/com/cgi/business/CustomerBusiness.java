package com.cgi.business;

import com.cgi.bean.Customer;
import com.cgi.dao.CustomerDAO;
import java.util.logging.Logger;

public class CustomerBusiness {
	
	private static final Logger logger = Logger.getLogger(CustomerDAO.class.getName());
        
        public void addCustomer(Customer customer) {
        	logger.info("Calling DAO Layer");
        	
            CustomerDAO dao = new CustomerDAO();
            dao.addCustomer(customer);
        }

        public void updateCustomer(Customer customer) {
        	logger.info("Calling DAO Layer");
        	
            CustomerDAO dao = new CustomerDAO();
            dao.updateCustomer(customer);
        }

        public void deleteCustomer(int id) {
        	logger.info("Calling DAO Layer");
        	
            CustomerDAO dao = new CustomerDAO();
            dao.deleteCustomer(id);
        }

        public void listCustomers() {
        	logger.info("Calling DAO Layer");
        	
            CustomerDAO dao = new CustomerDAO();
            dao.listCustomers();
        }
        public void getDetailsByAddress(String address) {
            
        	logger.info("Calling DAO Layer");
        	
        	CustomerDAO dao = new CustomerDAO();
        	dao.getDetailsByAddress(address);
        }

    }

