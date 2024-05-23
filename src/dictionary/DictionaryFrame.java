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
	private JMenuItem saveItem, exitItem, addItem, editItem;
	private JMenu fileMenu, optionMenu;
	private ImageIcon image;
	private DictionaryHandle solve;
	public DictionaryFrame(){
		super("Dictionary");
		pack();
		newImplement();
		setJMenuBar(menuBar);
		setBounds(100, 100, 915, 962);
		setIconImage(image.getImage());
		getContentPane().add(solve);
		getContentPane().setBackground(Color.white);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void newImplement(){
		editItem = new JMenuItem("edit");
		solve = new DictionaryHandle();
		image = new ImageIcon(solve.getArr().getOpen().getArrWords().getADDRESSIMAGE() + "Avatar.jpg");
		menuBar = new JMenuBar();
		optionMenu = new JMenu("option");
		addItem = new JMenuItem("add");
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
		menuBar.add(optionMenu);
		addItem.addActionListener(this);
		exitItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.setMnemonic(KeyEvent.VK_X);
		saveItem.setMnemonic(KeyEvent.VK_S);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getSource().toString();
		System.out.println(s);
		if(e.getSource() == exitItem){
			dispose();
		}
		else if(e.getSource() == saveItem){
			solve.getArr().getOpen().dictionaryExportToFile();
		}
		
	}
	
}
;