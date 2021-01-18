package vn.molu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.molu.dao.impl.DepartmentDAOImpl;
import vn.molu.domain.Department;

@Controller
@RequestMapping("pages/department")
public class DepartmentController {
	
	DepartmentDAOImpl repository = new DepartmentDAOImpl();
	
	@RequestMapping("list.html")
	public String index(Model model) {
		model.addAttribute("listOfDepartment", repository.getDepartments());
		return "department.index";
	}
	
	@RequestMapping("add.html")
	public String add(Model model) {
		model.addAttribute("department", new Department());
		return "department.add";
	}
	
	@RequestMapping(value = "add.html", method = RequestMethod.POST)
	public String add(Department obj) {
		repository.add(obj);
		return "redirect:/pages/department/list.html";
	}
	
	@RequestMapping("edit.html/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		model.addAttribute("o", repository.getDepartment(id));
		return "department.edit";
	}

	@RequestMapping(value = "edit.html/{id}", method = RequestMethod.POST)
	public String edit(Model model, Department obj, @PathVariable("id") Long id) {
		repository.edit(obj);
		return "redirect:/pages/department/list.html";
	}
	
	@RequestMapping("delete.html/{id}")
	public String delete(@PathVariable("id") Long id) {
		repository.delete(id);
		return "redirect:/pages/department/list.html";
	}

}
