package dictionary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.*;

public class AddVocabulary extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DictionaryFrame frame;
	private JTextField textKey, textValue;
	private JPanel panel;
	private JLabel labelKey, labelValue;
	private JButton buttonKey, buttonValue;
	private ImageIcon image;
	private boolean flag = true;
	private TreeMap<String, String> tree;
	
	public AddVocabulary(TreeMap<String, String> tree) {
		// TODO Auto-generated constructor stub
		super("Add Vocabulary");
		this.tree = tree;
		pack();
		handle();
		setBounds(100, 100, 315, 200);
		setIconImage(image.getImage());
		getContentPane().add(panel);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public void handle(){
		panel = new JPanel();
		frame = new DictionaryFrame();
		image = new ImageIcon(frame.getSolve().getArr().getOpen().getArrWords().getADDRESSIMAGE() + "Add.png");
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
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String key = textKey.getText();
		String value = frame.getSolve().getArr().dictionarySearcher(key, flag);
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
			tree.put(key, value);
			frame.getSolve().getArr().getOpen().getArrWords().setTree(tree);
			frame.getSolve().getArr().getOpen().dictionaryExportToFile();
			JOptionPane.showMessageDialog(this, "added vocabulary successfully", "Message", JOptionPane.PLAIN_MESSAGE, null);
			this.dispose();
		}
		
	}
	
}
