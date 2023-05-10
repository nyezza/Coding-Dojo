package com.yezza.nadhir.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yezza.nadhir.models.Travel;
@Repository
public interface ExpensRepository extends CrudRepository<Travel, Long> {
	
	List<Travel> findAll();

}
