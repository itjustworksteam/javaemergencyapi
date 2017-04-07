package it.itjustworks.emergency;

import com.vdurmont.emoji.EmojiParser;

public class Emoji {

	public static String withCountry(String country) {
		return EmojiParser.parseToUnicode(":"+ country.toLowerCase() +":" );
	}

}
