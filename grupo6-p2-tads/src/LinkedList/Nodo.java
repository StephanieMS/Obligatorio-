package LinkedList;

public class Nodo<V> {

	private V value;
	private Nodo<V> next;
	
	public Nodo(V value) {
		this.value = value;
		next = null;
	}
	
	public void setNext(Nodo<V> next) {
		this.next = next;
	}
	
	public Nodo<V> getNext() {
		return next;
	}
	
	public V getValue() {
		return value;
	}
	
	
}
