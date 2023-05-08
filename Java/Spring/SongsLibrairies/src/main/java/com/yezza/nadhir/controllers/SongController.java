package com.yezza.nadhir.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.yezza.nadhir.models.Album;
import com.yezza.nadhir.models.Song;
import com.yezza.nadhir.services.AlbumService;
import com.yezza.nadhir.services.SongService;

@Controller
public class SongController {
	@Autowired
	private SongService songService;
	
	@Autowired
	private AlbumService albumSerice;

	@GetMapping("/songs")
	public String index(Model model) {
		List<Song> allSongs = songService.readAllSongs();
		model.addAttribute("song", allSongs);
		return "SongFile/allSongs.jsp";
	}
	@GetMapping("/songs/new")
	public String createSong(@ModelAttribute("song") Song song,Model model) {
		List<Album> allAlbum = albumSerice.findAllAlbum();
		model.addAttribute("allAlbums", allAlbum);
		return "SongFile/createSong.jsp";
		
	}
}
