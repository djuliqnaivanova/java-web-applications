package com.weather.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weather.services.contracts.IWeatherForecastService;

@RestController
@RequestMapping("/api")
public class WeatherController {
	private IWeatherForecastService weatherForecastService;

	@Autowired
	public WeatherController(IWeatherForecastService service) {
		this.weatherForecastService = service;
	}

	@RequestMapping(value = "/forecast/{townName}", method = RequestMethod.GET)
	public String forecast(@PathVariable(value = "townName") String townName, HttpServletRequest request)
			throws Exception {
		String townForecast = this.weatherForecastService.town(townName);

		return townForecast;
	}
}
