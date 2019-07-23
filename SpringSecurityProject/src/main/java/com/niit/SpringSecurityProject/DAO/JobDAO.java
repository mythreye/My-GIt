package com.niit.SpringSecurityProject.DAO;

import java.util.List;

import com.niit.SpringSecurityProject.Model.Job;


public interface JobDAO {
	boolean createAndUpdateJob(Job job);
	  boolean deleteJob(int id);
	  List<Job> selectAllJob();
	  List<Job> selectUnapprovedJob();
	  Job selectOneJob(int id);
	  List<Job> selectEmployerJob(String email);
}
