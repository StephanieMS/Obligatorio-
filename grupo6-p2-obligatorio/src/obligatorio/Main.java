package obligatorio;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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
		
		System.out.println(" ");
		
		Scanner sc = new Scanner(System.in);
		
		int opcion = 0;
		
		while(opcion != 5) {
			
			menu();
			
			opcion = sc.nextInt();
			
			switch(opcion) {
			
				case 1:
					obtenerEmpresas();
					System.out.println(" ");
					break;
					
				case 2:
					obtenerMarcas();
					System.out.println(" ");
					break;
					
				case 3:
					obtenerPaises();
					System.out.println(" ");
					break;
					
				case 4:
					obtenerClases();
					System.out.println(" ");
					break;
					
				case 5:
					break;
				
				default:
					System.out.println("Ingrese numero valido");
					System.out.println(" ");
					break;
			}
			
		}

	}
	
	public static void menu() {
		
		System.out.println("Indique el numero de Reporte que desea realizar:");
		System.out.println(" ");
		System.out.println("1. Listar las 20 empresas que disponen de mayor cantidad de productos habilitados");
		System.out.println("2. Listar las 10 marcas por país que tienen mayor cantidad de productos habilitados");
		System.out.println("3. Listar los 10 países que disponen la mayor cantidad de productos habilitados");
		System.out.println("4. Listar las 20 clases por país que tienen mayor cantidad de productos habilitados");
		System.out.println("5. Salir");
		System.out.println(" ");
	}

	public static void cargarDatos(List<String[]> datos) throws ElementoYaExistenteException {

		long time_start;
		long time_end;
		long time;
		
		time_start = System.currentTimeMillis();
		
		for (int i = 1; i < datos.size(); i++) {

			Marca marcaProd = null;
			Empresa empresaProd = null;
			Pais paisProd = null;
			Clase claseProd = null;
			Rubro rubroProd = null;
			
			String keyMarca = datos.get(i)[12] + datos.get(i)[13];
			String keyClase = datos.get(i)[10] + datos.get(i)[13];

			if (marcas.pertenece(keyMarca) == true && marcas.get(keyMarca).getPaisMarca().getNombre().equals(datos.get(i)[13])) {
				marcaProd = marcas.get(keyMarca);
			} else {
				marcaProd = new Marca(datos.get(i)[12]);
				marcas.insertar(keyMarca , marcaProd);
				nombresMarcas.addLast(keyMarca);
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

			if (clases.pertenece(keyClase) == true && clases.get(keyClase).getPaisClase().getNombre().equals(datos.get(i)[13])) {
				claseProd = clases.get(keyClase);
			} else {
				claseProd = new Clase(datos.get(i)[10]);
				clases.insertar(keyClase, claseProd);
				nombresClases.addLast(keyClase);
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

			marcas.get(keyMarca).setProducto(prod);
			marcas.get(keyMarca).setPaisMarca(paisProd);
			empresas.get(datos.get(i)[5]).setProductos(prod);
			clases.get(keyClase).setPaisClase(paisProd);

			if (prod.getEstaHabilitado() == true) {
				prodHabilitados.insertar(keyProducto, prod);
				empresas.get(datos.get(i)[5]).setCantProdHabilitados();
				marcas.get(keyMarca).setCantProdHabilitados();
				paises.get(datos.get(i)[13]).setCantProdHabilitados();
				clases.get(keyClase).setCantProdHabilitados();
			}
		}
		
		time_end = System.currentTimeMillis();
		time = time_end - time_start;
		
		System.out.println("Tiempo de Carga de datos: " + time / 1000 + " segundos");
	}

	public static void obtenerEmpresas() throws PosicionInvalida, HeapVacio {

		long time_start;
		long time_end;
		long time;
		
		time_start = System.currentTimeMillis();
		
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
			System.out.println("Empresa:" + empresasConMayorProdHab[i].getNombre() + " -- Poductos Habilitados:"
					+ empresasConMayorProdHab[i].getCantProdHabilitados());
		}
		
		time_end = System.currentTimeMillis();
		time = time_end - time_start;
		
		System.out.println(" ");

		System.out.println("Tiempo de reporte: " + time / 1000 + " segundos");
	}

	public static void obtenerMarcas() throws PosicionInvalida, HeapVacio {

		long time_start;
		long time_end;
		long time;
		
		time_start = System.currentTimeMillis();
		
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
			System.out.println("Marca:" + marcasConMayorProdHab[i].getNombre() + " -- Pais:"
					+ marcasConMayorProdHab[i].getPaisMarca().getNombre() + " -- Productos Habilitados:"
					+ marcasConMayorProdHab[i].getCantProdHabilitados());
		}
		
		time_end = System.currentTimeMillis();
		time = time_end - time_start;
		
		System.out.println(" ");

		System.out.println("Tiempo de reporte: " + time / 1000 + " segundos");

	}

	public static void obtenerPaises() throws PosicionInvalida, HeapVacio {

		long time_start;
		long time_end;
		long time;
		
		time_start = System.currentTimeMillis();
		
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
		
		time_end = System.currentTimeMillis();
		time = time_end - time_start;
		
		System.out.println(" ");

		System.out.println("Tiempo de reporte: " + time / 1000 + " segundos");	
	}
	
	public static void obtenerClases() throws PosicionInvalida, HeapVacio {
		
		long time_start;
		long time_end;
		long time;
		
		time_start = System.currentTimeMillis();
		
		Clase clasesConMayorProdHab[] = new Clase[20];
		
		MyHeap<Integer, Clase> heapClases = new Heap<>(nombresClases.size(), 1);
		
		for (int i = 0; i < nombresClases.size(); i++) {

			int cantProd = clases.get(nombresClases.getElementoPorPos(i)).getCantProdHabilitados();

			heapClases.insert(cantProd, clases.get(nombresClases.getElementoPorPos(i)));
		}
		
		for (int n = 0; n < 10; n++) {
			clasesConMayorProdHab[n] = heapClases.findAndDelete();
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Clase:" + clasesConMayorProdHab[i].getNombre() + " -- Pais:"
					+ clasesConMayorProdHab[i].getPaisClase().getNombre() + " -- Productos Habilitados:"
					+ clasesConMayorProdHab[i].getCantProdHabilitados());
		}
		
		time_end = System.currentTimeMillis();
		time = time_end - time_start;
		
		System.out.println(" ");

		System.out.println("Tiempo de reporte: " + time / 1000 + " segundos");
	}
	

}