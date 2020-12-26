package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AgendaElectronicaController;
import controller.AgendaTelefonicaController;
import model.Contact;



public class AdaugaContactDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNume;
	private JTextField textPrenume;
	private JTextField textTelefon;
	private JTextField textAdresa;
	private AgendaElectronicaController agendaElectronicaController;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			AdaugaContactDialog dialog = new AdaugaContactDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public AdaugaContactDialog(AgendaElectronicaController agendaElectronicaController) {
		this.agendaElectronicaController=agendaElectronicaController;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setBounds(10, 11, 46, 14);
		contentPanel.add(lblNume);
		
		JLabel lblPrenume = new JLabel("Prenume");
		lblPrenume.setBounds(10, 47, 46, 14);
		contentPanel.add(lblPrenume);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(10, 83, 46, 14);
		contentPanel.add(lblTelefon);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setBounds(10, 119, 46, 14);
		contentPanel.add(lblAdresa);
		
		textNume = new JTextField();
		textNume.setBounds(51, 8, 106, 20);
		contentPanel.add(textNume);
		textNume.setColumns(10);
		
		textPrenume = new JTextField();
		textPrenume.setBounds(61, 44, 96, 20);
		contentPanel.add(textPrenume);
		textPrenume.setColumns(10);
		
		textTelefon = new JTextField();
		textTelefon.setBounds(51, 80, 106, 20);
		contentPanel.add(textTelefon);
		textTelefon.setColumns(10);
		
		textAdresa = new JTextField();
		textAdresa.setBounds(51, 116, 106, 20);
		contentPanel.add(textAdresa);
		textAdresa.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton Adauga = new JButton("Adauga");
				Adauga.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						agendaElectronicaController.creazaContact(textNume.getText(), textPrenume.getText(), textAdresa.getText(), textTelefon.getText());
						closeWindow();
					}
				});
				Adauga.setActionCommand("OK");
				buttonPane.add(Adauga);
				getRootPane().setDefaultButton(Adauga);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						closeWindow();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void closeWindow() {
		dispose();
	}
}
