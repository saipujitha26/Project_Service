package com.cg.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.project.entity.Employee;
import com.cg.project.entity.Project;
import com.cg.project.entity.ProjectResponse;
import com.cg.project.exception.DBException;
import com.cg.project.exception.ProjectAlreadyExistsException;
import com.cg.project.exception.ProjectNotFoundException;
import com.cg.project.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	private ProjectRepository projectRepository;
	
	@Value("${application.project.projecturl}")
	private String URL;
	
	private static final String Url="http://localhost:8081/employee/project/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Autowired
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;  
	}
	
	@Override
	public Project createProject(Project project) {
		Optional<Project> projectFromDb = projectRepository.findById(project.getProjectId());
		if(projectFromDb.isPresent()) {
			throw new ProjectAlreadyExistsException("project Already exists..");
		}
		Project newProject;
		try {
			newProject = projectRepository.save(project);
		}
			catch (Exception ex) {
				throw new DBException("DB Exception or Internal server error");
			}
		return newProject;
	}

	@Override
	public Project getProjectById(Long projectId) {
		Optional<Project> project = projectRepository.findById(projectId);
		if(project.isEmpty()) {
			throw new ProjectNotFoundException("project not found with given id ");
		}
		return project.get();
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> project = projectRepository.findAll();
		if(project.isEmpty()) {
			throw new ProjectNotFoundException("project Not found..");
		}
		return project;
	}

	@Override
	public String deleteProject(Long projectId) {
		if(projectRepository.findById(projectId).isPresent()) {
			projectRepository.deleteById(projectId);
		}else {
			throw new ProjectNotFoundException("project not found with id");
		}
		
		return "Project deleted successfully..";
	}

	@Override
	public ProjectResponse getEmployeeByProjectId(Long projectId) {
		Optional<Project> project = projectRepository.findById(projectId);
		if(project.isEmpty()) {
			throw new ProjectNotFoundException("project Not found..");
		}
		
		ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(Url+projectId,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
                });
		List<Employee> employee = responseEntity.getBody();
		ProjectResponse projectResponse = new ProjectResponse();
		projectResponse.setProject(project.get());
		projectResponse.setEmployees(employee);
	
		return projectResponse;
	}
	
}
