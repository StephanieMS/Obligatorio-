package obligatorio;

public class Pais {
	
	private String nombre;
	private int cantProdHabilitados = 0;

	public Pais(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantProdHabilitados() {
		return cantProdHabilitados;
	}

	public void setCantProdHabilitados() {
		cantProdHabilitados++;
	}
	
	
}
