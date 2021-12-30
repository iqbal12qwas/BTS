package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.implementation.IShoppingService;
import com.example.demo.model.ShoppingModel;
import com.example.demo.repository.ShoppingRepository;

@Service
public class ShoppingService implements IShoppingService {

	@Autowired
	private ShoppingRepository repository;

	// Get All User
	public List<ShoppingModel> listAll() {
		return repository.findAll();
	}

	// Get By Id
	public ShoppingModel get(Long id) {
		return repository.findById(id).get();
	}
	
	//Delete Shopping By Id
	public void delete(Long id) {
		repository.deleteById(id);
	}

	// Post Shopping
	@Override
	public ShoppingModel saveShopping(ShoppingModel shopping) {
		return repository.save(shopping);
	}

}
