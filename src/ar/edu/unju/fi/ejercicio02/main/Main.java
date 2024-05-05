package ar.edu.unju.fi.ejercicio02.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;
import ar.edu.unju.fi.ejercicio02.util.Listado;

public class Main {

	public static void main(String[] args) {
		
		try{
			int op=0;
			do {
				Scanner sc =new Scanner(System.in);
				System.out.println("\nIngrese Opcion");
				System.out.println("1.Crear Efemeride");
				System.out.println("2.Mostar Efemeride");
				System.out.println("3.Eliminar Efemeride");
				System.out.println("4.Modificar efemeride");
				System.out.println("5.Salir");
				op =sc.nextInt();
				switch(op) {
				case 1:
					crearEf(sc);
					break;
				case 2:
					mostrarEf(sc);
					break;
				case 3:
					elimEf(sc);
					break;
				case 4:
					modEf(sc);
					break;
				default:
					System.out.println("Opcion invalida");
					break;
				}
			}while(op!=5);
			
		}catch(InputMismatchException e) {
			System.out.println("El valor ingresado no es valido intente de nuevo."+"\nMensaje:" + e.getMessage());
		}


	}

	
	//Metodo creacion Efemeride
	public static void crearEf(Scanner sc) {
		Efemeride ef=new Efemeride();
		try {
			System.out.println("Ingrese codigo de este Efemeride");
			ef.setCod(sc.next());

			int num =0;
			do {
				System.out.println("Ingrese mes del Efemeride");
				num =sc.nextInt();
				if (num>=1 && num<=12) {
					ef.setMes(Mes.values()[num-1]);
				}
				else
					System.out.println("Este numero no es valido para el mes, debe ser entre 1 y 12");
			}while (num<1 && num>12);
			
			
			System.out.println("Ingrese dia de Efemeride");
			ef.setDia( sc.nextInt());
			sc.nextLine();
			
			System.out.println("Ingrese detalle del Efemeride");
			ef.setDetalle(sc.nextLine());
			
			Listado.listadoEfemerides.add(ef);
			
			System.out.println("Datos cargados correctamente");
			
			
			
		}
		catch(InputMismatchException e) {
			System.out.println("El valor ingresado no es correcto."+"\nMensaje:" + e.getMessage());
		}
		finally {
			System.out.println("Carga finalizada");
		}
	}
	
	//Metodo mostrar efemerides
	
	public static void mostrarEf(Scanner sc) {
		for (Efemeride efemeride: Listado.listadoEfemerides ) {
			System.out.println(efemeride.toString());
		}
	}
	
	
	//Metodo eliminar efemeride
	
	public static void elimEf(Scanner sc) {
		System.out.println("\nIngrese codigo del Efemeride que quiera eliminar");
		String cod = sc.next();
		int id = buscEf(sc,cod);
		if (id ==-1) {
			System.out.println("No existe ese efemeride");
		}
		else {
			Listado.listadoEfemerides.remove(id);
			System.out.println("Efemeride eliminado correctamente");
		}
	}
	
	//Metodo de modificacion
	public static void modEf(Scanner sc) {
		System.out.println("\nIngrese codigo del Efemeride que quiera eliminar");
		String cod = sc.next();
		int id = buscEf(sc,cod);
		if (id ==-1) {
			System.out.println("No existe ese efemeride");
		}
		else {
			int op =0;
			do {
				System.out.println("**Ingrese atrbiuto que quiera modificar");
				System.out.println("1.Mes");
				System.out.println("2.Dia");
				System.out.println("3.Detalle");
				System.out.println("4.Cancelar");
				op =sc.nextInt();
				switch(op) {
				case 1:
					System.out.println("Ingrese mes del Efemeride");
					int num =sc.nextInt();
					if (num>=1 && num<=12) {
						Listado.listadoEfemerides.get(id).setMes(Mes.values()[num-1]);
					}
					else
						System.out.println("Este numero no es valido para el mes, debe ser entre 1 y 12");
					break;
				case 2:
					System.out.println("Ingrese dia de Efemeride");
					Listado.listadoEfemerides.get(id).setDia( sc.nextInt());
					sc.nextLine();
					break;
				case 3:
					System.out.println("Ingrese detalle del Efemeride");
					Listado.listadoEfemerides.get(id).setDetalle(sc.nextLine());
					break;
				default:
					System.out.println("Opcion invalida");
					break;
				}
			}while(op!=4);
			
			System.out.println("Fin de la modificacion");
		}
	}
	
	//Metodo de busqueda en general
	public static int buscEf(Scanner sc,String cod) {
		int id = -1;
		for (Efemeride efemeride: Listado.listadoEfemerides ) {
			if (efemeride.getCod()==cod)
				id =Listado.listadoEfemerides.indexOf(efemeride);
		}
		return id;
	}
	
}



