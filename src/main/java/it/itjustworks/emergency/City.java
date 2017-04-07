package it.itjustworks.emergency;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class City implements Requestable {

	private String url;
	
	public City() {
		this.url = null;
	}
	
	public City withLatitudeAndLongitude(String latitude, String longitude) {
		return new City(latitude, longitude);
	}
	
	private City(String latitude, String longitude) {
		this.url = "/api/v2/city/"+latitude + "/"+longitude;
	}

	@Override
	public String url() {
		return this.url;
	}

	// create the city object from the response of the server
	private String latitude;
	private String longitude;
	private String name;
	private String code;
	
	private City(String latitude, String longitude, String name, String code){
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.code = code;
	}
	
	public static City parse(String response) {
		JsonParser parser = new JsonParser();
		JsonObject city = parser.parse(response).getAsJsonObject();
		String latitude = city.get("latitude").getAsString();
		String longitude = city.get("longitude").getAsString();
		String name = city.get("city").getAsString();
		String code = city.get("code").getAsString();
		return new City(latitude, longitude, name, code);
	}

	public String latitude() {
		return this.latitude;
	}

	public String longitude() {
		return this.longitude;
	}

	public String name() {
		return this.name;
	}

	public String code() {
		return this.code;
	}
	
	@Override
	public String toString() {
		String output = "";
		output += "City={latitude="+this.latitude+", longitude="+this.longitude+", name="+this.name+", code="+this.code+"}";
		return output;
	}

}
