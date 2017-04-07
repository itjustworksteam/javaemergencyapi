package it.itjustworks.emergency;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Police implements Requestable {

	private static final String LATITUDE_AND_LONGITUDE = "latandlong";
	private static final String COUNTRY = "country";
	private String url;
	
	public Police() {
		this.url = null;
	}
	
	private Police(String type, String country){
		this(type, country, null, null);
	}
	
	private Police(String type, String latitude, String longitude) {
		this(type, null, latitude, longitude);
	}
	
	private Police(String type, String country, String latitude, String longitude){
		if(type.equals(COUNTRY)){
			this.url = "/api/v2/police/" + country;
		} else if(type.equals(LATITUDE_AND_LONGITUDE)) {
			this.url = "/api/v2/police/" + latitude + "/" + longitude;
		} else {
			this.url = null;
		}
	}
	
	@Override
	public String url() {
		return this.url;
	}

	public Police withCountry(String country) {
		return new Police(COUNTRY, country);
	}

	public Police withLatitudeAndLongitude(String latitude, String longitude) {
		return new Police(LATITUDE_AND_LONGITUDE, latitude, longitude);
	}

	// create the object from the response of the server
	
	private String number;
	
	private Police(String number){
		this.number = number;
	}
	
	public static Police parse(String response) {
		JsonParser parser = new JsonParser();
		JsonObject police = parser.parse(response).getAsJsonObject();
		String number = police.get("police").getAsString();
		return new Police(number);
	}

	public String number() {
		return this.number;
	}

}
