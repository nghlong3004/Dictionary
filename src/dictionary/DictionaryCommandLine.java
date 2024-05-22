package dictionary;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class DictionaryCommandLine {
	private DictionaryManagement open;
	private TreeMap<String,String> tree;
	public DictionaryManagement getOpen() {
		return open;
	}
	public void setOpen(DictionaryManagement open) {
		this.open = open;
	}
	public void dictionaryBasic(){
		open.insertFromCommandline();
		open.showAllWords();
	}
	public void dictionaryAdvanced(){
		open = new DictionaryManagement();
		open.showAllWords();
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		System.out.println(open.dictionaryLookup(s));
		scan.close();
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
        SortedMap<String, String> subMap = tree.subMap(word, eWord);
        if (subMap.size() != 0) {
            for (Map.Entry<String, String> entry : subMap.entrySet()) {
                String keyWord = entry.getKey();
                list.add(keyWord);
            }
        }
		return list;
	}
	public String dictionarySearcher(String key, boolean flag){
		return tree.get(key);
	}
	public DictionaryCommandLine(){
		open = new DictionaryManagement();
		open.insertFromFile();
		tree = new TreeMap<>();
		int n = open.getArrWords().getWords().size();
		for(int i = 0; i < n; ++i){
			tree.put(open.getArrWords().getWords().get(i).getWordE(), open.getArrWords().getWords().get(i).getWordVi());
		}
	}

}
