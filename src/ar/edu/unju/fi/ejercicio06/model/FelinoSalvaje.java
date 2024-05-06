package ar.edu.unju.fi.ejercicio06.model;

public class FelinoSalvaje {
	private String nombre;
	private byte Edad;
	private float peso;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte getEdad() {
		return Edad;
	}
	public void setEdad(byte edad) {
		Edad = edad;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public FelinoSalvaje() {
		
	}
	public FelinoSalvaje(String nombre, byte edad, float peso) {
		super();
		this.nombre = nombre;
		Edad = edad;
		this.peso = peso;
	}
	
	@Override
	
	public String toString() {
		return "Nombre= "+nombre+", Edad= "+Edad + ", Peso= "+peso;
	}
	
}
