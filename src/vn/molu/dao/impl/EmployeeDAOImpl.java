package vn.molu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import vn.molu.dao.EmployeeDAO;
import vn.molu.domain.Employee;
import vn.molu.utils.HibernateUtil;

public class EmployeeDAOImpl extends Repository implements EmployeeDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployees() {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			return session.createQuery("From Employee").list();
		}
	}
	
	@Override
	public Employee getEmployee(Long id) {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			return session.find(Employee.class, id);
		}
	}

	@Override
	public int add(Employee obj) {
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
	public int edit(Employee obj) {
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
			session.delete(new Employee(id, null, null, null, null, null));
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
