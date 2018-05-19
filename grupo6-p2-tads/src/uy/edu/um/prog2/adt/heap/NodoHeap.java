package uy.edu.um.prog2.adt.heap;

public class NodoHeap<K,V> {
	K key;
	V value;


	public NodoHeap(K key, V value) {
		this.key = key;
		this.value = value;

	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getData() {
		return value;
	}

	public void setData(V value) {
		this.value = value;
	}
	
}
