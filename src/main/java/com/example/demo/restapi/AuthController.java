package com.example.demo.restapi;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.dto.UserDto;
import com.example.demo.model.UserModel;
import com.example.demo.responses.JwtRequest;
import com.example.demo.responses.JwtResponse;
import com.example.demo.responses.MessageResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Autowired
	JwtUtils jwtUtils;

	// Get All Users
	@GetMapping("/")
	public List<UserModel> list() {
		return userService.listAll();
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto signUpRequest) throws NoSuchAlgorithmException {
		if (userRepository.existsByUsername(signUpRequest.getUsers().getUsername())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse(false, "Error: Username is already taken!", null));
		}

		if (userRepository.existsByEmail(signUpRequest.getUsers().getEmail())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse(false, "Error: Email is already in use!", null));
		}

		// Create new user's account
		UserModel userModel = new UserModel();

		userModel.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getUsers().getPassword()));

		userModel.setUsername(signUpRequest.getUsers().getUsername());
		userModel.setEmail(signUpRequest.getUsers().getEmail());
		userModel.setPhone(signUpRequest.getUsers().getPhone());
		userModel.setAddress(signUpRequest.getUsers().getAddress());
		userModel.setCity(signUpRequest.getUsers().getCity());
		userModel.setCountry(signUpRequest.getUsers().getCountry());
		userModel.setName(signUpRequest.getUsers().getName());
		userModel.setPostcode(signUpRequest.getUsers().getPostcode());
		userRepository.save(userModel);
		
		final UserDetails userDetails = userService.loadUserByUsername(userModel.getUsername());

		final String token = jwtUtils.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(userModel.getEmail(), token, userModel.getUsername()));
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		UserModel userModel = userService.findByEmail(authenticationRequest.getEmail());

		if (userModel == null) {
			return ResponseEntity.ok(new MessageResponse(false, "Email & Password Not Found", ""));
		} else {
			authenticate(userModel.getUsername(), authenticationRequest.getPassword());

			final UserDetails userDetails = userService.loadUserByUsername(userModel.getUsername());

			final String token = jwtUtils.generateToken(userDetails);

			return ResponseEntity.ok(new JwtResponse(userModel.getEmail(), token, userModel.getUsername()));
		}
	}

	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
