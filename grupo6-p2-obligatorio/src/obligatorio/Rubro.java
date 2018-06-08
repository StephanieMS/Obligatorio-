package obligatorio;

public class Rubro {
	
	private String nombre;
	private int cantProdHabilitados = 0;

	public Rubro(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantProdHabilitados() {
		return cantProdHabilitados;
	}

	public void setCantProdHabilitados() {
		cantProdHabilitados++;
	}
	
	
	
}
