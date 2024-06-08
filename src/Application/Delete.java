package Application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Sever.Dictionary;
public class Delete extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textKey;
	private JPanel panel;
	private JLabel labelKey;
	private JButton buttonKey;
	private ImageIcon image;
	private boolean flag = true;
	private Panel solve;
	
	public Delete(Panel solve) {
		super("Delete");
		this.solve = solve;
		pack();
		handle();
		setBounds(100, 100, 315, 200);
		setIconImage(image.getImage());
		panel.setBackground(Color.white);
		getContentPane().add(panel);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void handle(){
		panel = new JPanel();
		buttonKey = new JButton("OK!!");
		image = new ImageIcon(new Dictionary().getADDRESSIMAGE() + "remove.png");
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
		key = key.substring(0, 1).toUpperCase() + key.substring(1).toLowerCase();
		String value = solve.getArr().dictionarySearcher(key, flag);
		if(value != null){
			solve.getArr().getOpen().getArrWords().getTree().remove(key);
			JOptionPane.showMessageDialog(this, "Delete vocabulary successfully", "Message", JOptionPane.PLAIN_MESSAGE, null);
			solve.getArr().getOpen().dictionaryExportToFile();
			this.dispose();
		}
		else{
			JOptionPane.showMessageDialog(this, "Not Found", "Message", JOptionPane.PLAIN_MESSAGE, null);
		}
	}
	
	
	
}
