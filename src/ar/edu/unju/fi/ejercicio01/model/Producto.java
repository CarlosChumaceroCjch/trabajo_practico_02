package ar.edu.unju.fi.ejercicio01.model;

public class Producto {
	private String cod;
	private String desc;
	private double precioU;
	private OrigenFabricacion origenFabricacion;
	private Categoria categoria;
	public Producto() {
		
	}
	
	public Producto(String cod, String desc, double precioU, OrigenFabricacion origenFabricacion, Categoria categoria) {
		super();
		this.cod = cod;
		this.desc = desc;
		this.precioU = precioU;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
	}

	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrecioU() {
		return precioU;
	}

	public void setPrecioU(double precioU) {
		this.precioU = precioU;
	}
	
	


	public enum OrigenFabricacion {
		ARGENTINA,CHINA,BRASIL,URUGUAY
	}
	
	public enum Categoria {
		TELEFONIA, INFORMATICA,ELECTROHOGAR,HERRAMIENTAS
	}
	
	
}
