package com.yezza.nadhir.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.yezza.nadhir.models.Car;
import com.yezza.nadhir.repositories.CarRepository;

public class CarService {
	@Autowired
	private CarRepository carRepo;
	
	
	public List<Car> findAllCars(){
		return carRepo.findAll();
	}
	 public Car findCarById(Long id) {
		 Optional<Car> oneCar = carRepo.findById(id);
		 return (oneCar.isPresent()) ? oneCar.get() : null;
	 }
	 
	 public Car SaveCar(Car c) {
		 return carRepo.save(c);
	 }
	 
	 public Car update (Car c) {
		 return carRepo.save(c);
	 }
	 
	 public void deleteCar(Long id) {
		 carRepo.deleteById(id);
	 }
}
