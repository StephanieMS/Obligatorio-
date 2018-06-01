package obligatorio;

public class Producto<K extends Comparable<K> > {
	
	private String nombre;
	private String nombreFantasia;
	private String estado;
	private K idProd;
	
	Marca pMarca;
	Empresa pEmpresa;
	Rubro pRubro;
	Clase pClase;
	Pais pPais;

	public Producto(String nombre, String nombreFantasia, K idProd, String estado, String nombreMarca, String nombreEmpresa,
			String rucEmpresa, String nombreRubro, String nombreClase, String nombrePais) {

		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
		this.idProd = idProd;
		this.estado = estado;
		pMarca = new Marca(nombreMarca);
		pEmpresa = new Empresa(nombreEmpresa, rucEmpresa);
		pRubro = new Rubro(nombreRubro);
		pClase = new Clase(nombreClase);
		pPais = new Pais(nombrePais);
	}
	

}
