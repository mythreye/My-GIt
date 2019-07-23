package com.niit.SpringSecurityProject.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SpringSecurityProject.DAO.MyCustomerDAO;
import com.niit.SpringSecurityProject.Model.MyCustomer;
import com.niit.SpringSecurityProject.Model.MysiteCredentials;

@Repository
@Transactional
public class MyCustomerDAOImpl implements MyCustomerDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean insertCustomer(MyCustomer mycustomer) {
		try {
			sessionFactory.getCurrentSession().save(mycustomer);
			MysiteCredentials mysiteCredentials = new MysiteCredentials();
			mysiteCredentials.setCredentialemail(mycustomer.getCustomeremail());
			mysiteCredentials.setCredentialpassword(mycustomer.getCustomerpassword());
			mysiteCredentials.setCredentialrole(mycustomer.getCustomerrole());
			mysiteCredentials.setCredentialstatus(true);
			sessionFactory.getCurrentSession().save(mysiteCredentials);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public MyCustomer SelectOneCustomer(String emailid) {
		try {

			MyCustomer mycustomer = (MyCustomer) sessionFactory.getCurrentSession()
					.createQuery("from MyCustomer where customeremail='" + emailid + "'").uniqueResult();
			return mycustomer;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
}
