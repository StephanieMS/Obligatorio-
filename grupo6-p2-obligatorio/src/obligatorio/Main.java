package obligatorio;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;

import p5.HeapSort;
import uy.edu.um.prog2.adt.binarySearchTree.BinarySearchTree;
import uy.edu.um.prog2.adt.binarySearchTree.MyBinarySearchTree;
import uy.edu.um.prog2.adt.linkedlist.MiLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MiListaEntero;
import uy.edu.um.prog2.adt.linkedlist.PosicionInvalida;

public class Main {
	
	private static MyBinarySearchTree<String, Marca> marcas;
		
	public static void main(String[] args) throws IOException {
		
		String fileName = "v_producto_real_updated.csv";
	
		CSVReader csvReader = new CSVReader(new FileReader(fileName), ';');

		List<String[]> datos = csvReader.readAll();
		
		csvReader.close();
		
		Marca primerProd = new Marca(datos.get(1)[12]);
		
		marcas = new BinarySearchTree<>(datos.get(1)[12], primerProd);
		
		cargarDatos(datos);
		
		try {
			obtenerEmpresas();
		} catch (PosicionInvalida e) {}
		
		
		
	}
	
	public static void cargarDatos(List<String[]> datos) {
		
		for(int i = 2 ; i < datos.size() ; i++) {
			
			Marca marcaProd = null;
			
			boolean existe = false;
			
			if(marcas.find(datos.get(i)[12]).getNombre() != null) {
				marcaProd = marcas.find(datos.get(i)[12]);
				existe = true;
			}else {
				marcaProd = new Marca(datos.get(i)[12]);
			}
			
			Producto<Integer> prod = new Producto<>((datos.get(i))[0], (datos.get(i))[1], (datos.get(i))[2], (datos.get(i))[20], 
				marcaProd, (datos.get(i))[5], (datos.get(i))[23], (datos.get(i))[3], (datos.get(i))[10], (datos.get(i))[13]);
			
			if(existe == true) {
				marcas.find(datos.get(i)[12]).setProducto(prod);
			}else {
				marcas.insert(datos.get(i)[12], marcaProd);
				marcas.find(datos.get(i)[12]).setProducto(prod);
			}
		
		}
		
	}
	
	public static void obtenerEmpresas() throws PosicionInvalida {
		
		Empresa empresasConMayorProdHab[] = new Empresa[20];
		
		MiListaEntero<Empresa> empresas = new MiLinkedList<>();
		
		ArrayList<Integer> cantElementosPorEmpresa = new ArrayList<>();
	
		for(int i = 0 ; i < marcas.preOrder().size(); i++) {
			
			for(int j = 0 ; j < marcas.preOrder().getElemento(i).getProductos().size(); j++) {
				
				if(marcas.preOrder().getElemento(i).getProductos().get(j).getEstado() == true) {
					empresas.addLast(marcas.preOrder().getElemento(i).getProductos().get(j).getpEmpresa());
				}
			}		
		}
		
		for(int i = 0 ; i < empresas.size() ; i++) {
			
			cantElementosPorEmpresa.add(empresas.getElemento(i).getCantProductosHabilitados());
			
		}
		HeapSort<Integer> heapToOrder = new HeapSort();
		
		heapToOrder.order(cantElementosPorEmpresa);
		
		for(int n = 0 ; n < 20; n++) {
			
		}
		
			
	}
				
	
	
}