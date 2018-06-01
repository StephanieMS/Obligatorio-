package obligatorio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;

import uy.edu.um.prog2.adt.hash.ElementoYaExistenteException;
import uy.edu.um.prog2.adt.hash.HashCerrado;
import uy.edu.um.prog2.adt.hash.HashTable;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "v_producto_real_updated.csv";
	
		CSVReader csvReader = new CSVReader(new FileReader(fileName), ';');

		List<String[]> datos = csvReader.readAll();
		
		HashTable<Integer, Producto<Integer>> productos;
		
		for(int i = 1 ; i < datos.size() ; i++) {
			
			String id = (datos.get(i))[2];
			int idProd = Integer.parseInt(id); 	// falta verificar que el String se pueda castear(en caso de que el idProd != numero)
			
			Producto<Integer> prod = new Producto<>((datos.get(i))[0], (datos.get(i))[1], idProd, (datos.get(i))[20], 
				(datos.get(i))[12], (datos.get(i))[5], (datos.get(i))[23], (datos.get(i))[3], (datos.get(i))[10], (datos.get(i))[13]);
			
			productos = new HashCerrado<>(datos.size());
			
			try {
				productos.insertar(idProd, prod);
			} catch (ElementoYaExistenteException e) {}
			
			System.out.println("Producto agregado");
		
		}
		
		csvReader.close();
		
	}
				
	
	
}
