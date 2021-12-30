package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.ShoppingModel;

public interface ShoppingRepository extends JpaRepository<ShoppingModel, Long>, PagingAndSortingRepository<ShoppingModel, Long>, CrudRepository<ShoppingModel, Long>  {

}
