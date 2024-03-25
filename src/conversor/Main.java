package conversor;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class Main extends JFrame{
	
	private JPanel contentPane;
	private JTextField inputTextField;
	private JTextField outputTextField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Main() {
		// Atributes
		Font font = new Font("Montserrat", Font.PLAIN, 14);
		String[] currenciesList = { "MXN", "USD", "EUR", "GBP", "JPY", "NZD" };
		String[] temperaturesList = { "C°", "F°", "K°" };
		
		setTitle("Conversor de unidades");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][]", "[][][][][][]"));
		
		JLabel titleLabel = new JLabel("Choose the type of units to convert");
		titleLabel.setFont(font);
		contentPane.add(titleLabel, "cell 0 0 3 1");


		// Text fields
		inputTextField = new JTextField();
		inputTextField.setFont(font);
		contentPane.add(inputTextField, "cell 0 3,growx");
		inputTextField.setColumns(10);
		
		JButton convertButton = new JButton("Convert");
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String obtainedInput = inputTextField.getText();
				outputTextField.setText(obtainedInput + "convert");
			}
		});
		contentPane.add(convertButton, "cell 2 4");

		outputTextField = new JTextField();
		outputTextField.setFont(font);
		outputTextField.setEditable(false);
		contentPane.add(outputTextField, "cell 0 5,growx");
		outputTextField.setColumns(10);

		JComboBox<?> currenciesTopBox = new JComboBox<>(currenciesList);
		currenciesTopBox.setSelectedIndex(0);
		contentPane.add(currenciesTopBox, "cell 1 3,growx");

		JComboBox<?> currenciesBottomBox = new JComboBox<>(currenciesList);
		currenciesBottomBox.setSelectedIndex(1);
		contentPane.add(currenciesBottomBox, "cell 1 5,growx");

		JComboBox<?> temperaturesTopBox = new JComboBox<>(currenciesList);
		temperaturesTopBox.setSelectedIndex(0);
		contentPane.add(temperaturesTopBox, "cell 1 3,growx");

		JComboBox<?> temperaturesBottomBox = new JComboBox<>(temperaturesList);
		temperaturesBottomBox.setSelectedIndex(1);
		contentPane.add(temperaturesBottomBox, "cell 1 5,growx");

		temperaturesTopBox.setVisible(false);
		temperaturesBottomBox.setVisible(false);

		// UnitsSelector
		JRadioButton currenciesRadioButton = new JRadioButton("Currencies");
		currenciesRadioButton.setFont(font);
		currenciesRadioButton.setSelected(true);
		currenciesRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				selectedList = currenciesList;
				temperaturesTopBox.setVisible(false);
				temperaturesBottomBox.setVisible(false);
				currenciesTopBox.setVisible(true);
				currenciesBottomBox.setVisible(true);
			}
		});
		contentPane.add(currenciesRadioButton, "cell 0 1");

		JRadioButton temperaturesRadioButton = new JRadioButton("Temperatures");
		temperaturesRadioButton.setFont(font);
		temperaturesRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temperaturesTopBox.setVisible(true);
				temperaturesBottomBox.setVisible(true);
				currenciesTopBox.setVisible(false);
				currenciesBottomBox.setVisible(false);
			}
		});
		contentPane.add(temperaturesRadioButton, "cell 1 1");

		ButtonGroup units = new ButtonGroup();
		units.add(currenciesRadioButton);
		units.add(temperaturesRadioButton);
		
	}

}
