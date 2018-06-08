package AlgoritmosOrdenamiento;

import java.util.ArrayList;

public class ParImpar<T extends Comparable<T>> {

	
	public int order(ArrayList<T> toOrder) {
		
		T temp = null;
		
		int size = toOrder.size();
		
		while(size > 3) {
			
			size--;
			size--;
				
			for(int i = 0 ; i < size; i++) {
					
				if(toOrder.get(i).compareTo(toOrder.get(i+2)) > 0) {
					temp = toOrder.get(i);
					toOrder.set(i, toOrder.get(i+2));
					toOrder.set((i+2), temp);
				}
			}	
		}
		
		size = toOrder.size();
		
		boolean change = false;
		
		int changes = 0;
		
		while(size > 1) {
	
			size--;
				
			for(int i = 0 ; i < size; i++) {
					
				if(toOrder.get(i).compareTo(toOrder.get(i+1)) > 0) {
					temp = toOrder.get(i);
					toOrder.set(i, toOrder.get(i+1));
					toOrder.set((i+1), temp);
					change = true;
					changes++;
					
				}
			}
			if(change == false) {
				size = 0;
			}
		}
	return changes;	
	}
	
}
