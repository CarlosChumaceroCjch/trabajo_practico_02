package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoEfectivo implements Pago{
	private LocalDate fecPago;
	private double montoPag;
	
	public PagoEfectivo(LocalDate fecPago) {
		this.fecPago = fecPago;
	}
	
	
	public void realizarPago(double costo) {
		montoPag=costo-(costo*0.1);
	}
	
	
	public void imprimirRecibo() {
		System.out.println("Fecha de pago: "+ fecPago);
		System.out.println("Monto pagado: "+montoPag);
	}
}
