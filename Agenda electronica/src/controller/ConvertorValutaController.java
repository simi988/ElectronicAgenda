package controller;

import model.ConvertorValuta;

public class ConvertorValutaController {
private ConvertorValuta convertorValuta;

public ConvertorValutaController() {
	convertorValuta=new ConvertorValuta();
	
}
public double convert(String from, String to, double number) {
	return convertorValuta.convert(from, to, number);
	
}
}
