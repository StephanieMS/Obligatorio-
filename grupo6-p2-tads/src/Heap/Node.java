package Heap;

public class Node<K extends Comparable<K>,T> {

	private K key;
	private T data;
	
	public Node(K key, T data) {
		this.key = key;
		this.data = data;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public void organizeMaxHeap(Node<K,T>[] toOrganize, int pos) {
		int posFather = (pos-1)/2;
		
		if(getKey().compareTo(toOrganize[posFather].getKey()) > 0) {
			
			Node<K,T> temp = toOrganize[posFather];
			toOrganize[posFather] = toOrganize[pos];
			toOrganize[pos] = temp;
			toOrganize[posFather].organizeMaxHeap(toOrganize, posFather);
			
		}
		
	}
	
	
}
