package obligatorio;

public class Producto<K extends Comparable<K> > {
	
	private String nombre;
	private String nombreFantasia;
	private String estado;
	private K idProd;
	private String pMarca;
	private String pEmpresa;
	private String rucEmpresa;
	private String pRubro;
	private String pClase;
	private String pPais;
	

	public Producto(String nombre, String nombreFantasia, K idProd, String estado, String nombreMarca, String nombreEmpresa,
			String rucEmpresa, String nombreRubro, String nombreClase, String nombrePais) {

		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
		this.idProd = idProd;
		this.estado = estado;
		this.pMarca = nombreMarca;
		this.pEmpresa = nombreEmpresa;
		this.rucEmpresa = rucEmpresa;
		this.pRubro = nombreRubro;
		this.pClase = nombreClase;
		this.pPais = nombrePais;

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


	public String getpMarca() {
		return pMarca;
	}


	public void setpMarca(String pMarca) {
		this.pMarca = pMarca;
	}


	public String getpEmpresa() {
		return pEmpresa;
	}


	public void setpEmpresa(String pEmpresa) {
		this.pEmpresa = pEmpresa;
	}


	public String getRucEmpresa() {
		return rucEmpresa;
	}


	public void setRucEmpresa(String rucEmpresa) {
		this.rucEmpresa = rucEmpresa;
	}


	public String getpRubro() {
		return pRubro;
	}


	public void setpRubro(String pRubro) {
		this.pRubro = pRubro;
	}


	public String getpClase() {
		return pClase;
	}


	public void setpClase(String pClase) {
		this.pClase = pClase;
	}


	public String getpPais() {
		return pPais;
	}


	public void setpPais(String pPais) {
		this.pPais = pPais;
	}
	
	
}


