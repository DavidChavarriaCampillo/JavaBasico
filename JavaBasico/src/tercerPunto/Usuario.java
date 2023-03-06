package tercerPunto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Usuario {
	
	private List<Cliente> ListClientes = new ArrayList<Cliente>();
	private List<Producto>ProductosTienda = new ArrayList<Producto>();
	
	public boolean AñadirCLiente(Cliente cliente) {
		boolean existe = ListClientes.stream()
				.filter(documento -> documento.getCedula() == cliente.getCedula()).findAny().isPresent();
		if(existe) {
			System.out.println("Ya existe un cliente con ese numero de documento");
			return true;
		}else {
			ListClientes.add(cliente);
			return false;
		}
	}
	
	public void borrarCliente(int documento) {
		if(ListClientes.stream().anyMatch(e -> e.getCedula() == documento)) {
			ListClientes.stream().filter(cliente -> cliente.getCedula() == documento).map(cliente ->{
				ListClientes.remove(cliente);
				System.out.println("Cliente eliminado");
				System.out.println(" ");
				return cliente;
			}).collect(Collectors.toList());			
		}else {
			System.out.println("El cliente que desea borrar no existe");
			System.out.println(" ");
		}			
	}
	
	public void buscarCliente(int documento) {
		if(ListClientes.stream().anyMatch(e -> e.getCedula() == documento)) {
			ListClientes.stream().forEach(cliente ->{
				if(cliente.getCedula() == documento) {
					System.out.println(cliente.toString() + cliente.getProductos().toString());
					System.out.println(" ");
				}
			});
		}
	}
	
	public void imprimir() {
		ListClientes.stream().forEach(cliente ->{
			String mensaje = "";
			if(cliente.getProductos().isEmpty()) {
				System.out.println("Cliente " + cliente.getNombre()
				+ " con cedula " + cliente.getCedula()
				+ " no tiene productos agregados");
				System.out.println(" ");
			}else {
				System.out.println("Cliente " + cliente.getNombre()
				+ " con cedula " + cliente.getCedula()
				+ " tiene los siguientes productos:\n");
				cliente.getProductos().stream().forEach(producto ->{	
					System.out.println("Producto: " + producto.getNombre()
					+ " Cantidad: " + producto.getCantidad()
					+ " ValorTotal: " + producto.getValorTotal());
				});
				System.out.println(" ");
			}
		});
	}
	
	public void modificarCLiente(int documento, String nombre) {
		if(ListClientes.stream().anyMatch(cliente -> cliente.getCedula() == documento)) {
			ListClientes.stream().filter(cliente -> cliente.getCedula() == documento).map(cliente ->{
				cliente.setNombre(nombre);
				System.out.println("El nombre fue modificado exitosamente");
				System.out.println(" ");
				return cliente;
			}).collect(Collectors.toList());
		}else {
			System.out.println("El documento ingresado no existe");
		}		
	}
	
	public void agregarProducto(int documento,String nombreProducto, int cantidad) {
		if(ProductosTienda.isEmpty()) {
			System.out.println(" ");
			System.out.println("La tienda no tiene productos, el usuario debe surtir");
			System.out.println(" ");
		}else {
			if(ListClientes.stream().anyMatch(cliente -> cliente.getCedula() == documento) && 
					ProductosTienda.stream().anyMatch(producto -> producto.getNombre().equals(nombreProducto))) {
				ListClientes.stream().filter(cliente -> cliente.getCedula() == documento).map(cliente ->{
					if(cliente.getProductos().stream().anyMatch(p -> p.getNombre().equals(nombreProducto))) {
						cliente.getProductos().stream().filter(p -> p.getNombre().equals(nombreProducto)).map(p->{
							p.setCantidad(p.getCantidad() + cantidad);
							p.setValorSinIVA(p.getValorUnitario()*p.getCantidad());
							p.setValorTotal(p.getValorSinIVA()+p.getIva());
							System.out.println("Se sumaron los productos a los que ya tenia");
							System.out.println(" ");
							return p;
						}).collect(Collectors.toList());
					}else {
						ProductosTienda.stream().filter(producto -> producto.getNombre().equals(nombreProducto))
						.map(producto ->{
							Producto p = new Producto(nombreProducto,cantidad);
							p.setIva(producto.getIva()*producto.getValorUnitario());
							p.setValorSinIVA(producto.getValorUnitario()*cantidad);
							p.setValorTotal(p.getValorSinIVA()+p.getIva());
							p.setValorUnitario(producto.getValorUnitario());
							cliente.setProductos(p);
							System.out.println("Producto agregado");
							System.out.println(" ");
							return producto;
						}).collect(Collectors.toList());
					}
					return cliente;
				}).collect(Collectors.toList());
			}else {
				System.out.println("El documento o el producto no existen el usuario lo debe agregar el cliente o el producto");
				System.out.println(" ");
			}
		}
	}
	
	public void agregarProductoTienda(Producto porducto) {
		if(ProductosTienda.stream().anyMatch(p -> p.getNombre().equals(porducto.getNombre()))){
			System.out.println("El producto ya existe");
			System.out.println(" ");
		}else {
			ProductosTienda.add(porducto);
		}
	}
	
	public void borrarProductoTienda(String nombre) {
		if(ProductosTienda.stream().anyMatch(producto -> producto.getNombre().equals(nombre))) {
			ProductosTienda.stream().filter(producto -> producto.getNombre().equals(nombre)).map(producto ->{
				ProductosTienda.remove(producto);
				return producto;
			}).collect(Collectors.toList());
		}else {
			System.out.println("El producto que intenta borrar no existe");
		}
	}
	
	public void aplicarDescuento() {	
		ListClientes.stream().forEach(cliente ->{
			if(cliente.getProductos().stream().anyMatch(producto -> producto.getCantidad() > 6) &&
					cliente.getProductos().stream().anyMatch(producto -> producto.getValorTotal() > 200000)) {
				cliente.getProductos().stream().filter(producto -> producto.getCantidad() > 6)
				.filter(producto -> producto.getValorTotal() > 200000).map(producto ->{
					producto.setValorTotal((producto.getValorTotal()-(producto.getValorTotal()*0.1)));
					return producto;
				}).collect(Collectors.toList());
				System.out.println("Cliente " + cliente.getNombre()
				+ " con cedula " + cliente.getCedula()
				+ " tiene los siguientes productos:");
				System.out.println();
				cliente.getProductos().stream().forEach(p ->{
					System.out.println("Producto: " + p.getNombre()
					+ " Cantidad: " + p.getCantidad()
					+ " ValorTotal: " + p.getValorTotal());
				});
			}else {
				System.out.println("El cliente " + cliente.getNombre() + " no tiene descuento");
				System.out.println(" ");
			}
			
		});
		/*List<Producto> descuento = new ArrayList<>();	
		ListClientes.stream().forEach(cliente ->{
			if(cliente.getProductos().stream().anyMatch(producto -> producto.getCantidad() > 6) &&
					cliente.getProductos().stream().anyMatch(producto -> producto.getValorTotal() > 200000)) {
				cliente.getProductos().stream().filter(producto -> producto.getCantidad() > 6)
				.filter(producto -> producto.getValorTotal() > 200000).map(producto ->{
					Producto p = new Producto();
					p.setNombre(producto.getNombre());
					p.setCantidad(producto.getCantidad());
					p.setIva(producto.getIva());
					p.setValorUnitario(producto.getValorUnitario());
					p.setValorSinIVA(producto.getValorSinIVA());
					p.setValorTotal((producto.getValorTotal()-(producto.getValorTotal()*0.1)));
					descuento.add(p);
					return producto;
				}).collect(Collectors.toList());
				System.out.println("Cliente " + cliente.getNombre()
				+ " con cedula " + cliente.getCedula()
				+ " tiene los siguientes productos:");
				descuento.stream().forEach(producto ->{
					System.out.println("Producto: " + producto.getNombre()
					+ " Cantidad: " + producto.getCantidad()
					+ " ValorTotal: " + producto.getValorTotal());
					System.out.println();
				});
			}else {
				System.out.println("El cliente " + cliente.getNombre() + " no tiene descuento");
				System.out.println(" ");
			}
			
		});*/
	}
}
