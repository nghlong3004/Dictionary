package Sever;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import Application.Intro;

public class DictionaryManagement {
	private Dictionary dictionary;
	public Dictionary getArrWords() {
		return dictionary;
	}
	public void dictionaryExportToFile() {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("newData.txt"), 1 << 16)) {
	        for (Map.Entry<String, String> entry : dictionary.getTree().entrySet()) {
	            StringBuilder sb = new StringBuilder();
	            sb.append(entry.getKey()).append(entry.getValue()).append('\n');
	            writer.write(sb.toString());
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public void insertFromFile() {
		long totalLines;
        try (Stream<String> lines = Files.lines(Paths.get(Constants.INPUT_FILE_PATH))) {
            totalLines = lines.count();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Intro intro = new Intro();
        AtomicInteger currentLine = new AtomicInteger(0);
	    try (Stream<String> lines = Files.lines(Paths.get(Constants.INPUT_FILE_PATH))) {
	        lines.forEach(line -> {
	            int splitIndex = line.indexOf('<');
	            if (splitIndex != -1) {
	                String key = line.substring(0, splitIndex).trim();
	                key = key.substring(0, 1).toUpperCase() + key.substring(1).toLowerCase();
	                String value = line.substring(splitIndex).trim();
	                dictionary.getTree().put(key, value);
	            }
                int progress = (int) (((double) currentLine.incrementAndGet() / totalLines) * 100);
                intro.value(progress);
	        });
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    intro.done();
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