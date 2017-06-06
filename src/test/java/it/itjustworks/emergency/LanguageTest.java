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
	
	@Test
	public void testFour() {
		assertEquals(new EnglishLanguage().country(), Utils.language(Utils.getFromLanguageCode("en-US")).country());
		assertEquals(new EnglishLanguage().city(), Utils.language(Utils.getFromLanguageCode("en-IT")).city());
	}
	
	@Test
	public void testFive() {
		assertEquals(new ItalianLanguage().city(), Utils.botLanguage("it-IT").city());
	}
	
	@Test
	public void testSix() {
		Language language = new EnglishLanguage();
		assertEquals("You are in ", language.country());
		assertEquals(" and the closest city is ", language.city());
		assertEquals("Welcome! 👋 With this bot you can retrieve "
				+ "the 🆘 phone numbers of the country only by "
				+ "sending your location 📍.\nFor more please send "
				+ "/help or simply press the \"SEND YOUR LOCATION\" button 👇\n", language.start());
		assertEquals(helpOutput(), language.help());
		assertEquals(feedbackOutput(), language.feedback());
		assertEquals(invalidOutput(), language.invalid());
		assertEquals(contributeOutput(), language.contribute());
		assertEquals(creditsOutput(), language.credits());
	}
	
	private String creditsOutput() {
		String output = "";
		output += "Developed by @therickys93, co-founder of 'It Just Works'. More info at www.itjustworks.it.";
		return output;
	}

	private String contributeOutput() {
		String output = "";
		output += "If you are a developer please follow this link: https://github.com/itjustworksteam/emergencybot/blob/master/README.md\n\n"
				+ "if you have any suggestion please use the /feedback command.\nThanks so much for your help!\n";
		return output;
	}

	public String invalidOutput() {
		String output = "";
		output += "Invalid command. Please see /help for more details.";
		return output;
	}
	
	private String feedbackOutput() {
		String output = "";
		output += "If you have a question or you need an help. Please use our support bot: @itjustworksbot.\n"
				+ "We will reply you as soon as possible!";
		return output;
	}
	
	private String helpOutput(){
		String output = "";
		output += "This bot needs only your location to work.\n"
				+ "Click the 'clip' and then click on 'Location' to send your current location.\n"
				+ "The response is a list of emergency numbers of the country where you are at the moment.\n\n"
				+ "All the commands are:\n"
				+ "/start - start the chat.\n"
				+ "/help - show this message.\n"
				+ "/credits - find out who is the developer.\n"
				+ "/contribute - see what you can do to improve the bot quality.\n"
				+ "/feedback - say us what you think.\n";
		return output;
	}
	
	private String italyResponseWithCity() {
		String output = "";
		output += "{\"name\":\"Italy\", \"code\":\"IT\", \"police\":\"113\", \"medical\":\"118\", \"fire\":\"115\", \"closestcity\":\"Voghera\"}";
		return output;
	}
}
