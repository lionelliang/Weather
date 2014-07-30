package fr.utt.helloandroid;

import java.util.ArrayList;

public class Data {

	private Coord coord;
	private Sys sys;
	private ArrayList<Weather> weather = new ArrayList<Weather>();
	private String base;
	private Main main;
	private Wind wind;
	private Clouds clouds;
	private long dt;
	private long id;
	private String name;
	private int cod;

	public Data(double lon, double lat, double message, String country,
			long sunrise, long sunset, int id, String main, String description,
			String icon, String base, double temp, int humidity,
			double pressure, double temp_min, double temp_max, double speed,
			double guest, double deg, int all, long dt, long id_m, String name,
			int cod) {
		super();
		// TODO Auto-generated constructor stub
		this.coord = new Coord(lon, lat);
		this.sys = new Sys(message, country, sunrise, sunset);
		this.weather.add(new Weather(id, main, description, icon));
		this.base = base;
		this.main = new Main(temp, humidity, pressure, temp_min, temp_max);
		this.wind = new Wind(speed, guest, deg);
		this.clouds = new Clouds(all);
		this.dt = dt;
		this.id = id_m;
		this.name = name;
		this.cod = cod;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public ArrayList<Weather> getWeather() {
		return weather;
	}

	public void setWeather(ArrayList<Weather> weather) {
		this.weather = weather;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public void getInfomation() {
		System.out.println(coord.getLat());
		System.out.println(weather.get(0).getId());
	}

	class Coord {

		private double lon;
		private double lat;

		public Coord(double lon, double lat) {
			super();
			// TODO Auto-generated constructor stub
			this.lon = lon;
			this.lat = lat;
		}

		public double getLon() {
			return lon;
		}

		public void setLon(float lon) {
			this.lon = lon;
		}

		public double getLat() {
			return lat;
		}

		public void setLat(float lat) {
			this.lat = lat;
		}

	}

	class Sys {

		private double message;
		private String country;
		private long sunrise;
		private long sunset;

		public Sys(double message, String country, long sunrise, long sunset) {
			super();
			this.message = message;
			this.country = country;
			this.sunrise = sunrise;
			this.sunset = sunset;
		}

		public double getMessage() {
			return message;
		}

		public void setMessage(double message) {
			this.message = message;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public long getSunrise() {
			return sunrise;
		}

		public void setSunrise(long sunrise) {
			this.sunrise = sunrise;
		}

		public long getSunset() {
			return sunset;
		}

		public void setSunset(long sunset) {
			this.sunset = sunset;
		}
	}

	class Weather {

		private int id;
		private String main;
		private String description;
		private String icon;

		public Weather(int id, String main, String description, String icon) {
			super();
			this.id = id;
			this.main = main;
			this.description = description;
			this.icon = icon;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getMain() {
			return main;
		}

		public void setMain(String main) {
			this.main = main;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

	}

	class Main {

		private double temp;
		private int humidity;
		private double pressure;
		private double temp_min;
		private double temp_max;

		public Main(double temp, int humidity, double pressure,
				double temp_min, double temp_max) {
			super();
			this.temp = temp;
			this.humidity = humidity;
			this.pressure = pressure;
			this.temp_min = temp_min;
			this.temp_max = temp_max;
		}

		public double getTemp() {
			return temp;
		}

		public void setTemp(double temp) {
			this.temp = temp;
		}

		public int getHumidity() {
			return humidity;
		}

		public void setHumidity(int humidity) {
			this.humidity = humidity;
		}

		public double getPressure() {
			return pressure;
		}

		public void setPressure(double pressure) {
			this.pressure = pressure;
		}

		public double getTemp_min() {
			return temp_min;
		}

		public void setTemp_min(double temp_min) {
			this.temp_min = temp_min;
		}

		public double getTemp_max() {
			return temp_max;
		}

		public void setTemp_max(double temp_max) {
			this.temp_max = temp_max;
		}

	}

	class Wind {

		private double speed;
		private double guest;
		private double deg;

		public Wind(double speed, double guest, double deg) {
			super();
			this.speed = speed;
			this.guest = guest;
			this.deg = deg;
		}

		public double getSpeed() {
			return speed;
		}

		public void setSpeed(double speed) {
			this.speed = speed;
		}

		public double getGuest() {
			return guest;
		}

		public void setGuest(double guest) {
			this.guest = guest;
		}

		public double getDeg() {
			return deg;
		}

		public void setDeg(double deg) {
			this.deg = deg;
		}

	}

	class Clouds {
		private int all;

		public Clouds(int all) {
			super();
			this.all = all;
		}

		public int getAll() {
			return all;
		}

		public void setAll(int all) {
			this.all = all;
		}

	}
	
}
