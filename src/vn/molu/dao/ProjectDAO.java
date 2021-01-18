package vn.molu.dao;

import java.util.List;

import vn.molu.domain.Project;

public interface ProjectDAO {
	
	public List<Project> getProjects();
	
	public Project getProject(Long id);
	
	public int add(Project obj);
	
	public int edit(Project obj);
	
	public int delete(Long id);

}
