package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.models.User;

public interface UserService {
	
	public List<User> list();
	
	public User add(User u);
	
	public Optional<User> find(Long id);
	
	public User getUserById(Long id);
	
	public User update(User u);
	
	public void delete(Long id);
}
