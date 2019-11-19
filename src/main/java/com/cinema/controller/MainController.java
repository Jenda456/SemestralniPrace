package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/hello")
	public String sayHello(Model theModel) {
		
		theModel.addAttribute("theDate", new java.util.Date());
		System.out.println("fefe");
		return "helloworld";
	}
}
