package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>, CrudRepository<UserModel, Long> {

//	Optional<UserModel> findByEmail(String email);
	UserModel findByUsername(String username);
	
	UserModel findByEmail(String email);

    Boolean existsByEmail(String email);

	Boolean existsByUsername(String username);
	
}
