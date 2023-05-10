package com.yezza.nadhir.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yezza.nadhir.models.Dojo;
import com.yezza.nadhir.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepo;
	
	// Read All
	public List<Dojo> allDojo(){
		return dojoRepo.findAll();
	}
	
	// Read One
	public Dojo oneDojo(Long id){
		Optional<Dojo> oneDojo = dojoRepo.findById(id);
		if (oneDojo.isPresent()) {
			return oneDojo.get();
		} else {
			return null;
		}
		}
	// create one
	public Dojo createOneDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	// update one
	public Dojo updateDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	// Delete One
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
}
