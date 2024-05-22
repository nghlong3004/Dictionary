package dictionary;

import java.awt.Color;

import javax.swing.JFrame;

public class Windows extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Windows(){
		super("Dictionary");
		pack();
		setBounds(100, 100, 915, 968);
		getContentPane().add(new Solve());
		getContentPane().setBackground(Color.white);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
;