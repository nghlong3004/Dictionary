package Application;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Sever.Dictionary;
import Sever.DictionaryCommandLine;
import Sever.GoogleAudio;

import java.util.ArrayList;

public class Panel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final boolean flag = true;
	private DictionaryCommandLine arr;
	private SelectLanguage languages;
	public DictionaryCommandLine getArr() {
		return arr;
	}
	private JTextField textKey;
	private JEditorPane textValue;
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
	public Panel() {
		setLayout(null);
		newElement();
		setBound();
		newText();
		newLabel();
		newList();
		evenText();
		eventList();
		voice();
		addImplement();
	}
	public void newElement(){
		arr = new DictionaryCommandLine();
		voiceButton = new JButton();
		languages = new SelectLanguage();
		textKey = new JTextField();
		textValue = new JEditorPane();
		textSearch = new JLabel();
		labelLeft = new JLabel();
		labelRight = new JLabel();
		ArrayList<String> list = new ArrayList<String>();
		listArray = new JList<String>(list.toArray(new String[list.size()]));
		scrollpane = new JScrollPane(textValue);
		scroll = new JScrollPane(listArray);
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
		labelLeft.add(languages);
		this.add(labelLeft);
		this.add(voiceButton);
		this.add(labelRight);
		this.add(scrollpane);
		this.add(textKey);
		this.add(scroll);
	}
	public void setBound(){
		this.setBounds(0, 0, new Dictionary().getH() * 30 - 30 >> 1, 962);
		scrollpane.setBounds(new Dictionary().getW(), new Dictionary().getH() * 2, new Dictionary().getW() - 30, new Dictionary().getH() * 13);
		scroll.setBounds(0,  new Dictionary().getH() * 2 + new Dictionary().getH() * 3 / 2, new Dictionary().getW(), new Dictionary().getH() * 11 + new Dictionary().getH() * 3 / 6);
		textSearch.setBounds(2, 1, (int) (new Dictionary().getW() * 0.8), (int) (new Dictionary().getH() * 3 / 2 * 0.8));
		textKey.setBounds(45, new Dictionary().getH() * 2 + 10, (int) (new Dictionary().getW() * 0.8), (int) (new Dictionary().getH() * 3 / 2 * 0.8) );
		labelLeft.setBounds(0, 0, new Dictionary().getW(), new Dictionary().getH() * 2);
		labelRight.setBounds(new Dictionary().getW(), 0, new Dictionary().getW(), new Dictionary().getH() * 2);
		voiceButton.setBounds((int) (new Dictionary().getW() * 0.9) + 1, new Dictionary().getH() * 2 + 25, 40, 40);
	}
	public void voice(){
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
								new GoogleAudio().speak(languages.getSelectedLanguageCode(),key);
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

	public void newText(){
		textValue.setContentType("text/html");
		textKey.setBackground(Color.WHITE);
		textSearch.setText("Search");
		textValue.setText("Definition");
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
	public void newLabel(){
		labelLeft.setText("Advanced English Dictionary");
		labelRight.setText("Definition");
		labelLeft.setHorizontalAlignment(SwingConstants.CENTER);
		labelRight.setHorizontalAlignment(SwingConstants.LEFT);
		labelRight.setVerticalAlignment(SwingConstants.BOTTOM);
		labelLeft.setForeground(Color.BLACK);
		ImageIcon image = new ImageIcon(new Dictionary().getADDRESSIMAGE() + "gg_translate.gif");
		labelRight.setIcon(new ImageIcon(image.getImage().getScaledInstance(arr.getOpen().getArrWords().getW(), arr.getOpen().getArrWords().getH() * 2, Image.SCALE_DEFAULT)));
		labelLeft.setBackground(Color.decode("#4263f5"));
		labelLeft.setOpaque(true);
		labelRight.setOpaque(true);
	}
	public void newList(){
		listArray.setFixedCellHeight(arr.getOpen().getArrWords().getH());
		listArray.setFixedCellWidth(arr.getOpen().getArrWords().getW());
		listArray.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	public void eventList(){
		listArray.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
		        if (!e.getValueIsAdjusting()) { 
		            String selectedValue = listArray.getSelectedValue();
		            if(selectedValue != null){
		            	String stringValue = arr.dictionarySearcher(selectedValue, flag);
			            textValue.setText(stringValue == null ? "" : stringValue);
		            }
		        }
		    }
		});
	}
	public void evenText() {
	    textKey.getDocument().addDocumentListener(new DocumentListener() {
	        @Override
	        public void insertUpdate(DocumentEvent e) {
	            updateSearchResults();
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            updateSearchResults();
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {  }
	    });
	    textKey.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String key = textKey.getText();
		        String value = arr.dictionarySearcher(key, flag);
		        textValue.setText(value == null ? "Not Found!!" : value);
			}
		});
	}
	private void updateSearchResults() {
	    String key = textKey.getText();
	    textSearch.setText(key.isEmpty() ? "Search" : "");
	    textSearch.setVisible(key.isEmpty());
	    ArrayList<String> list = arr.dictionarySearcher(key);
	    listArray.setListData(list.toArray(new String[0]));
	    if (!list.isEmpty()) {
	        Dimension cellSize = listArray.getCellBounds(0, 0).getSize();
	        int fontSize = (int) (cellSize.height * 0.3);
	        listArray.setFont(new Font(listArray.getFont().getName(), Font.PLAIN, fontSize));
	    }
	}
	
}
