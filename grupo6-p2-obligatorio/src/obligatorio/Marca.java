package obligatorio;

import uy.edu.um.prog2.adt.linkedlist.MiLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MiListaEntero;

public class Marca {

	private String nombre;
	private MiListaEntero<Producto> productos;
	private int cantProductosHabilitados;

	public Marca(String nombMarca) {
		this.nombre = nombMarca;
		productos = new MiLinkedList<>();
		cantProductosHabilitados = productos.getContador();
	}

	public String getNombre() {
		return nombre;
	}

	public void setProducto(Producto prod) {
		productos.agregar(prod);
	}

	public MiListaEntero<Producto> getProductos() {
		return productos;
	}

	public int getCantProductosHabilitados() {
		return cantProductosHabilitados;
	}

}
