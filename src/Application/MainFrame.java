package Application;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenuItem saveItem, exitItem;
	private JButton addItem, deleteItem, editItem;
	private JMenu fileMenu;
	private ImageIcon image;
	private MainPanel solve;
	private MainPanelSmall menuPanel;
	private JButton buttonMenu ;
	public void setButtonMenu(JButton buttonMenu) {
		this.buttonMenu = buttonMenu;
	}
	public MainPanel getSolve() {
		return solve;
	}
	public MainFrame(){
		super("Dictionary");
		pack();
		newImplement();
		setJMenuBar(menuBar);
		setBounds(0, 0, solve.getArr().getOpen().getArrWords().getH() * 30 - 30 >> 1, 962);
		image = new ImageIcon(solve.getArr().getOpen().getArrWords().getADDRESSIMAGE() + "Avatar.jpg");
		setIconImage(image.getImage());
		add(menuPanel);
		add(solve);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void menuEvent(ActionEvent e){
		this.buttonMenu.setVisible(false);
		solve.getTextKey().setEditable(false);
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i <= 400; ++i){
					try {
						menuPanel.setBounds(0, 0, i, 962);
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	public void newImplement(){
		solve = new MainPanel();
		buttonMenu = new JButton();
		menuPanel = new MainPanelSmall(buttonMenu, solve.getTextKey());
		editItem = menuPanel.getEdit();
		menuBar = new JMenuBar();
		deleteItem = menuPanel.getDelete();
		addItem = menuPanel.getAdd();
		fileMenu = new JMenu("File");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");
		image = new ImageIcon(solve.getArr().getOpen().getArrWords().getADDRESSIMAGE() + "Menus.png");
		initMenuBar();
	}
	public void initMenuBar(){
		buttonMenu.setIcon(new ImageIcon(image.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH)));
		buttonMenu.setBackground(Color.white);
		buttonMenu.setBounds(0, 0, 50, 40);
		buttonMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menuEvent(e);
			}
		});
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		addItem.addActionListener(this);
		exitItem.addActionListener(this);
		saveItem.addActionListener(this);
		editItem.addActionListener(this);
		deleteItem.addActionListener(this);
		exitItem.setMnemonic(KeyEvent.VK_X);
		saveItem.setMnemonic(KeyEvent.VK_S);
		JLabel temp = solve.getLabelLeft();
		menuPanel.setAdd(addItem);
		menuPanel.setDelete(deleteItem);
		menuPanel.setEdit(editItem);
		temp.add(buttonMenu);
		solve.setLabelLeft(temp);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == exitItem){
			dispose();
		}
		else if(e.getSource() == saveItem){
			solve.getArr().getOpen().dictionaryExportToFile();
		}
		else if(e.getSource() == addItem){
			new MainFrameAdd(solve.getArr().getOpen().getArrWords().getTree()).setVisible(true);
		}
		else if(e.getSource() == deleteItem){
			new MainFrameDelete(solve.getArr().getOpen().getArrWords().getTree()).setVisible(true);
		}
		else if(e.getSource() == editItem){
			new MainFrameEdit(solve.getArr().getOpen().getArrWords().getTree()).setVisible(true);
		}
	}
	
}