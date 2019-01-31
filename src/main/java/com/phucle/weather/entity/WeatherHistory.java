package com.phucle.weather.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "weather_history", catalog = "weather")
public class WeatherHistory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7252444606822337966L;
	private Long id;
	private String name;
	private int cod;
	private double coordLon;
	private double coordLat;
	private double mainTemp;
	private int mainPressure;
	private int mainHumidity;
	private int mainTempMin;
	private int mainTempMax;
	private double windSpeed;
	private int windDeg;
	private Date dt;
	private String weatherMain;
	private String weatherDescription;
	private String weatherIcon;
	private Integer rain1h;
	private Integer rain3h;
	private Integer snow1h;
	private Integer snow3h;

	public WeatherHistory() {
	}

	public WeatherHistory(String name, int cod, double coordLon, double coordLat, double mainTemp, int mainPressure,
			int mainHumidity, int mainTempMin, int mainTempMax, double windSpeed, int windDeg, Date dt,
			String weatherMain, String weatherDescription, String weatherIcon) {
		this.name = name;
		this.cod = cod;
		this.coordLon = coordLon;
		this.coordLat = coordLat;
		this.mainTemp = mainTemp;
		this.mainPressure = mainPressure;
		this.mainHumidity = mainHumidity;
		this.mainTempMin = mainTempMin;
		this.mainTempMax = mainTempMax;
		this.windSpeed = windSpeed;
		this.windDeg = windDeg;
		this.dt = dt;
		this.weatherMain = weatherMain;
		this.weatherDescription = weatherDescription;
		this.weatherIcon = weatherIcon;
	}

	public WeatherHistory(String name, int cod, double coordLon, double coordLat, double mainTemp, int mainPressure,
			int mainHumidity, int mainTempMin, int mainTempMax, double windSpeed, int windDeg, Date dt,
			String weatherMain, String weatherDescription, String weatherIcon, Integer rain1h, Integer rain3h,
			Integer snow1h, Integer snow3h) {
		this.name = name;
		this.cod = cod;
		this.coordLon = coordLon;
		this.coordLat = coordLat;
		this.mainTemp = mainTemp;
		this.mainPressure = mainPressure;
		this.mainHumidity = mainHumidity;
		this.mainTempMin = mainTempMin;
		this.mainTempMax = mainTempMax;
		this.windSpeed = windSpeed;
		this.windDeg = windDeg;
		this.dt = dt;
		this.weatherMain = weatherMain;
		this.weatherDescription = weatherDescription;
		this.weatherIcon = weatherIcon;
		this.rain1h = rain1h;
		this.rain3h = rain3h;
		this.snow1h = snow1h;
		this.snow3h = snow3h;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "cod", nullable = false)
	public int getCod() {
		return this.cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	@Column(name = "coord_lon", nullable = false, precision = 22, scale = 0)
	public double getCoordLon() {
		return this.coordLon;
	}

	public void setCoordLon(double coordLon) {
		this.coordLon = coordLon;
	}

	@Column(name = "coord_lat", nullable = false, precision = 22, scale = 0)
	public double getCoordLat() {
		return this.coordLat;
	}

	public void setCoordLat(double coordLat) {
		this.coordLat = coordLat;
	}

	@Column(name = "main_temp", nullable = false, precision = 22, scale = 0)
	public double getMainTemp() {
		return this.mainTemp;
	}

	public void setMainTemp(double mainTemp) {
		this.mainTemp = mainTemp;
	}

	@Column(name = "main_pressure", nullable = false)
	public int getMainPressure() {
		return this.mainPressure;
	}

	public void setMainPressure(int mainPressure) {
		this.mainPressure = mainPressure;
	}

	@Column(name = "main_humidity", nullable = false)
	public int getMainHumidity() {
		return this.mainHumidity;
	}

	public void setMainHumidity(int mainHumidity) {
		this.mainHumidity = mainHumidity;
	}

	@Column(name = "main_temp_min", nullable = false)
	public int getMainTempMin() {
		return this.mainTempMin;
	}

	public void setMainTempMin(int mainTempMin) {
		this.mainTempMin = mainTempMin;
	}

	@Column(name = "main_temp_max", nullable = false)
	public int getMainTempMax() {
		return this.mainTempMax;
	}

	public void setMainTempMax(int mainTempMax) {
		this.mainTempMax = mainTempMax;
	}

	@Column(name = "wind_speed", nullable = false, precision = 22, scale = 0)
	public double getWindSpeed() {
		return this.windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	@Column(name = "wind_deg", nullable = false)
	public int getWindDeg() {
		return this.windDeg;
	}

	public void setWindDeg(int windDeg) {
		this.windDeg = windDeg;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt", nullable = false, length = 19)
	public Date getDt() {
		return this.dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	@Column(name = "weather_main", nullable = false, length = 45)
	public String getWeatherMain() {
		return this.weatherMain;
	}

	public void setWeatherMain(String weatherMain) {
		this.weatherMain = weatherMain;
	}

	@Column(name = "weather_description", nullable = false, length = 45)
	public String getWeatherDescription() {
		return this.weatherDescription;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	@Column(name = "weather_icon", nullable = false, length = 45)
	public String getWeatherIcon() {
		return this.weatherIcon;
	}

	public void setWeatherIcon(String weatherIcon) {
		this.weatherIcon = weatherIcon;
	}

	@Column(name = "rain1h")
	public Integer getRain1h() {
		return this.rain1h;
	}

	public void setRain1h(Integer rain1h) {
		this.rain1h = rain1h;
	}

	@Column(name = "rain3h")
	public Integer getRain3h() {
		return this.rain3h;
	}

	public void setRain3h(Integer rain3h) {
		this.rain3h = rain3h;
	}

	@Column(name = "snow1h")
	public Integer getSnow1h() {
		return this.snow1h;
	}

	public void setSnow1h(Integer snow1h) {
		this.snow1h = snow1h;
	}

	@Column(name = "snow3h")
	public Integer getSnow3h() {
		return this.snow3h;
	}

	public void setSnow3h(Integer snow3h) {
		this.snow3h = snow3h;
	}
}
