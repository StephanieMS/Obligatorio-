package obligatorio;

import uy.edu.um.prog2.adt.linkedlist.MiLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MiListaEntero;

public class Clase {
	
	private String nombre;
	private MiListaEntero<Producto> productosHabilitados;
	private Pais paisClase;

	public Clase(String nombre) {
		this.nombre = nombre;
		productosHabilitados = new MiLinkedList<>();
	}

	public String getNombre() {
		return nombre;
	}
	
	public Pais getPaisClase() {
		return paisClase;
	}

	public void setPaisClase(Pais paisClase) {
		this.paisClase = paisClase;
	}

	public MiListaEntero<Producto> getProductosHabilitados() {
		return productosHabilitados;
	}

	public void setProductosHabilitados(Producto prod) {
		productosHabilitados.addLast(prod);
	}
	
	
}
