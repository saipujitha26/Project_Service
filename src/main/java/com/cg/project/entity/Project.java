package com.cg.project.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "project")
public class Project implements Serializable {

	@Id
	private Long projectId;

	private String projectName;

	private String clientName;

	private LocalDate projectStartDate;

	private LocalDate projectEndDate;

	private int projectTeamSize;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public LocalDate getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(LocalDate projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public LocalDate getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(LocalDate projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public int getProjectTeamSize() {
		return projectTeamSize;
	}

	public void setProjectTeamSize(int projectTeamSize) {
		this.projectTeamSize = projectTeamSize;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", clientName=" + clientName
				+ ", projectStartDate=" + projectStartDate + ", projectEndDate=" + projectEndDate + ", projectTeamSize="
				+ projectTeamSize + "]";
	}

	public Project(Long projectId, String projectName, String clientName, LocalDate projectStartDate,
			LocalDate projectEndDate, int projectTeamSize) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.clientName = clientName;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.projectTeamSize = projectTeamSize;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}


}
