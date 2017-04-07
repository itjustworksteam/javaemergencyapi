package it.itjustworks.emergency;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class NumbersTest {

	@Test
	public void testOne() {
		assertEquals("", "");
	}
	
	@Test
	public void testTwo() {
		@SuppressWarnings("deprecation")
		Numbers numbers = new Numbers(Numbers.ALL);
		assertEquals("/api/v2/numbers/all", numbers.url());
	}
	
	@Test
	public void testThree() {
		@SuppressWarnings("deprecation")
		Numbers numbers = new Numbers(Numbers.COUNTRY, "it");
		assertEquals("/api/v2/numbers/it", numbers.url());
	}
	
	@Test
	public void testFour() {
		@SuppressWarnings("deprecation")
		Numbers numbers = new Numbers(Numbers.LATITUDE_LONGITUDE, "45.0", "9.0");
		assertEquals("/api/v2/numbers/45.0/9.0", numbers.url());
	}
	
	@Test
	public void testFive() {
		@SuppressWarnings("deprecation")
		Numbers numbers = new Numbers("wrong");
		assertNull(numbers.url());
	}
	
	@Test
	public void testSix() {
		@SuppressWarnings("deprecation")
		Numbers numbers = new Numbers(Numbers.ALL);
		assertEquals("Numbers={url=/api/v2/numbers/all}", numbers.toString());
	}
	
	@Test
	public void testSeven() {
		@SuppressWarnings("deprecation")
		Numbers numbers = new Numbers(Numbers.COUNTRY, "it");
		assertEquals("Numbers={url=/api/v2/numbers/it}", numbers.toString());
	}
	
	@Test
	public void testEight() {
		@SuppressWarnings("deprecation")
		Numbers numbers = new Numbers(Numbers.LATITUDE_LONGITUDE, "45.0", "9.0");
		assertEquals("Numbers={url=/api/v2/numbers/45.0/9.0}", numbers.toString());
	}
	
	@Test
	public void testNine() {
		@SuppressWarnings("deprecation")
		Numbers numbers = new Numbers("wrong");
		assertEquals("Numbers={url=null}", numbers.toString());
	}
	
	@Test
	public void testTen() {
		Numbers numbers = new Numbers();
		assertNull(numbers.url());
	}
	
	@Test
	public void testEleven() {
		Numbers numbers = new Numbers().all();
		assertEquals("/api/v2/numbers/all", numbers.url());
	}
	
	@Test
	public void testTwelve() {
		Numbers numbers = new Numbers().withCountry("it");
		assertEquals("/api/v2/numbers/it", numbers.url());
	}
	
	@Test
	public void testThirteen() {
		Numbers numbers = new Numbers().withLatitudeAndLongitude("45.0", "9.0");
		assertEquals("/api/v2/numbers/45.0/9.0", numbers.url());
	}
	
	public void usageToRequest() throws IOException {
		new Emergency().sendRequest(new Numbers().all());
		new Emergency().sendRequest(new Numbers().withCountry("it"));
		new Emergency().sendRequest(new Numbers().withLatitudeAndLongitude("45.0", "9.0"));
	}
	
	public void usageAll() throws IOException {
		Country country = Country.parse(new Emergency().sendRequest(new Numbers().withCountry("it")));
		country.toString();
	}
	
}
