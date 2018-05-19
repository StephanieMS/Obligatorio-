package uy.edu.um.prog2.adt.queue;

public class Queue<E> implements MyQueue<E>{

	private Nodo<E> first;
	
	public Queue() {
		first = null;
	}
	
	public void enqueue(E element) {	
		Nodo<E> toAdd = new Nodo<E>(element);
		
		if(isEmpty() == true) {
			first = toAdd;
		}else {
			Nodo<E> temp = first;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(toAdd);
		}		
	}

	public void dequeue() throws EmptyQueueException {
		
		if(isEmpty() == true) {
			EmptyQueueException e1 = new EmptyQueueException("--EMPTY QUEUE--");
			throw e1;
		}else {
			Nodo<E> toDelete = first;
			first = first.getNext();
			toDelete.setNext(null);
		}
	}

	public boolean isEmpty() {
		boolean empty = false;
		
		if(first == null) {
			empty = true;
		}else {
			empty = false;
		}
		return empty;
	}

	public E getFirst() throws EmptyQueueException {
		E firstElement = null;
		
		if(isEmpty() == true) {
			EmptyQueueException e1 = new EmptyQueueException("--EMPTY QUEUE--");
			throw e1;
		}else {
			firstElement = first.getElement();
		}
		return firstElement;
	}
	
	public void print() {
		if(isEmpty() == false) {
			Nodo<E> temp = first;
			while(temp != null) {
				System.out.println(temp.getElement());
				temp = temp.getNext();
			}
		}else {
			System.out.println("EMPTY QUEUE");
		}
	}
	
}
