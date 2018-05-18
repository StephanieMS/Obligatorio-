package Heap;

public interface Heap <K,T>{

	void insert(K key, T data) throws LengthException;
	T getDelete() throws EmptyException;
	int getSize();
	
}
