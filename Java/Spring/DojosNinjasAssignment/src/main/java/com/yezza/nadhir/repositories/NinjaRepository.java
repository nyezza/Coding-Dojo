package com.yezza.nadhir.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yezza.nadhir.models.Ninja;
@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
	List<Ninja> findAll();
}
