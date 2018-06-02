package obligatorio;

public class Producto<K extends Comparable<K>> {

	private String nombre;
	private String nombreFantasia;
	private String estado;
	private K idProd;
	private Marca pMarca;
	private Empresa pEmpresa;
	private Rubro pRubro;
	private Clase pClase;
	private Pais pPais;

	public Producto(String nombre, String nombreFantasia, K idProd, String estado, Marca marca,
			String nombreEmpresa, String rucEmpresa, String nombreRubro, String nombreClase, String nombrePais) {

		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
		this.idProd = idProd;
		this.estado = estado;
		pMarca = marca;
		pEmpresa = new Empresa (nombreEmpresa, rucEmpresa);
		pRubro = new Rubro (nombreRubro);
		pClase = new Clase (nombreClase);
		pPais = new Pais (nombrePais);

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreFantasia() {
		return nombreFantasia;
	}

	public void setNombreFantasia(String nombreFantasia) {
		this.nombreFantasia = nombreFantasia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public K getIdProd() {
		return idProd;
	}

	public void setIdProd(K idProd) {
		this.idProd = idProd;
	}



}
