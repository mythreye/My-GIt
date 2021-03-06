package com.niit.SpringSecurityProject.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SpringSecurityProject.DAO.JobDAO;
import com.niit.SpringSecurityProject.Model.Job;

@Repository
@Transactional
public class JobDAOImpl implements JobDAO {

	@Autowired
	SessionFactory sf;

	public boolean createAndUpdateJob(Job job) {
		try {
			sf.getCurrentSession().saveOrUpdate(job);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteJob(int id) {
		try {
			sf.getCurrentSession().delete(selectOneJob(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Job> selectAllJob() {
		try {
			return sf.getCurrentSession().createQuery("from Job where status=" + true).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Job> selectUnapprovedJob() {
		try {
			return sf.getCurrentSession().createQuery("from Job where status=" + false).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Job selectOneJob(int id) {
		try {
			return (Job) sf.getCurrentSession().createQuery("from Job where id=" + id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Job> selectEmployerJob(String email) {
		try {
			return sf.getCurrentSession().createQuery("from Job where email='" + email+"'").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
