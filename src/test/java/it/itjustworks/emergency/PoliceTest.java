package it.itjustworks.emergency;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class PoliceTest {

	@Test
	public void testOne() {
		Police police = new Police().withCountry("it");
		assertEquals("/api/v2/police/it", police.url());
	}
	
	@Test
	public void testTwo() {
		Police police = new Police().withLatitudeAndLongitude("45.0", "9.0");
		assertEquals("/api/v2/police/45.0/9.0", police.url());
	}
	
	@Test
	public void testThree() {
		Police police = Police.parse(policeOutput());
		assertEquals("113", police.number());
	}
	
	public void usage() throws IOException {
		new Emergency().sendRequest(new Police().withCountry("it"));
	}
	
	public void usageAll() throws IOException {
		Police police = Police.parse(new Emergency().sendRequest(new Police().withCountry("it")));
		police.number();
	}
	
	private String policeOutput() {
		String output = "";
		output += "{\"police\":\"113\"}";
		return output;
	}
}
