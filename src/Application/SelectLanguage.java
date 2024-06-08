package Application;

import javax.swing.JComboBox;

import Sever.Constants;
import Sever.DictionaryLanguage;

public class SelectLanguage extends JComboBox<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DictionaryLanguage languageMap;
	public SelectLanguage() {
		// TODO Auto-generated constructor stub
		languageMap = new DictionaryLanguage();
    	addItem("EngLish");
    	for (String language : languageMap.keySet()) {
            addItem(language);
        }
    	setLayout(null);
    	setBounds((int)(Constants.WEIGHT * 0.8) ,(int)(Constants.HEIGHT * 1.5) , 80, 20);	
	}
	public String getSelectedLanguageCode() {
        String selectedLanguage = (String) getSelectedItem();
	    return languageMap.getLanguage(selectedLanguage);
	}
	
}
