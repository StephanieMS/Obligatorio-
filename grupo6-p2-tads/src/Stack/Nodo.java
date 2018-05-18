package Stack;

public class Nodo {

	private Object element;
	private Nodo next;
	private Nodo previous;
	
	public Nodo(Object element) {
		this.element = element;
		next = null;
		previous = null;
	}
	
	public void setNext(Nodo next) {
		this.next = next;
	}
	
	public void setPrevious(Nodo previous) {
		this.previous = previous;
	}

	public Nodo getNext() {
		return next;
	}
	
	public Nodo getPrevious() {
		return previous;
	}
	
	public Object getElement() {
		return element;
	}
	
	
}
