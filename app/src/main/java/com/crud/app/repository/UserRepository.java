package com.crud.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.crud.app.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

}
