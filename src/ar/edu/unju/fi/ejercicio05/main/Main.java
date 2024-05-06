package ar.edu.unju.fi.ejercicio05.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
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
					mostrarProd(productos);
					break;
				case 2:
					compra(productos, carrito);
					pagos(carrito);
					break;
				case 3:
					System.out.println("Compras finalizadas");
					break;
				default:
					System.out.println("Opcion incorrecta, intente de nuevo");
					break;
				}
			}while(op!=3);
				
		}catch(InputMismatchException e) {
			System.out.println("No es numero "+"\nMensaje:" + e.getMessage());
		}
		
		
	}
	
	//metodo para cargar productos
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
	
	//metodo mostrar productos
	public static void mostrarProd(List<Producto05>productos) {
		System.out.println("Selecciione los productos que desea comprar");
		for (Producto05 producto:productos) {
				System.out.println(producto.toString());
		}
		
	}
	
	//metodo de compras
	public static void compra(List<Producto05>productos, List<Producto05>carrito) {
		char op='Y';
		do {
			System.out.println("Ingrese el codigo del producto que desea comprar");
			String cod=sc.next();
			for (Producto05 producto:productos) {
				if(producto.getCod().equals(cod)) {
					if (producto.isdisp()) {
						carrito.add(producto);
						System.out.println("Producto agregado al carrito");
					}
					else
						System.out.println("Lo sentimos, este producto no esta disponible");
				}
				else
					System.out.println("Producto no encontrado");
				System.out.println("¿Desea agregar otro Producto? Y/N");
				op=sc.next().charAt(0);
		}
		}while (op!='Y');
		
		
	}
	
	//metodo seleccionde pago
	public static void pagos(List<Producto05>carrito) {
		int op=0;
		boolean flag=true;
		//Seleccion metodo de pago
		try {
			while (flag) {
				do {
					System.out.println("Seleccione su metodo de pago");
					System.out.println("1.Pago efectivo");
					System.out.println("2.Pago con Tarjeta");
					op =sc.nextInt();	
					switch(op) {
					case 1:
						pagoEf(carrito);
						//Limpiamos el carrito para futuras compras y cambiamos la bandera a falso para salir del bucle principal
						carrito.clear();
						flag=false;
						break;
					case 2:
						pagoTar(carrito);
						carrito.clear();
						flag=false;
						break;
					default:
						System.out.println("Opcion incorrecta, debe seleccionar un metodo de pago");
						break;
						
					}
				}while(op!=2);
			}
			
			
		}catch(InputMismatchException e) {
			System.out.println("Entrada invalida "+"\nMensaje:" + e.getMessage());
		}finally {
			System.out.println("Recursos limpiados");
		}
	}
	
	//metodo de pago efectivo
	public static void pagoEf(List<Producto05>carrito) {
		PagoEfectivo pagEf =new PagoEfectivo(LocalDate.now());
		//Sumar todos los costos de los productos en el carrito
		double costo =0;
		for (Producto05 producto:carrito) {
			costo=costo+producto.getPrecioU();
		}
		pagEf.realizarPago(costo);
		pagEf.imprimirRecibo();
	}
	
	//Metodo pago tarjeta
	public static void pagoTar(List<Producto05>carrito) {
		String numCar="";
		try {
			boolean flag =false;
			do {
				System.out.println("Porfavor ingrese el numero de su tarjeta");
				numCar =sc.next();
				if (numCar.matches("[0-9]*"))
					flag=true;
				else
					System.out.println("Error, Reintente ingresando un numero de tarjeta valido");
			}while(flag==false);

		}catch(Exception e) {
			System.out.println("Valor invalido\n"+e.getMessage());
		}
		
		double costo =0;
		for (Producto05 producto:carrito) {
			costo=costo+producto.getPrecioU();
		}
		PagoTarjeta pagTar =new PagoTarjeta(numCar, LocalDate.now());
		pagTar.realizarPago(costo);
		pagTar.imprimirRecibo();
		
	}
}
