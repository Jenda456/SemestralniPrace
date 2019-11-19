package com.cinema.service;

import java.util.List;

import com.cinema.entity.Movie;


public interface MovieService {

	public List<Movie> findAll();
	
	public Movie findById(int theId);
	
	public void save(Movie theEmployee);
	
	public void deleteById(int theId);
	
}
