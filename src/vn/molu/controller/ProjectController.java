package vn.molu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.molu.dao.impl.DepartmentDAOImpl;
import vn.molu.dao.impl.ProjectDAOImpl;
import vn.molu.domain.Department;
import vn.molu.domain.Project;

@Controller
@RequestMapping("pages/project")
public class ProjectController {

	ProjectDAOImpl repository = new ProjectDAOImpl();
	
	DepartmentDAOImpl departmentRepository = new DepartmentDAOImpl();

	@RequestMapping("list.html")
	public String index(Model model) {
		model.addAttribute("listOfProject", repository.getProjects());
		return "project.index";
	}

	@RequestMapping("add.html")
	public String add(Model model) {
		// Lấy list gồm các Department Hashmap vào Map<id, name>
		List<Department> list = departmentRepository.getDepartments();
		Map<Long, String> map = new HashMap<>();
		for (Department item : list) {
			map.put(item.getId(), item.getName());
		}
		model.addAttribute("map", map);
		model.addAttribute("project", new Project());
		return "project.add";
	}

	@RequestMapping(value = "add.html", method = RequestMethod.POST)
	public String add(Project obj) {
		repository.add(obj);
		return "redirect:/pages/project/list.html";
	}
	
	@RequestMapping("edit.html/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		// Lấy list gồm các Department Hashmap vào Map<id, name>
		List<Department> list = departmentRepository.getDepartments();
		Map<Long, String> map = new HashMap<>();
		for (Department item : list) {
			map.put(item.getId(), item.getName());
		}
		model.addAttribute("map", map);
		model.addAttribute("o", repository.getProject(id));
		return "project.edit";
	}

	@RequestMapping(value = "edit.html/{id}", method = RequestMethod.POST)
	public String edit(Model model, Project obj, @PathVariable("id") Long id) {
		repository.edit(obj);
		return "redirect:/pages/project/list.html";
	}
	
	@RequestMapping("delete.html/{id}")
	public String delete(@PathVariable("id") Long id) {
		repository.delete(id);
		return "redirect:/pages/project/list.html";
	}

}
