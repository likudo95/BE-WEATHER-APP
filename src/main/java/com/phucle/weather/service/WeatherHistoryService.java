package com.phucle.weather.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.phucle.weather.entity.WeatherHistory;

public interface WeatherHistoryService {
	public WeatherHistory getWeatherByName(String name);
	
	public Page<WeatherHistory> getWeatherHistory(String name, Pageable pageable);
	
	public void deleteById(Long id);
}
