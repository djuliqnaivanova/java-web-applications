package com.weather.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weather.services.contracts.IUserService;
import com.weather.services.contracts.IWeatherForecastService;

@RestController
@RequestMapping("/api")
public class WeatherController {
	private IWeatherForecastService weatherForecastService;
	private IUserService userService;

	@Autowired
	public WeatherController(IWeatherForecastService weatherForecastService, IUserService userService) {
		this.weatherForecastService = weatherForecastService;
		this.userService = userService;
	}

	@RequestMapping(value = "/forecast/{townName}", method = RequestMethod.GET, produces = "application/json")
	public String forecast(@PathVariable(value = "townName") String townName, HttpServletRequest request)
			throws Exception {
		String townForecast = this.weatherForecastService.town(townName);
		
		String userIP =request.getRemoteAddr();
		
		this.userService.saveUserSearchData(userIP, townName);

		return townForecast;
	}
}
