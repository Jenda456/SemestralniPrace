package com.cinema.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.entity.Movie;


public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	List<Movie> findAll();
	
}
