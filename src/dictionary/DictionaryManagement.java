package dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class DictionaryManagement {
	private Dictionary arrWords;
	public Dictionary getArrWords() {
		return arrWords;
	}
	public void dictionaryExportToFile(){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(arrWords.getADDRESSFILE()));
			for(Map.Entry<String, String>entry: arrWords.getTree().entrySet()){
				writer.write(entry.getKey() + '\t' + entry.getValue() + '\n');
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertFromFile(){
		try{
			BufferedReader read = new BufferedReader(new FileReader(arrWords.getADDRESSFILE()));
			int data = read.read();
			ArrayList<String> arrString = new ArrayList<String>();
			String word = "";
			while(data != -1){
				if(((char)data == '\n'|| (char)data == '\t') && !word.isEmpty()){
					arrString.add(word.trim());
					word = "";
				}
				else{
					word += (char)data;
				}
				data = read.read();
			}
			if(word.isEmpty() == false){
				arrString.add(word);
			}
			int n = arrString.size();
			for(int i = 0; i < n; i += 2){
				arrWords.getTree().put(arrString.get(i), arrString.get(i + 1));
			}
			read.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void showAllWords(){
		int i = 0;
		for(Map.Entry<String, String>entry: arrWords.getTree().entrySet()){
			if(i == 0){
				System.out.println("No" + '\t' + "| EngLish " + '\t' + "| Vietnamese");
			}
			System.out.println((i + 1) + "\t" + "| " + entry.getKey() + "\t\t" 
			+"| " + entry.getValue());
			++i;
		}
		
	}
	public DictionaryManagement(){
		arrWords = new Dictionary();
	}
	
}
