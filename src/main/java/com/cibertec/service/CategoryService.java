package com.cibertec.service;

import java.util.List;

import com.cibertec.models.Category;

public interface CategoryService {
	
	public List<Category> getAllCategory();
	
	public Category getCategoryById(Long id);

}
