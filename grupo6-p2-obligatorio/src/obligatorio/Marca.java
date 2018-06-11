package obligatorio;

import uy.edu.um.prog2.adt.linkedlist.MiLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MiListaEntero;

public class Marca {

	private String nombre;
	private MiListaEntero<Producto> productos;
	private MiListaEntero<Producto> productosHabilitados;
	private Pais paisMarca;

	public Marca(String nombMarca) {
		this.nombre = nombMarca;
		productos = new MiLinkedList<>();
		productosHabilitados = new MiLinkedList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setProducto(Producto prod) {
		productos.addLast(prod);
	}

	public MiListaEntero<Producto> getProductos() {
		return productos;
	}

	public Pais getPaisMarca() {
		return paisMarca;
	}

	public void setPaisMarca(Pais paisMarca) {
		this.paisMarca = paisMarca;
	}

	public MiListaEntero<Producto> getProductosHabilitados() {
		return productosHabilitados;
	}

	public void setProductosHabilitados(Producto prod) {
		productosHabilitados.addLast(prod);
	}


}
