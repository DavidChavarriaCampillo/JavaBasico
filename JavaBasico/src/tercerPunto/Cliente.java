package tercerPunto;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nombre;
	private int cedula;
	private List<Producto> productos = new ArrayList<Producto>();
	
	public Cliente(String nombre, int cedula) {
		this.nombre = nombre;
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Producto producto) {
		productos.add(producto);
	}

	@Override
	public String toString() {
		return "El cliente " + nombre + " identificado con cédula " + cedula + " tiene los siguientes productos:\n";
	}
	
}
