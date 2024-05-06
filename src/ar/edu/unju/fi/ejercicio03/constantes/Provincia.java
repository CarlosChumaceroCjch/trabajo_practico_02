package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	JUJUY(1111, 1000), SALTA(2222,2102), TUCUMAN(3333,33), CATAMARCA(4444,444), LA_RIOJA(5555,555), SANTIAGO_DEL_ESTERO(6666,666);
	
	private int cantPoblacion;
	private int superficie;
	
	private Provincia() {
		
	}

	private Provincia(int cantPoblacion, int superficie) {
		this.cantPoblacion = cantPoblacion;
		this.superficie = superficie;
	}

	public int getCantPoblacion() {
		return cantPoblacion;
	}

	public void setCantPoblacion(int cantPoblacion) {
		this.cantPoblacion = cantPoblacion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	public double calcularDensPoblacional() {
		return (double)cantPoblacion/superficie;
	}
}
