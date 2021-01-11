package com.example.demo.dao.orderDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer>, JpaSpecificationExecutor<Order > {
    @Query("from Order where userId=?1")
    List<Order> findByUserId(String user);

    @Modifying
    @Query("UPDATE Order SET logistic=?1 ,status='已发货' WHERE id=?2")
    void updateLogistics(String nuo,long id);

    @Modifying
    @Query("UPDATE Order SET status='已确认' WHERE logistic=?1")
    void updateStatus(String nuo);
}
