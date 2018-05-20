package uy.edu.um.prog2.adt.heap;

public interface MyHeap<K,V> {
	
	public void insert(K key, V value);
	
	public V findAndDelete();
	
	NodoHeap<K, V> getParent(int nPos);
	
	NodoHeap<K, V> getLeftChild(int pos);
	
	NodoHeap<K, V> getRightChild(int pos);
	
	public int getSize();
	
}
