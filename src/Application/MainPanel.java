package Application;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Sever.Dictionary;
import Sever.DictionaryCommandLine;
import Sever.GoogleTranslate;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final boolean flag = true;
	private DictionaryCommandLine arr;
	public DictionaryCommandLine getArr() {
		return arr;
	}
	private JTextField textKey;
	private JTextArea textValue;
	public JTextField getTextKey() {
		return textKey;
	}
	private JLabel labelLeft, labelRight, textSearch;
	public void setLabelLeft(JLabel labelLeft) {
		this.labelLeft = labelLeft;
	}
	public JLabel getLabelLeft() {
		return labelLeft;
	}
	private JButton voiceButton;
	private JScrollPane scrollpane, scroll;
	private JList<String> listArray;
	public MainPanel() {
		setLayout(null);
		arr = new DictionaryCommandLine();
		setBounds(0, 0, arr.getOpen().getArrWords().getH() * 30 - 30 >> 1, 962);
		initializationText();
		initializationJlabel();
		initializationHandleJlist();
		initHandleEventText();
		initHandleEventJlist();
		initializationJbutton();
		initializationJScrollPane();
		addImplement();
	}
	public void resetClick(){
		textKey.setText("");
		textValue.setText("");
		textSearch.setText("Search");
		textSearch.setVisible(true);
		ArrayList<String> list = new ArrayList<String>();
		listArray.setListData(list.toArray(new String[list.size()]));
	}
	public void addImplement(){
		add(labelLeft);
		add(voiceButton);
		add(labelRight);
		add(scrollpane);
		add(textKey);
		add(scroll);
	}
	public void initializationJScrollPane(){
		scrollpane = new JScrollPane(textValue);
		scrollpane.setBounds(arr.getOpen().getArrWords().getW(), arr.getOpen().getArrWords().getH() * 2, arr.getOpen().getArrWords().getW() - 30, arr.getOpen().getArrWords().getH() * 13);
		scroll = new JScrollPane(listArray);
		scroll.setBounds(0,  arr.getOpen().getArrWords().getH() * 2 + arr.getOpen().getArrWords().getH() * 3 / 2, arr.getOpen().getArrWords().getW(), arr.getOpen().getArrWords().getH() * 11 + arr.getOpen().getArrWords().getH() * 3 / 6);
	}
	public void initializationJbutton(){
		voiceButton = new JButton();
		voiceButton.setBounds((int) (arr.getOpen().getArrWords().getW() * 0.9) + 1, arr.getOpen().getArrWords().getH() * 2 + 25, 40, 40);
		ImageIcon image = new ImageIcon(arr.getOpen().getArrWords().getADDRESSIMAGE() + "Voice.png");
		Image cur = image.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		voiceButton.setIcon(new ImageIcon(cur));
		voiceButton.setBackground(Color.white);
		voiceButton.setFocusable(false);
		voiceButton.setHorizontalTextPosition(JButton.CENTER);
		voiceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				final String key = textKey.getText();
				if(key.length() > 0){
					Thread voiceThread = new Thread(new Runnable() {
	                    @SuppressWarnings("static-access")
						@Override
	                    public void run() {
							try {
								new GoogleTranslate().speak(key);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	                    }
	                });
	                voiceThread.start();
				}
			}
		});
	}
	public void menuEvent(ActionEvent e){
		System.out.println("aa");
	}
	public void initializationText(){
		textKey = new JTextField();
		textValue = new JTextArea();
		textKey.setBackground(Color.WHITE);
		textSearch = new JLabel();
		textSearch.setText("Search");
		textValue.setText("Definition");
		textSearch.setBounds(2, 1, (int) (arr.getOpen().getArrWords().getW() * 0.8), (int) (arr.getOpen().getArrWords().getH() * 3 / 2 * 0.8));
		textKey.setBounds(45, arr.getOpen().getArrWords().getH() * 2 + 10, (int) (arr.getOpen().getArrWords().getW() * 0.8), (int) (arr.getOpen().getArrWords().getH() * 3 / 2 * 0.8) );
		textSearch.setFont(new Font("Cambria", Font.PLAIN, 20));
		textValue.setFont(new Font("Cambria", Font.PLAIN, 20));
		textKey.setFont(new Font("Cambria", Font.PLAIN, 20));
		textKey.setForeground(Color.black);
		textKey.setCaretColor(Color.black);
		textSearch.setForeground(Color.black);
		textKey.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		textKey.add(textSearch);
		textValue.setEditable(false);
	}
	public void initializationJlabel(){
		labelLeft = new JLabel();
		labelRight = new JLabel();
		labelLeft.setText("Advanced English Dictionary");
		labelRight.setText("Definition");
		labelLeft.setHorizontalAlignment(SwingConstants.CENTER);
		labelRight.setHorizontalAlignment(SwingConstants.LEFT);
		labelRight.setVerticalAlignment(SwingConstants.BOTTOM);
		labelLeft.setForeground(Color.BLACK);
		labelLeft.setBounds(0, 0, arr.getOpen().getArrWords().getW(), arr.getOpen().getArrWords().getH() * 2);
		ImageIcon image = new ImageIcon(new Dictionary().getADDRESSIMAGE() + "gg_translate.gif");
		labelRight.setIcon(new ImageIcon(image.getImage().getScaledInstance(arr.getOpen().getArrWords().getW(), arr.getOpen().getArrWords().getH() * 2, Image.SCALE_DEFAULT)));
		labelRight.setBounds(arr.getOpen().getArrWords().getW(), 0, arr.getOpen().getArrWords().getW(), arr.getOpen().getArrWords().getH() * 2);
		labelLeft.setBackground(Color.decode("#4263f5"));
		labelLeft.setOpaque(true);
		labelRight.setOpaque(true);
	}
	public void initializationHandleJlist(){
		ArrayList<String> list = new ArrayList<String>();
		listArray = new JList<String>(list.toArray(new String[list.size()]));
		listArray.setFixedCellHeight(arr.getOpen().getArrWords().getH());
		listArray.setFixedCellWidth(arr.getOpen().getArrWords().getW());
		listArray.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	}
	public void initHandleEventJlist(){
		listArray.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
		        if (!e.getValueIsAdjusting()) { 
		            List<String> selectedValue = listArray.getSelectedValuesList();
		            String stringValue = "", stringKey = "";
		            int i = 0;
		            for(String key : selectedValue){
		            	stringValue += arr.dictionarySearcher(key, flag) + '\n';
		            	if(i > 0){
		            		stringKey += ", ";
		            	}
		            	stringKey += key;
		            	++i;
		            }
		            textValue.setText(stringValue);
		            textKey.setText(stringKey);
		        }
		    }
		});
	}
	public void initHandleEventText(){
		textKey.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				char c = e.getKeyChar();
				textSearch.setText("");
				textSearch.setVisible(false);
				String key = textKey.getText();
				if(c != (char)8){
					key += c;
				}
				if(key.length() == 0){
					textSearch.setText("Search");
					textSearch.setVisible(true);
				}
				ArrayList<String> list = arr.dictionarySearcher(key);
				int n = list.size();
				listArray.setListData(list.toArray(new String[list.size()]));
				for(int i = 0; i < n; ++i){
					Dimension cellSize = listArray.getCellBounds(i, i).getSize();
					int fontSize = (int)(cellSize.height * 0.3);
					listArray.setFont(new Font(listArray.getFont().getName(), Font.PLAIN, fontSize));
					
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		textKey.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String key = textKey.getText();
				String value = arr.dictionarySearcher(key, flag);
				if(value == null){
					textValue.setText("Not Found!!");
				}
				else{
					textValue.setText(value);
				}
			}
		});
	}
	
}
