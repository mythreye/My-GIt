package com.niit.SpringSecurityProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping({ "/", "/home" })
	String indexPage(Model m) {
		m.addAttribute("indexPage", true);
		return "index";
	}
	@RequestMapping("/aboutus")
	String aboutusPage(Model m) {
		m.addAttribute("aboutusPage", true);
		return "index";
	}

	@RequestMapping("/contactus")
	String contactusPage(Model m) {
		m.addAttribute("contactusPage", true);
		return "index";
	}

}
