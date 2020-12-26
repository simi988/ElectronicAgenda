package model;

import java.util.HashMap;
import java.util.Map;

public class ConvertorValuta {
	private static double Ron_Eur =0.22;
	private static double Eur_Ron =  4.64;
	private static double Ron_Usd = 0.25;
	private static double Usd_Ron = 4.07;
	private static double Eur_Usd = 1.15;
	private static double Usd_Eur = 0.86;
	private static double Ron_Ron =1;
	private static double Eur_Eur = 1;
	private static double Usd_Usd = 1;
	private Map <String,Double> convertor;
	
	public ConvertorValuta() {
		initialize();
	}
	void initialize() {
		convertor=new HashMap<String, Double>();
		convertor.put("Ron_Eur", Ron_Eur);
		convertor.put("Eur_Ron",Eur_Ron);
		convertor.put("Ron_Usd", Ron_Usd);
		convertor.put("Usd_Ron", Usd_Ron);
		convertor.put("Eur_Usd", Eur_Usd);
		convertor.put("Usd_Eur", Usd_Eur);
		convertor.put("Ron_Ron", Ron_Ron);
		convertor.put("Eur_Eur", Eur_Eur);
		convertor.put("Usd_Usd", Usd_Usd);
	}
	public double convert(String from, String to, double number) {
		double rataConversie=convertor.get(from +"_"+ to);
		double suma=rataConversie*number;
		return suma;
	}
}
