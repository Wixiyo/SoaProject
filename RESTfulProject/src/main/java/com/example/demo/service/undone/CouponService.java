package com.example.demo.service.undone;

import com.example.demo.service.undone.entity.Coupon;
import com.example.demo.service.undone.repository.CouponRepository;
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
