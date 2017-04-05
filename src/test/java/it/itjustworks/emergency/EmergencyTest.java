package it.itjustworks.emergency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;

import org.junit.Test;

public class EmergencyTest {

	@Test
	public void testOne() {
		assertEquals("", "");
	}
	
	@Test
	public void testTwo() throws IOException{
		String response = new Emergency().sendRequest(new Numbers(Numbers.ALL));
		assertNotEquals("", response);
	}
	
	@Test
	public void testThree() throws IOException {
		String response = new Emergency().sendRequest(new Numbers(Numbers.COUNTRY, "it"));
		assertEquals(italyResponse(), response);
	}
	
	@Test
	public void testFour() throws IOException {
		String response = new Emergency().sendRequest(new Numbers(Numbers.LATITUDE_LONGITUDE, "45.0", "9.0"));
		assertEquals(italyResponseWithCity(), response);
	}
	
	@Test(expected=Exception.class)
	public void testFive() throws IOException {
		String response = new Emergency().sendRequest(new Numbers("wrong"));
		assertEquals("", response);
		// throws exception
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
