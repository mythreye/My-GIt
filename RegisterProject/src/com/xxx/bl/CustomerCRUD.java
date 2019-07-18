package com.xxx.bl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.xxx.Model.Customer;

public class CustomerCRUD {

	public boolean addcustomer(Customer c) throws SQLException, ClassNotFoundException 
	{
		Class.forName("org.h2.Driver");
		Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","sa");
		PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?,?)");
		ps.setString(1, c.getFname());
		ps.setString(2, c.getLname());
		ps.setString(3, c.getDname());
		ps.setString(4, c.getEmailid());
		ps.setString(5, c.getUser_password());
		if(ps.executeUpdate()!=0)
			return true;
		else
			return false;
	}
	public ArrayList<Customer> SelectAllCustomer() throws ClassNotFoundException, SQLException
		{
		Class.forName("org.h2.Driver");
		Connection con=DriverManager.getConnection("jdbc:h2:~/test","sa","sa");
		Statement s=con.createStatement();		
		ResultSet rs=s.executeQuery("Select * from Customer");
		ArrayList<Customer> custlist=new ArrayList<>();
		while (rs.next()) 
		{
		 Customer c=new Customer();
		 c.setFname(rs.getString(1));
		 c.setLname(rs.getString(2));
		 c.setDname(rs.getString(3));
		 c.setEmailid(rs.getString(4));
		 custlist.add(c);
		}
		return custlist;
		
	}
}
