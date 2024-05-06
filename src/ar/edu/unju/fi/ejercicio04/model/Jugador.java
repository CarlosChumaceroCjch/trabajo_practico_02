package ar.edu.unju.fi.ejercicio04.model;

import java.time.LocalDate;
import java.util.Date;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fecNac;
	private String nac;
	private Double estatura;
	private Double peso;
	private Posicion posicion;
	
	public Jugador () {
		
	}
	
	public Jugador(String nombre, String apellido, LocalDate fecNac, String nac, Double estatura, Double peso,
			Posicion posicion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecNac = fecNac;
		this.nac = nac;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFecNac() {
		return fecNac;
	}

	public void setFecNac(LocalDate fecNac) {
		this.fecNac = fecNac;
	}

	public String getNac() {
		return nac;
	}

	public void setNac(String nac) {
		this.nac = nac;
	}

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public int edad() {
		LocalDate Hoy = LocalDate.now();
        int anios = Hoy.getYear() - fecNac.getYear();
        int meses = Hoy.getMonthValue() - fecNac.getMonthValue();
        int dias = Hoy.getDayOfMonth() - fecNac.getDayOfMonth();

        if (meses < 0 || (meses == 0 && dias < 0)) {
            anios--;
        }

        return anios;

	}
	
	@Override
	
	public String toString() {
		return "\nNombre: " + nombre + "\nApellido: " + apellido + "\nfecha Nacimiento: " + fecNac + "\nEdad: "+edad()+" años\nNacionalidadd: "+nac+"\nEstatura: "+estatura+" cm\nPeso: "+peso+" kg\nPosicion: "+posicion;
	}
	
}
