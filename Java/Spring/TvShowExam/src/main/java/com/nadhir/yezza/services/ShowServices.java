package com.nadhir.yezza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadhir.yezza.models.Show;
import com.nadhir.yezza.repositories.ShowRepositories;
@Service
public class ShowServices {

	@Autowired
	private ShowRepositories showRepo;
	
	// All Show
	public List<Show> findAllShow(){
		return showRepo.findAll();
	}
	
	// One Show
	public Show findShow(Long id) {
		Optional<Show> oneShow = showRepo.findById(id);
		return (oneShow.isPresent())? oneShow.get():null;
	}
	
	// create Show
	public Show createShow(Show s) {
		return showRepo.save(s);
	}
	
	// update Show
		public Show updateeShow(Show s) {
			return showRepo.save(s);
	}
		
	// Delete Show
		public void deletShow(Long id) {
			showRepo.deleteById(id);
		}
	
	
}
