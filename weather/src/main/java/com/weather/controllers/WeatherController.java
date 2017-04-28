package com.weather.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WeatherController {

	@RequestMapping("/forecast")
	public String Forecast(){
		return "It Works!";
	}
}
