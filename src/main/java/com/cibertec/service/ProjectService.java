package com.cibertec.service;

import java.util.List;

import com.cibertec.models.Project;

public interface ProjectService {
	
	public List<Project> getAllProject();

    public Project getProjectById(Long id);

}
