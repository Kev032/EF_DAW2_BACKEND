package com.cibertec.service;

import java.util.List;

import com.cibertec.models.Status;


public interface StatusService {
	
	public List<Status> getAllStatus();

    public Status getStatusById(Long id);

}
