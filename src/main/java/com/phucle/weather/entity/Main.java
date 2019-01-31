package com.phucle.weather.entity;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "temp", "pressure", "humidity", "temp_min", "temp_max" })
public class Main {

	@JsonProperty("temp")
	private double temp;
	@JsonProperty("pressure")
	private int pressure;
	@JsonProperty("humidity")
	private int humidity;
	@JsonProperty("temp_min")
	private int tempMin;
	@JsonProperty("temp_max")
	private int tempMax;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("temp")
	public double getTemp() {
		return temp;
	}

	@JsonProperty("temp")
	public void setTemp(double temp) {
		this.temp = temp;
	}

	@JsonProperty("pressure")
	public int getPressure() {
		return pressure;
	}

	@JsonProperty("pressure")
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	@JsonProperty("humidity")
	public int getHumidity() {
		return humidity;
	}

	@JsonProperty("humidity")
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	@JsonProperty("temp_min")
	public int getTempMin() {
		return tempMin;
	}

	@JsonProperty("temp_min")
	public void setTempMin(int tempMin) {
		this.tempMin = tempMin;
	}

	@JsonProperty("temp_max")
	public int getTempMax() {
		return tempMax;
	}

	@JsonProperty("temp_max")
	public void setTempMax(int tempMax) {
		this.tempMax = tempMax;
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