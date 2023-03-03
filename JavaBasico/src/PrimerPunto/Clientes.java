package PrimerPunto;

public class Clientes {
	private String nombre;
	private int cedula;
	
	public Clientes(String nombre, int cedula) {
		super();
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

	@Override
	public String toString() {
		return "Clientes [nombre=" + nombre + ", cedula=" + cedula + "]";
	}	
}
