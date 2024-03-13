package com.cibertec.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.models.Category;
import com.cibertec.repository.CategoryRepository;
import com.cibertec.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	@Override	
	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}

}
