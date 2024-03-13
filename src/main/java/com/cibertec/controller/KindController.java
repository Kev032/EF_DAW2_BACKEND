package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.models.Kind;
import com.cibertec.service.KindService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/kind")
@CrossOrigin(origins = AppSettings.CrossOriginUrl)
public class KindController {
	
	@Autowired
    private KindService kindService;

    @GetMapping
    public List<Kind> getAllKind() {
        return kindService.getAllKind();
    }

}
