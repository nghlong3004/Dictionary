package Application;

import javax.swing.SwingUtilities;

public class RunApplication {
	public void runApplication(){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				new MainFrame().setVisible(true);
			}
		});
	}
}
