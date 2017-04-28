package com.weather.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.weather.services.contracts.IWeatherForecastService;
@Service
public class WeatherForecastService implements IWeatherForecastService {
	private final String USER_AGENT = "Mozilla/5.0";
	private final String BASE_URL = "https://api.apixu.com/v1/current.json?key=3afaa84905474db383b131819172804&q=";
	
	@Override
	public String town(String townName) throws Exception{
		String url = this.BASE_URL + townName;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		return response.toString();
	}
}
