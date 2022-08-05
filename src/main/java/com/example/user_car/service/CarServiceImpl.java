package com.example.user_car.service;

import com.example.user_car.entity.Car;
import com.example.user_car.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class CarServiceImpl implements CarService{
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAll() {
        List<Car> carList = carRepository.findAll();
        log.info("in method getAll() find " + carList.size() + " number of cars");
        return carList;
    }

    @Override
    public Car getCarById(Integer id) {
        Car car = carRepository.findById(id).orElse(null);
        if (car == null) {
            log.warn("Car with id " + id + " hasn't been found");
            throw  new RuntimeException("No Car with such ID: " + id);
        }
        log.info("In method getCarById car " + car + " with id " + id + " has been found");
        return car;
    }

    @Override
    public void updateCar(Car car) {
        carRepository.save(car);
        log.info("Car  " + car + "  Has been Updated" );
    }

    @Override
    public Car findByLicplate(String licplate) {
        Car car = carRepository.findByLicplate(licplate);
        if (car == null){
            log.warn("The car with licplate" + licplate + "hasn't been found");
            throw new RuntimeException("No Car with a licplate: " + licplate);
        }
        log.info("Car " + car + " with licplate  " + licplate + " Has been found");
        return car;
    }
}
