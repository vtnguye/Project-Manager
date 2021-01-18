package vn.molu.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true)
	private Long id;
	
	@Column(name = "Username", unique = true)
	private String username;

	@Column(name = "Password")
	private String password;
	
	//Timestamp trong Java = DateTime trong sql (hiển thị ngày tháng năm và thời gian)
	@Column(name = "Active_Date")
	private Timestamp activeDate;
	
	@Column(name = "Employee_Id", unique = true)
	private Long employeeId;
	
	public User() {
	}

	public User(Long id, String username, String password, Long employeeId) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.employeeId = employeeId;
	}

	public User(Long id, String username, String password, Timestamp activeDate, Long employeeId) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.activeDate = activeDate;
		this.employeeId = employeeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Timestamp activeDate) {
		this.activeDate = activeDate;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

}
