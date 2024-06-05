package Application;

import javax.swing.JComboBox;

import Sever.Dictionary;
import Sever.Languages;

public class SelectLanguage extends JComboBox<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Languages languageMap;
	public SelectLanguage() {
		// TODO Auto-generated constructor stub
		languageMap = new Languages();
    	addItem("EngLish");
    	for (String language : languageMap.languageMap.keySet()) {
            addItem(language);
        }
    	setLayout(null);
    	setBounds((int)(new Dictionary().getW() * 0.8) ,(int)(new Dictionary().getH() * 1.5) , 80, 20);	
	}
	public String getSelectedLanguageCode() {
        String selectedLanguage = (String) getSelectedItem();
	    return languageMap.languageMap.get(selectedLanguage);
	}
	
}
