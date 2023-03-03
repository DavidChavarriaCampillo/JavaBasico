package tercerPunto;

import java.util.Scanner;


public class TestPuntoTres {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Usuario clienteNuevo = new Usuario();
		boolean condicion = true;
		boolean condicionC = true;
		boolean condicionP = true;
		String opcion;
		int cont = 0;
		
		do {
			System.out.println("a. Menu Clientes \n"
					+ "b. Menu Productos \n"
					+ "c. Salir");			
			opcion = sc.next().toLowerCase();
			switch(opcion) {
				case "a":
					do {
						condicionC = true;
						System.out.println("a. Añadir nuevo cliente \n"
								+ "b. Borrar un cliente \n"
								+ "c. Buscar un cliente \n"
								+ "d. Mostrar Clientes \n"
								+ "e. Modificar un cliente \n"
								+ "f. Agregar un Producto \n"
								+ "g. Aplicar decuento \n"
								+ "h. Menu anterior \n"
								+ "Escoge una opcion");			
						opcion = sc.next().toLowerCase();			
						System.out.println(" ");
						System.out.println("Escogiste la opcion " + opcion);
						System.out.println(" ");
						
						switch(opcion) {
						
							case "a":
								try {					
									System.out.println("Ingrese el nombre del cliente");
									String nombre = sc.next();
									System.out.println(" ");						
									System.out.println("Ingrese numero de Documento del cliente");
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
									clienteNuevo.borrarCliente(documento);					
									break;						
								}catch(Exception e) {		
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
									System.out.println("Valor invalido");
									System.out.println(" ");
									break;
								}
								
								
							case "d":
								clienteNuevo.imprimir();
								System.out.println(" ");						
								break;
							
							case "e":
								try {
									System.out.println("Digite el documento del cliente");
									int documento = Integer.parseInt(sc.next());
									System.out.println("Digite el nombre nuevo");
									String nombre = sc.next();
									clienteNuevo.modificarCLiente(documento, nombre);
									break;
								}catch(Exception e) {
									System.out.println("Valor invalido");
									System.out.println(" ");
									break;
								}
							
							case "f":
								try {
									System.out.println("Digite el documento del cliente");
									int documento = Integer.parseInt(sc.next());
									System.out.println("Nombre del producto");
									String nombreProducto = sc.next();
									System.out.println("Cantidad de producto");
									int cantidad = Integer.parseInt(sc.next());
									clienteNuevo.agregarProducto(documento,nombreProducto,cantidad);
									break;
								}catch(Exception e) {
									System.out.println("Valor invalido");
									System.out.println(" ");
									break;
								}								
								
							case "g":
								clienteNuevo.aplicarDescuento();
								break;
							
							case "h":
								condicionC = false;
								break;
								
							default:
								System.out.println("La opcion elegida no existe");
								System.out.println(" ");
						}
					}while(condicionC);
					break;
					
				case "b":
					do {
						condicionP = true;
						System.out.println("a. Añadir \n"
								+ "b. Borrar \n"
								+ "c. Menu anterior \n"
								+ "Escoge una opcion");			
						opcion = sc.next().toLowerCase();
						switch(opcion) {
							case "a":
								try {
									System.out.println("Digite el nombre del producto");
									String nombre = sc.next();
									System.out.println(" ");
									System.out.println("Digite el valor unitario del producto");
									double valorUnitario = Integer.parseInt(sc.next());
									System.out.println(" ");
									Producto productoTienda = new Producto(nombre,valorUnitario);
									clienteNuevo.agregarProductoTienda(productoTienda);
									break;
								}catch(Exception e) {
									System.out.println("Valor invalido");
									System.out.println(" ");
									break;
								}
								
							case "b":
								System.out.println("Digite el nombre del producto");
								String nombre = sc.next();
								clienteNuevo.borrarProductoTienda(nombre);
								break;
								
							case "c":
								condicionP = false;
								break;
								
							default:
								System.out.println("La opcion elegida no existe");
								System.out.println(" ");
						}
					}while(condicionP);
					break;
					
				case "c":
					condicion = false;
					System.exit(0);
					break;
					
				default:
					System.out.println("La opcion elegida no existe");
					System.out.println(" ");
			}			
		}while(condicion);
	}

}
