package com.nadhir.yezza.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nadhir.yezza.models.Show;
@Repository
public interface ShowRepositories extends CrudRepository<Show, Long> {
	List<Show> findAll();
	Optional <Show> findByTitle(String title); 
}
