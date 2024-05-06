package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		/*
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12f);
		
		Converter<FelinoDomestico, FelinoSalvaje> converter =x ->  new FelinoSalvaje(x.getNombre(),x.getEdad(),x.getPeso());
		
		FelinoSalvaje FelS01= converter.convert(gato);
		*/
		
		FelinoSalvaje gato = new FelinoSalvaje("Nube",(byte)13,12f);
		
		if (Converter.isNotNull(gato)){
			Converter<FelinoSalvaje, FelinoDomestico> converter =x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
			FelinoDomestico felD01 = converter.convert(gato);
			converter.mostrarObjeto(felD01);
		}
		

	}

}
