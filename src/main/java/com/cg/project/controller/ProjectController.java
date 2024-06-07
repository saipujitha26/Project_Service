package com.cg.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.project.entity.Project;
import com.cg.project.entity.ProjectResponse;
import com.cg.project.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	private ProjectService projectService;
	
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@PostMapping("/")
	public ResponseEntity<Project> createProject(@RequestBody Project project){
		Project newProject = projectService.createProject(project);
			return ResponseEntity.status(HttpStatus.CREATED).body(newProject);
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Project> getProjectById(@PathVariable("id") Long projectId){
		Optional<Project> project = Optional.of(projectService.getProjectById(projectId));
			return new ResponseEntity<Project>(project.get(), HttpStatus.OK);
	}
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<ProjectResponse> getProjectWithEmployeesById(@PathVariable("id") Long projectId){
		Optional<ProjectResponse> project = Optional.of(projectService.getEmployeeByProjectId(projectId));
			return new ResponseEntity<ProjectResponse>(project.get(), HttpStatus.OK);
	}

	
	@GetMapping("/")
	public ResponseEntity<List<Project>> getAllProject(){
		List<Project> project = projectService.getAllProjects();
		return ResponseEntity.status(HttpStatus.OK).body(project);	
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProject(@PathVariable("id") Long projectId){
		projectService.deleteProject(projectId);
		return ResponseEntity.status(HttpStatus.OK).body("Project deleted Successfully..");
	}
	

}
