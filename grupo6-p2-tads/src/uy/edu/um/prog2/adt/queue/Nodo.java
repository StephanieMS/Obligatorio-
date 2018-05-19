package uy.edu.um.prog2.adt.queue;

public class Nodo<E> {
	
	private E element;
	private Nodo<E> next;
	private int priority = 0;
	
	public Nodo(E element) {
		this.element = element;
		next = null;
		priority = 0;
	}
	
	public void setNext(Nodo<E> next) {
		this.next = next;
	}

	public Nodo<E> getNext() {
		return next;
	}
	
	public E getElement() {
		return element;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int getPriority() {
		return priority;
	}

}
