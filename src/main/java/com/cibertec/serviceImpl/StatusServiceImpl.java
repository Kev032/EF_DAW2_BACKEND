package com.cibertec.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.models.Status;
import com.cibertec.repository.StatusRepository;
import com.cibertec.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService{

	@Autowired
	StatusRepository statusRepository;
	
	@Override
	public List<Status> getAllStatus() {
		return statusRepository.findAll();
	}

	@Override
	public Status getStatusById(Long id) {
		return statusRepository.findById(id).orElse(null);
	}
	

}
