package obligatorio;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.opencsv.CSVReader;
import uy.edu.um.prog2.adt.hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.hash.HashCerrado;
import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.heap.Heap;
import uy.edu.um.prog2.adt.heap.HeapVacio;
import uy.edu.um.prog2.adt.heap.MyHeap;
import uy.edu.um.prog2.adt.linkedlist.PosicionInvalida;

public class Main {

	private static HashTable<String, Marca> marcas;
	private static HashTable<String, Empresa> empresas;
	private static HashTable<String, Pais> paises;
	private static HashTable<String, Clase> clases;

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
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Presione 'Enter' para cargar datos");
		
		System.out.println(" ");
		
		if(sc.nextLine() != null) {
			cargarDatos(datos);
		}
		
		System.out.println(" ");
		
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
		sc.close();
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
			
			if(datos.get(i)[12].contains("  ")) {
				datos.get(i)[12] = datos.get(i)[12].replace("  "," ");
			}
			
			String keyMarca = datos.get(i)[12] + datos.get(i)[13];
			String keyClase = datos.get(i)[10] + datos.get(i)[13];

			if (marcas.pertenece(keyMarca) == true && marcas.get(keyMarca).getPaisMarca().getNombre().equals(datos.get(i)[13])) {
				marcaProd = marcas.get(keyMarca);
			} else {
				marcaProd = new Marca(datos.get(i)[12]);
				marcas.insertar(keyMarca , marcaProd);
			}

			if (empresas.pertenece(datos.get(i)[5]) == true) {
				empresaProd = empresas.get(datos.get(i)[5]);
			} else {
				empresaProd = new Empresa(datos.get(i)[5], datos.get(i)[23]);
				empresas.insertar(datos.get(i)[5], empresaProd);
			}
				
			if (paises.pertenece(datos.get(i)[13]) == true) {
				paisProd = paises.get(datos.get(i)[13]);
			} else {
				paisProd = new Pais(datos.get(i)[13]);
				paises.insertar(datos.get(i)[13], paisProd);
			}

			if (clases.pertenece(keyClase) == true && clases.get(keyClase).getPaisClase().getNombre().equals(datos.get(i)[13])) {
				claseProd = clases.get(keyClase);
			} else {
				claseProd = new Clase(datos.get(i)[10]);
				clases.insertar(keyClase, claseProd);
			}

			if (datos.get(i)[3].equals("Exp")) {
				rubroProd = Rubro.EXPENDEDOR;
			} else if(datos.get(i)[3].equals("Elab")){
				rubroProd = Rubro.ELABORADOR;
			}else {
				rubroProd = Rubro.EXPENDEDOR_ELABORADOR;
			}
			
			Producto prod = new Producto(datos.get(i)[0], datos.get(i)[1], datos.get(i)[2], datos.get(i)[20], marcaProd,
					empresaProd, rubroProd, claseProd, paisProd);

			marcas.get(keyMarca).setProducto(prod);
			marcas.get(keyMarca).setPaisMarca(paisProd);
			empresas.get(datos.get(i)[5]).setProductos(prod);
			clases.get(keyClase).setPaisClase(paisProd);
	
