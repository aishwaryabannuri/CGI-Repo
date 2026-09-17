package com.cgi.constants;
public class SQLConstants {
    public static final String INSERT_CUSTOMER =
            "insert into customer(id,name,address) values(?,?,?)";
    public static final String UPDATE_CUSTOMER =
            "update customer set name=?, address=? where id=?";
    public static final String DELETE_CUSTOMER =
            "delete from customer where id=?";
    public static final String LIST_CUSTOMERS =
            "select * from customer";
}