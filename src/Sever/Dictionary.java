package Sever;

import java.util.TreeMap;

public class Dictionary {
	private final String ADDRESSIMAGE = "image\\";
	private final String ADDRESSFILE = "data.txt";
	public String getADDRESSAPIAUDIO() {
		return ADDRESSAPIAUDIO;
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
	private TreeMap<String,String> tree = new TreeMap<String, String>();
	public TreeMap<String, String> getTree() {
		return this.tree;
	}
	public void setTree(TreeMap<String, String> tree) {
		this.tree = tree;
	}
	
	
}

