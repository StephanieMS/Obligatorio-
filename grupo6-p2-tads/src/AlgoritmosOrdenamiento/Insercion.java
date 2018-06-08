package AlgoritmosOrdenamiento;

import java.util.ArrayList;

public class Insercion<T extends Comparable<T>> {

	public void order(ArrayList<T> toOrder) {
		
		T temp = null;
		
		int size = toOrder.size();
		
		if(size > 1) {
			
			for(int i = 1 ; i < size; i++) {
				
				int n = i;
				
				while(n > 0 && toOrder.get(n).compareTo(toOrder.get(n-1)) < 0) {
					temp = toOrder.get(n);
					toOrder.set(n, toOrder.get(n-1));
					toOrder.set((n-1), temp);
					n--;
				}
			}
		}
	}
	
}
