package com.niit.SpringSecurityProject.DAO;

import java.util.List;

import com.niit.SpringSecurityProject.Model.MyCustomer;


public interface MyCustomerDAO {

	boolean insertCustomer(MyCustomer mycustomer);
	MyCustomer SelectOneCustomer(String emailid);
}
