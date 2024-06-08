package Sever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class GoogleTranslate {

	public static String translate(String text, String langFrom, String langTo) throws IOException{
		String urlStr = (Constants.GOOGLE_TRANSLATE_API_URL)
				+ "?q=" + URLEncoder.encode(text, "UTF-8")
				+ "&source=" + langFrom
				+ "&target=" + langTo;
		@SuppressWarnings("deprecation")
		URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
	}
}

