package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.models.Category;
import com.cibertec.service.CategoryService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = AppSettings.CrossOriginUrl)
public class CategoryController {

	@Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

}
