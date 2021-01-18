package vn.molu.dao;

import java.util.List;

import vn.molu.domain.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(Long id);
	
	public int add(Employee obj);
	
	public int edit(Employee obj);
	
	public int delete(Long id);

}
