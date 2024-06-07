package com.cg.project.entity;

import java.util.List;

public class ProjectResponse {
	
	private Project project;
	
	private List<Employee> employees;
	
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public ProjectResponse(Project project, List<Employee> employees) {
		super();
		this.project = project;
		this.employees = employees;
	}
	public ProjectResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProjectResponse [project=" + project + ", employees=" + employees + "]";
	}

	
}
