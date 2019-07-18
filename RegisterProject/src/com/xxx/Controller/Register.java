package com.xxx.Controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import com.xxx.Model.Customer;
import com.xxx.bl.CustomerCRUD;

import sun.security.jca.GetInstance.Instance;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;
		Customer newcustomer = new Customer();

		try {
			newcustomer.setFname(request.getParameter("first_name"));
			newcustomer.setLname(request.getParameter("last_name"));
			newcustomer.setDname(request.getParameter("display_name"));
			newcustomer.setEmailid(request.getParameter("email"));
			String pass = request.getParameter("user_password").toString();
			String cpass = request.getParameter("password_confirmation").toString();
			if (pass.equals(cpass)) {
				newcustomer.setUser_password(pass);
				CustomerCRUD c = new CustomerCRUD();
				if (c.addcustomer(newcustomer)) {
					request.setAttribute("status", true);
					request.setAttribute("message", "Inserted successfuly");
					request.setAttribute("newcoustomer", new Customer());

				} else {
					request.setAttribute("status", true);
					request.setAttribute("message", "Not Inserted successfuly try after sometime");
					request.setAttribute("newcoustomer", newcustomer);
				}

			} else {
				request.setAttribute("status", true);
				request.setAttribute("message", "password and confirm password did not match");
				request.setAttribute("newcustomer", newcustomer);
			}
		} catch (Exception e) {
			if(e.getMessage().contains("primary key"))
			{
				request.setAttribute("status", true);
				request.setAttribute("message", "Email Id Already Exists");
				request.setAttribute("newcustomer", newcustomer);
				System.err.println(e.getMessage());
			} else {
				request.setAttribute("status", true);
				request.setAttribute("message", "Server Error Contact Admin");
				request.setAttribute("newcustomer", newcustomer);
				System.err.println(e.getMessage());
			}

		}
		rd = request.getRequestDispatcher("views/index.jsp");
		rd.forward(request, response);
	}

}
