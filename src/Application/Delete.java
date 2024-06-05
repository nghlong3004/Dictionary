package Application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Sever.DictionaryCommandLine;
import Sever.DictionaryManagement;

public class Delete extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainFrame frame;
	private JTextField textKey;
	private JPanel panel;
	private JLabel labelKey;
	private JButton buttonKey;
	private boolean flag = true;
	private Map<String, String> tree;
	
	public Delete(Map<String, String> tree) {
		super("Delete");
		this.tree = tree;
		pack();
		handle();
		setBounds(100, 100, 315, 200);
		panel.setBackground(Color.white);
		getContentPane().add(panel);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void handle(){
		panel = new JPanel();
		frame = new MainFrame();
		buttonKey = new JButton("OK!!");
		buttonKey.setBounds(250 >> 1, 110, 50, 30);
		buttonKey.setFont(new Font("Cambria", Font.ITALIC, 8));
		buttonKey.setBackground(Color.white);
		buttonKey.addActionListener(this);
		labelKey = new JLabel();
		labelKey.setBounds(0, 30, 50, 70);
		labelKey.setText("EngLish");
		labelKey.setHorizontalAlignment(JLabel.CENTER);
		textKey = new JTextField();
		textKey.setFont(new Font("Cambria", Font.BOLD, 18));
		textKey.setBounds(50, 30, 230, 70);
		panel.setLayout(null);
		panel.add(buttonKey);
		panel.add(labelKey);
		panel.add(textKey);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String key = textKey.getText();
		String value = new DictionaryCommandLine().dictionarySearcher(key, flag);
		if(value != null){
			tree.remove(key);
			JOptionPane.showMessageDialog(this, "Delete vocabulary successfully", "Message", JOptionPane.PLAIN_MESSAGE, null);
			new DictionaryManagement().dictionaryExportToFile();
			this.dispose();
		}
		else{
			JOptionPane.showMessageDialog(this, "Not Found", "Message", JOptionPane.PLAIN_MESSAGE, null);
		}
	}
	
	
	
}
