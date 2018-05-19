package uy.edu.um.prog2.adt.linkedlist;

public class Nodo<V> {

	private V valor;
	private Nodo<V> siguiente;

	public Nodo(V nValor) {

		valor = nValor;
		siguiente = null;

	}

	public void setSiguiente(Nodo<V> oTemp) {
		siguiente = oTemp;
	}

	public Nodo<V> getSiguiente() {
		return siguiente;
	}

	public void setValor(V nValor) {
		valor = nValor;
	}

	public V getValor() {
		return valor;
	}

}
