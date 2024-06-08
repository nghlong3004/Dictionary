package Application;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Sever.Constants;

public class Button extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Button() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBounds(250,51,45, 25);
		setBackground(Color.white);
		ImageIcon image = new ImageIcon(Constants.IMAGE_FILE_PATH + "Searchbar.png");
		setIcon(new ImageIcon(image.getImage().getScaledInstance(30, 15, Image.SCALE_DEFAULT)));
	}
}
