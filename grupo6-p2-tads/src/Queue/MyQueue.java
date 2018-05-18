package Queue;

public interface MyQueue<T> {
	void enqueue (T element);
	void dequeue () throws EmptyQueueException;
	boolean isEmpty();
	public T getFirst() throws EmptyQueueException;
	public void print();
}
