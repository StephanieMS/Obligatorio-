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
		}catch(ElementoYaExistenteException e) {}
		
	}
	
	public static void cargarDatos(List<String[]> datos) throws ElementoYaExistenteException {
		
		for(int i = 1 ; i < datos.size() /8 ; i++) {
			
			Marca marcaProd = null;
			Empresa empresaProd = null;
			Pais paisProd = null;
			Clase claseProd = null;
			Rubro rubroProd = null;
			
			if(marcas.pertenece(datos.get(i)[12]) == true){
				marcaProd = marcas.get(datos.get(i)[12]);
				marcaProd.setCantProductosHabilitados();
			}else {
				marcaProd = new Marca(datos.get(i)[12]);
				marcas.insertar(datos.get(i)[12], marcaProd);
				nombresMarcas.addLast(datos.get(i)[12]);
			}
			
			if(empresas.pertenece(datos.get(i)[5]) == true){
				empresaProd = empresas.get(datos.get(i)[5]);
				empresaProd.setCantProductosHabilitados();
			}else {
				empresaProd = new Empresa(datos.get(i)[5], datos.get(i)[23]);
				empresas.insertar(datos.get(i)[5], empresaProd);
				nombresEmpresas.addLast(datos.get(i)[5]);
			}
			
			if(paises.pertenece(datos.get(i)[13]) == true){
				paisProd = paises.get(datos.get(i)[13]);
				paisProd.setCantProductosHabilitados();
			}else {
				paisProd = new Pais(datos.get(i)[13]);
				paises.insertar(datos.get(i)[13], paisProd);
				nombresPaises.addLast(datos.get(i)[13]);
			}
			
			
			//CORREGIR
			
			
			if(clases.pertenece(datos.get(i)[13]) == true){
				 = empresas.get(datos.get(i)[5]);
				empresaProd.setCantProductosHabilitados();
			}else {
				empresaProd = new Empresa(datos.get(i)[5], datos.get(i)[23]);
				empresas.insertar(datos.get(i)[5], empresaProd);
				nombresEmpresas.addLast(datos.get(i)[5]);
			}
			
			
			
			
			if(empresas.pertenece(datos.get(i)[5]) == true){
				empresaProd = empresas.get(datos.get(i)[5]);
				empresaProd.setCantProductosHabilitados();
			}else {
				empresaProd = new Empresa(datos.get(i)[5], datos.get(i)[23]);
				empresas.insertar(datos.get(i)[5], empresaProd);
				nombresEmpresas.addLast(datos.get(i)[5]);
			}
			
			Producto prod = new Producto(datos.get(i)[0], datos.get(i)[1], datos.get(i)[2], datos.get(i)[20], 
					marcaProd, empresaProd, datos.get(i)[3], datos.get(i)[10], paisProd);
		
		}
		
	}
	
	
	
//	public static void obtenerEmpresas() throws PosicionInvalida {
//		
//		Empresa empresasConMayorProdHab[] = new Empresa[20];
//		
//		
//		
//		MiListaEntero<Empresa> empresas = new MiLinkedList<>();
//		
//		ArrayList<Integer> cantElementosPorEmpresa = new ArrayList<>();
//	
//		for(int i = 0 ; i < marcas.preOrder().size(); i++) {
//			
//			if(marcas.preOrder() != null && marcas.preOrder().getElemento(i) != null) {
//				
//				for(int j = 0 ; j < marcas.preOrder().getElemento(i).getProductos().size(); j++) {
//					
//					if(marcas.preOrder().getElemento(i).getProductos().get(j).getEstado() == true) {
//						empresas.addLast(marcas.preOrder().getElemento(i).getProductos().get(j).getpEmpresa());
//					}
//				}	
//			}
//				
//		}
//		
//		for(int i = 0 ; i < empresas.size() ; i++) {
//			
//			cantElementosPorEmpresa.add(empresas.getElemento(i).getCantProductosHabilitados());
//			
//		}
//		HeapSort<Integer> heapToOrder = new HeapSort();
//		
//		heapToOrder.order(cantElementosPorEmpresa);
//		
//		for(int n = 0 ; n < 20; n++) {
//			
//			for(int j = 0; j < empresas.size(); j++) {
//			
//				if(empresas.getElemento(j).getCantProductosHabilitados() == cantElementosPorEmpresa.get(n)) {
//					empresasConMayorProdHab[n] = empresas.getElemento(j);
//				}
//			}
//		}
//		
//		for(int i = 0 ; i < 20; i++) {
//			System.out.println(empresasConMayorProdHab[i].getNombre());
//		}	
//	}
				
	
	
}