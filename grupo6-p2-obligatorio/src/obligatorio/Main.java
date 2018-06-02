package obligatorio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import uy.edu.um.prog2.adt.hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.hash.HashCerrado;
import uy.edu.um.prog2.adt.hash.HashTable;

public class Main {
	
	private static HashTable<String, Marca> marcas;
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "v_producto_real_updated.csv";
	
		CSVReader csvReader = new CSVReader(new FileReader(fileName), ';');

		List<String[]> datos = csvReader.readAll();
		
		csvReader.close();
		
		marcas = new HashCerrado<>(datos.size() / 2);
		
		cargarDatos(datos);
		
		
	}
	
	public static void cargarDatos(List<String[]> datos) {
		
		for(int i = 1 ; i < datos.size() ; i++) {
			
			String id = (datos.get(i))[2];
			int idProd = Integer.parseInt(id); 	// falta verificar que el String se pueda castear(en caso de que el idProd != numero)
			
			Marca marcaProd = null;
			
			boolean existe = false;
			
			if(marcas.pertenece(datos.get(i)[12]) == true) {
				marcaProd = marcas.get(datos.get(i)[12]);
				existe = true;
			}else {
				marcaProd = new Marca(datos.get(i)[12]);
			}
			
			Producto<Integer> prod = new Producto<>((datos.get(i))[0], (datos.get(i))[1], idProd, (datos.get(i))[20], 
				marcaProd, (datos.get(i))[5], (datos.get(i))[23], (datos.get(i))[3], (datos.get(i))[10], (datos.get(i))[13]);
			
			if(existe == true) {
				marcas.get(datos.get(i)[12]).setProducto(prod);
				System.out.println("CARGADO");
			}else {
				try {
				marcas.insertar(datos.get(i)[12], marcaProd);
				}catch(ElementoYaExistenteException e1) {}
				
				marcas.get(datos.get(i)[12]).setProducto(prod);
				System.out.println("CARGADO");
			}
		
		}
		
	}
				
	
	
}