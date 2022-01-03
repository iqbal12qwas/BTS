package com.example.demo.restapi;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/api/testingusers")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService service;

	// Get All Users
	@GetMapping("/")
	public List<UserModel> list() {
		return service.listAll();
	}

	// Get Detail User
	@GetMapping("/user/{id}")
	public ResponseEntity<UserModel> get(@PathVariable Long id) {
		try {
			UserModel user = service.get(id);
			return new ResponseEntity<UserModel>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	// Register User
//	@PostMapping(value = "/signup", consumes = "application/json")
//	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseSignUp save(@RequestBody UserDto users) throws NoSuchAlgorithmException {
//		ResponseSignUp response = new ResponseSignUp();
//		UserModel userModel = new UserModel();
//
//		MessageDigest digest = MessageDigest.getInstance("SHA-256");
//		byte[] myHashBytes = digest.digest(users.getUsers().getPassword().getBytes(StandardCharsets.UTF_8));
//		String myHash = Base64.getEncoder().encodeToString(myHashBytes);
//		userModel.setPassword(myHash);
//		
//		userModel.setUsername(users.getUsers().getUsername());
//		userModel.setEmail(users.getUsers().getEmail());
//		userModel.setPhone(users.getUsers().getPhone());
//		userModel.setAddress(users.getUsers().getAddress());
//		userModel.setCity(users.getUsers().getCity());
//		userModel.setCountry(users.getUsers().getCountry());
//		userModel.setName(users.getUsers().getName());
//		userModel.setPostcode(users.getUsers().getPostcode());
//		service.saveUser(userModel);
//		
//		response.setEmail(users.getUsers().getEmail());
//		response.setToken("");
//		response.setUsername(users.getUsers().getUsername());
//		return response;
//	}
	
	

}
