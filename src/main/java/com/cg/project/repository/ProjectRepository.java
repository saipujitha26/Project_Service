package com.cg.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.project.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
