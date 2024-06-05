package Sever;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class Languages {
	public Map<String, String> languageMap = new TreeMap<>();
	public Languages() {
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
