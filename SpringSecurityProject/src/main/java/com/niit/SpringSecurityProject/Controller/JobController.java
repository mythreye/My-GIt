package com.niit.SpringSecurityProject.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.SpringSecurityProject.DAO.JobDAO;
import com.niit.SpringSecurityProject.Model.Job;

@Controller
@RequestMapping("/Employee")
public class JobController {

	@Autowired
	JobDAO jobdao;

	@RequestMapping("/viewjob")
	String viewjob(Model m, HttpSession httpSession) {
		m.addAttribute("showmess", false);
		m.addAttribute("message", "");
		m.addAttribute("viewjob", true);
		m.addAttribute("jobs", jobdao.selectAllJob());
		return "index";
	}

	@RequestMapping("/viewonejob")
	String viewonejob(@RequestParam("jobid")int id,Model m, HttpSession httpSession) {
		m.addAttribute("showmess", false);
		m.addAttribute("message", "");
		m.addAttribute("viewonejob", true);
		m.addAttribute("job", jobdao.selectOneJob(id));
		return "index";
	}

}
