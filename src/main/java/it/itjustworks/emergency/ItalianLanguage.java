package it.itjustworks.emergency;

public class ItalianLanguage implements Language {

	@Override
	public String country() {
		return "Tu sei in ";
	}

	@Override
	public String city() {
		return " e la citta' piu' vicina e' ";
	}

}
