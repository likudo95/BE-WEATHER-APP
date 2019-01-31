package com.phucle.weather.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.phucle.weather.entity.WeatherHistory;
import com.phucle.weather.entity.WeatherResponse;



/**
 * Using to mapping from API object to DB object
 * @author li.kudo
 *
 */
@Mapper(componentModel="spring")
public interface WeatherMapper {
	WeatherMapper MAPPER = Mappers.getMapper(WeatherMapper.class);
	@Mappings({
		@Mapping(target="name", source="name"),
		@Mapping(target="coordLon", source="coord.lon"),
		@Mapping(target="coordLat", source="coord.lat"),
		@Mapping(target="cod", source="cod"),
		@Mapping(target="mainTemp", source="main.temp"),
		@Mapping(target="mainPressure", source="main.pressure"),
		@Mapping(target="mainHumidity", source="main.humidity"),
		@Mapping(target="mainTempMin", source="main.tempMin"),
		@Mapping(target="mainTempMax", source="main.tempMax"),
		@Mapping(target="windSpeed", source="wind.speed"),
		@Mapping(target="windDeg", source="wind.deg"),
		@Mapping(target="dt", source="dt"),
		@Mapping(target="rain1h", source="rain.rain1h"),
		@Mapping(target="rain3h", source="rain.rain3h"),
		@Mapping(target="snow1h", source="snow.snow1h"),
		@Mapping(target="snow3h", source="snow.snow3h")
	})
	WeatherHistory toWeatherHistory(WeatherResponse weatherResponse);
	
	@AfterMapping
    default public void after(@MappingTarget WeatherHistory weatherHistory, WeatherResponse weatherResponse) {
        weatherHistory.setWeatherMain(weatherResponse.getWeather().get(0).getMain());
        weatherHistory.setWeatherIcon(weatherResponse.getWeather().get(0).getIcon());
        weatherHistory.setWeatherDescription(weatherResponse.getWeather().get(0).getDescription());
    }
}
