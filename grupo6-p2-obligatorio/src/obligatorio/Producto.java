package obligatorio;

public class Producto {

	private String nombre;
	private String nombreFantasia;
	private String estado;
	private String idProd;
	private Marca pMarca;
	private Empresa pEmpresa;
	private Rubro pRubro;
	private Clase pClase;
	private Pais pPais;
	private boolean estaHabilitado = false;

	public Producto(String nombre, String nombreFantasia, String idProd, String estado, Marca marca, Empresa empresa,
			Rubro rubro, Clase clase, Pais pais) {

		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
		this.idProd = idProd;
		this.estado = estado;
		if(estado.equals("HABILITADO")) {
			estaHabilitado = true;
		}
		pMarca = marca;
		pEmpresa = empresa;
		pRubro = rubro;
		pClase = clase;
		pPais = pais;

	}
	
	public boolean getEstaHabilitado() {
		return estaHabilitado;
	}

}
