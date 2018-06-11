package obligatorio;

import uy.edu.um.prog2.adt.linkedlist.MiLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MiListaEntero;

public class Pais {
	
	private String nombre;
	private MiListaEntero<Producto> productosHabilitados;

	public Pais(String nombre) {
		this.nombre = nombre;
		productosHabilitados = new MiLinkedList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public MiListaEntero<Producto> getProductosHabilitados() {
		return productosHabilitados;
	}

	public void setProductosHabilitados(Producto prod) {
		productosHabilitados.addLast(prod);
	}
	
}
