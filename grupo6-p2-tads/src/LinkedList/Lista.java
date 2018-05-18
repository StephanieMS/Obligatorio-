package LinkedList;

public interface Lista<V> {
	
	public void addFirst(V value);
	public void addLast(V value);
	public void delete(V value);
	public V get(int pos);
	public void print();
	
}
