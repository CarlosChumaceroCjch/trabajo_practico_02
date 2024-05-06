package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;
import ar.edu.unju.fi.ejercicio04.model.Listado;

public class Main {

	public static void main(String[] args) {
		int op=0;	
		Scanner sc= new Scanner(System.in);


		do {
			System.out.println("\nMENÚ");
			System.out.print("Por favor seleccione una opción: ");
		    System.out.println("\n1- Alta de jugador");
		    System.out.println("2- Mostrar datos de un jugador");
		    System.out.println("3- Mostrar jugadores ordenados por apellido");
		    System.out.println("4- Modificar datos de un jugador");
		    System.out.println("5- Eliminar un jugador");
			try {	
				op=sc.nextInt();
				sc.nextLine();
				
			} catch(InputMismatchException e1) {
		        System.out.println("Error: El valor ingresado no es un entero.");
		        sc.nextLine();

			}catch (Exception e2) {
				System.out.println("Error imprevisto. Motivo: " + e2.getMessage());
			}
			finally {
				System.out.println("Recursos cerrados");
			}
		
		//Seleccion de Metodos
		switch (op) {
        case 1:
            altaJug(sc);
            break;
        case 2:
            mostrarJug(sc);
            break;
        case 3:
            modificarJug(sc);
            break;
        case 4:
            eliminarJugador(sc);
            break;
        case 5:
            System.out.println("Saliendo de menu");
            break;
        default:
            System.out.println("Opción no válida. Intente nuevamente.");
		}
		}while (op!=5);
		sc.close();

	}

	//Metodo alta jugador
	public static void altaJug(Scanner sc){
        try {
        	Jugador jugador =new Jugador();
            System.out.print("Ingrese el nombre del jugador: ");
            jugador.setNombre(sc.nextLine());

            System.out.print("Ingrese el apellido del jugador: ");
            jugador.setApellido(sc.nextLine());

            System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
            jugador.setFecNac(LocalDate.parse(sc.nextLine()));

            System.out.print("Ingrese la nacionalidad del jugador:");
            jugador.setNac(sc.nextLine());

            System.out.print("Ingrese la estatura del jugador (en cm): ");
            jugador.setEstatura(sc.nextDouble());

            System.out.print("Ingrese el peso del jugador: ");
            jugador.setPeso(sc.nextDouble());
            
            int opPos =0;
            do {
                System.out.print("Seleccione la posicion que tomara el Jugador");
                System.out.println("\n1- Delantero");
                System.out.println("2- Medio");
                System.out.println("3- Defensa");
                System.out.println("4- Arquero");  
                opPos  = sc.nextInt();
	            switch(opPos) {
	            	case 1:
	            		jugador.setPosicion(Posicion.DELANTERO);
	            		break;
	            	case 2:
	            		jugador.setPosicion(Posicion.MEDIO);
	            		break;
	            	case 3:
	            		jugador.setPosicion(Posicion.DEFENSA);
	            		break;
	            	case 4:
	            		jugador.setPosicion(Posicion.ARQUERO);
	            		break;
	            	default:
	            		System.out.println("Opcion invalida, intente nuevamente");
	            }     		
	         }while (opPos<1 ||opPos>4);
            Listado.listadoJugadores.add(jugador);
            System.out.println("Jugador dado de alta correctamente.");
            
            
        } catch(InputMismatchException e1) {
	        System.out.println("Error: El valor ingresado no es valido.");
	        sc.nextLine();
        } catch (Exception e) {
            System.out.println("Error al dar de alta al jugador. Motivo: " + e.getMessage());
        }
		finally {
			System.out.println("Recursos cerrados");
		}
	}
	
	//metodo mostra jugadores
	public static void mostrarJug(Scanner sc) {
		for (Jugador jugador:Listado.listadoJugadores) {
			jugador.toString();
		}
	}
	
