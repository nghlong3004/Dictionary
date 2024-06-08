package Application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Sever.Constants;
import Sever.DictionaryCommandLine;
import Sever.DictionaryHelper;

public class Edit extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textKey, textValue;
	private JPanel panel;
	private JLabel labelKey, labelValue;
	private JButton buttonValue;
	private boolean flag = true;
	private ImageIcon image;
	private DictionaryPanel dictionaryPanel;
	
	public Edit(DictionaryPanel dictionaryPanel) {
		// TODO Auto-generated constructor stub
		super("Edit Vocabulary");
		this.dictionaryPanel = dictionaryPanel;
		pack();
		handle();
		setBounds(100, 100, 315, 200);
		panel.setBackground(Color.white);
		setIconImage(image.getImage());
		getContentPane().add(panel);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public void handle(){
		panel = new JPanel();
		image = new ImageIcon(Constants.IMAGE_FILE_PATH + "Edit.png");
		buttonValue = new JButton("OK!!");
		buttonValue.setBounds(( 250 )>> 1, 102, 50, 30);
		buttonValue.setBackground(Color.white);
		buttonValue.setFont(new Font("Cambria", Font.ITALIC, 8));
		buttonValue.addActionListener(this);
		labelKey = new JLabel();
		labelValue = new JLabel();
		labelKey.setBounds(0, 0, 50, 50);
		labelValue.setBounds(0, 51, 50, 25);
		labelKey.setText("EngLish");
		labelKey.setHorizontalAlignment(JLabel.CENTER);
		labelValue.setText("VN");
		labelValue.setHorizontalAlignment(JLabel.CENTER);
		textKey = new JTextField();
		textValue = new JTextField();
		textKey.setBounds(50, 0, 250, 50);
		textValue.setBounds(50, 51, 250, 50);
		textKey.setFont(new Font("Cambria", Font.BOLD, 18));
		textValue.setFont(new Font("Cambria", Font.BOLD, 18));
		panel.setLayout(null);
		panel.add(buttonValue);
		panel.add(labelKey);
		panel.add(labelValue);
		panel.add(textKey);
		panel.add(textValue);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String key = textKey.getText().trim();
		key = key.substring(0, 1).toUpperCase() + key.substring(1).toLowerCase();
		String value = DictionaryCommandLine.dictionarySearcher(key, flag);
		if(value == null){
			JOptionPane.showMessageDialog(this, "Not Found", "Message", JOptionPane.PLAIN_MESSAGE, null);
		}
		else{
			value = textValue.getText();
			dictionaryPanel.getArr().getOpen().getArrWords().getTree().put(key, DictionaryHelper.parseHTML(key, value));
			dictionaryPanel.getArr().getOpen().dictionaryExportToFile();
			JOptionPane.showMessageDialog(this, "Successful vocabulary revision", "Message", JOptionPane.PLAIN_MESSAGE, null);
			this.dispose();
		}
		
	}
	
}
