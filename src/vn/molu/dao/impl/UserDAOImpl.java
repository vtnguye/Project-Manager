package vn.molu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import vn.molu.dao.UserDAO;
import vn.molu.domain.User;
import vn.molu.utils.Helper;
import vn.molu.utils.HibernateUtil;

public class UserDAOImpl extends Repository implements UserDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			return session.createQuery("From User").list();
		}
	}
	
	@Override
	public User getUser(Long id) {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			return session.find(User.class, id);
		}
	}
	
	@Override
	public int add(User obj) {
		obj.setPassword(Helper.bcrypt(obj.getPassword()));
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
	public int edit(User obj) {
		obj.setPassword(Helper.bcrypt(obj.getPassword()));
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
			session.delete(new User(id, null, null, null, null));
			tran.commit();
			return 1;
		} catch (Exception ex) {
			if (tran != null) {
				tran.rollback();
			}
			return 0;
		}
	}
	
	/**
	 * Dùng cho Security.UserService - hàm loadUserByUsername(String username).
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public User login(String username) {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {
			Query query = session.createQuery("FROM User WHERE Username = :u");
			query.setParameter("u", username);
			User obj = (User) query.uniqueResult();
			return obj;
		}
	}
}
