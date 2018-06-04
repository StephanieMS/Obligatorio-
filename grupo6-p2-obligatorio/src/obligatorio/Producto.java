package obligatorio;

public class Producto<K extends Comparable<K>> {

	private String nombre;
	private String nombreFantasia;
	private boolean estado;
	private String idProd;
	private Marca pMarca;
	private Empresa pEmpresa;
	private Rubro pRubro;
	private Clase pClase;
	private Pais pPais;

	public Producto(String nombre, String nombreFantasia, String idProd, String estado, Marca marca,
			String nombreEmpresa, String rucEmpresa, String nombreRubro, String nombreClase, String nombrePais) {

		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
		this.idProd = idProd;
		pMarca = marca;
		if(estado.equals("HABILITADO")) {
			pMarca.setCantProductosHabilitados();
		}
		pEmpresa = new Empresa (nombreEmpresa, rucEmpresa);
		if(estado.equals("HABILITADO")) {
			pEmpresa.setCantProductosHabilitados();
			this.estado = true;
		}else {
			this.estado = false;
		}
		pRubro = new Rubro (nombreRubro);
		pClase = new Clase (nombreClase);
		pPais = new Pais (nombrePais);

	}

	public String getNombre() {
		return nombre;
	}

	public String getNombreFantasia() {
		return nombreFantasia;
	}

	public boolean getEstado() {
		return estado;
	}

	public Empresa getpEmpresa() {
		return pEmpresa;
	}



}
