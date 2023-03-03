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
		boolean existe = ListClientes.stream().anyMatch(e -> e.getCedula() == documento);
		if(existe) {
			ListClientes.stream().forEach(cliente ->{
				if(cliente.getCedula() == documento) {
					ListClientes.remove(cliente);
				}
			});
			System.out.println("Cliente eliminado");
		}else {
			System.out.println("El cliente que desea borrar no existe");
		}			
	}
	
	public void buscarCliente(int documento) {
		boolean existe = ListClientes.stream().anyMatch(e -> e.getCedula() == documento);
		if(existe) {
			ListClientes.stream().forEach(cliente ->{
				if(cliente.getCedula() == documento) {
					System.out.println(cliente.toString() + cliente.getProductos().toString());
				}
			});
		}
	}
	
	public void imprimir() {
		ListClientes.stream().forEach(cliente ->{
			int cont = 0;
			String mensaje2 = "";
			String mensaje = "Cliente " + cliente.getNombre()
			+ " con cedula " + cliente.getCedula()
			+ " tiene los siguientes productos:";
			for(Producto producto : cliente.getProductos()) {
				mensaje2 = mensaje2 + (++cont) + " Producto: " + producto.getNombre()
						+ " Cantidad: " + producto.getCantidad()
						+ " ValorTotal" + producto.getValorTotal();
			}
			System.out.println(mensaje + " " + mensaje2);
		});
	}
	
	public void modificarCLiente(int documento, String nombre) {
		if(ListClientes.stream().anyMatch(cliente -> cliente.getCedula() == documento)) {
			ListClientes.stream().filter(cliente -> cliente.getCedula() == documento).map(cliente ->{
				cliente.setNombre(nombre);
				return cliente;
			}).collect(Collectors.toList());
		}else {
			System.out.println("El documento ingresado no existe");
		}		
	}
	
	public void agregarProducto(int documento,String nombreProducto, int cantidad) {
		if(ProductosTienda.isEmpty()) {
			System.out.println("La tienda no tiene productos, el usuario debe surtir");
		}else {
			if(ListClientes.stream().anyMatch(cliente -> cliente.getCedula() == documento) && 
					ProductosTienda.stream().anyMatch(producto -> producto.getNombre().equals(nombreProducto))) {
				ListClientes.stream().filter(cliente -> cliente.getCedula() == documento).map(cliente ->{
					if(cliente.getProductos().stream().anyMatch(p -> p.getNombre().equals(nombreProducto))) {
						cliente.getProductos().stream().filter(p -> p.getNombre().equals(nombreProducto)).map(p->{
							p.setCantidad(p.getCantidad() + cantidad);
							return p;
						}).collect(Collectors.toList());
					}else {
						ProductosTienda.stream().forEach(producto ->{
							Producto p = new Producto(nombreProducto,cantidad);
							p.setIva(producto.getIva());
							p.setValorSinIVA(producto.getValorSinIVA());
							p.setValorTotal(producto.getValorTotal());
							p.setValorUnitario(producto.getValorUnitario());
							cliente.setProductos(p);
						});
					}
					return cliente;
				}).collect(Collectors.toList());
			}else {
				System.out.println("El documento o el producto no existen el usuario lo debe agregar el o el producto");
			}
		}
		
		/*for(Cliente cliente : ListClientes) {
			if(cliente.getCedula() == documento) {
				Producto p = separarProducto(nombreProducto, cantidad);
				cliente.setProductos(p);
				break;
			}
		}*/
	}
	
	public void agregarProductoTienda(Producto porducto) {
		if(ProductosTienda.stream().anyMatch(p -> p.getNombre().equals(porducto.getNombre()))){
			System.out.println("El producto ya existe");
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
		
	}
	
	/*private Producto separarProducto(String nombreProducto, int cantidad) {
		Producto p = new Producto();
		for(Producto producto : ProductosTienda) {
			String t = producto.getNombre();
			System.out.println(t);
			if(producto.getNombre().equals(nombreProducto)) {
				p.setNombre(nombreProducto);
				p.setCantidad(cantidad);
				p.setIva(producto.getIva());
				p.setValorSinIVA(producto.getValorSinIVA());
				p.setValorTotal(producto.getValorTotal());
				p.setValorUnitario(producto.getValorUnitario());
				return p;
			}
		}
		return p;
	}*/
}
