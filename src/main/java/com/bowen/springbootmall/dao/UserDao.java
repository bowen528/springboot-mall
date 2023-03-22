package com.bowen.springbootmall.dao;

import com.bowen.springbootmall.dto.UserRegisterRequest;
import com.bowen.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    User getUserByEmail(String email);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
