package vn.molu.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Table Employee_Project có Primary Key là một Composite Key (2 column tạo thành 1 Primary key).
 * Class này gọi là @IdClass - đặc tả Composite Primary Key.
 * The composite primary key class must be public.
 * It must have a no-arg constructor.
 * It must define equals() and hashCode() methods.
 * It must be Serializable.
 */
@Table(name = "Employee_Project")
public class EmployeeProjectID implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "Employee_Id")
	private Long employeeId;

	@Column(name = "Project_Id")
	private Long projectId;

	public EmployeeProjectID() {
	}

	public EmployeeProjectID(Long employeeId, Long projectId) {
		this.employeeId = employeeId;
		this.projectId = projectId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeProjectID other = (EmployeeProjectID) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		return true;
	}

}
