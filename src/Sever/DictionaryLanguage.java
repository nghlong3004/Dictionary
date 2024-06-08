package Sever;

import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DictionaryLanguage {
	private static Map<String, String> languageMap = new TreeMap<>();
	public String getLanguage(String key) {
		return languageMap.get(key);
	}
	public Set<String> keySet() {
		return languageMap.keySet();
	}
	public DictionaryLanguage() {
		Locale[] locales = Locale.getAvailableLocales();
    	for (Locale locale : locales) {
    	    String language = locale.getDisplayLanguage();
    	    String code = locale.getLanguage();
    	    if (!language.isEmpty() && !code.isEmpty() && code != "en") {
    	        languageMap.put(language, code);
    	    }
    	}
    	languageMap.put("EngLish", "en");
	}
}
