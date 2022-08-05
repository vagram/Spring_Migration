package com.example.user_car;

import com.example.user_car.entity.Car;
import com.example.user_car.entity.User;
import com.example.user_car.service.UserCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserCarController {
    @Autowired
    private UserCarService userCarService;

    @GetMapping("/")
    public List<User>  findAllBy(){
        return userCarService.getAllUsers();
    }



    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userCarService.getUserById(id);


    }


    @PostMapping("/")
    public User updateUser(@RequestBody User user){
        userCarService.updateUser(user);
        return user;
    }

}
