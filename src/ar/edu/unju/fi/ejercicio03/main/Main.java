package ar.edu.unju.fi.ejercicio03.main;

import ar.edu.unju.fi.ejercicio03.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		
Provincia[] listado = Provincia.values();
		
		for(Provincia p : listado ) {
			System.out.println("\n"+p);
			System.out.println("Superficie: "+p.getSuperficie());
			System.out.println("Cabtidad Habitantes: "+p.getCantPoblacion());
			System.out.println("Densidad poblacional: "+p.calcularDensPoblacional());
		}
	}

}
