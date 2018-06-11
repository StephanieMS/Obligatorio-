package obligatorio;

public class Clase {
	
	private String nombre;
	private int cantProdHabilitados = 0;
	private Pais paisClase;

	public Clase(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setCantProdHabilitados() {
		cantProdHabilitados++;
	}
	
	public int getCantProdHabilitados() {
		return cantProdHabilitados;
	}
	
	public Pais getPaisClase() {
		return paisClase;
	}

	public void setPaisClase(Pais paisClase) {
		this.paisClase = paisClase;
	}
}
