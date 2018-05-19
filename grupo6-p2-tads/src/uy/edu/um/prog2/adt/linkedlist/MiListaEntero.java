package uy.edu.um.prog2.adt.linkedlist;

public interface MiListaEntero<V> {

	public void agregar(V nValue);

	public V getElemento(int posicion) throws PosicionInvalida;

	public int size();

	public void eliminarElemento(V value);

	public boolean existeElemento(V nValor);

	public void addFirst(V Value);

	public void addLast(V Value);

}
