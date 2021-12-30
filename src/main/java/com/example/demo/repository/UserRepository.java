package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>, PagingAndSortingRepository<UserModel, Long>, CrudRepository<UserModel, Long> {
	
	
}
