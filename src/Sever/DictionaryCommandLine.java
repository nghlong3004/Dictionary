package Sever;

import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;

public class DictionaryCommandLine {
	private DictionaryManagement open;
	public DictionaryManagement getOpen() {
		return open;
	}
	public void setOpen(DictionaryManagement open) {
		this.open = open;
	}
	public void display(){
		open.showAllWords();
	}
	public ArrayList<String> dictionarySearcher(String key){
		ArrayList<String> list = new ArrayList<String>();
        String word = key;
        int endWord = word.length() - 1;
        char[] oldWord = word.toCharArray();
        if(endWord >= 0){
        	int i = Integer.valueOf(oldWord[endWord]) + 1;
        	oldWord[endWord] = (char)i;
        }
        String eWord = new String(oldWord);
        SortedMap<String, String> subMap = open.getArrWords().getTree().subMap(word, eWord);
        if (subMap.size() != 0) {
            for (Map.Entry<String, String> entry : subMap.entrySet()) {
                String keyWord = entry.getKey();
                list.add(keyWord);
            }
        }
		return list;
	}
	public String dictionarySearcher(String key, boolean flag){
		return open.getArrWords().getTree().get(key);
	}
	public DictionaryCommandLine(){
		open = new DictionaryManagement();
		open.insertFromFile();
	}

}
