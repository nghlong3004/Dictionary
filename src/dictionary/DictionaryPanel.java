package dictionary;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.util.ArrayList;
import java.util.List;

public class DictionaryPanel extends JPanel{
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
	private JLabel labelLeft, labelRight, textSearch;
	private JButton voiceButton;
	private JScrollPane scrollpane, scroll;
	private JList<String> listArray;
	public DictionaryPanel() {
		setLayout(null);
		arr = new DictionaryCommandLine();
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
		voiceButton.setBounds(arr.getOpen().getArrWords().getW() * 2 - 81, arr.getOpen().getArrWords().getH() * 2 - 40, 50, 40);
		ImageIcon image = new ImageIcon(arr.getOpen().getArrWords().getADDRESSIMAGE() + "Voice.png");
		Image cur = image.getImage().getScaledInstance(50, 36, Image.SCALE_SMOOTH);
		voiceButton.setIcon(new ImageIcon(cur));
		voiceButton.setHorizontalTextPosition(JButton.CENTER);
		voiceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String key = textKey.getText();
				if(key.length() > 0){
					Thread voiceThread = new Thread(new Runnable() {
	                    @Override
	                    public void run() {
	                        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
	                        if(voice !=  null){
	                        	voice.allocate();
		                        voice.setRate(120);
		                        voice.setPitch(110);
		                        voice.speak(textKey.getText());
		                        voice.deallocate();
	                        }
	                    }
	                });
	                voiceThread.start();
				}
			}
		});
	}
	public void initializationText(){
		textKey = new JTextField();
		textValue = new JTextArea();
		textSearch = new JLabel();
		textSearch.setText("Search");
		textSearch.setBounds(0, 10, (int) (arr.getOpen().getArrWords().getW() * 0.8), (int) (arr.getOpen().getArrWords().getH() * 3 / 2 * 0.8));
		textKey.setBounds(0, arr.getOpen().getArrWords().getH() * 2, arr.getOpen().getArrWords().getW(), arr.getOpen().getArrWords().getH() * 3 / 2 );
		textSearch.setFont(new Font("Cambria", Font.PLAIN, 20));
		textValue.setFont(new Font("Cambria", Font.PLAIN, 20));
		textKey.setFont(new Font("Cambria", Font.PLAIN, 20));
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
		labelLeft.setForeground(Color.WHITE);
		labelRight.setForeground(Color.WHITE);
		labelLeft.setBounds(0, 0, arr.getOpen().getArrWords().getW(), arr.getOpen().getArrWords().getH() * 2);
		labelRight.setBounds(arr.getOpen().getArrWords().getW(), 0, arr.getOpen().getArrWords().getW(), arr.getOpen().getArrWords().getH() * 2);
		labelLeft.setBackground(Color.decode("#4263f5"));
		labelRight.setBackground(Color.decode("#4272f5"));
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
