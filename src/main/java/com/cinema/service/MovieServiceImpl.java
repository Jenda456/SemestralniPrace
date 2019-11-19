package com.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.dao.MovieRepository;
import com.cinema.entity.Movie;


@Service
public class MovieServiceImpl implements MovieService {

	private MovieRepository movieRepository;
	
	@Autowired
	public MovieServiceImpl(MovieRepository theMovieRepository) {
		movieRepository = theMovieRepository;
	}
	
	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public Movie findById(int theId) {
		Optional<Movie> result = movieRepository.findById(theId);
		
		Movie theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Movie theMovie) {
		movieRepository.save(theMovie);
	}

	@Override
	public void deleteById(int theId) {
		movieRepository.deleteById(theId);
	}

}






