package com.yezza.nadhir.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yezza.nadhir.models.Ninja;
import com.yezza.nadhir.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	// Read All
	public List<Ninja> findAllNinja(){
		return ninjaRepo.findAll();
	}
	
	// read One
	public Ninja findNinjaById(Long id) {
		Optional<Ninja> oneNinja = ninjaRepo.findById(id);
		if (oneNinja.isPresent()) {
			return oneNinja.get();
		} else {
			return null;
		}
	}
	
	// Create One
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	//Update One
	public Ninja updateNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	//Delete One
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
