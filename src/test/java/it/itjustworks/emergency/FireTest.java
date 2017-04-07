package it.itjustworks.emergency;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class FireTest {

	@Test
	public void testOne() {
		Fire fire = new Fire().withCountry("it");
		assertEquals("/api/v2/fire/it", fire.url());
	}
	
	@Test
	public void testTwo() {
		Fire fire = new Fire().withLatitudeAndLongitude("45.0", "9.0");
		assertEquals("/api/v2/fire/45.0/9.0", fire.url());
	}
	
	@Test
	public void testThree() {
		Fire fire = Fire.parse(fireOutput());
		assertEquals("115", fire.number());
	}
	
	public void usage() throws IOException {
		new Emergency().sendRequest(new Fire().withCountry("it"));
	}
	
	public void usageAll() throws IOException {
		Fire fire = Fire.parse(new Emergency().sendRequest(new Fire().withCountry("it")));
		fire.number();
	}
	
	private String fireOutput() {
		String output = "";
		output += "{\"fire\":\"115\"}";
		return output;
	}
}
