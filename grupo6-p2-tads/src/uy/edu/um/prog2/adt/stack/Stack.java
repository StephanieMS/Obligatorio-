package uy.edu.um.prog2.adt.stack;

public interface Stack {
	public void pop() throws EmptyStackException;

	public Object top() throws EmptyStackException;

	public void push(Object element);

	public boolean isEmpty();

	public void makeEmpty();

	public void print();
}
