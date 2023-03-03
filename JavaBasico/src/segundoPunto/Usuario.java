package segundoPunto;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private List<Cliente> ListClientes = new ArrayList<Cliente>();

	public Usuario() {
	}

	public boolean AñadirCLiente(Cliente cliente) {		
		if(cliente.getNombre().matches(".*[0-9].*")) {
			System.out.println("No es posible usar el valor");
			System.out.println(" ");
			return true;
		}
		
		for(Cliente client : ListClientes) {
			if(client.getCedula() == cliente.getCedula()) {
				System.out.println("El cliente con numero de cedula " + cliente.getCedula() + " ya existe");
				System.out.println(" ");
				return true;
			}
		}		
		ListClientes.add(cliente);
		return false;		
	}
	
	public void borrarCliente(int documento) {		
		if(ListClientes == null) {
			System.out.println("No se puede eliminar el cliente porque no tiene clientes agregados");
			System.out.println(" ");
		}else {
			for(Cliente cliente : ListClientes) {
				if(documento == cliente.getCedula()) {
					ListClientes.remove(cliente);
					System.out.println("Cliente eliminado con exito");
					System.out.println(" ");
					break;
				}
			}
		}
		System.out.println("el documento ingresado no existe en el sistema");
		System.out.println(" ");
	}
	
	public void buscarCliente(int cedula) {		
		int cont = 1;
		boolean condicion = true;
		String mensaje = "";
		for (Cliente cliente : ListClientes) {					
			if(cedula == cliente.getCedula()) {
				mensaje = "El cliente que se busca está en la posición " 
						+ cont
						+ ", El cliente se llama " 
						+ cliente.getNombre() 
						+ " y su cédula es " + cliente.getCedula();
				System.out.println(mensaje);
				condicion = false;
				break;
			}							
			++cont;		
		}
		if(condicion) {
			mensaje = "El cliente buscado no existe";
			System.out.println(" ");
			System.out.println(mensaje);
		}
	}
	
	public void imprimir() {		
		int cont = 0;
		String mensaje = "";		
		for (Cliente cliente : ListClientes) {			
			mensaje = "Cliente número " 
			+ (++cont) 
			+ ": El cliente se llama " 
			+ cliente.getNombre() 
			+ " y su cédula es " + cliente.getCedula();			
			System.out.println(mensaje);
		}
	}
}
