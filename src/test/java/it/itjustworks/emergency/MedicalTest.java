package it.itjustworks.emergency;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class MedicalTest {

	@Test
	public void testOne() {
		Medical medical = new Medical().withCountry("it");
		assertEquals("/api/v2/medical/it", medical.url());
	}
	
	@Test
	public void testTwo() {
		Medical medical = new Medical().withLatitudeAndLongitude("45.0", "9.0");
		assertEquals("/api/v2/medical/45.0/9.0", medical.url());
	}
	
	@Test
	public void testThree() {
		Medical medical = Medical.parse(medicalOutput());
		assertEquals("118", medical.number());
	}
	
	public void usage() throws IOException {
		new Emergency().sendRequest(new Medical().withCountry("it"));
	}
	
	public void usageAll() throws IOException {
		Medical medical = Medical.parse(new Emergency().sendRequest(new Medical().withCountry("it")));
		medical.number();
	}
	
	private String medicalOutput() {
		String output = "";
		output += "{\"medical\":\"118\"}";
		return output;
	}
}
