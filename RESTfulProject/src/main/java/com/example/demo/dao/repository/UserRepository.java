package com.example.demo.dao.repository;

import com.example.demo.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    @Query("from User where userId=?1")
    User findUser(String id);

    @Modifying
    @Query("UPDATE User SET userName=?1, address=?2 ,phone=?3 WHERE userId=?4")
    void update(String userName,String address,String phone,String userId);
}
