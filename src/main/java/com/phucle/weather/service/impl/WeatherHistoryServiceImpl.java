package com.phucle.weather.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.phucle.weather.dao.WeatherHistoryDAO;
import com.phucle.weather.entity.WeatherHistory;
import com.phucle.weather.entity.WeatherResponse;
import com.phucle.weather.mapper.WeatherMapper;
import com.phucle.weather.service.WeatherHistoryService;

@Service
public class WeatherHistoryServiceImpl implements WeatherHistoryService {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WeatherHistoryDAO weatherHistoryDAO;

	@Value("${api.appid}")
	private String appid;
	
	@Value("${api.url}")
	private String url;

	@Override
	@Transactional
	public WeatherHistory getWeatherByName(String name) {
		//Call api to retrieve data
		WeatherResponse weatherResponse = restTemplate.getForObject(String.format(url, name, appid),
				WeatherResponse.class);
		//Mapping from api object to db object
		WeatherHistory history = WeatherMapper.MAPPER.toWeatherHistory(weatherResponse);
		return weatherHistoryDAO.save(history);
	}

	@Override
	public Page<WeatherHistory> getWeatherHistory(String name, Pageable pageable) {
		//Get Paging data with 5 items per page
		return weatherHistoryDAO.findByNameIgnoreCase(name, pageable);
	}
	
	@Override
	public void deleteById(Long id) {
		weatherHistoryDAO.deleteById(id);
	}
}
