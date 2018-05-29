package obligatorio;

public class Producto {
	private String nombre;
	private String nombreFantasia;
	private String estado;
	Marca pMarca;
	Empresa pEmpresa;
	Rubro pRubro;
	Clase pClase;
	Pais pPais;

	public Producto(String nombre, String nombreFantasia, String estado, String nombreMarca, String nombreEmpresa,
			String rucEmpresa, String nombreRubro, String nombreClase, String nombrePais) {

		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
		this.estado = estado;
		pMarca = new Marca(nombreMarca);
		pEmpresa = new Empresa(nombreEmpresa, rucEmpresa);
		pRubro = new Rubro(nombreRubro);
		pClase = new Clase(nombreClase);
		pPais = new Pais(nombrePais);
	}

}
