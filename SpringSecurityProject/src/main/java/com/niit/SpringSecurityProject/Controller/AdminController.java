package com.niit.SpringSecurityProject.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.SpringSecurityProject.DAO.JobDAO;
import com.niit.SpringSecurityProject.Model.Job;

@Controller
@RequestMapping("/Admin")
public class AdminController {
	@Autowired
	JobDAO jobdao;

	@RequestMapping("/viewalljob")
	String viewpostedjob(Model m, HttpSession httpSession) {
		m.addAttribute("showmess", false);
		m.addAttribute("message", "");
		m.addAttribute("viewjob", true);
		m.addAttribute("jobs", jobdao.selectUnapprovedJob());
		return "index";
	}

	@RequestMapping("/approvejob")
	String deletejob(@RequestParam("jobid") int id, Model m) {
		Job job = jobdao.selectOneJob(id);
		job.setStatus(true);
		if (jobdao.createAndUpdateJob(job)) {
			m.addAttribute("message", "Job Approved");
		} else {
			m.addAttribute("message", "Job Not Approved");
		}
		m.addAttribute("showmess", true);
		m.addAttribute("viewjob", true);
		m.addAttribute("jobs", jobdao.selectUnapprovedJob());
		return "index";
	}
}
