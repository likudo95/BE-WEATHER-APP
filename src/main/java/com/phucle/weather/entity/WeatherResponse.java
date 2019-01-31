package com.phucle.weather.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.phucle.weather.configuration.UnixTimestampDeserializer;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "coord", "weather", "base", "main", "visibility", "wind", "clouds","rain", "snow","dt", "sys", "id", "name",
		"cod" })
public class WeatherResponse {

	@JsonProperty("coord")
	private Coord coord;
	@JsonProperty("weather")
	private List<Weather> weather = null;
	@JsonProperty("base")
	private String base;
	@JsonProperty("main")
	private Main main;
	@JsonProperty("visibility")
	private int visibility;
	@JsonProperty("wind")
	private Wind wind;
	@JsonProperty("clouds")
	private Clouds clouds;
	@JsonProperty("rain")
	private Rain rain;
	@JsonProperty("snow")
	private Snow snow;
	@JsonProperty("dt")
	@JsonDeserialize(using = UnixTimestampDeserializer.class)
	private Date dt;
	@JsonProperty("sys")
	private Sys sys;
	@JsonProperty("id")
	private int id_location;
	@JsonProperty("name")
	private String name;
	@JsonProperty("cod")
	private int cod;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("coord")
	public Coord getCoord() {
		return coord;
	}

	@JsonProperty("coord")
	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	@JsonProperty("weather")
	public List<Weather> getWeather() {
		return weather;
	}

	@JsonProperty("weather")
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	@JsonProperty("base")
	public String getBase() {
		return base;
	}

	@JsonProperty("base")
	public void setBase(String base) {
		this.base = base;
	}

	@JsonProperty("main")
	public Main getMain() {
		return main;
	}

	@JsonProperty("main")
	public void setMain(Main main) {
		this.main = main;
	}

	@JsonProperty("visibility")
	public int getVisibility() {
		return visibility;
	}

	@JsonProperty("visibility")
	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	@JsonProperty("wind")
	public Wind getWind() {
		return wind;
	}

	@JsonProperty("wind")
	public void setWind(Wind wind) {
		this.wind = wind;
	}

	@JsonProperty("clouds")
	public Clouds getClouds() {
		return clouds;
	}

	@JsonProperty("clouds")
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	@JsonProperty("dt")
	public Date getDt() {
		return dt;
	}

	@JsonProperty("dt")
	public void setDt(Date dt) {
		this.dt = dt;
	}

	@JsonProperty("sys")
	public Sys getSys() {
		return sys;
	}

	@JsonProperty("sys")
	public void setSys(Sys sys) {
		this.sys = sys;
	}

	@JsonProperty("id")
	public int getIdLocation() {
		return id_location;
	}

	@JsonProperty("id")
	public void setIdLocation(int id_location) {
		this.id_location = id_location;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("cod")
	public int getCod() {
		return cod;
	}

	@JsonProperty("cod")
	public void setCod(int cod) {
		this.cod = cod;
	}

	@JsonProperty("rain")
	public Rain getRain() {
		return rain;
	}

	@JsonProperty("rain")
	public void setRain(Rain rain) {
		this.rain = rain;
	}

	@JsonProperty("snow")
	public Snow getSnow() {
		return snow;
	}

	@JsonProperty("snow")
	public void setSnow(Snow snow) {
		this.snow = snow;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}