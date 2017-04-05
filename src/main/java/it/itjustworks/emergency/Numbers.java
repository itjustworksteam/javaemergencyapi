package it.itjustworks.emergency;

public class Numbers implements Requestable{

	public static final String ALL = "all";
	public static final String COUNTRY = "country";
	public static final String LATITUDE_LONGITUDE = "latandlong";
	private String url;
	
	public Numbers(String type) {
		this(type, null, null, null);
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

	public Numbers(String type, String country) {
		this(type, country, null, null);
	}

	public Numbers(String type, String latitude, String longitude) {
		this(type, null, latitude, longitude);
	}

	@Override
	public String url() {
		return this.url;
	}

}
