package com.example.user_car;

import com.example.user_car.entity.User;
import com.example.user_car.service.BuyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buy")
@Slf4j
public class BuyController {
    @Autowired
    private BuyService buyService;
    @GetMapping("/{id}/{idCar}")
     public User buyCar(@PathVariable  Integer id, @PathVariable Integer idCar) throws Exception {
        User user = buyService.buyCar(id,idCar);
        if (user == null){
            throw new RuntimeException("The purchase wasn't done!");
        }
        log.info("User with: " + id + "has bought Car with id: " + idCar);
         return  buyService.buyCar(id,idCar);
     }
}
