package obligatorio;

import java.util.ArrayList;

public class Marca {
	
	private String nombre;
	
	private ArrayList<Producto> productos;

	public Marca(String nombMarca) {
		productos = new ArrayList<>();
		this.nombre = nombMarca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setProducto(Producto prod) {
		productos.add(prod);
	}
	
}
