package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.models.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
