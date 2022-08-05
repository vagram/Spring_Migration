package com.example.user_car.service;

import com.example.user_car.entity.Car;
import com.example.user_car.entity.User;
import com.example.user_car.repository.CarRepository;
import com.example.user_car.repository.UserRepository;
import com.zaxxer.hikari.util.SuspendResumeLock;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.PrinterAbortException;
import java.util.List;

@Service
@Slf4j
public class UserCarServiceImpl implements UserCarService{

    @Autowired
    UserRepository userRepository;
    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll();
        log.info("In method getAllUsers found " +userList.size() + " users");
        return userList;
    }


    @Override
    @Transactional
    public User getUserById(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            log.warn("No User with such ID: " + id);
            throw new RuntimeException("No User with such ID: " + id);
        }
        log.info("User " + user + " with id  " + id + " found");
        return user;
    }

    @Override
    @Transactional
    public void updateUser(User user){
        userRepository.save(user);
        log.info("User " + user + "  Has been Saved");
    }

}
