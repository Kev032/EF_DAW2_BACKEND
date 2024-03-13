package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.models.Priority;
import com.cibertec.service.PriorityService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/priority")
@CrossOrigin(origins = AppSettings.CrossOriginUrl)
public class PriorityController {

	@Autowired
	private PriorityService priorityService;

	@GetMapping
	public List<Priority> getAllPriority() {
		return priorityService.getAllPriority();
	}

}
