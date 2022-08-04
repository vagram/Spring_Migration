package com.example.user_car.service;

import com.example.user_car.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();
    Car getCarById(Integer id);
    void updateCar(Car car);

    Car findByLicplate(String licplate);

}
