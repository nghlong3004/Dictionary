package Application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.*;

public class MainFrameEdit extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainFrame frame;
	private JTextField textKey, textValue;
	private JPanel panel;
	private JLabel labelKey, labelValue;
	private JButton buttonValue;
	private boolean flag = true;
	private ImageIcon image;
	private TreeMap<String, String> tree;
	
	public MainFrameEdit(TreeMap<String, String> tree) {
		// TODO Auto-generated constructor stub
		super("Edit Vocabulary");
		this.tree = tree;
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
		frame = new MainFrame();
		image = new ImageIcon(frame.getSolve().getArr().getOpen().getArrWords().getADDRESSIMAGE() + "Edit.png");
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
		String key = textKey.getText();
		String value = frame.getSolve().getArr().dictionarySearcher(key, flag);
		if(value == null){
			JOptionPane.showMessageDialog(this, "Not Found", "Message", JOptionPane.PLAIN_MESSAGE, null);
		}
		else{
			value = textValue.getText();
			tree.put(key, value);
			frame.getSolve().getArr().getOpen().getArrWords().setTree(tree);
			frame.getSolve().getArr().getOpen().dictionaryExportToFile();
			JOptionPane.showMessageDialog(this, "Successful vocabulary revision", "Message", JOptionPane.PLAIN_MESSAGE, null);
			this.dispose();
		}
		
	}
	
}
