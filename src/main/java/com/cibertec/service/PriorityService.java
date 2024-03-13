package com.cibertec.service;

import java.util.List;

import com.cibertec.models.Priority;

public interface PriorityService {
	
	public List<Priority> getAllPriority();
	
	public Priority getProrityById(Long id);

}
