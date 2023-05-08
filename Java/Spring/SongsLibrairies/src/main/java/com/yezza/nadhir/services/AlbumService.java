package com.yezza.nadhir.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yezza.nadhir.models.Album;
import com.yezza.nadhir.repositories.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	//Read All
	public List<Album> findAllAlbum(){
		return albumRepository.findAll();
	}
	
	//Read One
	public Album findOneAlbum(Long id) {
		Optional<Album> oneAlbum = albumRepository.findById(id);
		return oneAlbum.isPresent() ? oneAlbum.get() : null;
	}
	
	// Create Album
	public Album createAlbum(Album album) {
		return albumRepository.save(album);
	}
	
	// update Album
	public Album updateAlbum(Album album) {
		return albumRepository.save(album);
	}
	
	//Delete Album
	public void deletAlbum(Long id) {
		albumRepository.deleteById(id);		
	}
}
