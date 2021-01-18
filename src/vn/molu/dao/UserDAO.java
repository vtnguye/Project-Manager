package vn.molu.dao;

import java.util.List;

import vn.molu.domain.User;

public interface UserDAO {
	
	public List<User> getUsers();
	
	public User getUser(Long id);
	
	public int add(User obj);
	
	public int edit(User obj);
	
	public int delete(Long id);
	
	public User login(String username);

}
