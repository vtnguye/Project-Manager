package vn.molu.dao;

import java.util.List;

import vn.molu.domain.Department;

public interface DepartmentDAO {
	
	public List<Department> getDepartments();
	
	public Department getDepartment(Long id);
	
	public int add(Department obj);
	
	public int edit(Department obj);
	
	public int delete(Long id);

}
