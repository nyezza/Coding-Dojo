package com.nour.dojoandninjafullcrud.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nour.dojoandninjafullcrud.Models.UserModel;
@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
	List<UserModel> findAll();

	Optional<UserModel> findByEmail(String email);
}
