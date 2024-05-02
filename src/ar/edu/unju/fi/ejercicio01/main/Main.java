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
						case 2:
							Mostrarprods (lista);
							break;
						case 3:
							ModProd (sc,lista);
							
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

	//Metodo para mostrar todos los productos
	public static void Mostrarprods (List<Producto>lista) {
		
		for (Producto productos :lista) {
			productos.toString();
		}
	}
	
	//metodo para modificar un producto
	
	public static void ModProd (Scanner sc,List<Producto>lista) {
		System.out.println("Ingrese codigo del producto al cual desea modificar");
		try {
		String cod =sc.next();
		int num =buscar(cod, lista);
		if (num ==-1) {
			System.out.println("No se encontro ese producto");
		}
		else {
			System.out.println("\nSeleccione el atributo que desee modificar");
			System.out.println("1.Descripcion");
			System.out.println("2.Precio unitario");
			System.out.println("3.Origen de su Fabricacion");
			System.out.println("4.Categoria");
			System.out.println("5.Cancelar");
			System.out.println("Elija una opcion");
			int op =sc.nextInt();
			switch (op) {
			case 1:
				System.out.println("Ingrese nueva descripcion");
				lista.get(num).setDesc(sc.next());
				System.out.println("Descripcion modificada con exito");
				break;
			case 2:
				System.out.println("Ingrese nuevo precio");
				lista.get(num).setPrecioU(sc.nextDouble());
				System.out.println("Precio modificado con exito");
				break;
			case 3:
				
				do {
					System.out.println("Seleccione nuevo origen de Fabricacion");
					System.out.println("1.Argentina");
					System.out.println("2.China");
					System.out.println("3.Brasil");
					System.out.println("4.Uruguay");
					System.out.println("5.Cancelar");
					System.out.println("Elija una opcion");
					op =sc.nextInt();
					
					switch(op) {
					case 1:
						lista.get(num).setOrigenFabricacion(OrigenFabricacion.ARGENTINA);
						break;
					case 2:
						lista.get(num).setOrigenFabricacion(OrigenFabricacion.CHINA);
						break;
					case 3:
						lista.get(num).setOrigenFabricacion(OrigenFabricacion.BRASIL);
						break;
					case 4:
						lista.get(num).setOrigenFabricacion(OrigenFabricacion.URUGUAY);
						break;
					case 5:
						System.out.println("Modificacion de producto finalizada");
						break;
					default:
						System.out.println("Opcion invalida, intente nuevamente");
						break;
					}
				}while(op<1 || op>4);
				System.out.println("Origen  modificado con exito");
				break;
			case 4:
				int op2=0;
				do {
					System.out.println("Seleccione el origen de fabricacion del Producto");
					System.out.println("----Categoria----");
					System.out.println("1.Telefonia");
					System.out.println("2.Informatica");
					System.out.println("3.Electro hogar");
					System.out.println("4.Herramientas");
					System.out.println("5.Cancelar");
					System.out.println("Elija una opcion");
					op2 =sc.nextInt();
					
					switch(op2) {
					case 1:
						lista.get(num).setCategoria(Categoria.TELEFONIA);
						break;
					case 2:
						lista.get(num).setCategoria(Categoria.INFORMATICA);
						break;
					case 3:
						lista.get(num).setCategoria(Categoria.ELECTROHOGAR);
						break;
					case 4:
						lista.get(num).setCategoria(Categoria.HERRAMIENTAS);
						break;
					case 5:
						System.out.println("Modificacion de producto finalizada");
						break;
					default:
						System.out.println("Opcion invalida, intente nuevamente");
						break;
					}
				}while(op2<1 || op2>4);
				System.out.println("Origen  modificado con exito");
				break;
			case 5:
				System.out.println("Modificacion de producto finalizada");
				break;
			}
		}
		
		
		
		}catch (InputMismatchException e) {
			System.out.println("El valor ingresado no es valido "+"\nMensaje:" + e.getMessage());
		}
		finally {
			System.out.println("Recursos cerrados");
		}
	}
	
	//Metodo de busqueda de codigo de producto
	public static int buscar (String cod,List<Producto>lista) {
		int prod =-1;
        for (Producto producto : lista) {
        	if (producto.getCod()==cod) {
        		prod = lista.indexOf(producto);
        	}                
        }
        return prod;
	}
	
}


