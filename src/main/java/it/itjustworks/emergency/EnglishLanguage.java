package it.itjustworks.emergency;

public class EnglishLanguage implements Language {

	@Override
	public String country() {
		return "You are in ";
	}

	@Override
	public String city() {
		return " and the closest city is ";
	}

	@Override
	public String start() {
		String output = "";
		output += "Welcome! " + Emoji.hello() + " With this bot you can retrieve the "+ Emoji.sos() +" phone numbers of the country "
				+ "only by sending your location " + Emoji.location() + ".\nFor more please send /help or simply press the "
						+ "\"SEND YOUR LOCATION\" button " + Emoji.below() + "\n";
		return output;
	}

	@Override
	public String help() {
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

	@Override
	public String feedback() {
		String output = "";
		output += "If you have a question or you need an help. Please use our support bot: @itjustworksbot.\n"
				+ "We will reply you as soon as possible!";
		return output;
	}

	@Override
	public String invalid() {
		String output = "";
		output += "Invalid command. Please see /help for more details.";
		return output;
	}

	@Override
	public String contribute() {
		String output = "";
		output += "If you are a developer please follow this link: https://github.com/itjustworksteam/emergencybot/blob/master/README.md\n\n"
				+ "if you have any suggestion please use the /feedback command.\nThanks so much for your help!\n";
		return output;
	}

	@Override
	public String credits() {
		String output = "";
		output += "Developed by @therickys93, co-founder of 'It Just Works'. More info at www.itjustworks.it.";
		return output;
	}
}
