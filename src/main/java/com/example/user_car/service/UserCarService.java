package com.example.user_car.service;

import com.example.user_car.entity.User;

import java.util.List;

public interface UserCarService {
    List<User> getAllUsers();
    User getUserById(Integer id);
    void updateUser(User user);
}
