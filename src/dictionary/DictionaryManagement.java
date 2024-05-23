package dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
	private Dictionary arrWords;
	public Dictionary getArrWords() {
		return arrWords;
	}
	public void add(Word value){
		arrWords.getWords().add(value);
	}
	public void deleteWord(String value){
		int n = this.arrWords.getWords().size();
		for(int i = 0; i < n; ++i){
			if(arrWords.getWords().get(i).getWordE().equals(value)){
				System.out.println(i);
				arrWords.getWords().remove(i);
				break;
			}
			if(arrWords.getWords().get(i).wordExplain().equals(value)){
				arrWords.getWords().remove(i);
				break;
			}
		}
	}
	public void FixWord(String value, String key){
		int n = this.arrWords.getWords().size();
		for(int i = 0; i < n; ++i){
			if(arrWords.getWords().get(i).getWordE().equals(value)){
				arrWords.getWords().get(i).setWordE(key);
			}
			if(arrWords.getWords().get(i).wordExplain().equals(value)){
				arrWords.getWords().get(i).setWordE(key);
			}
		}
	}
	public void insertFromCommandline(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap so luong tu : ");
		int n = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i < n; ++i){
			add(new Word(scan.nextLine(), scan.nextLine()));
		}
		scan.close();
	}
	public void dictionaryExportToFile(){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(arrWords.getADDRESSFILE() + "output.txt"));
			for(Word a : arrWords.getWords()){
				writer.write(a.getWordE() + '\t' + a.getWordVi() + '\n');
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void insertFromFile(){
		try{
			BufferedReader read = new BufferedReader(new FileReader(arrWords.getADDRESSFILE() + "data.txt"));
			int data = read.read();
			ArrayList<String> arrString = new ArrayList<String>();
			String word = "";
			while(data != -1){
				if((char)data == '\n' && !word.isEmpty()){
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
				add(new Word(arrString.get(i), arrString.get(i + 1)));
			}
			read.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void showAllWords(){
		int n = arrWords.getWords().size();
		for(int i = 0; i < n; ++i){
			if(i == 0){
				System.out.println("No" + '\t' + "| EngLish " + '\t' + "| Vietnamese");
			}
			System.out.println((i + 1) + "\t" + "| " + arrWords.getWords().get(i).getWordE() + "\t\t" 
			+"| " + arrWords.getWords().get(i).wordExplain());
		}
		
	}
	public String dictionaryLookup(String key){
		ArrayList<Word> words = arrWords.getWords();
		int n = words.size();
		for(int i = 0; i < n; ++i){
			if(key.equals(words.get(i).getWordE())){
				return words.get(i).wordExplain();
			}
			if(key.equals(words.get(i).wordExplain())){
				return words.get(i).getWordE();
			}
		}
		return null;
	}
	public DictionaryManagement(){
		arrWords = new Dictionary();
	}
	
}
