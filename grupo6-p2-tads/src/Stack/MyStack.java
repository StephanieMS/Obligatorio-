package Stack;

public class MyStack implements Stack{

	private Nodo first;
	private Nodo last;
	
	public MyStack() {
		first = null;
		last = null;
	}
	
	
	public void pop() throws EmptyStackException {
		if(isEmpty() == true) {
			EmptyStackException e2 = new EmptyStackException("--EMPTY STACK--");
			throw e2;
		}else {
			Nodo toDelete = last;
			last = last.getPrevious();
			last.setNext(null);
			toDelete.setNext(null);
			toDelete.setPrevious(null);
		}
	}
	
	public Object top() throws EmptyStackException {
		Object top = null;
		
		if(isEmpty() == true) {
			EmptyStackException e1 = new EmptyStackException("--EMPTY STACK--");
			throw e1;
		}else {
			top = last.getElement();
		}
		return top;
	}

	public void push(Object element) {
		Nodo toAdd = new Nodo(element);
		
		if(isEmpty() == true) {
			first = toAdd;
			last = toAdd;
		}else {
			Nodo temp = first;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(toAdd);
			toAdd.setPrevious(temp);
			last = toAdd;
		}		
	}

	public boolean isEmpty() {
		boolean empty = false;
		if(first == null) {
			empty = true;
		} else {
			empty = false;
		}
		return empty;
	}

	public void makeEmpty() {
		if(isEmpty() == false) {
			while(first != last) {
				Nodo toDelete = last;
				last = last.getPrevious();
				last.setNext(null);
				toDelete.setNext(null);
				toDelete.setPrevious(null);
			}
			if(first == last) {
				first = null;
				last = null;
			}
		}
	}
	
	public void print() {
		if(isEmpty() == false) {
			Nodo temp = first;
			while(temp != null) {
				System.out.println(temp.getElement());
				temp = temp.getNext();
			}
		}else {
			System.out.println("EMPTY STACK");
		}
	}
	
	
}
