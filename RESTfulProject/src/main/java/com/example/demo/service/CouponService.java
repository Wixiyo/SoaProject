package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Coupon;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.CouponRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CouponService {//优惠券服务，未完成

    @Autowired
    private CouponRepository couponRepository;

    public ResponseData getCoupons() {
        List<Coupon> coupons = new ArrayList<Coupon>(couponRepository.findAll());
        return new ResponseData(ExceptionMsg.SUCCESS,coupons);
    }
}
