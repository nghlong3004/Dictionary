package Sever;

public class DictionaryHelper {
	public static String parseHTML(String key, String value){
		return "<html><i>" + key + "</i><br/><ul><li><font color='#cc0000'><b>" + value + "</b></font></li></ul></html>";
	}
}
