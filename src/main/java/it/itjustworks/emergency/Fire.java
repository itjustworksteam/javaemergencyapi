package it.itjustworks.emergency;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Fire implements Requestable {

	private static final String LATANDLONG = "latandlong";
	private static final String COUNTRY = "country";
	private String url;
	
	public Fire() {
		
	}
	
	private Fire(String type, String country){
		this(type, country, null, null);
	}
	
	private Fire(String type, String latitude, String longitude){
		this(type, null, latitude, longitude);
	}
	
	private Fire(String type, String country, String latitude, String longitude){
		if(type.equals(COUNTRY)){
			this.url = "/api/v2/fire/"+country;
		} else if(type.equals(LATANDLONG)){
			this.url = "/api/v2/fire/"+latitude+"/"+longitude;
		} else {
			this.url = null;
		}
	}
	
	public Fire withCountry(String country) {
		return new Fire(COUNTRY, country);
	}

	@Override
	public String url() {
		return this.url;
	}

	public Fire withLatitudeAndLongitude(String latitude, String longitude) {
		return new Fire(LATANDLONG, latitude, longitude);
	}

	// create the object from the response of the server
	private String number;
	
	private Fire(String number){
		this.number = number;
	}
	
	public static Fire parse(String response) {
		JsonParser parser = new JsonParser();
		JsonObject fire = parser.parse(response).getAsJsonObject();
		String number = fire.get("fire").getAsString();
		return new Fire(number);
	}

	public String number() {
		return this.number;
	}

	
	
}
