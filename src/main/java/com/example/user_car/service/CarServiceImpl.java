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
        log.info("List of Cars");
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Integer id) {
        Car car = carRepository.findById(id).orElse(null);
        log.info("Car with id " + id);
        if (car == null) {
            throw  new RuntimeException("No Car with such ID: " + id);
        }
        return car;
    }

    @Override
    public void updateCar(Car car) {
        log.info("Car  " + car + "  Has been Updated" );
        carRepository.save(car);
    }

    @Override
    public Car findByLicplate(String licplate) {
        Car car = carRepository.findByLicplate(licplate);
        log.info("Car with licplate  " + licplate + " Has been found");
        if (car == null){
            throw new RuntimeException("No Car with a licplate: " + licplate);
        }
        return car;
    }
}
