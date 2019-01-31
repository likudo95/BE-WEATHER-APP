package com.phucle.weather.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.phucle.weather.dao.WeatherHistoryDAO;
import com.phucle.weather.entity.Weather;
import com.phucle.weather.entity.WeatherHistory;
import com.phucle.weather.entity.WeatherResponse;
import com.phucle.weather.mapper.WeatherMapper;
import com.phucle.weather.service.impl.WeatherHistoryServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherHistoryServiceTest {

	@Mock
	WeatherHistoryDAO weatherHistoryDAO;

	@Mock
	RestTemplate rest;
	
	@MockBean
	@Autowired
	WeatherMapper weatherMapper;

	@InjectMocks
	WeatherHistoryServiceImpl weatherHistoryService;

	@Before
	public void setUp() {
		ReflectionTestUtils.setField(weatherHistoryService, "appid", "b6907d289e10d714a6e88b30761fae22");
		ReflectionTestUtils.setField(weatherHistoryService, "url",
				"https://openweathermap.org/data/2.5/weather?q=%s&unit=metrics&appid=%s");
	}

	@Test
	public void testGetByName() {
		List<Weather> weathers = new ArrayList<>();
		weathers.add(new Weather());
		WeatherHistory rs = new WeatherHistory();
		WeatherResponse response = new WeatherResponse();
		response.setWeather(weathers);
		when(weatherHistoryDAO.save(any(WeatherHistory.class))).thenReturn(rs);
		when(rest.getForObject(String.format("https://openweathermap.org/data/2.5/weather?q=%s&unit=metrics&appid=%s",
				"Singapore", "b6907d289e10d714a6e88b30761fae22"), WeatherResponse.class))
						.thenReturn(response);
		when(weatherMapper.toWeatherHistory(any(WeatherResponse.class))).thenReturn(rs);
		assertTrue("Test getByName Success", rs.equals(weatherHistoryService.getWeatherByName("Singapore")));
	}
	
	@Test(expected = Exception.class)
	public void testGetByNameFail() {
		when(rest.getForObject(String.format("https://openweathermap.org/data/2.5/weather?q=%s&unit=metrics&appid=%s",
				"Singapore", "b6907d289e10d714a6e88b30761fae22"), WeatherResponse.class))
						.thenThrow(Exception.class);
		weatherHistoryService.getWeatherByName("Singapore");
	}
	
	@Test(expected = Exception.class)
	public void testGetByNameSaveException() {
		when(weatherHistoryDAO.save(any(WeatherHistory.class))).thenThrow(Exception.class);
		weatherHistoryService.getWeatherByName("Singapore");
	}
	
	@Test
	public void getHistory() {
		List<WeatherHistory> data = new ArrayList<>();
		data.add(new WeatherHistory());
		data.add(new WeatherHistory());
		Pageable pageable = PageRequest.of(0, 5, Sort.by("id").descending());
		when(weatherHistoryDAO.findByNameIgnoreCase("Singapore", pageable)).thenReturn(new PageImpl<>(data));
		assertTrue("Test getHistory success", data.size() == weatherHistoryService.getWeatherHistory("Singapore", pageable).getContent().size());
	}
	
	@Test(expected = Exception.class)
	public void getHistoryThrowException() {
		List<WeatherHistory> data = new ArrayList<>();
		data.add(new WeatherHistory());
		data.add(new WeatherHistory());
		Pageable pageable = PageRequest.of(0, 5, Sort.by("id").descending());
		when(weatherHistoryDAO.findByNameIgnoreCase("Singapore", pageable)).thenThrow(Exception.class);
		assertTrue("Test getHistory success", data.size() == weatherHistoryService.getWeatherHistory("Singapore", pageable).getContent().size());
	}

	
	
}
