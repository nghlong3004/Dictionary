package Application;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Sever.Constants;


public class MenuPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel textLabel;
	private JButton add, edit, delete;
	public JButton getAdd() {
		return add;
	}
	public void setAdd(JButton add) {
		this.add = add;
	}
	public JButton getEdit() {
		return edit;
	}
	public void setEdit(JButton edit) {
		this.edit = edit;
	}
	public JButton getDelete() {
		return delete;
	}
	public void setDelete(JButton delete) {
		this.delete = delete;
	}
	public MenuPanel() {
		setLayout(null);
		setBounds(0, 0, 0, 962);
		newImplement();
		handle();
	}
	public void handle(){
		textLabel.setBounds(0, 0, 400, 150);
		ImageIcon image = new ImageIcon(Constants.IMAGE_FILE_PATH + "arrow-left.png");
		image = new ImageIcon(Constants.IMAGE_FILE_PATH + "MenuBig.png");
		textLabel.setIcon(new ImageIcon(image.getImage().getScaledInstance(400, 150, Image.SCALE_SMOOTH)));
		textLabel.setVerticalTextPosition(JLabel.CENTER);
		add.setFocusable(false);
		edit.setFocusable(false);
		delete.setFocusable(false);
		image = new ImageIcon(Constants.IMAGE_FILE_PATH + "Add.png");
		add.setIcon(new ImageIcon(image.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		add.setBackground(Color.white);
		image = new ImageIcon(Constants.IMAGE_FILE_PATH + "Remove.png");
		delete.setIcon(new ImageIcon(image.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		delete.setBackground(Color.white);
		image = new ImageIcon(Constants.IMAGE_FILE_PATH + "edit.png");
		edit.setIcon(new ImageIcon(image.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		edit.setBackground(Color.white);
		add.setBounds(77 ,189 , 231 , 75);
		edit.setBounds(77 ,302 , 231 , 75);
		delete.setBounds(77 ,414 , 231 , 75);
		add(textLabel);
		add(add);
		add(edit);
		add(delete);
	}
	public void newImplement(){
		textLabel = new JLabel();
		add = new JButton("Add");
		edit = new JButton("Edit");
		delete = new JButton("Delete");
	}
	public void Run(int i){
		this.setBounds(0, 0, i, 962);
	}
	private double easeOutCubic(double t) {
	    return 1 - Math.pow(1 - t, 3);
	}
	public void exitMenu(ActionEvent e) {
	    Timer animationTimer = new Timer(1, new ActionListener() {
	        private int startWidth = 400;
	        private int targetWidth = 0;
	        private long startTime = System.currentTimeMillis();
	        private long duration = 500;

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            long currentTime = System.currentTimeMillis();
	            long elapsedTime = currentTime - startTime;
	            double t = (double) elapsedTime / duration;

	            if (t >= 1) {
	                t = 1;
	                ((Timer) e.getSource()).stop();
	            }

	            double easedValue = easeOutCubic(t); 
	            int currentWidth = (int) (startWidth + (targetWidth - startWidth) * easedValue);
	            Run(currentWidth); 
	        }
	    });

	    animationTimer.start();
	}
}
