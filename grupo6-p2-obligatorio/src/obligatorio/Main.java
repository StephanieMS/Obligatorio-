package obligatorio;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.opencsv.CSVReader;

import uy.edu.um.prog2.adt.binarySearchTree.BinarySearchTree;
import uy.edu.um.prog2.adt.binarySearchTree.MyBinarySearchTree;
import uy.edu.um.prog2.adt.hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.hash.HashCerrado;
import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.heap.Heap;
import uy.edu.um.prog2.adt.heap.HeapVacio;
import uy.edu.um.prog2.adt.heap.MyHeap;
import uy.edu.um.prog2.adt.linkedlist.MiLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MiListaEntero;
import uy.edu.um.prog2.adt.linkedlist.PosicionInvalida;

public class Main {

	private static HashTable<String, Marca> marcas;
	private static HashTable<String, Empresa> empresas;
	private static HashTable<String, Pais> paises;
	private static HashTable<String, Clase> clases;
	private static MyBinarySearchTree<String, Rubro> rubros;
	
	private static HashTable<Integer, Producto> prodHabilitados;

	private static MiListaEntero<String> nombresMarcas;
	private static MiListaEntero<String> nombresEmpresas;
	private static MiListaEntero<String> nombresPaises;
	private static MiListaEntero<String> nombresClases;
	
	public static void main(String[] args)
			throws IOException, ElementoYaExistenteException, PosicionInvalida, HeapVacio {

		String fileName = "v_producto_real_updated.csv";

		@SuppressWarnings("deprecation")
		CSVReader csvReader = new CSVReader(new FileReader(fileName), ';');

		List<String[]> datos = csvReader.readAll();

		csvReader.close();

		marcas = new HashCerrado<>(datos.size() / 2);

		empresas = new HashCerrado<>(datos.size() / 4);

		paises = new HashCerrado<>(193);

		clases = new HashCerrado<>(datos.size() / 2);

		rubros = new BinarySearchTree<>();

		prodHabilitados = new HashCerrado<>(datos.size() / 2);

		nombresMarcas = new MiLinkedList<>();

		nombresEmpresas = new MiLinkedList<>();

		nombresPaises = new MiLinkedList<>();

		nombresClases = new MiLinkedList<>();

		cargarDatos(datos);

		obtenerEmpresas();
		
		System.out.println(" ");
		
		obtenerMarcas();

		System.out.println(" ");
		
		obtenerPaises();
		
	}

	public static void cargarDatos(List<String[]> datos) throws ElementoYaExistenteException {

		for (int i = 1; i < datos.size(); i++) {

			Marca marcaProd = null;
			Empresa empresaProd = null;
			Pais paisProd = null;
			Clase claseProd = null;
			Rubro rubroProd = null;

			if (marcas.pertenece(datos.get(i)[12]) == true) {
				marcaProd = marcas.get(datos.get(i)[12]);
			} else {
				marcaProd = new Marca(datos.get(i)[12]);
				marcas.insertar(datos.get(i)[12], marcaProd);
				nombresMarcas.addLast(datos.get(i)[12]);
			}

			if (empresas.pertenece(datos.get(i)[5]) == true) {
				empresaProd = empresas.get(datos.get(i)[5]);
			} else {
				empresaProd = new Empresa(datos.get(i)[5], datos.get(i)[23]);
				empresas.insertar(datos.get(i)[5], empresaProd);
				nombresEmpresas.addLast(datos.get(i)[5]);
			}

			if (paises.pertenece(datos.get(i)[13]) == true) {
				paisProd = paises.get(datos.get(i)[13]);
			} else {
				paisProd = new Pais(datos.get(i)[13]);
				paises.insertar(datos.get(i)[13], paisProd);
				nombresPaises.addLast(datos.get(i)[13]);
			}

			if (clases.pertenece(datos.get(i)[10]) == true) {
				claseProd = clases.get(datos.get(i)[10]);
			} else {
				claseProd = new Clase(datos.get(i)[10]);
				clases.insertar(datos.get(i)[10], claseProd);
				nombresClases.addLast(datos.get(i)[10]);
			}

			if (rubros.find(datos.get(i)[3]) != null) {
				rubroProd = rubros.find(datos.get(i)[3]);
			} else {
				rubroProd = new Rubro(datos.get(i)[3]);
				rubros.insert(datos.get(i)[3], rubroProd);
			}

			Producto prod = new Producto(datos.get(i)[0], datos.get(i)[1], datos.get(i)[2], datos.get(i)[20], marcaProd,
					empresaProd, rubroProd, claseProd, paisProd);
			
			int keyProducto = (datos.get(i)[0] + datos.get(i)[2] + datos.get(i)[4]).hashCode();

			marcas.get(datos.get(i)[12]).setProducto(prod);
			marcas.get(datos.get(i)[12]).setPaisMarca(paisProd);
			empresas.get(datos.get(i)[5]).setProductos(prod);

			if (prod.getEstaHabilitado() == true) {
				prodHabilitados.insertar(keyProducto, prod);
				empresas.get(datos.get(i)[5]).setCantProdHabilitados();
				marcas.get(datos.get(i)[12]).setCantProdHabilitados();
				paises.get(datos.get(i)[13]).setCantProdHabilitados();
			}
		}
	}

