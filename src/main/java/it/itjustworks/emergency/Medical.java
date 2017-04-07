package it.itjustworks.emergency;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Medical implements Requestable {

	private static final String DEFAULT = "default";
	private static final String MEDICAL = "medical";
	private static final String LATANDLONG = "latandlong";
	private static final String COUNTRY = "country";
	private String url;
	
	@Override
	public String url() {
		return this.url;
	}
	
	public Medical() {
		this(DEFAULT, null, null, null);
	}
	
	private Medical(String type, String country){
		this(type, country, null, null);
	}
	
	private Medical(String type, String latitude, String longitude){
		this(type, null, latitude, longitude);
	}
	
	private Medical(String type, String country, String latitude, String longitude){
		if(type.equals(COUNTRY)){
			this.url = "/api/v2/medical/"+country;
		} else if(type.equals(LATANDLONG)){
			this.url = "/api/v2/medical/"+latitude + "/" + longitude;
		} else {
			this.url = null;
		}
	}

	public Medical withCountry(String country) {
		return new Medical(COUNTRY, country);
	}

	public Medical withLatitudeAndLongitude(String latitude, String longitude) {
		return new Medical(LATANDLONG, latitude, longitude);
	}

	// create the object from the response of the server
	private String number;
	
	private Medical(String number){
		this.number = number;
	}
	
	public static Medical parse(String response) {
		JsonParser parser = new JsonParser();
		JsonObject medical = parser.parse(response).getAsJsonObject();
		String number = medical.get(MEDICAL).getAsString();
		return new Medical(number);
	}

	public String number() {
		return this.number;
	}

}
