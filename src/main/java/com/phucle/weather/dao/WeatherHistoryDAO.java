package com.phucle.weather.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.phucle.weather.entity.WeatherHistory;

public interface WeatherHistoryDAO extends JpaRepository<WeatherHistory, Long> {

	Page<WeatherHistory> findByNameIgnoreCase(String name, Pageable pageable);
	
}
