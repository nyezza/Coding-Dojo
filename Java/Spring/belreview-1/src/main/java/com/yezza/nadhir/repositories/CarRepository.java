package com.yezza.nadhir.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yezza.nadhir.models.Car;

public interface CarRepository extends CrudRepository<Car, Long> {
		List<Car> findAll();
}
