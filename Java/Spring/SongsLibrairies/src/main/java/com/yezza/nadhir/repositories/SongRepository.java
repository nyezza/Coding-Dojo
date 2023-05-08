package com.yezza.nadhir.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yezza.nadhir.models.Song;


@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	
	List<Song> findAll();
}
