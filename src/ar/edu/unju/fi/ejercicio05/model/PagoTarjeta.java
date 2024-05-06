package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoTarjeta implements Pago {
	private String numTar;
	private LocalDate fecPago;
	private double montoPag;

	public PagoTarjeta(String numTar, LocalDate fecPago) {
		super();
		this.numTar = numTar;
		this.fecPago = fecPago;
	}
	
	
	
	public void realizarPago(double costo) {
		montoPag=costo+(costo*0.15);
	}
	
	
	public void imprimirRecibo() {
		System.out.println("Numero de Tarjeta: "+numTar);
		System.out.println("Fecha de pago: "+ fecPago);
		System.out.println("Monto pagado: "+montoPag);
		
	}
}
