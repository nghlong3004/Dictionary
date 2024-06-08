package Application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import Sever.Constants;
import Sever.DictionaryCommandLine;
import Sever.DictionaryHelper;
import Sever.GoogleTranslate;

public class Add extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textKey, textValue;
	private JPanel panel;
	private JLabel labelKey, labelValue;
	private JButton buttonKey, buttonValue, se;
	private ImageIcon image;
	private DictionaryPanel dictionaryPanel;
	private boolean flag = true;
	
	public Add(DictionaryPanel dictionaryPanel) {
		// TODO Auto-generated constructor stub
		super("Add Vocabulary");
		this.dictionaryPanel = dictionaryPanel;
		pack();
		handle();
		panel.setBackground(Color.white);
		setBounds(100, 100, 315, 200);
		setIconImage(image.getImage());
		getContentPane().add(panel);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public void handle(){
		se = new Button();
		panel = new JPanel();
		image = new ImageIcon(Constants.IMAGE_FILE_PATH + "add.png");
		buttonKey = new JButton("OK!!");
		buttonValue = new JButton("OK!!");
		buttonKey.setBounds((50 + 250 ) >> 1, 51, 50, 25);
		buttonKey.setFont(new Font("Cambria", Font.ITALIC, 8));
		buttonKey.setBackground(Color.white);
		buttonValue.setBounds((50 + 250 ) >> 1, 82 + 50, 50, 25);
		buttonValue.setBackground(Color.white);
		buttonValue.setFont(new Font("Cambria", Font.ITALIC, 8));
		buttonValue.addActionListener(this);
		buttonKey.addActionListener(this);
		buttonValue.setVisible(false);
		labelKey = new JLabel();
		labelValue = new JLabel();
		labelKey.setBounds(0, 0, 50, 50);
		labelValue.setBounds(0,  81, 50, 50);
		labelKey.setText("EngLish");
		se.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonPef(e);
			}
		});
		labelKey.setHorizontalAlignment(JLabel.CENTER);
		labelValue.setText("VN");
		labelValue.setHorizontalAlignment(JLabel.CENTER);
		textKey = new JTextField();
		textValue = new JTextField();
		textKey.setBounds(50, 0, 250, 50);
		textValue.setBounds(50, 81, 250, 50);
		textKey.setFont(new Font("Cambria", Font.BOLD, 18));
		textValue.setFont(new Font("Cambria", Font.BOLD, 18));
		textValue.setEditable(false);
		panel.setLayout(null);
		panel.add(buttonKey);
		panel.add(buttonValue);
		panel.add(labelKey);
		panel.add(labelValue);
		panel.add(textKey);
		panel.add(textValue);
		panel.add(se);
	}
	public void setText(String value){
		textValue.setText(value);
	}
	public void buttonPef(ActionEvent e){
		String key = textKey.getText().trim();
		key = key.substring(0, 1).toUpperCase() + key.substring(1).toLowerCase();
		String value = null;
		if(key.length() > 0){
			try {
				value = (GoogleTranslate.translate(key, "En", "vi"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			textValue.setText(value);
			flag = false;
			buttonKey.setVisible(false);
			buttonValue.setVisible(true);
			textValue.setEditable(true);
		}
		else{
			JOptionPane.showMessageDialog(this, "Error", "Message", JOptionPane.ERROR_MESSAGE);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String key = textKey.getText().trim();
		key = key.substring(0, 1).toUpperCase() + key.substring(1).toLowerCase();
		String value = DictionaryCommandLine.dictionarySearcher(key, flag);
		if(flag || value != null){
			if(value == null){
				flag = false;
				buttonKey.setVisible(false);
				buttonValue.setVisible(true);
				textValue.setEditable(true);
			}
			else{
				JOptionPane.showMessageDialog(this, "This vocabulary already exists", "Message", JOptionPane.PLAIN_MESSAGE, null);
			}
		}
		else{
			value = textValue.getText();
			dictionaryPanel.getArr().getOpen().getArrWords().getTree().put(key, DictionaryHelper.parseHTML(key, value));
			dictionaryPanel.getArr().getOpen().dictionaryExportToFile();
			JOptionPane.showMessageDialog(this, "added vocabulary successfully", "Message", JOptionPane.PLAIN_MESSAGE, null);
			this.dispose();
		}
		
	}
	
}
