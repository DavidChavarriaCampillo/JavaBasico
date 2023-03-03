package segundoPunto;

import java.util.Scanner;

public class TestPuntoDos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Usuario clienteNuevo = new Usuario();
		boolean condicion = true;
		String opcion;
		int cont = 0;
		
		do {			
			System.out.println("a. Añadir nuevo cliente \n"
					+ "b. Borrar un cliente \n"
					+ "c. Buscar un cliente \n"
					+ "d. Mostrar un cliente \n"
					+ "e. Salir \n"
					+ "Escoge una opcion");			
			opcion = sc.next().toLowerCase();			
			System.out.println(" ");
			System.out.println("Escogiste la opcion " + opcion);
			System.out.println(" ");
			
			switch(opcion) {
			
				case "a":
					try {					
						System.out.println("Ingrese su nombre");
						String nombre = sc.next();
						System.out.println(" ");						
						System.out.println("Ingrese su numero de Documento");
						int documento = Integer.parseInt(sc.next());
						System.out.println(" ");
						Cliente cliente = new Cliente(nombre,documento);											
						boolean desicion = clienteNuevo.AñadirCLiente(cliente);
						if(desicion) {
							break;
						}						
						System.out.println("Cliente agregado");
						System.out.println(" ");
						cont++;
						break;						
					}catch(Exception e) {						
						System.out.println(" ");
						System.out.println("No es posible usar el valor");
						System.out.println(" ");						
						break;						
					}
					
				case "b":					
					try {						
						System.out.println("Ingrese el documento del cliente que desea borrar");
						int documento = Integer.parseInt(sc.next());
						System.out.println(" ");						
						clienteNuevo.borrarCliente(documento);					
						break;						
					}catch(Exception e) {		
						System.out.println(" ");
						System.out.println("Valor invalido");
						System.out.println(" ");
						break;
					}
					
				case "c":
					try {
						System.out.println("Digite el documento del cliente");
						int documento = Integer.parseInt(sc.next());					
						clienteNuevo.buscarCliente(documento);					
						break;
					}catch(Exception e) {
						System.out.println(" ");
						System.out.println("Valor invalido");
						System.out.println(" ");
						break;
					}
					
					
				case "d":
					try {
						clienteNuevo.imprimir();
						System.out.println(" ");						
						break;
					}catch(Exception e){
						break;
					}
				
				case "e":
					System.exit(0);
					break;
					
				default:
					System.out.println("La opcion elegida no existe");
					System.out.println(" ");
			}
		}while(condicion);			
	}
}
