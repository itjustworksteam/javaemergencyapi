package it.itjustworks.emergency;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LanguageTest {

	@Test
	public void testOne() {
		assertEquals("en", Utils.getFromLanguageCode("en-US"));
		assertEquals("en", Utils.getFromLanguageCode("en-IT"));
		assertEquals("it", Utils.getFromLanguageCode("it-IT"));
		assertEquals("it", Utils.getFromLanguageCode("it-US"));
	}
	
	@Test
	public void testTwo() {
		Country country = Country.parse(italyResponseWithCity(), new EnglishLanguage());
		assertEquals("Italy", country.name());
		assertEquals("IT", country.code());
		assertEquals("113", country.police());
		assertEquals("118", country.medical());
		assertEquals("115", country.fire());
		assertEquals("You are in Italy 🇮🇹 and the closest city is Voghera", country.prettyToString());
	}
	
	@Test
	public void testThree() {
		Country country = Country.parse(italyResponseWithCity(), new ItalianLanguage());
		assertEquals("Italy", country.name());
		assertEquals("IT", country.code());
		assertEquals("113", country.police());
		assertEquals("118", country.medical());
		assertEquals("115", country.fire());
		assertEquals("Tu sei in Italy 🇮🇹 e la citta' piu' vicina e' Voghera", country.prettyToString());
	}
	
	private String italyResponseWithCity() {
		String output = "";
		output += "{\"name\":\"Italy\", \"code\":\"IT\", \"police\":\"113\", \"medical\":\"118\", \"fire\":\"115\", \"closestcity\":\"Voghera\"}";
		return output;
	}
}
