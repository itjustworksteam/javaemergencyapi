package it.itjustworks.emergency;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParserTest {

	@Test
	public void testOne() {
		assertEquals("", "");
	}
	
	@Test
	public void testTwo() {
		Country country = Country.parse(italyResponse());
		assertEquals("Italy", country.name());
		assertEquals("IT", country.code());
		assertEquals("113", country.police());
		assertEquals("118", country.medical());
		assertEquals("115", country.fire());
	}
	
	@Test
	public void testThree() {
		Country country = Country.parse(italyResponseWithCity());
		assertEquals("Italy", country.name());
		assertEquals("IT", country.code());
		assertEquals("113", country.police());
		assertEquals("118", country.medical());
		assertEquals("115", country.fire());
		assertEquals("Voghera", country.city());
	}
	
	private String italyResponse() {
		String output = "";
		output += "{\"name\":\"Italy\", \"code\":\"IT\", \"police\":\"113\", \"medical\":\"118\", \"fire\":\"115\"}";
		return output;
	}
	
	private String italyResponseWithCity() {
		String output = "";
		output += "{\"name\":\"Italy\", \"code\":\"IT\", \"police\":\"113\", \"medical\":\"118\", \"fire\":\"115\", \"closestcity\":\"Voghera\"}";
		return output;
	}
	
}
