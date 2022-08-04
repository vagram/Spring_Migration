package com.example.user_car;


import com.example.user_car.entity.Car;
import com.example.user_car.entity.User;
import com.example.user_car.service.CarService;
import com.example.user_car.service.UserCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/")
    public List<Car> findAllBy(){
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Integer id){
        return carService.getCarById(id);
    }

    @PostMapping("/")
    public Car updateCar(@RequestBody Car car){
        carService.updateCar(car);
        return car;
    }
}
