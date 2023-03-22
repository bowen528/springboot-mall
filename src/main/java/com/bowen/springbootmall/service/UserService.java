package com.bowen.springbootmall.service;

import com.bowen.springbootmall.dto.UserLoginRequest;
import com.bowen.springbootmall.dto.UserRegisterRequest;
import com.bowen.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}
