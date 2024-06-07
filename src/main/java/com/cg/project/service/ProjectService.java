package com.cg.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.project.entity.Employee;
import com.cg.project.entity.Project;
import com.cg.project.entity.ProjectResponse;

@Service
public interface ProjectService {
	
public Project createProject(Project project);
	
	public Project getProjectById(Long projectId);
	
	public List<Project> getAllProjects();
	
	public String deleteProject(Long projectId);
	
	public ProjectResponse getEmployeeByProjectId(Long projectId);

}
