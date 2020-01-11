package com.cinema.dao;

import com.cinema.entity.Movie;
import com.cinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findAll();

	@Query("SELECT u.email FROM User u where u.email = :email")
	String findEmail(@Param("email") String email);
}
