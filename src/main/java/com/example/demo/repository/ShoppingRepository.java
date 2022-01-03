package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ShoppingModel;

@Repository
public interface ShoppingRepository extends JpaRepository<ShoppingModel, Long>, PagingAndSortingRepository<ShoppingModel, Long>, CrudRepository<ShoppingModel, Long>  {

}
