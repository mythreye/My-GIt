package com.niit.SpringSecurityProject.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.SpringSecurityProject.DAO.JobDAO;
import com.niit.SpringSecurityProject.Model.Job;

@Controller
@RequestMapping("/Employer")
public class EmployerController {

	@Autowired
	JobDAO jobdao;

	@RequestMapping("/addjob")
	String addjobpage(Model m) {
		m.addAttribute("addjob", true);
		m.addAttribute("newjob", new Job());
		m.addAttribute("haserror", false);
		m.addAttribute("error", "");
		m.addAttribute("showmess", false);
		m.addAttribute("message", "");
		return "index";

	}

	@RequestMapping("/postjob")
	String customerPage(@Valid @ModelAttribute("newjob") Job newjob, BindingResult br, Model m,
			HttpSession httpSession) {
		newjob.setEmail(httpSession.getAttribute("useremail").toString());
		newjob.setStatus(false);
		if (br.hasErrors()) {
			m.addAttribute("addjob", true);
			m.addAttribute("newjob", newjob);
			m.addAttribute("haserror", true);
			m.addAttribute("error", "Please Check all data");
			m.addAttribute("showmess", false);
			m.addAttribute("message", "");
			return "index";
		} else {
			try {
				if (jobdao.createAndUpdateJob(newjob)) {
					m.addAttribute("addjob", true);
					m.addAttribute("newjob", new Job());
					m.addAttribute("haserror", false);
					m.addAttribute("error", "");
					m.addAttribute("showmess", true);
					m.addAttribute("message", "Job Posted");
				}
				return "index";
			} catch (Exception e1) {
				m.addAttribute("addjob", true);
				m.addAttribute("newjob", newjob);
				m.addAttribute("haserror", true);
				m.addAttribute("error", "Please Check all data");
				m.addAttribute("showmess", false);
				m.addAttribute("message", "");
				return "index";
			}
		}
	}

	@RequestMapping("/viewmyjob")
	String viewpostedjob(Model m, HttpSession httpSession) {
		m.addAttribute("showmess", false);
		m.addAttribute("message", "");
		m.addAttribute("viewjob", true);
		m.addAttribute("jobs", jobdao.selectEmployerJob(httpSession.getAttribute("useremail").toString()));
		return "index";
	}

	@RequestMapping("/deletemyjob")
	String deletejob(@RequestParam("jobid") int id, Model m, HttpSession httpSession) {
		if (jobdao.deleteJob(id))
			m.addAttribute("message", "Deleted Job");
		else
			m.addAttribute("message", "Not Deleted Job");

		m.addAttribute("showmess", true);
		m.addAttribute("viewjob", true);
		m.addAttribute("jobs", jobdao.selectEmployerJob(httpSession.getAttribute("useremail").toString()));
		return "index";
	}

	@RequestMapping("/viewonejob")
	String viewonejob(@RequestParam("jobid") int id, Model m, HttpSession httpSession) {
		m.addAttribute("showmess", false);
		m.addAttribute("message", "");
		m.addAttribute("viewonejob", true);
		m.addAttribute("job", jobdao.selectOneJob(id));
		return "index";
	}

}
