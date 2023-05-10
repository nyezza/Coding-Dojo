package com.yezza.nadhir.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yezza.nadhir.models.Travel;
import com.yezza.nadhir.repositories.ExpensRepository;

@Service
public class TravelService {
	@Autowired
	private ExpensRepository expensRepo;
	
	// Find All
	public List<Travel> findAllTravel() {
		//return expensRepo.findAll();
		return expensRepo.findAll();
	}
	
	// Find One
	public Travel findTravelById(Long id) {
		Optional<Travel> travelById = expensRepo.findById(id); 
		return travelById.isPresent() ? travelById.get(): null;
	}
	
	//Create
	public Travel createTravel(Travel travel) {
		return expensRepo.save(travel);
	}
	
	//update
	public Travel updateTravel(Travel travel) {
		return expensRepo.save(travel);
	}
	
	//delete
	public void deleteTravel(Long id) {
		expensRepo.deleteById(id);
	}
}
