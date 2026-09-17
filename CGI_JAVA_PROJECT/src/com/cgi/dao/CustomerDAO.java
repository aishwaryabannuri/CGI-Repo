package com.cgi.dao;

import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cgi.bean.Customer;
import com.cgi.constants.SQLConstants;
import com.cgi.utils.DBConnection;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	
	private static final Logger logger = Logger.getLogger(CustomerDAO.class.getName());
       

   public void addCustomer(Customer customer) {
       try {
            Connection con = DBConnection.getConnection();

            
           //String sql = "insert into customer(name,address) values(?,?)";
            
           
           String sql = SQLConstants.INSERT_CUSTOMER;
           //
            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getAddress());
           

            int result = ps.executeUpdate();

            if(result > 0) {
                logger.info("Customer Added Successfully");
            }

        } catch(Exception e) {
            logger.severe(e.getMessage());
        }
    }
    public void updateCustomer(Customer customer) {
        try {
            Connection con = DBConnection.getConnection();
            //String sql =
                   // "update customer set name=?, address=? where id=?";
            
            String sql = SQLConstants.UPDATE_CUSTOMER;
            
            PreparedStatement ps =
                    con.prepareStatement(sql);
            
            
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setInt(3, customer.getId());
            
            int result = ps.executeUpdate();
            if(result > 0) {
                logger.info("Customer Updated Successfully");
            }
        } catch(Exception e) {
        	  logger.severe(e.getMessage());
        }
    }
    public void deleteCustomer(int id) {
        try {
            Connection con = DBConnection.getConnection();
           // String sql =
                   // "delete from customer where id=?";
            
            String sql = SQLConstants.DELETE_CUSTOMER;
            //
            PreparedStatement ps =
                    con.prepareStatement(sql);
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            if(result > 0) {
                logger.info("Customer Deleted Successfully");
            }
        } catch(Exception e) {
        	  logger.severe(e.getMessage());
        }
    }
    public void listCustomers() {

        try {

            Connection con = DBConnection.getConnection();

            //String sql = "select * from customer";
            
            String sql = SQLConstants.LIST_CUSTOMERS;

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            
            List<Customer> custList = new ArrayList<>();

            while(rs.next()) {
            	Customer customer = new Customer(
            			rs.getInt("id"),
            			rs.getString("name"),
            			rs.getString("address"));
            	custList.add(customer);
            			
            
            }
            
            custList.forEach(cust ->
            logger.info(
                "CustID : " + cust.getId()
                + " Name : " + cust.getName()
                + " Address : " + cust.getAddress()));

        } catch(Exception e) {
        	  logger.severe(e.getMessage());
        }
    }
    
    public void getDetailsByAddress(String address) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "select * from customer";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Customer> custList = new ArrayList<>();

            while(rs.next()) {

                Customer customer = new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"));

                custList.add(customer);
            }

            custList.stream()
                    .filter(c -> c.getAddress().equalsIgnoreCase(address))
                    .forEach(System.out::println);

        } catch(Exception e) {
            logger.severe(e.getMessage());
        }
    }
    
    
}
