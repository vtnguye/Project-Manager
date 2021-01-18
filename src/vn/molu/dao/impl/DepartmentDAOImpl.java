package vn.molu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import vn.molu.dao.DepartmentDAO;
import vn.molu.domain.Department;
import vn.molu.utils.HibernateUtil;

public class DepartmentDAOImpl extends Repository implements DepartmentDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartments() {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			return session.createQuery("From Department").list();
		}
	}
	
	@Override
	public Department getDepartment(Long id) {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			return session.find(Department.class, id);
		}
	}
	
	@Override
	public int add(Department obj) {
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
	public int edit(Department obj) {
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
			session.delete(new Department(id, null));
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
