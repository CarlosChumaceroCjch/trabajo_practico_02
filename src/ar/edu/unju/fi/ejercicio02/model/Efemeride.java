package ar.edu.unju.fi.ejercicio02.model;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;

public class Efemeride {
	private String cod;
	private Mes mes;
	private int dia;
	private String detalle;
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public Mes getMes() {
		return mes;
	}
	public void setMes(Mes mes) {
		this.mes = mes;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	public Efemeride () {
		
	}
	public Efemeride(String cod, Mes mes, int dia, String detalle) {
		super();
		this.cod = cod;
		this.mes = mes;
		this.dia = dia;
		this.detalle = detalle;
	}
	
	@Override
	public String toString() {
		return "Efemeride "+"\nCodigo=" + cod + "\nMes=" + mes + "\nDia=" + dia + "\nDetalle=" + detalle;
	}
	
}
