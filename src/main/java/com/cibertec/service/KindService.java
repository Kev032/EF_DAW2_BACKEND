package com.cibertec.service;

import java.util.List;

import com.cibertec.models.Kind;

public interface KindService {
	
	public List<Kind> getAllKind();
	
	public Kind getKindById(Long id);

}
