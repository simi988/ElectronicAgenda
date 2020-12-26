package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.AgendaElectronicaController;
import model.Contact;

public class AgendaTelefonicaView extends JPanel {
	private static final String[] TABLECOLUMNS = new String[] { "Fotografie", "Nume", "Prenume", "Telefon", "Adresa" };
	private JPanel mainPanel;
	private JTable table_1;
	private DefaultTableModel tableModel;
	private AgendaElectronicaController agendaElectronicaController;

	public AgendaTelefonicaView(JPanel mainPanel, AgendaElectronicaController agendaElectronicaController) {
		this.mainPanel = mainPanel;
		this.agendaElectronicaController = agendaElectronicaController;
		initialize();

	}

	private void initialize() {
		setLayout(null);
		table_1 = new JTable();

		table_1.setBounds(178, 11, 262, 278);
		add(table_1);

		JButton btnAdaugaContact = new JButton("Adauga Contact");
		btnAdaugaContact.setIcon(
				new ImageIcon("C:\\Users\\Catalin\\Desktop\\49069726_2311384869081508_8925999960252481536_n.png"));
		btnAdaugaContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdaugaContactDialog adaugaContactDialog = new AdaugaContactDialog(agendaElectronicaController);
				adaugaContactDialog.setVisible(true);
				adaugaContactDialog.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						afisiazaContacte();
					}
				});

			}
		});
		btnAdaugaContact.setBounds(-28, 11, 196, 55);
		add(btnAdaugaContact);

		JButton btnStergeContact = new JButton("Sterge Contact");
		btnStergeContact.setIcon(
				new ImageIcon("C:\\Users\\Catalin\\Desktop\\49187713_1973427702952273_740355037871472640_n.png"));
		btnStergeContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] selectedRows = table_1.getSelectedRows();

				for (int i = 0; i < selectedRows.length; i++) {
					String numarTelefon = tableModel.getValueAt(selectedRows[i], 3).toString();
					agendaElectronicaController.stergeContact(numarTelefon);
				}

				StergeContactDialog stergeContactDialog = new StergeContactDialog(agendaElectronicaController);
				stergeContactDialog.setVisible(true);
				stergeContactDialog.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						afisiazaContacte();
					}

				});

			}
		});
		btnStergeContact.setBounds(-28, 77, 196, 48);
		add(btnStergeContact);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainPanel.setVisible(true);

			}
		});
		btnBack.setBounds(10, 221, 88, 23);
		add(btnBack);
	}

	private void afisiazaContacte() {
		List<Contact> contacte = agendaElectronicaController.getListaContacte();
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(TABLECOLUMNS);

		for (int i = 0; i < contacte.size(); i++) {
			Contact contactCurent = contacte.get(i);
			tableModel.addRow(new Object[] { null, contactCurent.getNume(), contactCurent.getPrenume(),
					contactCurent.getNumarDeTelefon(), contactCurent.getAdresa() });

		}

		table_1.setModel(tableModel);
	}

}
