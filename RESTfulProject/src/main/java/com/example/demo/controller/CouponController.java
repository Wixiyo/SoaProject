package com.example.demo.controller;

import com.example.demo.repository.CouponRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.Response;
import com.example.demo.result.ResponseData;
import com.example.demo.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("coupon")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
public class CouponController {
    protected Response result(ExceptionMsg msg){
        return new Response(msg);
    }
    protected Response result(){
        return new Response();
    }
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private CouponService couponService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseData searchcart() {
        return couponService.getCoupons();
    }
}

