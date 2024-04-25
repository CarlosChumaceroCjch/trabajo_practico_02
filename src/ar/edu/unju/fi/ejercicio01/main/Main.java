package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		
		List<Producto> lista =new ArrayList<Producto>();				
				Scanner sc =new Scanner(System.in);
				int op=0;
				try {
					do {
						System.out.println("**Ingrese Opcion");
						System.out.println("1.Crear Producto");
						System.out.println("2.Mostrar Productos");
						System.out.println("3.Modificar Productos");
						System.out.println("4.Salir");
						op =sc.nextInt();
						
						switch(op) {
						case 1:
							CrearProd(sc, lista);
							break;
						}
					}while(op!=4);
					
				}catch(InputMismatchException e) {
					System.out.println("No es numero "+"\nMensaje:" + e.getMessage());
				}
				

	}
	//Metodo para crear productos

	public static void CrearProd(Scanner sc, List<Producto>lista) {
		System.out.println("Ingrese Codigo de producto");
		String cod=sc.next();
		System.out.println("Ingrese Descripcion de producto");
		String desc = sc.next();
		System.out.println("Ingrese Precio Unitario de producto");
		Double precU = sc.nextDouble();
		
		OrigenFabricacion origen =null;
		try {
			int op=0;
			do {
				System.out.println("Seleccione el origen de fabricacion del Producto");
				System.out.println("----Origen de fabricacion----");
				System.out.println("1.Argentina");
				System.out.println("2.China");
				System.out.println("3.Brasil");
				System.out.println("4.Uruguay");
				System.out.println("Elija una opcion");
				op =sc.nextInt();
				
				switch(op) {
				case 1:
					origen= OrigenFabricacion.ARGENTINA;
					break;
				case 2:
					origen= OrigenFabricacion.CHINA;
					break;
				case 3:
					origen= OrigenFabricacion.BRASIL;
					break;
				case 4:
					origen= OrigenFabricacion.URUGUAY;
					break;
				default:
					System.out.println("Opcion invalida, intente nuevamente");
					break;
				}
			}while(op<1 || op>4);
			
		}catch(InputMismatchException e) {
			System.out.println("El valor ingresado no es un numero "+"\nMensaje:" + e.getMessage());
		}
		
		Categoria categ =null;
		try {
			int op2=0;
			do {
				System.out.println("Seleccione el origen de fabricacion del Producto");
				System.out.println("----Categoria----");
				System.out.println("1.Telefonia");
				System.out.println("2.Informatica");
				System.out.println("3.Electro hogar");
				System.out.println("4.Herramientas");
				System.out.println("Elija una opcion");
				op2 =sc.nextInt();
				
				switch(op2) {
				case 1:
					categ= Categoria.TELEFONIA;
					break;
				case 2:
					categ= Categoria.INFORMATICA;
					break;
				case 3:
					categ= Categoria.ELECTROHOGAR;
					break;
				case 4:
					categ= Categoria.HERRAMIENTAS;
					break;
				default:
					System.out.println("Opcion invalida, intente nuevamente");
					break;
				}
			}while(op2<1 || op2>4);
			
		}catch(InputMismatchException e) {
			System.out.println("El valor ingresado no es un numero "+"\nMensaje:" + e.getMessage());
		}
		
		Producto producto =new Producto(cod, desc, precU, origen, categ);
		lista.add(producto);
		System.out.println("Producto cargado correctamente");
		
	}
}


