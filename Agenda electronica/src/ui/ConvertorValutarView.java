package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import controller.AgendaElectronicaController;

public class ConvertorValutarView extends JPanel  {
	private JPanel mainPanel;
	private JTextField fromText;
	private JTextField toText;
	private AgendaElectronicaController agendaElectronicaController;

	public ConvertorValutarView (JPanel mainPanel,  AgendaElectronicaController agendaElectronicaController) {
		this.mainPanel = mainPanel;
		this.agendaElectronicaController = agendaElectronicaController;
		initialize();

	}

	private void initialize() {
		
setLayout(null);
		
		fromText = new JTextField();
		fromText.setHorizontalAlignment(SwingConstants.RIGHT);
		fromText.setBounds(173, 33, 86, 20);
		add(fromText);
		fromText.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				mainPanel.setVisible(true);
			}
		});
		btnBack.setBounds(29, 210, 89, 23);
		add(btnBack);
		
		JButton btnConvert = new JButton("Convert");
		
		btnConvert.setBounds(206, 210, 89, 23);
		add(btnConvert);
		
		JLabel lblFrom = new JLabel(" from");
		lblFrom.setBounds(10, 33, 50, 20);
		add(lblFrom);
		
		JComboBox fromCombo = new JComboBox();
		fromCombo.setModel(new DefaultComboBoxModel(new String[] {"Ron", "Eur", "Usd"}));
		fromCombo.setBounds(55, 33, 108, 20);
		add(fromCombo);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setBounds(10, 96, 46, 14);
		add(lblTo);
		
		JComboBox toCombo = new JComboBox();
		toCombo.setModel(new DefaultComboBoxModel(new String[] {"Ron", "Eur", "Usd"}));
		toCombo.setBounds(55, 93, 108, 20);
		add(toCombo);
		
		toText = new JTextField();
		toText.setEditable(false);
		toText.setHorizontalAlignment(SwingConstants.RIGHT);
		toText.setBounds(173, 93, 86, 20);
		add(toText);
		toText.setColumns(10);
		
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String from=fromCombo.getSelectedItem().toString();
				String to=toCombo.getSelectedItem().toString();
				double number=Double.parseDouble(fromText.getText());
				double rezultat=agendaElectronicaController.convert(from, to, number);
				toText.setText(rezultat+"");
			}
		});

}
}