	public static void obtenerEmpresas() throws PosicionInvalida, HeapVacio {

		Empresa empresasConMayorProdHab[] = new Empresa[20];

		MyHeap<Integer, Empresa> heapEmpresas = new Heap<>(nombresEmpresas.size(), 1);

		for (int i = 0; i < nombresEmpresas.size(); i++) {

			int cantProd = empresas.get(nombresEmpresas.getElementoPorPos(i)).getCantProdHabilitados();

			heapEmpresas.insert(cantProd, empresas.get(nombresEmpresas.getElementoPorPos(i)));
		}

		for (int n = 0; n < 20; n++) {
			empresasConMayorProdHab[n] = heapEmpresas.findAndDelete();
		}

		for (int i = 0; i < 20; i++) {
			System.out.println("Nombre:" + empresasConMayorProdHab[i].getNombre() + " -- Poductos Habilitados:"
					+ empresasConMayorProdHab[i].getCantProdHabilitados());
		}

	}

	public static void obtenerMarcas() throws PosicionInvalida, HeapVacio {

		Marca marcasConMayorProdHab[] = new Marca[10];

		MyHeap<Integer, Marca> heapMarcas = new Heap<>(nombresMarcas.size(), 1);

		for (int i = 0; i < nombresMarcas.size(); i++) {

			int cantProd = marcas.get(nombresMarcas.getElementoPorPos(i)).getCantProdHabilitados();

			heapMarcas.insert(cantProd, marcas.get(nombresMarcas.getElementoPorPos(i)));
		}

		for (int n = 0; n < 10; n++) {
			marcasConMayorProdHab[n] = heapMarcas.findAndDelete();
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("Nombre:" + marcasConMayorProdHab[i].getNombre() + " -- Pais:"
					+ marcasConMayorProdHab[i].getPaisMarca().getNombre() + " -- Productos Habilitados:"
					+ marcasConMayorProdHab[i].getCantProdHabilitados());
		}

	}

	public static void obtenerPaises() throws PosicionInvalida, HeapVacio {

		Pais paisesConMayorProdHab[] = new Pais[10];

		MyHeap<Integer, Pais> heapPaises = new Heap<>(nombresPaises.size(), 1);
		
		int porcentaje;

		for (int i = 0; i < nombresPaises.size(); i++) {

			int cantProd = paises.get(nombresPaises.getElementoPorPos(i)).getCantProdHabilitados();

			heapPaises.insert(cantProd, paises.get(nombresPaises.getElementoPorPos(i)));

		}

		for (int n = 0; n < 10; n++) {
			paisesConMayorProdHab[n] = heapPaises.findAndDelete();
		}  

		for (int i = 0; i < 10; i++) {
			porcentaje = (paisesConMayorProdHab[i].getCantProdHabilitados()*100) / (prodHabilitados.getCantElementos());
			
			System.out.println("Pais:" + paisesConMayorProdHab[i].getNombre() + " -- Productos Habilitados:"
					+ paisesConMayorProdHab[i].getCantProdHabilitados() + " -- Porcentaje:" + porcentaje + "%");
		}
	}
	
	public void obtenerClasesPorPais() {
		
		
		
	}
	

}