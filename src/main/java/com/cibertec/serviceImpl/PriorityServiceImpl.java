package com.cibertec.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.models.Priority;
import com.cibertec.repository.PriorityRepository;
import com.cibertec.service.PriorityService;

@Service
public class PriorityServiceImpl implements PriorityService{
	
	@Autowired
	PriorityRepository priorityRepository;

	@Override
	public List<Priority> getAllPriority() {
		return priorityRepository.findAll();
	}

	@Override
	public Priority getProrityById(Long id) {
		return priorityRepository.findById(id).orElse(null);
	}
	
	

}
