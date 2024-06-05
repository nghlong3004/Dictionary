package Sever;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class DictionaryManagement {
	private Dictionary dictionary;
	public Dictionary getArrWords() {
		return dictionary;
	}
	public void dictionaryExportToFile(){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("newData.txt"));
			for(Map.Entry<String, String>entry: dictionary.getTree().entrySet()){
				writer.write(entry.getKey() + entry.getValue() + '\n');
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertFromFile() {
	    try (BufferedReader reader = new BufferedReader(new FileReader(dictionary.getADDRESSFILE()))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            int splitIndex = line.indexOf('<');
	            if (splitIndex != -1) {
	                String key = line.substring(0, splitIndex).trim();
	                String value = line.substring(splitIndex).trim();
	                dictionary.getTree().put(key, value);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public void showAllWords(){
		int i = 0;
		for(Map.Entry<String, String>entry: dictionary.getTree().entrySet()){
			if(i == 0){
				System.out.println("No" + '\t' + "| EngLish " + '\t' + "| Vietnamese");
			}
			System.out.println((i + 1) + "\t" + "| " + entry.getKey() + "\t\t" 
			+"| " + entry.getValue());
			++i;
		}
		
	}
	public DictionaryManagement(){
		dictionary = new Dictionary();
	}
	
}
