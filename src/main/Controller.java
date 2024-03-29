package main;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.math.BigDecimal;

import enums.CurrencyUnit;
import enums.TemperatureUnit;
import util.CurrencyConverter;
import util.TemperatureConverter;
import util.ValidateInput;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class Controller extends JFrame{
	
	private JPanel contentPane;
	private JTextField inputTextField;
	private JTextField outputTextField;
	
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller frame = new Controller();
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
	public Controller() {
//		Attributes
		Font font = new Font("Montserrat", Font.PLAIN, 14);
		
		/**
		 * Window and elements setup
		 */
//		ContentPane
		setTitle("Unit Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(new MigLayout("", "[grow][grow]", "[20px][][][][25px:n][][][][grow]"));
		setContentPane(contentPane);
		
//		Label
		JLabel titleLabel = new JLabel("Choose the type of units to convert");
		titleLabel.setFont(font);
		contentPane.add(titleLabel, "cell 0 0 3 1");
		
//		TypeSelector
		JRadioButton currenciesRadioButton = new JRadioButton("Currencies");
		currenciesRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		currenciesRadioButton.setSelected(true);
		contentPane.add(currenciesRadioButton, "cell 1 1");
		
		JRadioButton temperaturesRadioButton = new JRadioButton("Temperatures");
		temperaturesRadioButton.setHorizontalAlignment(SwingConstants.RIGHT);
		temperaturesRadioButton.setFont(font);
		contentPane.add(temperaturesRadioButton, "cell 1 1");
		
		ButtonGroup units = new ButtonGroup();
		units.add(currenciesRadioButton);
		units.add(temperaturesRadioButton);
		
//		TextField
		inputTextField = new JTextField();
		inputTextField.setFont(font);
		contentPane.add(inputTextField, "cell 0 3,growx");
		
		JLabel validationErrorLabel = new JLabel();
		validationErrorLabel.setFont(font);
		validationErrorLabel.setForeground(new Color(255, 0, 0));
		validationErrorLabel.setVisible(false);
		contentPane.add(validationErrorLabel, "cell 0 4 2 1");

		outputTextField = new JTextField();
		outputTextField.setFont(font);
		outputTextField.setEditable(false);
		contentPane.add(outputTextField, "cell 0 5,growx");
		
//		UnitSelectorPane
		JPanel subSelectorTopPane = new JPanel();
		subSelectorTopPane.setLayout(new CardLayout(0, 0));
		contentPane.add(subSelectorTopPane, "cell 1 3,grow");

		JPanel subSelectorBottomPane = new JPanel();
		subSelectorBottomPane.setLayout(new CardLayout(0, 0));
		contentPane.add(subSelectorBottomPane, "cell 1 5,grow");

//		UnitSelectors
		JComboBox<CurrencyUnit> currenciesTopBox = new JComboBox<>(CurrencyUnit.values());
		currenciesTopBox.setSelectedIndex(0);
		subSelectorTopPane.add(currenciesTopBox);
		
		JComboBox<CurrencyUnit> currenciesBottomBox = new JComboBox<>(CurrencyUnit.values());
		currenciesBottomBox.setSelectedIndex(1);
		subSelectorBottomPane.add(currenciesBottomBox);
		
		JComboBox<TemperatureUnit> temperaturesTopBox = new JComboBox<>(TemperatureUnit.values());
		temperaturesTopBox.setSelectedIndex(0);
		subSelectorTopPane.add(temperaturesTopBox);
		temperaturesTopBox.setVisible(false);

		JComboBox<TemperatureUnit> temperaturesBottomBox = new JComboBox<>(TemperatureUnit.values());
		temperaturesBottomBox.setSelectedIndex(1);
		subSelectorBottomPane.add(temperaturesBottomBox);
		temperaturesBottomBox.setVisible(false);
		
//		ConvertButton
		JButton convertButton = new JButton("Convert");
		contentPane.add(convertButton, "cell 1 7");
		
//		Action listeners
		/**
		 * currenciesRadioButton
		 * temperaturesRadioButton
		 * 
		 * This action listeners change the value of witch boxes are visible
		 * depending on the radio button selected
		 */
		currenciesRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temperaturesTopBox.setVisible(false);
				temperaturesBottomBox.setVisible(false);
				currenciesTopBox.setVisible(true);
				currenciesBottomBox.setVisible(true);
			}
		});
		
		temperaturesRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temperaturesTopBox.setVisible(true);
				temperaturesBottomBox.setVisible(true);
				currenciesTopBox.setVisible(false);
				currenciesBottomBox.setVisible(false);
			}
		});
		
		/**
		 * temperaturesTopBox
		 * temperaturesBottomBox
		 * currenciesTopBox
		 * currenciesBottomBox
		 * 
		 * This action listeners change the value of the non-selected box
		 * to un-match the value of the selected one
		 * i.e: There can't be a conversion from Celsius to Celsius
		 */
		temperaturesTopBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temperaturesTopBox.getSelectedIndex() == temperaturesBottomBox.getSelectedIndex()) {
					try {
						temperaturesBottomBox.setSelectedIndex(temperaturesBottomBox.getSelectedIndex() + 1);
					} catch(Exception e1) {
						temperaturesBottomBox.setSelectedIndex(0);
					}
				}
			}
		});

		temperaturesBottomBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temperaturesBottomBox.getSelectedIndex() == temperaturesTopBox.getSelectedIndex()) {
					try {
						temperaturesTopBox.setSelectedIndex(temperaturesTopBox.getSelectedIndex() + 1);
					} catch(Exception e1) {
						temperaturesTopBox.setSelectedIndex(0);
					}
				}
			}
		});

		currenciesTopBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currenciesTopBox.getSelectedIndex() == currenciesBottomBox.getSelectedIndex()) {
					try {
						currenciesBottomBox.setSelectedIndex(currenciesBottomBox.getSelectedIndex() + 1);
					} catch(Exception e1) {
						currenciesBottomBox.setSelectedIndex(0);
					}
				}
			}
		});

		currenciesBottomBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currenciesBottomBox.getSelectedIndex() == currenciesTopBox.getSelectedIndex()) {
					try {
						currenciesTopBox.setSelectedIndex(currenciesTopBox.getSelectedIndex() + 1);
					} catch(Exception e1) {
						currenciesTopBox.setSelectedIndex(0);
					}
				}
			}
		});

		/**
		 * This action listener enables input validation in real time
		 */
		inputTextField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if (!ValidateInput.validateInput(inputTextField.getText().toString())) {
					inputTextField.setForeground(new Color(255, 0, 0));
					validationErrorLabel.setText(ValidateInput.getValidationError());
					validationErrorLabel.setVisible(true);
					convertButton.setEnabled(false);
				} else {
					inputTextField.setForeground(new Color(0, 0, 0));
					validationErrorLabel.setVisible(false);
					convertButton.setEnabled(true);
				}
			}
		});
		
		/**
		 * This action listener perfoms the conversion and return the output value
		 */
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BigDecimal inputValue = new BigDecimal(inputTextField.getText().toString());
					BigDecimal outputValue = new BigDecimal("0");
					if (currenciesRadioButton.isSelected()) {
						CurrencyUnit fromUnit = (CurrencyUnit) currenciesTopBox.getSelectedItem();
						CurrencyUnit toUnit = (CurrencyUnit) currenciesBottomBox.getSelectedItem();
						outputValue = CurrencyConverter.getConversionValue(inputValue, fromUnit, toUnit);
					} else if (temperaturesRadioButton.isSelected()) {
						TemperatureUnit fromUnit = (TemperatureUnit) temperaturesTopBox.getSelectedItem();
						TemperatureUnit toUnit = (TemperatureUnit) temperaturesBottomBox.getSelectedItem();
						outputValue = TemperatureConverter.getConversionValue(inputValue, fromUnit, toUnit);
					}
					outputTextField.setText(outputValue.toString());
				} catch (Exception e2) {
					outputTextField.setText("NaN");
				}
			}
		});
		
		
	}

}
