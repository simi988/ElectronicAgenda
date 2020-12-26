package ui;

import javax.swing.JPanel;

import controller.AgendaElectronicaController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Label;

public class CalculatorView extends JPanel {
	private AgendaElectronicaController agendaElectronicaController;
	private JPanel mainPanel;
	private JTextField textField;
	double num,ans;
	int calculare;
	Label label;
	
	
	public CalculatorView(JPanel mainPanel, AgendaElectronicaController agendaElectronicaController) {
		this.mainPanel = mainPanel;

		this.agendaElectronicaController = agendaElectronicaController;
		initialize();
		

	}

	public void operatori() {
		switch(calculare) {
		case 1:
			ans=num+Double.parseDouble(textField.getText( ));
			textField.setText(Double.toString(ans) );
			break;
			
			
		case 2:
			ans=num-Double.parseDouble(textField.getText( ));
			textField.setText(Double.toString(ans) );
			break;
			
		case 3:
			ans=num*Double.parseDouble(textField.getText( ));
			textField.setText(Double.toString(ans) );
			break;
			
		case 4:
			ans=num/Double.parseDouble(textField.getText( ));
			textField.setText(Double.toString(ans) );
			break;
			
		}
	}
	private void initialize() {

	label= new Label();
		setLayout(null);
		this.setVisible(true);

		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText( )+ "1");
			}
		});
		button.setBounds(31, 122, 63, 29);
		add(button);

		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText( )+ "2");
			}
		});
		button_1.setBounds(130, 122, 63, 29);
		add(button_1);

		JButton button_2 = new JButton("3");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText( )+ "3");
			}
		});
		button_2.setBounds(229, 117, 63, 29);
		add(button_2);

		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(" ");
			}
		});
		btnC.setBounds(179, 77, 89, 29);
		add(btnC);

		JButton button_3 = new JButton("4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText( )+ "4");
			}
		});
		button_3.setBounds(31, 162, 63, 29);
		add(button_3);

		JButton button_4 = new JButton("7");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText( )+ "7");
			}
		});
		button_4.setBounds(31, 202, 63, 29);
		add(button_4);

		JButton button_5 = new JButton("0");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText( )+ "0");
			}
		});
		button_5.setBounds(31, 242, 63, 29);
		add(button_5);

		JButton button_6 = new JButton("5");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText( )+ "5");
			}
		});
		button_6.setBounds(130, 162, 63, 29);
		add(button_6);

		JButton button_7 = new JButton("6");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText( )+ "6");
			}
		});
		button_7.setBounds(229, 162, 63, 29);
		add(button_7);

		JButton button_8 = new JButton("8");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText( )+ "8");
			}
		});
		button_8.setBounds(130, 202, 63, 29);
		add(button_8);

		JButton button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText( )+ "9");
			}
		});
		button_9.setBounds(229, 202, 63, 29);
		add(button_9);

		JButton button_10 = new JButton(".");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText( )+ ".");
			}
		});
		button_10.setBounds(130, 242, 63, 29);
		add(button_10);

		JButton button_11 = new JButton("=");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatori();
				 label.setText("");
				
			}
		});
		button_11.setBounds(229, 242, 89, 29);
		add(button_11);

		JButton button_12 = new JButton("+");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 num=Double.parseDouble(textField.getText( ));
				 calculare=1;
				 textField.setText("");
				 label.setText(num + "+");
			}
		});
		button_12.setBounds(328, 76, 89, 30);
		add(button_12);

		JButton button_13 = new JButton("-");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 num=Double.parseDouble(textField.getText( ));
				 calculare=2;
				 textField.setText("");
				 label.setText(num + "-");
			}
		});
		button_13.setBounds(328, 117, 89, 29);
		add(button_13);

		JButton button_14 = new JButton("*");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 num=Double.parseDouble(textField.getText( ));
				 calculare=3;
				 textField.setText("");
				 label.setText(num + "*");
			}
		});
		button_14.setBounds(328, 162, 89, 29);
		add(button_14);

		JButton button_15 = new JButton("/");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 num=Double.parseDouble(textField.getText( ));
				 calculare=4;
				 textField.setText("");
				 label.setText(num + "/");
			}
		});
		button_15.setBounds(328, 209, 89, 30);
		add(button_15);

		textField = new JTextField();
		textField.setBounds(31, 46, 350, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnSterge = new JButton("<--");
		btnSterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lenght=textField.getText().length();
				int number=textField.getText().length()-1;
				String store;
				
				if(lenght>0) {
					StringBuilder back= new StringBuilder(textField.getText());
					back.deleteCharAt(number);
					store=back.toString();
					textField.setText(store);
				}
			}
		});
		btnSterge.setBounds(31, 80, 89, 23);
		add(btnSterge);
		
		Label label = new Label(" ");
		label.setAlignment(Label.RIGHT);
		label.setForeground(Color.RED);
		label.setBounds(288, 18, 102, 22);
		add(label);

	}
}
