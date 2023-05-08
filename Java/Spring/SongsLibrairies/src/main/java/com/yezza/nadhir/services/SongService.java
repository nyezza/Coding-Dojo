package com.yezza.nadhir.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yezza.nadhir.models.Song;
import com.yezza.nadhir.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository songRepo;
	
	//CRUD
	
	//Read All
	public List<Song> readAllSongs(){
		return songRepo.findAll();
	}
	
	//Read One Song
	public Song readOneSong(Long id) {
		Optional<Song> oneSong = songRepo.findById(id);
		return oneSong.isPresent() ? oneSong.get() : null;
	}
	
	//Create one Song
	public Song createSong(Song song) {
		return songRepo.save(song);
	}
	
	//Update Song
	public Song updateSong(Song song) {
		return songRepo.save(song);
	}
	
	//Delete One Song
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
}
