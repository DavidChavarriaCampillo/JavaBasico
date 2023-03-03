package PrimerPunto;

public class Usuario {
	
	private Clientes[] clientes = new Clientes[4];

	public Usuario() {
		
	}
	
	public boolean AñadirCLiente(Clientes cliente, int cont) {
		Clientes[] nuevoArreglo = new Clientes[clientes.length + 1];		
		if(cliente.getNombre().matches(".*[0-9].*")) {
			System.out.println("No es posible usar el valor");
			System.out.println(" ");
			return true;
		}		
		if(clientes.length == 10) {
			System.out.println("Debe borrar un cliente antes de poder ingresar uno nuevo");
			System.out.println(" ");
			return true;
		}		
		if(cont < 4) {		
			clientes[cont] = cliente;
			return false;
		}else {			
			for(int i= 0; i < nuevoArreglo.length; i++) {
				if(i < clientes.length) {
					nuevoArreglo[i] = clientes[i];
				}else {
					nuevoArreglo[i] = cliente;
				}
			}
		}
		clientes = nuevoArreglo;
		return false;		
	}
	
	public void borrarCliente(int posicion) {
		if(posicion > 0 && posicion <= clientes.length) {
			Clientes[] nuevoArreglo = new Clientes[clientes.length - 1];
			if(clientes.length <= 4) {
				System.out.println("No se puede eliminar el cliente porque ya esta en el minimo permitido");
				System.out.println(" ");
			}else {
				for (int i = 0; i < nuevoArreglo.length; i++) {
					if(i == (posicion - 1)) {
						for(int f = (posicion - 1); f < nuevoArreglo.length; f++) {
							nuevoArreglo[f] = clientes[f+1]; 
						}
						break;
					}else {
						nuevoArreglo[i] = clientes[i];
					}
				}
				clientes = nuevoArreglo;
			}
		}else {
			System.out.println("Valor no valido");
			System.out.println(" ");
		}	 
	}
	
	public void buscarCliente(int cedula) {
		try {
			int cont = 1;
			String mensaje = "";
			for (int i = 0; i < clientes.length; i++) {					
				if(cedula == clientes[i].getCedula()) {
					mensaje = "El cliente que se busca está en la posición " 
							+ cont
							+ ", El cliente se llama " 
							+ clientes[i].getNombre() 
							+ " y su cédula es " + clientes[i].getCedula();
					System.out.println(mensaje);
					System.out.println(" ");
					break;
				}			
				++cont;		
			}
			mensaje = "El cliente buscado no existe";
			System.out.println(mensaje);
			System.out.println(" ");
		}catch(Exception e) {
			System.out.println(" ");
			System.out.println("El cliente buscado no existe");
			System.out.println(" ");
		}
		
	}	
	
	public void imprimir() {		
		int cont = 0;
		String mensaje = "";		
		for (int i = 0; i < clientes.length; i++) {			
			mensaje = "Cliente número " 
			+ (++cont) 
			+ ": El cliente se llama " 
			+ clientes[i].getNombre() 
			+ " y su cédula es " + clientes[i].getCedula();			
			System.out.println(mensaje);
			System.out.println(" ");
		}
	}
}
