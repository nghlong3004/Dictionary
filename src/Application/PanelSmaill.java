package Application;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Sever.Dictionary;


public class PanelSmaill extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel textLabel;
	private JButton add, edit, delete, exit, buttonMenu;
	private JTextField solve;
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
	public PanelSmaill(JButton buttonMenu, JTextField solve) {
		setLayout(null);
		setBounds(0, 0, 0, 962);
		this.buttonMenu = buttonMenu;
		this.solve = solve;
		newImplement();
		handle();
	}
	public void handle(){
		textLabel.setBounds(0, 0, 400, 150);
		exit.setBounds(380, 0, 20, 20);
		ImageIcon image = new ImageIcon(new Dictionary().getADDRESSIMAGE() + "arrow-left.png");
		exit.setIcon(new ImageIcon(image.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		image = new ImageIcon(new Dictionary().getADDRESSIMAGE() + "MenuBig.png");
		textLabel.setIcon(new ImageIcon(image.getImage().getScaledInstance(400, 150, Image.SCALE_SMOOTH)));
		textLabel.setVerticalTextPosition(JLabel.CENTER);
		add.setFocusable(false);
		edit.setFocusable(false);
		delete.setFocusable(false);
		exit.setFocusable(false);
		buttonMenu.setFocusable(false);
		image = new ImageIcon(new Dictionary().getADDRESSIMAGE() + "Add.png");
		add.setIcon(new ImageIcon(image.getImage()));
		add.setBackground(Color.white);
		image = new ImageIcon(new Dictionary().getADDRESSIMAGE() + "Remove.png");
		delete.setIcon(new ImageIcon(image.getImage()));
		delete.setBackground(Color.white);
		image = new ImageIcon(new Dictionary().getADDRESSIMAGE() + "Edit.png");
		edit.setIcon(new ImageIcon(image.getImage()));
		edit.setBackground(Color.white);
		add.setBounds(77 ,189 , 231 , 75);
		edit.setBounds(77 ,302 , 231 , 75);
		delete.setBounds(77 ,414 , 231 , 75);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				exitMenu(e);
			}
		});
		textLabel.add(exit);
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
		exit = new JButton();
	}
	public void Run(int i){
		this.setBounds(0, 0, i, 962);
	}
	public void exitMenu(ActionEvent e){
		new Thread(new Runnable() {
			@Override
			public void run() {
			// TODO Auto-generated method stub
				for(int i = 400; i >= 0; --i){
					try {
						Run(i);
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		this.buttonMenu.setVisible(true);
		this.solve.setEnabled(true);
	}
}
