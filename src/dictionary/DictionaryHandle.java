package dictionary;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

import java.util.ArrayList;
import java.util.List;

public class DictionaryHandle extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int H = 60, W = 450;
	private final boolean flag = true;
	private DictionaryCommandLine arr;
	public DictionaryCommandLine getArr() {
		return arr;
	}
	private JTextField textKey;
	private JTextArea textValue;
	private JLabel labelLeft, labelRight, textSearch;
	private JScrollPane scrollpane, scroll;
	private JList<String> listArray;
	
	public DictionaryHandle() {
		setLayout(null);
		arr = new DictionaryCommandLine();
		initializationText();
		initializationJlabel();
		initializationHandleJlist();
		initHandleEventText();
		initHandleEventJlist();
		scrollpane = new JScrollPane(textValue);
		scrollpane.setBounds(W, H * 2, W, H * 12 + H);
		scroll = new JScrollPane(listArray);
		scroll.setBounds(0,  H * 2 + H * 3 / 2, W, H * 11);
		add(labelLeft);
		add(labelRight);
		add(scrollpane);
		add(textKey);
		add(scroll);
	}
	public void initializationText(){
		textKey = new JTextField();
		textValue = new JTextArea();
		textSearch = new JLabel();
		textSearch.setText("Search");
		textSearch.setBounds(0, 10, (int) (W * 0.8), (int) (H * 3 / 2 * 0.8));
		textSearch.setFont(new Font("Cambria", Font.PLAIN, 20));
		textValue.setFont(new Font("Cambria", Font.PLAIN, 20));
		textKey.setFont(new Font("Cambria", Font.PLAIN, 20));
		textKey.add(textSearch);
		textValue.setEditable(false);
		textKey.setBounds(0, H * 2, W, H * 3 / 2 );
	}
	public void initializationJlabel(){
		labelLeft = new JLabel();
		labelRight = new JLabel();
		labelLeft.setText("Advanced English Dictionary");
		labelLeft.setHorizontalAlignment(SwingConstants.CENTER);
		labelLeft.setForeground(Color.WHITE);
		labelLeft.setBounds(0, 0, W, H * 2);
		labelLeft.setBackground(Color.decode("#4263f5"));
		labelLeft.setOpaque(true);
		labelRight.setText("Definition");
		labelRight.setBounds(W, 0, W, H * 2);
		labelRight.setForeground(Color.WHITE);
		labelRight.setHorizontalAlignment(SwingConstants.LEFT);
		labelRight.setVerticalAlignment(SwingConstants.BOTTOM);
		labelRight.setBackground(Color.decode("#4272f5"));
		labelRight.setOpaque(true);
	}
	public void initializationHandleJlist(){
		ArrayList<String> list = new ArrayList<String>();
		listArray = new JList<String>(list.toArray(new String[list.size()]));
		listArray.setFixedCellHeight(H);
		listArray.setFixedCellWidth(W);
		listArray.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	}
	public void initHandleEventJlist(){
		listArray.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
		        if (!e.getValueIsAdjusting()) { 
		            List<String> selectedValue = listArray.getSelectedValuesList();
		            String s = "";
		            for(String key : selectedValue){
		            	s += arr.dictionarySearcher(key, flag) + '\n';
		            }
		            textValue.setText(s);
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
