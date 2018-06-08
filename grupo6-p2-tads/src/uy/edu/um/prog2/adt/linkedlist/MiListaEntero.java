package uy.edu.um.prog2.adt.linkedlist;

public interface MiListaEntero<V> {

	public void addFirst(V nValue);
	
	public void addLast(V nValue);

	public V getElementoPorPos(int posicion) throws PosicionInvalida;

	public int size();

	public void eliminarElemento(V value);

	public boolean existeElemento(V nValor);

	public int getContador();
	
}
