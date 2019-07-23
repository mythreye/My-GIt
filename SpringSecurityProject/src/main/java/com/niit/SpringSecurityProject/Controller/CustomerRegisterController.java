package com.niit.SpringSecurityProject.Controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.SpringSecurityProject.DAO.MyCustomerDAO;
import com.niit.SpringSecurityProject.Model.MyCustomer;

@Controller
public class CustomerRegisterController {

	@Autowired
	MyCustomerDAO mycustomerdao;

	@RequestMapping("/register")
	String registerPage(Model m) {
		m.addAttribute("registerPage", true);
		m.addAttribute("myCustomer", new MyCustomer());
		m.addAttribute("haserror", false);
		m.addAttribute("error", "");
		m.addAttribute("showmess", false);
		m.addAttribute("message", "");
		return "index";
	}

	@RequestMapping("/addcustomer")
	String customerPage(@Valid @ModelAttribute("myCustomer") MyCustomer mycustomer, BindingResult br, Model m) {
		if (br.hasErrors()) {
			m.addAttribute("registerPage", true);
			m.addAttribute("myCustomer", mycustomer);
			m.addAttribute("haserror", true);
			m.addAttribute("error", "Please Check all data");
			m.addAttribute("showmess", false);
			m.addAttribute("message", "");
			return "index";

		} else {
			try {
				BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
				mycustomer.setCustomerpassword(bCryptPasswordEncoder.encode(mycustomer.getCustomerpassword()));
				if (mycustomerdao.insertCustomer(mycustomer)) {
					m.addAttribute("registerPage", true);
					m.addAttribute("myCustomer", new MyCustomer());
					m.addAttribute("haserror", false);
					m.addAttribute("error", "");
				}
				m.addAttribute("showmess", true);
				m.addAttribute("message", "Your registered succesfully.");
				return "index";
			} catch (Exception e1) {
				m.addAttribute("registerPage", true);
				m.addAttribute("myCustomer", mycustomer);
				m.addAttribute("haserror", true);
				m.addAttribute("error", "Data already present.Please check your EmailId.");
				m.addAttribute("showmess", false);
				m.addAttribute("message", "");
				return "index";
			}
		}

	}
}
