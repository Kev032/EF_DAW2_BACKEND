package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.models.Status;
import com.cibertec.service.StatusService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/status")
@CrossOrigin(origins = AppSettings.CrossOriginUrl)
public class StatusController {
	
	@Autowired
    private StatusService statusService;

    @GetMapping
    public List<Status> getAllStatus() {
        return statusService.getAllStatus();
    }

}
