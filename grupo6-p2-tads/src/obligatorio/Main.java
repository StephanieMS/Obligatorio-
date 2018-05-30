package obligatorio;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		
		String file = "v_producto_real_updated.csv";
		
		CSVReader csv = new CSVReader(new FileReader(file), ';');
		
		String[] fila = null;
		
		fila = csv.readNext(); 
		
		csv.close();
		
	
	}
	
}
