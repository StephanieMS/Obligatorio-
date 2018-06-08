package AlgoritmosOrdenamiento;

import java.util.ArrayList;

public class Seleccion<T extends Comparable<T>>{

	public void order(ArrayList<T> toOrder) {
		
		int size = toOrder.size();
		
		if(size > 1) {
			
			int n = 0;
			int pos = 0;
			
			while(n < size) {
				
				T temp = null;
				T smaller = toOrder.get(n);
				pos = n;
				
				for(int i = n; i < size - 1; i++) {
					
					if(smaller.compareTo(toOrder.get(i+1)) > 0) {
						smaller = toOrder.get(i+1);
						pos = i+1;
					}
				}
				
				temp = toOrder.get(n);
				toOrder.set(n, smaller);
				toOrder.set(pos, temp);
				n++;
			}
			
		}
		
	}
	
	
}
