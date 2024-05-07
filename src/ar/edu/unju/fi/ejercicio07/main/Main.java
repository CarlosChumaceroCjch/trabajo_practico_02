package ar.edu.unju.fi.ejercicio07.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio05.model.Producto05;

public class Main {

		public static Scanner sc =new Scanner(System.in);
		public static void main(String[] args) {
			List<Producto05>productos =new  ArrayList<>();
			List<Producto05>carrito =new  ArrayList<>();
			cargarProductos(productos);
			int op=0;
			try {
				do {
					System.out.println("Bienvenido, seleccione su operacion");
					System.out.println("1.Mostrar Productos");
					System.out.println("2.Realizar compra");
					System.out.println("3.Salir");
					op =sc.nextInt();
					switch(op) {
					case 1:
						mostrarProdT(productos);
						break;
					case 2:
						System.out.println(nDisp(productos));
						break;
					case 3:
						List<Producto05>productosIncrementados =aumentoPrecio(productos);
						//System.out.println(productosIncrementados);
						break;
					case 4:
						System.out.println(categYT(productos));
						break;
					case 5:
						System.out.println(OrdenarDesc(productos));
						break;
					case 6:
						System.out.println(mayus(productos));
						break;
					case 7:
						System.out.println("Fin programa");
					default:
						System.out.println("Opcion incorrecta, intente de nuevo");
						break;
					}
				}while(op!=3);
					
			}catch(InputMismatchException e) {
				System.out.println("No es numero "+"\nMensaje:" + e.getMessage());
			}
			


	}
	public static void cargarProductos(List<Producto05>productos){
		Producto05 p1 = new  Producto05("AAA", "Samsung", 2000, OrigenFabricacion.BRASIL, Categoria.TELEFONIA, false);
		Producto05 p2 = new  Producto05("BBB", "HP", 3000, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true);
		Producto05 p3 = new  Producto05("CCC", "Liliana", 1200, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true);
		Producto05 p4 = new  Producto05("DDD", "Phillips", 4000, OrigenFabricacion.BRASIL, Categoria.INFORMATICA,true );
		Producto05 p5 = new  Producto05("EEE", "Taladro", 2700, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS,false );
		Producto05 p6 = new  Producto05("FFF", "LCD360HZ", 3000, OrigenFabricacion.URUGUAY, Categoria.INFORMATICA,false );
		Producto05 p7 = new  Producto05("GGG", "Hitachi", 1800, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR,true );
		Producto05 p8 = new  Producto05("HHH", "Iphone", 3000, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, true);
		Producto05 p9 = new  Producto05("III", "HP", 3000, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true);
		Producto05 p10 = new  Producto05("JJJ", "Drean", 4000, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, false);
		Producto05 p11 = new  Producto05("KKK", "LG", 4000, OrigenFabricacion.BRASIL, Categoria.INFORMATICA,true );
		Producto05 p12 = new  Producto05("LLL", "Destornillador", 700, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS,false );
		Producto05 p13 = new  Producto05("MMM", "Home Theater", 5000, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR,true );
		Producto05 p14 = new  Producto05("NNN", "JBL", 1800, OrigenFabricacion.URUGUAY, Categoria.INFORMATICA,false );
		Producto05 p15 = new  Producto05("OOO", "Noga", 4800, OrigenFabricacion.BRASIL, Categoria.INFORMATICA,false );
		
		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		productos.add(p4);
		productos.add(p5);
		productos.add(p6);
		productos.add(p7);
		productos.add(p8);
		productos.add(p9);
		productos.add(p10);
		productos.add(p11);
		productos.add(p12);
		productos.add(p13);
		productos.add(p14);
		productos.add(p15);	
	}
	
	//metodo mostrar productos con Consumer
	public static void mostrarProdT(List<Producto05>productos) {
		Consumer<Producto05> mostrar = p ->{ if (p.isdisp())
			System.out.println(p);
		};
		productos.forEach(mostrar);
	}

	//metodo mostrar producto con Predicate y Filter
	
	public static List<Producto05> nDisp (List<Producto05>productos){
		Predicate<Producto05> save = p -> !p.isdisp();
		return productos.stream().filter(save).collect(Collectors.toList());
				
	}
	
	//Metodo incremento precios
	
	public static List<Producto05>aumentoPrecio(List<Producto05>productos){
		Function<Producto05, Producto05> precioAum =p ->{
			p.setPrecioU(p.getPrecioU()*1.20f);
			return p;
		};
		return productos.stream().map(precioAum).collect(Collectors.toList());
	}
	
	
	//Metodo Mostrar por categorias
	public static List<Producto05> categYT (List<Producto05>productos){
		Predicate<Producto05> save = p -> (p.isdisp()&& p.getCategoria()==Categoria.ELECTROHOGAR);
		return productos.stream().filter(save).collect(Collectors.toList());
				
	}
	
	//metodo para ordenar descendentemente
	public static List<Producto05> OrdenarDesc(List<Producto05>productos){
		Comparator<Producto05> c = Comparator.comparing(Producto05 :: getPrecioU).reversed();

		productos.sort(c);
		return productos;
	}
	
	//Mostrar Productos Con mayusculas
	
	public static List<Producto05>mayus(List<Producto05>productos){
		Function<Producto05, Producto05> caps =p ->{
			p.setDesc(p.getDesc().toUpperCase());;
			return p;
		};
		return productos.stream().map(caps).collect(Collectors.toList());
	}
}

