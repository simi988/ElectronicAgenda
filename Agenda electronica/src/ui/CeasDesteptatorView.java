package ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import javax.swing.*;

public class CeasDesteptatorView extends JPanel implements ActionListener, Runnable {

	private JPanel mainPanel;
	Date alartTime;

	String musicFile;

	JLabel currentTime;

	JLabel alarmTime;
	JSpinner alarmSetter;
	JButton setAlarm;

	JLabel fileName;
	JFileChooser fileChooser;
	JButton fileChooserButton;
	JButton setMusic;

	Thread runner;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnBack;


	public CeasDesteptatorView(JPanel mainPanel) {
		this.mainPanel = mainPanel;
		setLayout(null);

	

		initialize();
	}

	private void initialize() {

		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 450, 25);

		JPanel alarmPanel = new JPanel();
		alarmPanel.setBounds(0, 94, 79, 206);
		alarmPanel.setLayout(new BoxLayout(alarmPanel, BoxLayout.Y_AXIS));

		JPanel filePanel = new JPanel();
		filePanel.setBounds(371, 25, 79, 275);
		filePanel.setLayout(new BoxLayout(filePanel, BoxLayout.Y_AXIS));
		topPanel.setLayout(null);

		
		JLabel topLabel = new JLabel("Current Time:");
		topLabel.setBounds(0, 0, 124, 25);
		topLabel.setHorizontalAlignment(JLabel.CENTER);
		topLabel.setFont(topLabel.getFont().deriveFont(20.0f));
		topPanel.add(topLabel);

		
		alarmPanel.add(new JLabel("Alarm Time:"));
		alarmTime = new JLabel("n/a");
		alarmTime.setHorizontalAlignment(JLabel.CENTER);
		alarmTime.setFont(alarmTime.getFont().deriveFont(25f));
		alarmPanel.add(alarmTime);
		setAlarm = new JButton("Set Alarm");
		alarmPanel.add(setAlarm);

		
		filePanel.add(new JLabel("Music File:"));
		fileName = new JLabel("n/a");
		filePanel.add(fileName);
		filePanel.add(new JLabel("Select New File:"));
		fileChooser = new JFileChooser();
		fileChooserButton = new JButton("Browse...");
		filePanel.add(fileChooserButton);
		setMusic = new JButton("Set Music");
		filePanel.add(setMusic);
		setLayout(null);

		add(topPanel);
		add(alarmPanel);
		add(filePanel);

		

		setAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ora = textField.getText();
				String minut = textField_1.getText();
				alartTime = new Date();
				alartTime.setHours(Integer.parseInt(ora));
				alartTime.setMinutes(Integer.parseInt(minut));
				alarmTime.setText(alartTime.getHours() + ":" + alartTime.getMinutes());
			}
		});
		setMusic.addActionListener(this);
		fileChooserButton.addActionListener(this);

		textField = new JTextField();
		textField.setBounds(89, 101, 73, 20);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(205, 101, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);

		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainPanel.setVisible(true);
			}
		});
		btnBack.setBounds(170, 223, 89, 23);
		add(btnBack);
		
				
				currentTime = new JLabel();
				currentTime.setBounds(0, 25, 259, 58);
				add(currentTime);
				currentTime.setHorizontalAlignment(JLabel.CENTER);
				currentTime.setFont(currentTime.getFont().deriveFont(50.0f));

		
		runner = new Thread(this);
		runner.start();
	}

	
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == fileChooserButton) {
			int option = fileChooser.showOpenDialog(this);
		}

	}

	
	public void run() {

		while (true) {

			
			Date now = new Date();
			currentTime.setText(now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds());
			if (alartTime != null) {
				if ((now.getHours()==alartTime.getHours())&&(now.getMinutes()==alartTime.getMinutes())) {
					JOptionPane.showMessageDialog(null, "Trezirea");
					alartTime=null;
				}
			}
			
			try {
				Thread.currentThread().sleep(1000);
			} catch (Exception e) {
				
			}
		}
	}

}
