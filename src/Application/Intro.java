package Application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import Sever.Constants;

public class Intro extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JProgressBar bar;
	private ImageIcon image;
	public Intro() {
		pack();
		setSize(400, 90);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(getIconImage());
		image = new ImageIcon(Constants.IMAGE_FILE_PATH + "intro.png");
		setIconImage(image.getImage());
		bar = new JProgressBar(0, 100);
		bar.setStringPainted(true);
		bar.setFont(new Font("MV Boli", Font.BOLD, 25));
		bar.setForeground(Color.red);
		bar.setBackground(Color.white);
		getContentPane().add(bar, BorderLayout.CENTER);
		setVisible(true);
	}
	public void value(int i) {
		bar.setValue(i);
	}
	public void open() {
		setVisible(true);
	}
	public void done() {
		bar.setString("Done!");
		dispose();
	}
	
	
}
