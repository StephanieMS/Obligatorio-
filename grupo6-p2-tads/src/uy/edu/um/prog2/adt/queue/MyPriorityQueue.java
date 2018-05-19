package uy.edu.um.prog2.adt.queue;

public class MyPriorityQueue<P> implements PriorityQueue<P>{
	
	private Nodo<P> first;
	private Nodo<P> last;
	
	public MyPriorityQueue() {
		first = null;
		last = null;
	}
	
	public void enqueue(P element) {
		Nodo<P> toAdd = new Nodo<>(element);
		
		if(isEmpty() == true) {
			first = toAdd;
			last = first;
		}else {
			last.setNext(toAdd);
			last = toAdd;
		}		
	}

	public void dequeue() throws EmptyQueueException {
		if(isEmpty() == true) {
			EmptyQueueException e1 = new EmptyQueueException("--EMPTY QUEUE--");
			throw e1;
		}else {
			Nodo<P> toDelete = first;
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

	public P getFirst() throws EmptyQueueException {
		P firstElement = null;
		
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
			Nodo<P> temp = first;
			while(temp != null) {
				System.out.println(temp.getElement());
				temp = temp.getNext();
			}
		}else {
			System.out.println("EMPTY QUEUE");
		}
	}

	public void insertWithPriority(P element, int priority) {
		Nodo<P> toAdd = new Nodo<>(element);
		toAdd.setPriority(priority);
		
		Nodo<P> temp = first;
		
		if(temp != null) {
			if(first.getPriority() < priority) {
				toAdd.setNext(first);
				first = toAdd; 
			}else if(first.getPriority() == priority){ 
				while((temp.getNext()).getPriority() == priority) {
					temp = temp.getNext();
				}
				toAdd.setNext(temp.getNext());
				temp.setNext(toAdd);
			}else if(last.getPriority() >= priority) {
				last.setNext(toAdd);
				last = toAdd;
			}else {
				while(temp != last && temp.getPriority() != priority) {
					temp = temp.getNext();
				}
				
				if(temp == last) {
					temp = first;
					while((temp.getNext()).getPriority() > priority) {
						temp = temp.getNext();
					}
					if((temp.getNext()).getPriority() < priority) {
						toAdd.setNext(temp.getNext());
						temp.setNext(toAdd);
					}
				}else if(temp.getPriority() == priority) {
					while(temp.getNext() != last && (temp.getNext()).getPriority() == priority ) {
						temp = temp.getNext();
					}
					if(temp.getNext() == last) {
						temp.setNext(toAdd);
						toAdd.setNext(last);
					}else {
						toAdd.setNext(temp.getNext());
						temp.setNext(toAdd);
					}
				}
			}
		}
		if(isEmpty() == true) {
			first = toAdd;
		}	
	}
	


}
