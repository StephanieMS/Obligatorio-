package obligatorio;

public class Producto	{

	private String nombre;
	private String nombreFantasia;
	private String estado;
	private String idProd;
	private Marca pMarca;
	private Empresa pEmpresa;
	private Rubro pRubro;
	private Clase pClase;
	private Pais pPais;

	public Producto(String nombre, String nombreFantasia, String idProd, String estado, Marca marca,
			Empresa empresa, Rubro rubro, Clase clase, Pais pais) {

		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
		this.idProd = idProd;
		this.estado = estado;
		pMarca = marca;
		pEmpresa = empresa;
		pRubro = rubro;
		pClase = clase;
		pPais = pais;

	}
	

}
