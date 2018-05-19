package uy.edu.um.prog2.adt.queue;

public interface MyQueue<T> {
	
	void enqueue (T element);
	
	void dequeue () throws EmptyQueueException;
	
	boolean isEmpty();
	
	public T getFirst() throws EmptyQueueException;
	
	public void print();

}
