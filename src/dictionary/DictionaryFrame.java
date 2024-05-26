package dictionary;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DictionaryFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenuItem saveItem, exitItem, addItem, editItem, deleteItem;
	private JMenu fileMenu, optionMenu;
	private ImageIcon image;
	private DictionaryPanel solve;
	public DictionaryPanel getSolve() {
		return solve;
	}
	public DictionaryFrame(){
		super("Dictionary");
		pack();
		newImplement();
		setJMenuBar(menuBar);
		setBounds(100, 100, solve.getArr().getOpen().getArrWords().getH() * 30 - 30 >> 1, 962);
		setIconImage(image.getImage());
		getContentPane().add(solve);
		getContentPane().setBackground(Color.white);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void newImplement(){
		editItem = new JMenuItem("Edit");
		solve = new DictionaryPanel();
		image = new ImageIcon(solve.getArr().getOpen().getArrWords().getADDRESSIMAGE() + "Avatar.jpg");
		menuBar = new JMenuBar();
		optionMenu = new JMenu("Option");
		deleteItem = new JMenuItem("Delete");
		addItem = new JMenuItem("Add");
		fileMenu = new JMenu("File");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");
		initMenuBar();
	}
	public void initMenuBar(){
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		optionMenu.add(addItem);
		optionMenu.add(editItem);
		optionMenu.add(deleteItem);
		menuBar.add(optionMenu);
		addItem.addActionListener(this);
		exitItem.addActionListener(this);
		saveItem.addActionListener(this);
		editItem.addActionListener(this);
		deleteItem.addActionListener(this);
		optionMenu.addActionListener(this);
		exitItem.setMnemonic(KeyEvent.VK_X);
		saveItem.setMnemonic(KeyEvent.VK_S);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		solve.resetClick();
		if(e.getSource() == exitItem){
			dispose();
		}
		else if(e.getSource() == saveItem){
			solve.getArr().getOpen().dictionaryExportToFile();
		}
		else if(e.getSource() == addItem){
			new AddVocabulary(solve.getArr().getOpen().getArrWords().getTree()).setVisible(true);
		}
		else if(e.getSource() == deleteItem){
			new DeleteVocabulary(solve.getArr().getOpen().getArrWords().getTree()).setVisible(true);
		}
		else if(e.getSource() == editItem){
			new EditVocabulary(solve.getArr().getOpen().getArrWords().getTree()).setVisible(true);
		}
	}
	
}