package dictionary;

import javax.swing.SwingUtilities;

public class DictionaryApplication {
	public void runApplication(){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				new Windows().setVisible(true);
			}
		});
	}
}
