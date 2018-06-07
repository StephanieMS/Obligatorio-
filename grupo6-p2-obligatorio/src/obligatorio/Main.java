package obligatorio;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.opencsv.CSVReader;

import p5.HeapSort;
import uy.edu.um.prog2.adt.binarySearchTree.BinarySearchTree;
import uy.edu.um.prog2.adt.binarySearchTree.MyBinarySearchTree;
import uy.edu.um.prog2.adt.hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.hash.HashCerrado;
import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.linkedlist.MiLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MiListaEntero;
import uy.edu.um.prog2.adt.linkedlist.PosicionInvalida;

public class Main {

	private static HashTable<String, Marca> marcas;
	private static HashTable<String, Empresa> empresas;
	private static HashTable<String, Pais> paises;
	private static HashTable<String, Clase> clases;
	private static MiListaEntero<String> rubros;

	private static MiListaEntero<String> nombresMarcas;
	private static MiListaEntero<String> nombresEmpresas;
	private static MiListaEntero<String> nombresPaises;
	private static MiListaEntero<String> nombresClases;

	public static void main(String[] args) throws IOException {

		String fileName = "v_producto_real_updated.csv";

		CSVReader csvReader = new CSVReader(new FileReader(fileName), ';');

		List<String[]> datos = csvReader.readAll();

		csvReader.close();

		marcas = new HashCerrado<>(datos.size() / 2);

		empresas = new HashCerrado<>(datos.size() / 4);

		paises = new HashCerrado<>(193);

		rubros = new MiLinkedList<>();

		clases = new HashCerrado<>(datos.size() / 2);

		nombresMarcas = new MiLinkedList<>();

		nombresEmpresas = new MiLinkedList<>();

		nombresPaises = new MiLinkedList<>();

		nombresClases = new MiLinkedList<>();

		try {
			cargarDatos(datos);
		} catch (ElementoYaExistenteException e) {
		}

	}

	public static void cargarDatos(List<String[]> datos) throws ElementoYaExistenteException {

		for (int i = 1; i < datos.size() / 8; i++) {

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

			// sin terminar
			if (rubros.existeElemento(datos.get(i)[3]) == true) {
				rubroProd = rubros.get(datos.get(i)[5]); // tiene que ser una posicion porque el get busca por posicion
			} else {
				rubroProd = new Rubro(datos.get(i)[3]);
				rubros.agregar(datos.get(i)[3]);
			}

			Producto prod = new Producto(datos.get(i)[0], datos.get(i)[1], datos.get(i)[2], datos.get(i)[20], marcaProd,
					empresaProd, rubroProd, claseProd, paisProd);

		}

	}

	public static void obtenerEmpresas() {
		Empresa empresasConMayorProdHab[] = new Empresa[20];
		MiListaEntero<Integer> cantElementosPorEmpresa = new MiLinkedList<>();

		// la key en empresas.getElemento tiene que ser una empresa pero no se como
		// poner cual empresa tiene que ser en esa posicion
		for (int i = 0; i < nombresEmpresas.size(); i++) {
			cantElementosPorEmpresa
					.add(empresas.getElemento(nombresEmpresas.getElemento(i), Empresa).getCantProductosHabilitados());
		}
		
		//hay que agregar heapSort a la carpeta de los tads
		HeapSort<Integer> heapToOrder = new HeapSort();

		heapToOrder.order(cantElementosPorEmpresa);

		for (int n = 0; n < 20; n++) {
			for (int j = 0; j < 20; j++) {
				if (empresas.getElemento(nombresEmpresas.getElemento(n), Empresa)
						.getCantProductosHabilitados() == cantElementosPorEmpresa.getElemento(j)) {
					empresasConMayorProdHab[n] = empresas.getElemento(nombresEmpresas.getElemento(j), Empresa);
				}
			}

		}

		for (int i = 0; i < 20; i++) {
			System.out.println(empresasConMayorProdHab[i].getNombre());
		}

	}

}