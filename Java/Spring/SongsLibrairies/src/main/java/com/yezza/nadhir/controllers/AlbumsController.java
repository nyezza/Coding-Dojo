package com.yezza.nadhir.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.yezza.nadhir.models.Album;
import com.yezza.nadhir.services.AlbumService;

import jakarta.validation.Valid;

@Controller
public class AlbumsController {

	@Autowired
	private AlbumService albumService;
	
	//Read All
	@GetMapping("/")
	public String index(Model model) {
		List<Album> allAlbum = albumService.findAllAlbum();
		model.addAttribute("album", allAlbum);
		return "AlbumFile/Allalbums.jsp";
	}
	
	// create Album
	@GetMapping("/album/new")
	public String newAlbum(@ModelAttribute("album")Album album) {
		return "AlbumFile/newAlbum.jsp";
	}
	
	// create and save album
	
	@PostMapping("/")
	public String processAlbum(@Valid @ModelAttribute("album") Album album,BindingResult result) {
		if(result.hasErrors()) {
			return "AlbumFile/newalbum.jsp";
		}
		else {
			albumService.createAlbum(album);
		}
		return "redirect:/";
	}
	@GetMapping("/album/{id}")
	public String viewAlbum(@PathVariable("id")Long id,Model model) {
		model.addAttribute("oneAlbum", albumService.findOneAlbum(id));
		return "AlbumFile/showOne.jsp";
	}
	
	//@PutMapping("/album/edit/{id}")
	
	@DeleteMapping("/album/{id}")
	public void deleteById(@PathVariable("id")Long id) {
		albumService.deletAlbum(id);
	}
}
