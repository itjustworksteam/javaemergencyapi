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
	
	@Test
	public void testSix() {
		Numbers numbers = new Numbers(Numbers.ALL);
		assertEquals("Numbers={url=/api/v2/numbers/all}", numbers.toString());
	}
	
	@Test
	public void testSeven() {
		Numbers numbers = new Numbers(Numbers.COUNTRY, "it");
		assertEquals("Numbers={url=/api/v2/numbers/it}", numbers.toString());
	}
	
	@Test
	public void testEight() {
		Numbers numbers = new Numbers(Numbers.LATITUDE_LONGITUDE, "45.0", "9.0");
		assertEquals("Numbers={url=/api/v2/numbers/45.0/9.0}", numbers.toString());
	}
	
	@Test
	public void testNine() {
		Numbers numbers = new Numbers("wrong");
		assertEquals("Numbers={url=null}", numbers.toString());
	}
	
}
