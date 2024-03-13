package com.cibertec.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.models.Kind;
import com.cibertec.repository.KindRepository;
import com.cibertec.service.KindService;

@Service
public class KindServiceImpl implements KindService{

	@Autowired
	KindRepository kindRepository;
	
	@Override
	public List<Kind> getAllKind() {
		return kindRepository.findAll();
	}

	@Override
	public Kind getKindById(Long id) {
		return kindRepository.findById(id).orElse(null);
	}

}
