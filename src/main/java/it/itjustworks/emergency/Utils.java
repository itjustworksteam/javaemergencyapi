package it.itjustworks.emergency;

import java.util.HashMap;
import java.util.Map;

public class Utils {
	
	public static String getFromLanguageCode(String languageCode) {
		return languageCode.substring(0, 2);
	}

	public static Language language(String language) {
		Map<String, Language> map = languages();
		if(map.containsKey(language)) {
			return map.get(language);
		} else {
			return map.get("en");
		}
	}

	private static Map<String, Language> languages(){
		Map<String, Language> response = new HashMap<String, Language>();
		response.put("en", new EnglishLanguage());
		response.put("it", new ItalianLanguage());
		return response;
	}

	public static Language botLanguage(String code) {
		return Utils.language(Utils.getFromLanguageCode(code));
	}
	
}
