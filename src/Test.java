import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Test {
	private JFrame frame;
	JProgressBar pro;
	public Test() {
		pro = new JProgressBar();
		pro.setValue(0);
		pro.setBounds(0, 0, 400 , 50);
		pro.setStringPainted(true);
		frame = new JFrame();
		frame.add(pro);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(417, 90);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		fill();
	}
	public void fill() {
		int i = 0;
		while(i <= 100) {
			pro.setValue(i);
			++i;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		frame.setVisible(false);
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
