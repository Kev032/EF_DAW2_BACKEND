package com.cibertec.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cibertec.models.User;
import com.cibertec.repository.UserRepository;
import com.cibertec.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> list(){
		return userRepository.findAll();
	}

	@Override
	public User add(User u) {
		return userRepository.save(u);
	}

	@Override
	public Optional<User> find(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User update(User u) {
		return userRepository.save(u);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
}
