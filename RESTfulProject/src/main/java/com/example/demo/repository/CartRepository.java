package com.example.demo.repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer>, JpaSpecificationExecutor<Cart > {
    @Query("from Cart where userId=?1")
    List<Cart> findByUserId(String user);
}
