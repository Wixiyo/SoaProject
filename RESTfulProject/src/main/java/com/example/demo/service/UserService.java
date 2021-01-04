package com.example.demo.service;

import com.example.demo.entity.Merchandise;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {//用户管理服务
    @Autowired
    private UserRepository userRepository;

    public ResponseData update(User user) {
        userRepository.update(user.getUserName(), user.getAddress(), user.getPhone(), user.getUserId());
        return new ResponseData(ExceptionMsg.SUCCESS, user);
    }

    public ResponseData add(User user) {
        userRepository.save(user);
        // return "{success:true,message: \"添加成功\" }";
        return new ResponseData(ExceptionMsg.SUCCESS, user);
    }

    public ResponseData check(String id,String password) {
        User user = userRepository.findUser(id);
        if(user.getPassword().equals(password)){
            return new ResponseData(ExceptionMsg.SUCCESS, user);
        }
        else {
            return new ResponseData(ExceptionMsg.FAILED, id);
        }
    }
}