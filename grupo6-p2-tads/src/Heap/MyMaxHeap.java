package Heap;

public class MyMaxHeap<K extends Comparable<K>,T> implements Heap<K, T>{

	Node<K, T>[] maxHeap;
	
	public MyMaxHeap(int length) {
		maxHeap = new Node[length];
	}
	
	@Override
	public void insert(K key, T data) throws LengthException {
		Node<K, T> toInsert = new Node<>(key, data);
		
		int i = 0;
		while(maxHeap[i] != null && i < maxHeap.length) {
			i++;
		}
		if(i < maxHeap.length) {
			maxHeap[i] = toInsert;
			maxHeap[i].organizeMaxHeap(maxHeap, i);
		}else {
			LengthException e1 = new LengthException("--HEAP COMPLETE--");
			throw e1;
		}
		
	}

	@Override
	public T getDelete() throws EmptyException{
		T dataExit = null;
		
		if(maxHeap.length != 0) {
			dataExit =  maxHeap[0].getData();
			if(maxHeap[1].getKey().compareTo(maxHeap[2].getKey()) > 0) {
				for(int i = 0; i < maxHeap.length - 1; i++) {
					maxHeap[i] = maxHeap[i+1];
				}
			}else if(maxHeap[1].getKey().compareTo(maxHeap[2].getKey()) < 0) {
				maxHeap[0] = maxHeap[2];
				for(int i = 2; i < maxHeap.length - 1; i++) {
					maxHeap[i] = maxHeap[i+1];
				}
			}
		}else {
			EmptyException e1 = new EmptyException("--EMPTY HEAP--");
			throw e1;
		}
		
		return dataExit;
	}

	@Override
	public int getSize() {
		int size = 0;
		
		while(maxHeap[size] != null && size < maxHeap.length) {
			size++;
		}
		
		return size;
	}
	
	
	
	
}
