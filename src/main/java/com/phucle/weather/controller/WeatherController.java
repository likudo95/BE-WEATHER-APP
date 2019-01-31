package com.phucle.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phucle.weather.entity.WeatherHistory;
import com.phucle.weather.service.impl.WeatherHistoryServiceImpl;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

	@Autowired
	private WeatherHistoryServiceImpl weatherHistoryService;

	@GetMapping("/search")
	public WeatherHistory getWeatherByName(@RequestParam("name") String name) {
		return weatherHistoryService.getWeatherByName(name);
	}

	@GetMapping("/history")
	public Page<WeatherHistory> getPagingWeatherHistory(@RequestParam("name") String name,
			@RequestParam("page") int page, @RequestParam("size") int size) {
		return weatherHistoryService.getWeatherHistory(name, PageRequest.of(page, size, Sort.by("id").descending()));
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteWeather(@RequestParam("id") Long id) {
		weatherHistoryService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
