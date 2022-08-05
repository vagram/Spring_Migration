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

        User user = userCarService.getUserById(id);
        Car car = carService.getCarById(idCar);

        if (user == null) {
            log.warn("No such a User with id : " + id);
            throw new RuntimeException("No such a User with id : " + id);
        }

        if (car == null){
            log.warn("No such a Car with id: " + idCar);
            throw new RuntimeException("No such car with id: " + idCar);
        }


        if (user.getLicplate()!=null){
            log.warn("This licplate own user with id " + id);
            throw new RuntimeException("This licplate own user with id " + id);
        }

        if (car.getOwner().equals("Own")){
            log.warn("This car : " + car + " already has an Owner!");
            throw new RuntimeException("This car already has an Owner!" + idCar);

        }

        if (user.getBuy() < car.getPrice()){
            log.warn("User with id: " + id + " don't have enough money!" +
                    "balance is: " + user.getBuy() + "Car price is: " + car.getPrice());
            throw new RuntimeException("You don't have enough money" );
        }

        user.setLicplate(car.getLicplate());
        car.setOwner("Own");
        userCarService.updateUser(user);
        carService.updateCar(car);
        log.info("User with a " + id + " has bought a Car with id " + idCar );
        return user;
    }
}
