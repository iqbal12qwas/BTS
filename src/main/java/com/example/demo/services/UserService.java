package com.example.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.implementation.IUserService;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository repository;

	//Get All User
	public List<UserModel> listAll() {
		return repository.findAll();
	}
	
	//Post User
	@Override
	public UserModel saveUser(UserModel user) {
		return repository.save(user);
	}
	
	//Get By Id
	public UserModel get(Long id) {
		return repository.findById(id).get();
	}
	
	//Delete User
	public void delete(Long id) {
		repository.deleteById(id);
	}


}
