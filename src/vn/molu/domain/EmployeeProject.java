package vn.molu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Project")
@IdClass(EmployeeProjectID.class)
public class EmployeeProject {

	@Id
	@Column(name = "Employee_Id")
	private Long employeeId;

	@Id
	@Column(name = "Project_Id")
	private Long projectId;
	
	@ManyToMany
	@JoinColumn(name = "Id", referencedColumnName = "Employee_Id")
	private List<Employee> employees;
	
	@ManyToMany
	@JoinColumn(name = "Id", referencedColumnName = "Project_Id")
	private List<Project> projects;

	public EmployeeProject() {
	}

	public EmployeeProject(Long employeeId, Long projectId) {
		this.employeeId = employeeId;
		this.projectId = projectId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

}
