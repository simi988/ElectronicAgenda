package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AgendaTelefonica {
	private List<Contact> listaContacte;

	public AgendaTelefonica() {
		listaContacte = new ArrayList<Contact>();
	}

	public List<Contact> getListaContacte() {
		return listaContacte;
	}

	public void setListaContacte(List<Contact> listaContacte) {
		this.listaContacte = listaContacte;
	}

	public void adaugaContact(Contact contact) {
		listaContacte.add(contact);
	}

	public void scoateContanct(Contact contact) {
		listaContacte.remove(contact);
	}

	public void stergeContact(String numarTelefon) {
		List<Contact> listaContacteDeSters = new ArrayList<>();
		for (Contact contact : listaContacte) {
			if (contact.getNumarDeTelefon().equals(numarTelefon)) {
				listaContacteDeSters.add(contact);
			}
		}
		listaContacte.removeAll(listaContacteDeSters);
	}
}
