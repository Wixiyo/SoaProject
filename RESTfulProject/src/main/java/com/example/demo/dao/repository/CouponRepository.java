package com.example.demo.dao.repository;

import com.example.demo.dao.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CouponRepository extends JpaRepository<Coupon,Long>, JpaSpecificationExecutor<Coupon > {
}
