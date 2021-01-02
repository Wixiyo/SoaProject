package com.example.demo.repository;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer>, JpaSpecificationExecutor<Order > {
    @Query("from Order where userId=?1")
    List<Order> findByUserId(String user);

    @Modifying
    @Query("UPDATE Order SET logistic=?1 WHERE id=?2")
    void updateLogistics(String nuo,long id);
}
