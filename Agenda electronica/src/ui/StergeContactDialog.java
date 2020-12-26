package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AgendaElectronicaController;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StergeContactDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private AgendaElectronicaController agendaElectronicaController;

	/**
	 * Launch the application.
	 *
	 * public static void main(String[] args) { try { StergeContactDialog dialog =
	 * new StergeContactDialog();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 **
	 * 
	 * Create the dialog.
	 */
	public StergeContactDialog(AgendaElectronicaController agendaElectronicaController) {
		this.agendaElectronicaController = agendaElectronicaController;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblContactulAFost = new JLabel("Contactul a fost sters din lista de contacte");
			lblContactulAFost.setBounds(91, 106, 279, 14);
			contentPanel.add(lblContactulAFost);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						closeWindow();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				getRootPane().setDefaultButton(cancelButton);
			}
		}
	}

	public void closeWindow() {
		dispose();
	}
}
