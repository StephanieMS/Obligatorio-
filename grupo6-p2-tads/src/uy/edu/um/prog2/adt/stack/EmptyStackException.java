package uy.edu.um.prog2.adt.stack;

public class EmptyStackException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EmptyStackException(String msj) {
		super(msj);
	}
}
