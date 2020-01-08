package com.cinema.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinema.entity.Movie;
import com.cinema.service.MovieService;

@Controller
@RequestMapping("/admin/movies")
public class MovieAdminController {

	private MovieService movieService;

	public MovieAdminController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping("/list")
	public String getMoviesList(Model theModel) {
		List<Movie> movies = movieService.findAll();		
		
		theModel.addAttribute("movies", movies);
		
		return "movies/admin/list-movies";
	}
	
	@GetMapping("/showForm")
	public String showForm(Model theModel) {
		Movie movie = new Movie();
		
		theModel.addAttribute("movie", movie);
		
		return "movies/admin/movies-form";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Movie movie = new Movie();
		
		theModel.addAttribute("movie", movie);
		
		return "movies/admin/movies-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("movieId") int theId,
									Model theModel) {
		 
		Movie movie = movieService.findById(theId);
				
		theModel.addAttribute("movie", movie);
		 
		return "movies/admin/movies-form";
	}
	
	
	@PostMapping("/save")
	public String saveMovie(@ModelAttribute("movie") Movie movie) {
				
		movieService.save(movie);
						
		return "redirect:list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("movieId") int theId) {
		
		movieService.deleteById(theId);
		return "redirect:list";
	}
	
}
