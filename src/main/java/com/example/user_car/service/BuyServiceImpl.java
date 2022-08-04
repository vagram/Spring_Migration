package com.example.user_car.service;

import com.example.user_car.entity.Car;
import com.example.user_car.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyServiceImpl implements BuyService{
    @Autowired
    CarService carService;
    @Autowired
    UserCarService userCarService;
    @Override
    public User buyCar(Integer id, Integer idCar) {
        User user1 = userCarService.getUserById(id);
        log.info("Get User By Id  " + user1.getId());

        User user = userCarService.getUserById(id);
        Car car1 = carService.getCarById(idCar);
        log.info("Get Car By Id  " + car1.getId());
        Car car = carService.getCarById(idCar);
        if (user == null) {
            log.warn("No such a User!");
            return null;
        }


        if (car == null){
            log.warn("No such a Car!");
            return null;
        }
        if (user.getLicplate()!=null){
            log.warn("This licplate own user with id " + id);
            return null;
        }
        if (car.getOwner().equals("Own")){
            log.warn("This car already has an Owner!");
            return null;
        }
        if (user.getBuy() < car.getPrice()){
            log.warn("You don't have enough money!");
            return null;
        }
        user.setLicplate(car.getLicplate());
        car.setOwner("Own");
        userCarService.updateUser(user);
        carService.updateCar(car);
        log.warn("User with a " + id + " has bought a Car with id " + idCar );
        return user;
    }
}
