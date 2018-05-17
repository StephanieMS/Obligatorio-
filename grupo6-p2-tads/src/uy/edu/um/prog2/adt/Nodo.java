package uy.edu.um.prog2.adt;

public class Nodo {

	private int valor;
	private Nodo siguiente;
	private Nodo anterior;

	public Nodo(int nValor) {

		valor = nValor;
		siguiente = null;
		anterior = null;

	}

	public void setSiguiente(Nodo oTemp) {
		siguiente = oTemp;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setValor(int nValor) {
		valor = nValor;
	}

	public int getValor() {
		return valor;
	}

	public Nodo getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}

}
