package PrimerPunto;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	private List<Clientes> ListClientes = new ArrayList<Clientes>();

	public Menu() {

	}

	public List<Clientes> getlientes() {
		
		return ListClientes;
		
	}

	public boolean AñadirCLiente(Clientes cliente) {
		
		if(cliente.getNombre().matches(".*[0-9].*")) {
			System.out.println("No es posible usar el valor");
			System.out.println(" ");
			return true;
		}
		
		if(ListClientes.size() == 10) {
			System.out.println("Debe borrar un cliente antes de poder ingresar uno nuevo");
			System.out.println(" ");
			return true;
		}
		
		this.ListClientes.add(cliente);
		return false;
		
	}
	
	public void borrarCliente(int posicion) {
		
		if(this.ListClientes.size() <= 4) {
			System.out.println("No se puede eliminar el cliente porque ya esta en el minimo permitido");
			System.out.println(" ");
		}else {
			this.ListClientes.remove(posicion-1);
		}
		 
	}


	public void imprimir() {
		
		int cont = 0;
		String mensaje = "";
		
		for (int i = 0; i < ListClientes.size(); i++) {
			
			mensaje = "Cliente número " 
			+ (++cont) 
			+ ": El cliente se llama " 
			+ ListClientes.get(i).getNombre() 
			+ " y su cédula es " + ListClientes.get(i).getCedula();
			
			System.out.println(mensaje);

		}

	}
	
	public void buscardor(int cedula) {
		
		int cont = 1;
		String mensaje = "";
		for (int i = 0; i < ListClientes.size(); i++) {
					
			if(cedula == ListClientes.get(i).getCedula()) {
				mensaje = "El cliente que se busca está en la posición " 
						+ cont
						+ ", El cliente se llama " 
						+ ListClientes.get(i).getNombre() 
						+ " y su cédula es " + ListClientes.get(i).getCedula();
				break;
			}else {
				
				mensaje = "El cliente buscado no existe";
				
			}
			
			++cont;		
			System.out.println(mensaje);

		}
	}	
}
