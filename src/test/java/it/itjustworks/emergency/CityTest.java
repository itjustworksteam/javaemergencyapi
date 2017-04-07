package it.itjustworks.emergency;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class CityTest {

	@Test
	public void testOne() {
		City city = new City().withLatitudeAndLongitude("45.0", "9.0");
		assertEquals("/api/v2/city/45.0/9.0", city.url());
	}
	
	@Test
	public void testTwo() {
		City city = City.parse(cityResponse());
		assertEquals("44.99467", city.latitude());
		assertEquals("9.00862", city.longitude());
		assertEquals("Voghera", city.name());
		assertEquals("IT", city.code());
	}
	
	@Test
	public void testThree() {
		City city = City.parse(cityResponse());
		assertEquals("City={latitude=44.99467, longitude=9.00862, name=Voghera, code=IT}", city.toString());
	}
	
	public void usage() throws IOException {
		new Emergency().sendRequest(new City().withLatitudeAndLongitude("45.0", "9.0"));
	}
	
	public void usageAll() throws IOException {
		City city = City.parse(new Emergency().sendRequest(new City().withLatitudeAndLongitude("45.0", "9.0")));
		city.toString();
	}
	
	private String cityResponse() {
		String output = "";
		output += "{\"latitude\":\"44.99467\",\"longitude\":\"9.00862\",\"city\":\"Voghera\",\"code\":\"IT\"}";
		return output;
	}
	
}
