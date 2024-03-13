package com.cibertec.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.models.Project;
import com.cibertec.repository.ProjectRepository;
import com.cibertec.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public List<Project> getAllProject() {
		return projectRepository.findAll();
	}

	@Override
	public Project getProjectById(Long id) {
		return projectRepository.findById(id).orElse(null);
	}

}
