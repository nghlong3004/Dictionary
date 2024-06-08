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
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import Sever.Dictionary;

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
	private Panel solve;
	private Menu menuPanel;
	private JButton buttonMenu, exit;
	private JLayeredPane layeredPane;
	public void setButtonMenu(JButton buttonMenu) {
		this.buttonMenu = buttonMenu;
	}
	public Panel getSolve() {
		return solve;
	}
	public MainFrame(){
		super("Dictionary");
		pack();
		newImplement();
		setJMenuBar(menuBar);
		setBounds(0, 0, solve.getArr().getOpen().getArrWords().getH() * 30 - 30 >> 1, 962);
		image = new ImageIcon(solve.getArr().getOpen().getArrWords().getADDRESSIMAGE() + "avatar.jpg");
		setIconImage(image.getImage());
	    add(layeredPane);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void menuEvent(ActionEvent e) {
	    this.buttonMenu.setVisible(false);
	    solve.resetClick();
	    Timer animationTimer = new Timer(0, new ActionListener() {
	        private int startWidth = 0;
	        private int targetWidth = 400;
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

	            menuPanel.setBounds(0, 0, currentWidth, 962);
	        }
	    });

	    animationTimer.start();
	}

	private double easeOutCubic(double t) {
	    return 1 - Math.pow(1 - t, 3);
	}
	public void newImplement(){
		solve = new Panel();
		exit = new JButton();
		buttonMenu = new JButton();
		menuPanel = new Menu();
		editItem = menuPanel.getEdit();
		menuBar = new JMenuBar();
		deleteItem = menuPanel.getDelete();
		addItem = menuPanel.getAdd();
		fileMenu = new JMenu("File");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");
		exit.setFocusable(false);
		buttonMenu.setFocusable(false);
		image = new ImageIcon(new Dictionary().getADDRESSIMAGE() + "arrow-left.png");
		exit.setIcon(new ImageIcon(image.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		exit.setBounds(380, 0, 20, 20);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menuPanel.exitMenu(e);
				buttonMenu.setVisible(true);
			}
		});
		menuPanel.textLabel.add(exit);
		image = new ImageIcon(solve.getArr().getOpen().getArrWords().getADDRESSIMAGE() + "Menus.png");
		layeredPane = new JLayeredPane();
		layeredPane.add(menuPanel, JLayeredPane.PALETTE_LAYER);
	    layeredPane.add(solve, JLayeredPane.DEFAULT_LAYER);
	    layeredPane.moveToFront(menuPanel); 
		initMenuBar();
	}
	public void initMenuBar(){
		buttonMenu.setIcon(new ImageIcon(image.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
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
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setAccelerator(KeyStroke.getKeyStroke("control X"));
		saveItem.setAccelerator(KeyStroke.getKeyStroke("control S"));
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
			new Add(solve).setVisible(true);
		}
		else if(e.getSource() == deleteItem){
			new Delete(solve).setVisible(true);
		}
		else if(e.getSource() == editItem){
			new Edit(solve).setVisible(true);
		}
	}
	
}