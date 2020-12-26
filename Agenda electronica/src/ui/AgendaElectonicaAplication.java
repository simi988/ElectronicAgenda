package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import controller.AgendaElectronicaController;

public class AgendaElectonicaAplication {

	private JFrame frmAgendaElectronica;
	private JPanel panelMeniu;
	private JPanel panelAgendaTelefonica;
	private JPanel panelCalculator;
	private JPanel panelCalendar;
	private JPanel panelConvertorValutar;
	private JTable table;
	
	private AgendaElectronicaController agendaElectronicaController;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaElectonicaAplication window = new AgendaElectonicaAplication();
					window.frmAgendaElectronica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgendaElectonicaAplication() {
		this.agendaElectronicaController=new AgendaElectronicaController();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgendaElectronica = new JFrame();
		frmAgendaElectronica
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Catalin\\Desktop\\Apple_Phone-128.png"));
		frmAgendaElectronica.setTitle("Agenda Electronica");
		frmAgendaElectronica.setBounds(100, 100, 450, 300);
		frmAgendaElectronica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgendaElectronica.getContentPane().setLayout(new CardLayout(0, 0));

		final JPanel panelMeniu = new JPanel();
		frmAgendaElectronica.getContentPane().add(panelMeniu, "name_94395102344254");
		panelMeniu.setLayout(null);
		panelMeniu.setVisible(true);

		final JPanel panelAgendaTelefonica = new AgendaTelefonicaView(panelMeniu, agendaElectronicaController);
		frmAgendaElectronica.getContentPane().add(panelAgendaTelefonica, "name_94397562062502");
		panelAgendaTelefonica.setLayout(null);
		
		
		JButton btnAgendaTelefonicaButton = new JButton("Agenda Telefonica");
		btnAgendaTelefonicaButton.setIcon(
				new ImageIcon("C:\\Users\\Catalin\\Desktop\\49165527_351826178984222_5529119418291847168_n.png"));
		btnAgendaTelefonicaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelAgendaTelefonica.setVisible(true);
				panelMeniu.setVisible(false);
			}
		});
		btnAgendaTelefonicaButton.setBounds(10, 56, 175, 43);
		panelMeniu.add(btnAgendaTelefonicaButton);
		
		final JPanel panelCalendar = new CalendarView(panelMeniu);
		frmAgendaElectronica.getContentPane().add(panelCalendar, "name_94404042532182");
		panelCalendar.setVisible(false);
		JButton btnCalendarButton = new JButton("Calendar");
		btnCalendarButton.setIcon(
				new ImageIcon("C:\\Users\\Catalin\\Desktop\\48947176_308317996454659_1744718927994290176_n.png"));
		btnCalendarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCalendar.setVisible(true);
				panelMeniu.setVisible(false);
			}
		});
		btnCalendarButton.setBounds(212, 56, 154, 43);
		panelMeniu.add(btnCalendarButton);

		JPanel panelCalculator = new CalculatorView(panelMeniu, agendaElectronicaController);
		frmAgendaElectronica.getContentPane().add(panelCalculator, "name_94583936605199");
		panelCalculator.setVisible(false);
		JButton btnCalculatorButton = new JButton("Calculator");
		btnCalculatorButton.setIcon(
				new ImageIcon("C:\\Users\\Catalin\\Desktop\\48954526_738985703153341_4374669845925462016_n.png"));
		btnCalculatorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCalculator.setVisible(true);
				panelMeniu.setVisible(false);
			}
		});
		btnCalculatorButton.setBounds(10, 127, 175, 43);
		panelMeniu.add(btnCalculatorButton);

		final JPanel panelConvertorValutar = new ConvertorValutarView(panelMeniu,agendaElectronicaController);
		frmAgendaElectronica.getContentPane().add(panelConvertorValutar, "name_94600381258282");
		JButton btnConvertorValutarButton = new JButton("Convertor Valutar");
		btnConvertorValutarButton.setIcon(
				new ImageIcon("C:\\Users\\Catalin\\Desktop\\48404234_537339576742180_8801713845908275200_n.png"));
		btnConvertorValutarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelConvertorValutar.setVisible(true);
				panelMeniu.setVisible(false);
			}
		});
		btnConvertorValutarButton.setBounds(212, 127, 154, 43);
		panelMeniu.add(btnConvertorValutarButton);

		

		JPanel panelCeasDesteptator = new  CeasDesteptatorView(panelMeniu);
		frmAgendaElectronica.getContentPane().add(panelCeasDesteptator, "name_99662653607220");
		JButton btnCeasDesteptator = new JButton("Ceas Desteptator");
		btnCeasDesteptator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCeasDesteptator.setVisible(true);
				panelMeniu.setVisible(false);

			}
		});
		btnCeasDesteptator.setIcon(
				new ImageIcon("C:\\Users\\Catalin\\Desktop\\48402862_791565177861687_2441304787375882240_n.png"));
		btnCeasDesteptator.setBounds(115, 0, 166, 45);
		panelMeniu.add(btnCeasDesteptator);
	}
}
