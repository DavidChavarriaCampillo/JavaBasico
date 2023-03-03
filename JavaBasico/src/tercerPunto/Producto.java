package tercerPunto;

public class Producto {
	private String nombre;
	private int cantidad;
	private double valorUnitario;
	private double valorSinIVA = 0.005;
	private double valorTotal;
	private double iva = 0.19;
	
	
	public Producto() {

	}

	public Producto(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	public Producto(String nombre,double valorUnitario) {
		this.nombre = nombre;
		this.valorUnitario = valorUnitario;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getValorSinIVA() {
		return valorSinIVA;
	}

	public void setValorSinIVA(double valorSinIVA) {
		this.valorSinIVA = valorSinIVA;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre 
				+ ", Cantidad:" + cantidad + ", valor unitario: " + valorUnitario 
				+ ", valor sin Iva: " + valorSinIVA
				+ ", valor total: " + valorTotal + ", Iva: " + iva + "\n";
	}
}
