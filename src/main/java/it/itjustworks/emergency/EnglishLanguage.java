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

}
