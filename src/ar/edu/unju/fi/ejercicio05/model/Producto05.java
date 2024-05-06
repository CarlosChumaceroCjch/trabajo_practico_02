package ar.edu.unju.fi.ejercicio05.model;

import ar.edu.unju.fi.ejercicio01.model.Producto;

public class Producto05  extends Producto{
	private boolean disp;
	
	public Producto05() {
		
	}
	
	
	
	public Producto05(boolean disp) {
		super();
		this.disp = disp;
	}

	public Producto05(String cod,String desc, double precioU, OrigenFabricacion origen, Categoria categoria,boolean disp){
		super(cod,desc,precioU,origen,categoria);
		this.disp=disp;
	}

	public boolean isdisp() {
		return disp;
	}

	public void setStatus(boolean status) {
		this.disp = status;
	}
	
	private String checkDisp() {
		if (disp)
			return "Disponible";
		else
			return "No disponible";
	}
	
@Override
	public String toString() {
		return Producto05.super.toString()+"\nStock: "+checkDisp();
}
	
}
