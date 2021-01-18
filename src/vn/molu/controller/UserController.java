package vn.molu.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.molu.dao.impl.EmployeeDAOImpl;
import vn.molu.dao.impl.UserDAOImpl;
import vn.molu.domain.Employee;
import vn.molu.domain.User;

@Controller
@RequestMapping("pages")
public class UserController {

	UserDAOImpl repository = new UserDAOImpl();

	EmployeeDAOImpl employeeRepository = new EmployeeDAOImpl();

	@RequestMapping("user/list.html")
	public String index(Model model) {
		model.addAttribute("listOfUser", repository.getUsers());
		return "user.index";
	}

	@RequestMapping("register.html")
	public String register(Model model) {
		// Lấy list gồm các Employee Hashmap vào Map<Employee_Id, Full_Name>
		List<Employee> list = employeeRepository.getEmployees();
		Map<Long, String> map = new HashMap<>();
		for (Employee item : list) {
			map.put(item.getId(), item.getFullName());
		}
		model.addAttribute("map", map);
		model.addAttribute("obj", new User());
		return "register";
	}

	@RequestMapping(value = "register.html", method = RequestMethod.POST)
	public String register(User obj) {
		// Lấy time hiện tại gán vào obj - activeDate
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		obj.setActiveDate(timestamp);
		repository.add(obj);
		return "redirect:/pages/login.html";
	}

	@RequestMapping("user/edit.html/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		
		// Lấy list gồm các Employee Hashmap vào Map<Employee_Id, Full_Name>
		List<Employee> list = employeeRepository.getEmployees();
		Map<Long, String> map = new HashMap<>();
		for (Employee item : list) {
			map.put(item.getId(), item.getFullName());
		}
		model.addAttribute("map", map);
		model.addAttribute("o", repository.getUser(id));
		return "user.edit";
	}
	
	

	@RequestMapping(value = "user/edit.html/{id}", method = RequestMethod.POST)
	public String edit(Model model, User obj, @PathVariable("id") Long id) {
		repository.edit(obj);
		return "redirect:/pages/user/list.html";
	}

	@RequestMapping("user/delete.html/{id}")
	public String delete(@PathVariable("id") Long id) {
		repository.delete(id);
		return "redirect:/pages/user/list.html";
	}

	@RequestMapping("login.html")
	public String login() {
		return "login";
	}

}
