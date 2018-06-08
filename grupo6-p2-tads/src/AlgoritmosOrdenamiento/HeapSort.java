package AlgoritmosOrdenamiento;

import java.util.List;

import uy.edu.um.prog2.adt.heap.*;

public class HeapSort<T extends Comparable<T>> {

	public void order(List<T> toOrder) {
		
		int size = toOrder.size();
		
		MyHeap<T,T> min = new Heap<>(size,-1);
		
		for(int i = 0 ; i < size; i++) {
			
			min.insert(toOrder.get(i), toOrder.get(i));
				
		}
		
		for(int i = 0; i < size; i++) {
			
			toOrder.set(i, min.findAndDelete());
			
		}
		
	}
	
	
}
