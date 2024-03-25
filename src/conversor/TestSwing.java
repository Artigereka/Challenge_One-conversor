package conversor;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TestSwing {
	
	public static void main(String[] args) {
		
//		Component JFrame
		JFrame miJFrame = new JFrame("Example - Java Swing");
		miJFrame.setSize(500, 300);
		
//		Component JPanel
		JPanel miJPanel = new JPanel();
		miJPanel.setSize(300, 300);
		
//		This design is for centering the components
		miJPanel.setLayout(new GridBagLayout());
		
//		Component JTextField
		JLabel miJLabel = new JLabel();
		miJLabel.setText("Write your opinion about Java Swing:	");
		
//		Component JTextArea
		JTextArea miJTextArea = new JTextArea(5, 20);

//		Connect the components JLabel and JTextField in JPanel
		miJPanel.add(miJLabel);
		miJPanel.add(miJTextArea);

//		Connect JPanel to JFrame
		miJFrame.add(miJPanel);

//		Make JFrame visible
		miJFrame.setVisible(true);
		
	}

}
