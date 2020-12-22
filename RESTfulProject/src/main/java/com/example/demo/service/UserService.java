package com.example.demo.service;

import com.example.demo.entity.Merchandise;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseData update(User model) {
        userRepository.save(model);
        return new ResponseData(ExceptionMsg.SUCCESS,model);
    }

    public ResponseData add(User user) {
        userRepository.save(user);
        // return "{success:true,message: \"添加成功\" }";
        return new ResponseData(ExceptionMsg.SUCCESS,user);
    }
}
