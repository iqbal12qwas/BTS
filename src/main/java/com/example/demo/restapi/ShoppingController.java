package com.example.demo.restapi;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ShoppingDto;
import com.example.demo.exception.ResponseShopping;
import com.example.demo.model.ShoppingModel;
import com.example.demo.services.ShoppingService;

@RestController
@RequestMapping("/api/shopping")
public class ShoppingController {

	@Autowired
	private ShoppingService services;

	// Get All Shopping
	@GetMapping
	public List<ShoppingModel> list() {
		return services.listAll();
	}

	// Get Detail Shopping By Id
	@GetMapping("/{id}")
	public ResponseEntity<ShoppingModel> get(@PathVariable Long id) {
		try {
			ShoppingModel shopping = services.get(id);
			return new ResponseEntity<ShoppingModel>(shopping, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<ShoppingModel>(HttpStatus.NOT_FOUND);
		}
	}

	// Post Shopping
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseShopping save(@RequestBody ShoppingDto shoppings) throws NoSuchAlgorithmException {
		ResponseShopping response = new ResponseShopping();
		ShoppingModel shoppingModel = new ShoppingModel();

		shoppingModel.setCreateddate(shoppings.getShopping().getCreateddate());
		shoppingModel.setName(shoppings.getShopping().getName());
		services.saveShopping(shoppingModel);

		response.setData(shoppingModel);
		return response;
	}

	// Delete Shopping
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		services.delete(id);
	}

	// Update Shopping
	@PutMapping(value = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseShopping update(@RequestBody ShoppingDto shopping, @PathVariable Long id)
			throws NoSuchAlgorithmException {

		ResponseShopping response = new ResponseShopping();

		ShoppingModel existShopping = services.get(id);
		existShopping.setCreateddate(shopping.getShopping().getCreateddate());
		existShopping.setName(shopping.getShopping().getName());
		services.saveShopping(existShopping);
		response.setData(existShopping);
		return response;
	}

}
