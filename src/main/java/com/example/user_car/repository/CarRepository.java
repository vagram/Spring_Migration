package com.example.user_car.repository;

import com.example.user_car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Car,Integer> {

    Car findByLicplate(String licplate);
}
