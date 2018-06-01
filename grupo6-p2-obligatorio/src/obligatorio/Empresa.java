package obligatorio;

public class Empresa {
	
	private String nombre;
	private String ruc;
	private int cantProductosHabilitados;
	
	public Empresa(String nombre, String ruc) {
		this.nombre = nombre;
		this.ruc = ruc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public int getCantProductosHabilitados() {
		return cantProductosHabilitados;
	}

	public void setCantProductosHabilitados(int cantProductosHabilitados) {
		this.cantProductosHabilitados = cantProductosHabilitados;
	}
	
	
	
}
