package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.models.Project;
import com.cibertec.service.ProjectService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = AppSettings.CrossOriginUrl)
public class ProjectController {
	
	@Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllProject() {
        return projectService.getAllProject();
    }

}
