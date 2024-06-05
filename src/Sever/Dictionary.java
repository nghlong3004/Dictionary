package Sever;

import java.util.Map;
import java.util.TreeMap;

public class Dictionary {
	private final String ADDRESSIMAGE = "image\\";
	private final String ADDRESSFILE = "data.txt";
	public String getADDRESSAPIAUDIO() {
		return ADDRESSAPIAUDIO;
	}
	public String parseHTML(String key, String value){
		return "<html><i>" + key + "</i><br/><ul><li><font color='#cc0000'><b>" + value + "</b></font></li></ul></html>";
	}
	private final String ADDRESSAPISEARCH = "https://clients1.google.com/complete/search";
	public String getADDRESSAPISEARCH() {
		return ADDRESSAPISEARCH;
	}
	private final String ADDRESSAPIAUDIO = "http://translate.google.com/translate_tts";
	private final String ADDRESSAPITRANS = "https://script.google.com/macros/s/AKfycbwU7msuEL2UyzONn_I9m2HMG9FarUKOlmn6jbKIKhPx8Vd1QkqtxnQokl8R792zRrDQ/exec";
	public String getADDRESSAPI() {
		return ADDRESSAPITRANS;
	}
	private final int H = 60, W = 450;
	public int getH() {
		return H;
	}
	public int getW() {
		return W;
	}
	public String getADDRESSFILE() {
		return ADDRESSFILE;
	}
	public  String getADDRESSIMAGE() {
		return ADDRESSIMAGE;
	}
	private final Map<String,String> tree = new TreeMap<String, String>();
	public Map<String, String> getTree() {
		return this.tree;
	}
	
	
	
}

