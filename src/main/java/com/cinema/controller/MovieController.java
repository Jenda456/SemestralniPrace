package com.cinema.controller;

import com.cinema.entity.Movie;
import com.cinema.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

	private MovieService movieService;

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping("/list")
	public String getMoviesList(Model theModel) {
		List<Movie> movies = movieService.findAll();		
		
		theModel.addAttribute("movies", movies);
		
		return "movies/list-movies";
	}

	@GetMapping("/detail/{id}")
	public String getDetail(Model theModel,@PathVariable int id) {
		Movie movie = movieService.findById(id);

		theModel.addAttribute("movie", movie);

		return "movies/movie-detail";
	}
}
