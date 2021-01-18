package vn.molu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import vn.molu.dao.ProjectDAO;
import vn.molu.domain.Project;
import vn.molu.utils.HibernateUtil;

public class ProjectDAOImpl extends Repository implements ProjectDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjects() {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			return session.createQuery("From Project").list();
		}
	}
	
	@Override
	public Project getProject(Long id) {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			return session.find(Project.class, id);
		}
	}

	@Override
	public int add(Project obj) {
		Transaction tran = null;
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			tran = session.beginTransaction();
			session.save(obj);
			tran.commit();
			return 1;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			return 0;
		}
	}

	@Override
	public int edit(Project obj) {
		Transaction tran = null;
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			tran = session.beginTransaction();
			session.update(obj);
			tran.commit();
			return 1;
		} catch (Exception e) {
			if (tran != null) {
				tran.rollback();
			}
			return 0;
		}
	}

	@Override
	public int delete(Long id) {
		Transaction tran = null;
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			tran = session.beginTransaction();
			session.delete(new Project(id, null, null, null, null));
			tran.commit();
			return 1;
		} catch (Exception ex) {
			if (tran != null) {
				tran.rollback();
			}
			return 0;
		}
	}

}