			if (prod.getEstaHabilitado() == true) {
				marcas.get(keyMarca).setProductosHabilitados(prod);
				empresas.get(datos.get(i)[5]).setProductosHabilitados(prod);
				clases.get(keyClase).setProductosHabilitados(prod);
				paises.get(datos.get(i)[13]).setProductosHabilitados(prod);
			}
		}
		
		time_end = System.currentTimeMillis();
		time = time_end - time_start;
		
		System.out.println("Tiempo de Carga de datos: " + time + " milisegundos");
	}

	
	public static void obtenerEmpresas() throws PosicionInvalida, HeapVacio {		
		
		long time_start;
		long time_end;
		long time;
		
		time_start = System.currentTimeMillis();
		
		Empresa empresasConMayorProdHab[] = new Empresa[20];

		MyHeap<Integer, Empresa> heapEmpresas = new Heap<>(empresas.getCantElementos(), 1);
		
		Iterator<Empresa> iterator = empresas.iterator();

		int cantProd = 0;
		Empresa tempEmpresa = null;
			
		while(iterator.hasNext() != false) {
			tempEmpresa = iterator.next();
			cantProd = tempEmpresa.getProductosHabilitados().size();
			heapEmpresas.insert(cantProd, tempEmpresa);
		}
		
		for (int n = 0; n < 20; n++) {
			empresasConMayorProdHab[n] = heapEmpresas.findAndDelete();
		}
		
		for (int i = 0; i < 20; i++) {
			System.out.println("Empresa:" + empresasConMayorProdHab[i].getNombre() + " -- Poductos Habilitados:"
					+ empresasConMayorProdHab[i].getProductosHabilitados().size());
		}
		
		time_end = System.currentTimeMillis();
		time = time_end - time_start;
		
		System.out.println(" ");
		System.out.println("Tiempo de reporte: " + time + " milisegundos");
	}

	
	public static void obtenerMarcas() throws PosicionInvalida, HeapVacio {

		long time_start;
		long time_end;
		long time;
		
		time_start = System.currentTimeMillis();
		
		Marca marcasConMayorProdHab[] = new Marca[10];

		MyHeap<Integer, Marca> heapMarcas = new Heap<>(marcas.getCantElementos(), 1);

		Iterator<Marca> iterator = marcas.iterator();

		int cantProd = 0;
		Marca tempMarca = null;
			
		while(iterator.hasNext() != false) {
			tempMarca = iterator.next();
			cantProd = tempMarca.getProductosHabilitados().size();
			heapMarcas.insert(cantProd, tempMarca);
		}

		for (int n = 0; n < 10; n++) {
			marcasConMayorProdHab[n] = heapMarcas.findAndDelete();
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("Marca:" + marcasConMayorProdHab[i].getNombre() + " -- Pais:"
					+ marcasConMayorProdHab[i].getPaisMarca().getNombre() + " -- Productos Habilitados:"
					+ marcasConMayorProdHab[i].getProductosHabilitados().size());
		}
		
		time_end = System.currentTimeMillis();
		time = time_end - time_start;
		
		System.out.println(" ");
		System.out.println("Tiempo de reporte: " + time + " milisegundos");
	}

	
	public static void obtenerPaises() throws PosicionInvalida, HeapVacio {

		long time_start;
		long time_end;
		long time;
		
		time_start = System.currentTimeMillis();
		
		Pais paisesConMayorProdHab[] = new Pais[10];

		MyHeap<Integer, Pais> heapPaises = new Heap<>(paises.getCantElementos(), 1);
		
		int cantProdHabilitados = 0;

		Iterator<Pais> iterator = paises.iterator();

		int cantProd = 0;
		Pais tempPais = null;
			
		while(iterator.hasNext() != false) {
			tempPais = iterator.next();
			cantProd = tempPais.getProductosHabilitados().size();
			cantProdHabilitados = cantProdHabilitados + cantProd;
			heapPaises.insert(cantProd, tempPais);
		}

		for (int n = 0; n < 10; n++) {
			paisesConMayorProdHab[n] = heapPaises.findAndDelete();
		}  

		for (int i = 0; i < 10; i++) {

			int porcentaje = (paisesConMayorProdHab[i].getProductosHabilitados().size()*100) / cantProdHabilitados;
			
			System.out.println("Pais:" + paisesConMayorProdHab[i].getNombre() + " -- Productos Habilitados:"
					+ paisesConMayorProdHab[i].getProductosHabilitados().size() + " -- Porcentaje:" + porcentaje + "%");
		}
		
		time_end = System.currentTimeMillis();
		time = time_end - time_start;
		
		System.out.println(" ");
		System.out.println("Tiempo de reporte: " + time + " milisegundos");	
	}
	
	
	public static void obtenerClases() throws PosicionInvalida, HeapVacio {
		
		long time_start;
		long time_end;
		long time;
		
		time_start = System.currentTimeMillis();
		
		Clase clasesConMayorProdHab[] = new Clase[20];
		
		MyHeap<Integer, Clase> heapClases = new Heap<>(clases.getCantElementos(), 1);
		
		Iterator<Clase> iterator = clases.iterator();

		int cantProd = 0;
		Clase tempClase = null;
			
		while(iterator.hasNext() != false) {
			tempClase = iterator.next();
			cantProd = tempClase.getProductosHabilitados().size();
			heapClases.insert(cantProd, tempClase);
		}
		
		for (int n = 0; n < 20; n++) {
			clasesConMayorProdHab[n] = heapClases.findAndDelete();
		}
		
		for (int i = 0; i < 20; i++) {
			System.out.println("Clase:" + clasesConMayorProdHab[i].getNombre() + " -- Pais:"
					+ clasesConMayorProdHab[i].getPaisClase().getNombre() + " -- Productos Habilitados:"
					+ clasesConMayorProdHab[i].getProductosHabilitados().size());
		}
		
		time_end = System.currentTimeMillis();
		time = time_end - time_start;
		
		System.out.println(" ");
		System.out.println("Tiempo de reporte: " + time + " milisegundos");
	}

}