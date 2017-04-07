package it.itjustworks.emergency;

public class Numbers implements Requestable{

	public static final String ALL = "all";
	public static final String COUNTRY = "country";
	public static final String LATITUDE_LONGITUDE = "latandlong";
	private String url;
	
	@Deprecated
	public Numbers(String type) {
		this(type, null, null, null);
	}
	
	public Numbers() {
		this.url = null;
	}
	
	private Numbers(String type, String country, String latitude, String longitude) {
		if(type.equals(ALL)){
			this.url = "/api/v2/numbers/all";
		} else if(type.equals(COUNTRY)) {
			this.url = "/api/v2/numbers/"+country;
		} else if(type.equals(LATITUDE_LONGITUDE)){
			this.url = "/api/v2/numbers/"+latitude+"/"+longitude;
		} else {
			this.url = null;
		}
	}

	@Deprecated
	public Numbers(String type, String country) {
		this(type, country, null, null);
	}

	@Deprecated
	public Numbers(String type, String latitude, String longitude) {
		this(type, null, latitude, longitude);
	}

	@Override
	public String url() {
		return this.url;
	}
	
	@Override
	public String toString() {
		String output = "";
		output += "Numbers={url="+this.url+"}";
		return output;
	}

	public Numbers all() {
		return new Numbers(Numbers.ALL);
	}

	public Numbers withCountry(String country) {
		return new Numbers(Numbers.COUNTRY, country);
	}

	public Numbers withLatitudeAndLongitude(String latitude, String longitude) {
		return new Numbers(Numbers.LATITUDE_LONGITUDE, latitude, longitude);
	}

}
