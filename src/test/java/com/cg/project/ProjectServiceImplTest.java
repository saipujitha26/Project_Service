package com.cg.project;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.project.entity.Project;
import com.cg.project.service.ProjectServiceImpl;


@ExtendWith(MockitoExtension.class)
public class ProjectServiceImplTest {
	
	@InjectMocks
	private ProjectServiceImpl projectServiceImpl;
	
	@Test
	public void getProjectByIdTest() {
		
		Project project = projectServiceImpl.getProjectById(1L);
		
	}
	
	

}
