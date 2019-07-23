package com.niit.SpringSecurityProject.Controller;

import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.SpringSecurityProject.DAO.MyCustomerDAO;

@Controller
public class LoginController {

	@Autowired
	MyCustomerDAO mycustomerdao;

	@RequestMapping("/login")
	String loginPage(Model m) {

		m.addAttribute("haserror", false);
		m.addAttribute("error", "");
		m.addAttribute("loginPage", true);
		return "index";
	}

	@RequestMapping("/flogin")
	String floginPage(Model m) {

		m.addAttribute("haserror", true);
		m.addAttribute("error", "check UserName and password");
		m.addAttribute("loginPage", true);
		return "index";
	}

	@RequestMapping("/loginsuccess")
	String loginsuccess(HttpSession httpSession) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals("ROLE_USER")) {
				httpSession.setAttribute("useremail", email);
				httpSession.setAttribute("employeelogin", true);
				httpSession.setAttribute("employerlogin", false);
				return "redirect:/Employee/viewjob";
			} else if (authority.getAuthority().equals("ROLE_ADMIN")) {
				httpSession.setAttribute("useremail", email);
				httpSession.setAttribute("employerlogin", true);
				httpSession.setAttribute("employeelogin", false);
				return "redirect:/Employer/addjob";
			} else {
				httpSession.setAttribute("useremail", email);
				httpSession.setAttribute("username", "Administrator");
				httpSession.setAttribute("employeelogin", false);
				httpSession.setAttribute("employerlogin", false);
				return "redirect:/Admin/viewalljob";
			}
		}
		return "";
	}

}
