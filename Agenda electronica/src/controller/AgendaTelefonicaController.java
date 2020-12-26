package controller;

import java.util.List;

import model.AgendaTelefonica;
import model.Contact;

public class AgendaTelefonicaController {
	private AgendaTelefonica agenda;

	public AgendaTelefonicaController() {
		this.agenda = new AgendaTelefonica();

	}

	public void creazaContact(String nume, String prenume, String adresa, String numarDeTelefon) {
		Contact contact = new Contact();
		contact.setNume(nume);
		contact.setPrenume(prenume);
		contact.setAdresa(adresa);
		contact.setNumarDeTelefon(numarDeTelefon);
		agenda.adaugaContact(contact);

	}



	public List<Contact> getListaContacte() {
		return agenda.getListaContacte();
	}

	public void stergeContact(String numarTelefon) {
		agenda.stergeContact(numarTelefon);	
	}
}
