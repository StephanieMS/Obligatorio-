package obligatorio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "v_producto_real_updated.csv";
	
		CSVReader csvReader = new CSVReader(new FileReader(fileName), ';');

	//	List<String[]> datos = csvReader.readAll();
		
		String[] fila = null;
		
		while((fila = csvReader.readNext()) != null) {
		    System.out.println("NOMBRE: " + fila[0]);
		}
		
		csvReader.close();
		
	}
				
	
	
}
