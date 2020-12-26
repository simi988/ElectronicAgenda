package ui;

import javax.swing.JPanel;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class CalendarView extends JPanel {
	private JPanel mainPanel;
	  DefaultTableModel model;
	  Calendar cal = new GregorianCalendar();
	  JLabel label;
	public CalendarView(JPanel mainPanel) {
		this.mainPanel = mainPanel;
		initialize();

	}

	private void initialize() {
 
		this.setSize(300, 200);
		this.setVisible(true);

		label = new JLabel();
		label.setBounds(45, 0, 210, 23);
		label.setHorizontalAlignment(SwingConstants.CENTER);

		JButton b1 = new JButton("<-");
		b1.setBounds(0, 0, 45, 23);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.MONTH, -1);
				updateMonth();
			}
		});

		JButton b2 = new JButton("->");
		b2.setBounds(255, 0, 45, 23);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.MONTH, +1);
				updateMonth();
			}
		});

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 300, 23);
		panel.setLayout(null);
		panel.add(b1);
		panel.add(label);
		panel.add(b2);

		String[] columns = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		model = new DefaultTableModel(null, columns);
		setLayout(null);

		this.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 23, 300, 177);
		add(panel_1);
		panel_1.setLayout(null);
		JTable table = new JTable(model);
		table.setBounds(0, 0, 298, 147);
		panel_1.add(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				mainPanel.setVisible(true);
			}
		});
		btnBack.setBounds(0, 154, 89, 23);
		panel_1.add(btnBack);

		this.updateMonth();

	}

	void updateMonth() {
		cal.set(Calendar.DAY_OF_MONTH, 1);

		String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		int year = cal.get(Calendar.YEAR);
		label.setText(month + " " + year);

		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);

		model.setRowCount(0);
		model.setRowCount(weeks);

		int i = startDay - 1;
		for (int day = 1; day <= numberOfDays; day++) {
			model.setValueAt(day, i / 7, i % 7);
			i = i + 1;
		}

	}
}