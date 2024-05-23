package dictionary;

import java.util.ArrayList;

public class Dictionary {
	private final String ADDRESSIMAGE = "C:\\Users\\hh1305\\LONG\\JAVA\\Dictionary\\image\\";
	private final String ADDRESSFILE = "C:\\Users\\hh1305\\LONG\\JAVA\\Dictionary\\";
	public String getADDRESSFILE() {
		return ADDRESSFILE;
	}
	public String getADDRESSIMAGE() {
		return ADDRESSIMAGE;
	}
	private ArrayList<Word> words;
	public ArrayList<Word> getWords() {
		return words;
	}
	public Dictionary(){
		words = new ArrayList<Word>();
	}
	
}
