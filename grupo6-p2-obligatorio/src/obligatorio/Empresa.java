package obligatorio;

import uy.edu.um.prog2.adt.linkedlist.MiLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MiListaEntero;

public class Empresa {
	
	private String nombre;
	private String ruc;
	private MiListaEntero<Producto> productos;
	
	public Empresa(String nombre, String ruc) {
		this.nombre = nombre;
		this.ruc = ruc;
		productos = new MiLinkedList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public MiListaEntero<Producto> getProductos() {
		return productos;
	}

	public void setProductos(MiListaEntero<Producto> productos) {
		this.productos = productos;
	}
	
	
	
}
