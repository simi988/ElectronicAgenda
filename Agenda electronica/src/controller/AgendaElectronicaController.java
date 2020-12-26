package controller;

import java.util.List;

import model.Calculator;
import model.Contact;

public class AgendaElectronicaController {
	private AgendaTelefonicaController agendaTelefonicaController;
	private ConvertorValutaController convert;
	public AgendaElectronicaController() {
		this.agendaTelefonicaController=new AgendaTelefonicaController();
		this.convert=new ConvertorValutaController();
	}
	public void creazaContact(String nume, String prenume, String adresa, String numarDeTelefon) {
		agendaTelefonicaController.creazaContact(nume, prenume, adresa, numarDeTelefon);
	}
	
	public double convert(String from, String to, double number) {
		return convert.convert(from, to, number);
	}
	
	
	
	public List<Contact> getListaContacte() {
		return agendaTelefonicaController.getListaContacte();
	}
	public void stergeContact(String numarTelefon) {
		agendaTelefonicaController.stergeContact(numarTelefon);
		
	}
}
