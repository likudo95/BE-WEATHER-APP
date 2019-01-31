package com.phucle.weather.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "1h", "3h" })
public class Snow {

	@JsonProperty("1h")
	private int snow1h;

	@JsonProperty("3h")
	private int snow3h;

	public int getSnow1h() {
		return snow1h;
	}

	public void setSnow1h(int snow1h) {
		this.snow1h = snow1h;
	}

	public int getSnow3h() {
		return snow3h;
	}

	public void setSnow3h(int snow3h) {
		this.snow3h = snow3h;
	}

}
