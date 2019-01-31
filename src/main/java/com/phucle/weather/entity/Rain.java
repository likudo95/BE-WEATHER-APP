package com.phucle.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {

	@JsonProperty("1h")
	private int rain1h;

	@JsonProperty("3h")
	private int rain3h;

	public int getRain1h() {
		return rain1h;
	}

	public void setRain1h(int rain1h) {
		this.rain1h = rain1h;
	}

	public int getRain3h() {
		return rain3h;
	}

	public void setRain3h(int rain3h) {
		this.rain3h = rain3h;
	}
}