	//Metodo modificar Jugador
	public static void modificarJug(Scanner sc) {
		try {
			System.out.println("Ingrese nombre del jugador a buscar: ");
			String nombre=sc.nextLine();
			
			System.out.println("Ingres apellido:");
			String apell=sc.nextLine();
			
			//Metodo de busqueda de jugadores
			int jugador = buscIndJugador(nombre, apell); 
			int op = 0;
			if (jugador!=-1) {
				do {
					System.out.println("Ingrese Opcion que desea modificar");
					System.out.println("1.Nombre");
					System.out.println("2.apellido");
					System.out.println("3.Fecha de nacimiento");
					System.out.println("4.Nacionalidad");
					System.out.println("5.Estatura");
					System.out.println("6.Peso.");
					System.out.println("7.Posicion");
					System.out.println("8.Salir");
					op =sc.nextInt();
					
					switch (op) {
					case 1:
			            System.out.print("Ingrese el nombre del jugador: ");
			            Listado.listadoJugadores.get(jugador).setNombre(sc.nextLine());
						break;
					case 2:
						System.out.print("Ingrese el apellido del jugador: ");
						Listado.listadoJugadores.get(jugador).setApellido(sc.nextLine());
						break;
					case 3:
						 System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
						 Listado.listadoJugadores.get(jugador).setFecNac(LocalDate.parse(sc.nextLine()));
						break;
					case 4:
						 System.out.print("Ingrese la nacionalidad del jugador:");
						 Listado.listadoJugadores.get(jugador).setNac(sc.nextLine());
						break;
					case 5:
			            System.out.print("Ingrese la estatura del jugador (en cm): ");
			            Listado.listadoJugadores.get(jugador).setEstatura(sc.nextDouble());
						break;
					case 6:
			            System.out.print("Ingrese el peso del jugador: ");
			            Listado.listadoJugadores.get(jugador).setPeso(sc.nextDouble());
						break;
					case 7:
						int opPos =0;
			            do {
			                System.out.print("Seleccione la posicion que tomara el Jugador");
			                System.out.println("\n1- Delantero");
			                System.out.println("2- Medio");
			                System.out.println("3- Defensa");
			                System.out.println("4- Arquero");  
			                opPos  = sc.nextInt();
				            switch(opPos) {
				            	case 1:
				            		Listado.listadoJugadores.get(jugador).setPosicion(Posicion.DELANTERO);
				            		break;
				            	case 2:
				            		Listado.listadoJugadores.get(jugador).setPosicion(Posicion.MEDIO);
				            		break;
				            	case 3:
				            		Listado.listadoJugadores.get(jugador).setPosicion(Posicion.DEFENSA);
				            		break;
				            	case 4:
				            		Listado.listadoJugadores.get(jugador).setPosicion(Posicion.ARQUERO);
				            		break;
				            	default:
				            		System.out.println("Opcion invalida, intente nuevamente");
				            }     		
				         }while (opPos<1 ||opPos>4);
						break;
					case 8:
						System.out.println("Carga finalizada");
						break;
					default:
						System.out.println("Opcion invalida, intente nuevamente");
						break;
					}
				}while(op!=8);
				
				
				
				System.out.println("Datos modificados con exito");
				}
			else 
				System.out.println("Jugador no encontrado.");
	        } catch(InputMismatchException e1) {
		        System.out.println("Error: El valor ingresado no es valido.");
		        sc.nextLine();
	        } catch (Exception e) {
	            System.out.println("Error al cargar nuevos datos del jugador. Motivo: " + e.getMessage());
	        }
			finally {
				System.out.println("Recursos cerrados");
			}
	}
	
	//Metodo Eliminar jugador
	public static void eliminarJugador(Scanner sc) {
		Iterator<Jugador> it = Listado.listadoJugadores.iterator();
		
		System.out.println("Ingrese nombre del jugador a buscar: ");
		String nombre=sc.nextLine();
		System.out.println("Ingres apellido:");
		String apell=sc.nextLine();
		
		while (it.hasNext()) {
			Jugador i=it.next();
			if (i.getApellido().equals(apell) && i.getNombre().equals(nombre)) {
				it.remove();
			}
			else
				System.out.println("No existe un jugador con ese nobmre y apellido");
		}
	}
	
	
	
	//Metodo busqueda
	
	public static int buscIndJugador(String nombre, String apellido) {
		int jug =-1;
            for (Jugador jugador : Listado.listadoJugadores) {
            	if (jugador.getApellido().equals(apellido) && jugador.getNombre().equals(nombre)) {
            		jug = Listado.listadoJugadores.indexOf(jugador);
            	}                
            }
            return jug;
        } 
	
}
