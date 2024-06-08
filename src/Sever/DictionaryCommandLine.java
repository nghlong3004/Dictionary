package Sever;

import java.util.ArrayList;
import java.util.Map;

public class DictionaryCommandLine {
	private static DictionaryManagement dictionaryManagement;
	public DictionaryManagement getOpen() {
		return dictionaryManagement;
	}
	public void setOpen(DictionaryManagement open) {
		DictionaryCommandLine.dictionaryManagement = open;
	}
	public void display(){
		dictionaryManagement.showAllWords();
	}
	public static ArrayList<String> dictionarySearcher(String key) {
	    String word = key;
	    int endWord = word.length() - 1;
	    if (endWord >= 0) {
	        word = word.substring(0, endWord) + (char) (word.charAt(endWord) + 1);
	    }
	    ArrayList<String> list = new ArrayList<>();
	    for (Map.Entry<String, String> entry : dictionaryManagement.getArrWords().getTree().entrySet()) {
	        String keyWord = entry.getKey();
	        if (keyWord.compareTo(key) >= 0 && keyWord.compareTo(word) < 0) {
	            list.add(keyWord);
	        }
	    }
	    return list;
	}
	public static String dictionarySearcher(String key, boolean flag){
		if(key.isEmpty()){
			return "";
		}
		return dictionaryManagement.getArrWords().getTree().get(key);
	}
	public DictionaryCommandLine(){
		dictionaryManagement = new DictionaryManagement();
		dictionaryManagement.insertFromFile();
	}

}
