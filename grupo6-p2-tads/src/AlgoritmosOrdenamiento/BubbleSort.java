package AlgoritmosOrdenamiento;

import java.util.ArrayList;

public class BubbleSort<T extends Comparable<T>> {
	
	public void order(ArrayList<T> toOrder) {
		
		T temp = null;
		
		int size = toOrder.size();
		
		boolean changes = false;
		
		while(size > 1) {
			
			size--;
				
			for(int i = 0 ; i < size; i++) {
					
				if(toOrder.get(i).compareTo(toOrder.get(i+1)) > 0) {
					temp = toOrder.get(i);
					toOrder.set(i, toOrder.get(i+1));
					toOrder.set((i+1), temp);
					changes = true;
				}
			}
			if(changes == false) {
				size = 0;
			}
		}
	}
}
