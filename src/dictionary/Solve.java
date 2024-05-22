package dictionary;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.ArrayList;

public class Solve extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DictionaryCommandLine arr;
	private JTextField text;
	private JTextArea valueText;
	private JLabel labelLeft, labelRight;
	private JScrollPane scrollpane, scroll;
	@SuppressWarnings("rawtypes")
	private JList listArray;

	private final int H = 60, W = 450;
	
	public Solve() {
		setLayout(null);
		arr = new DictionaryCommandLine();
		text = new JTextField();
		valueText = new JTextArea();
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
		valueText.setFont(new Font("Cambria", Font.PLAIN, 20));
		text.setFont(new Font("Cambria", Font.PLAIN, 20));
		add(labelLeft);
		add(labelRight);
		text.setText("Search");
		valueText.setEditable(false);
		text.setBounds(0, H * 2, W, H * 3 / 2 );
		ArrayList<String> list = new ArrayList<String>();
		listArray = new JList<String>(list.toArray(new String[list.size()]));
		listArray.setFixedCellHeight(H);
		listArray.setFixedCellWidth(W);
		listArray.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(final ListSelectionEvent e) {
		        if (!e.getValueIsAdjusting()) { 
		            int selectedIndex = listArray.getSelectedIndex();
		            if (selectedIndex != -1) {
		                String selectedValue = arr.dictionarySearcher(String.valueOf(listArray.getSelectedValue()), true);
		                valueText.setText(selectedValue);
		            }
		        }
		    }
		});
		text.addActionListener(this);
		scrollpane = new JScrollPane(valueText);
		scrollpane.setBounds(W, H * 2, W, H * 2);
		scroll = new JScrollPane(listArray);
		scroll.setBounds(0,  H * 2 + H * 3 / 2, W, H * 12);
		add(scrollpane);
		add(text);
		add(scroll);
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String key = text.getText();
		ArrayList<String> list = arr.dictionarySearcher(key);
		int n = list.size();
		listArray.setListData(list.toArray(new String[list.size()]));
		for(int i = 0; i < n; ++i){
			Dimension cellSize = listArray.getCellBounds(i, i).getSize();
			int fontSize = (int)(cellSize.height * 0.3);
			listArray.setFont(new Font(listArray.getFont().getName(), Font.PLAIN, fontSize));
			
		}
	}
	
}
