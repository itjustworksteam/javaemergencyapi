package it.itjustworks.emergency;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumbersTest {

	@Test
	public void testOne() {
		assertEquals("", "");
	}
	
	@Test
	public void testTwo() {
		Numbers numbers = new Numbers(Numbers.ALL);
		assertEquals("/api/v2/numbers/all", numbers.url());
	}
	
	@Test
	public void testThree() {
		Numbers numbers = new Numbers(Numbers.COUNTRY, "it");
		assertEquals("/api/v2/numbers/it", numbers.url());
	}
	
	@Test
	public void testFour() {
		Numbers numbers = new Numbers(Numbers.LATITUDE_LONGITUDE, "45.0", "9.0");
		assertEquals("/api/v2/numbers/45.0/9.0", numbers.url());
	}
	
	@Test
	public void testFive() {
		Numbers numbers = new Numbers("wrong");
		assertNull(numbers.url());
	}
	
}
