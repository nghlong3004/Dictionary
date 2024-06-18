package Sever;

import java.util.ArrayList;

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
		ArrayList<String> wordsWithPrefix = new ArrayList<>(dictionaryManagement.getArrWords().getTree()
			    .subMap(key, key + Character.MAX_VALUE).headMap(key + "\uffff").keySet());
	    return wordsWithPrefix;
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
