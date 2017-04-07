package it.itjustworks.emergency;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Country {

	private String name;
	private String code;
	private String police;
	private String medical;
	private String fire;
	private String city;
	
	Country(String name, String code, String police, String medical, String fire, String city) {
		this.name = name;
		this.code = code;
		this.police = police;
		this.medical = medical;
		this.fire = fire;
		this.city = city;
	}
	
	public static Country parse(String request) {
		JsonParser parser = new JsonParser();
		JsonObject country = parser.parse(request).getAsJsonObject();
		String name = country.get("name").getAsString();
		String code = country.get("code").getAsString();
		String police = country.get("police").getAsString();
		String medical = country.get("medical").getAsString();
		String fire = country.get("fire").getAsString();
		String city = null;
		if(country.get("closestcity") != null){
			city = country.get("closestcity").getAsString();
		}
		return new Country(name, code, police, medical, fire, city);
	}

	public String name() {
		return this.name;
	}

	public String code() {
		return this.code;
	}

	public String police() {
		return this.police;
	}

	public String medical() {
		return this.medical;
	}

	public String fire() {
		return this.fire;
	}

	public String city() {
		return this.city;
	}

	@Override
	public String toString() {
		String output = "";
		output += "Country={name="+this.name+", code="+this.code+", police="+this.police+", medical="+this.medical+", fire="+this.fire;
		if(this.city != null){
			output += ", city=Voghera";
		}
		output += "}";
		return output;
	}

	public String prettyToString() {
		String output = "";
		output += "You are in "+this.name+" " + Emoji.withCountry(this.code);
		if(this.city != null){
			output += " and the closest city is " + this.city;
		}
		return output;
	}
	
}
