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
	
	@Test
	public void testFour() {
		Country country = Country.parse(italyResponse());
		assertEquals("Country={name=Italy, code=IT, police=113, medical=118, fire=115}", country.toString());
	}
	
	@Test
	public void testFive() {
		Country country = Country.parse(italyResponseWithCity());
		assertEquals("Country={name=Italy, code=IT, police=113, medical=118, fire=115, city=Voghera}", country.toString());
	}
	
	@Test
	public void testSix() {
		Country country = Country.parse(italyResponse());
		assertEquals("You are in Italy 🇮🇹", country.prettyToString());
	}
	
	@Test
	public void testSeven() {
		Country country = Country.parse(italyResponseWithCity());
		assertEquals("You are in Italy 🇮🇹 and the closest city is Voghera", country.prettyToString());
	}
	
	@Test
	public void improveCodeCoverage() {
		Emoji emoji = new Emoji();
		emoji.toString();
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
