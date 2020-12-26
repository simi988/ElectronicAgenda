package model;
import java.awt.Image;

public class Contact {
	private String nume;
	private String prenume;
	private String adresa;
	private String numarDeTelefon;
	private Image fotografie;

	public Contact(String nume, String prenume, String adresa, String numarDeTelefon, Image fotografie) {
		this.nume = nume;
		this.prenume = prenume;
		this.adresa = adresa;
		this.numarDeTelefon = numarDeTelefon;
		this.fotografie = fotografie;
	}

	public Contact() {
		nume = new String();
		prenume = new String();
		adresa = new String();
		numarDeTelefon = new String();
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getNumarDeTelefon() {
		return numarDeTelefon;
	}

	public void setNumarDeTelefon(String numarDeTelefon) {
		this.numarDeTelefon = numarDeTelefon;
	}

	public Image getFotografie() {
		return fotografie;
	}

	public void setFotografie(Image fotografie) {
		this.fotografie = fotografie;
	}

}
