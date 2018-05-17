package uy.edu.um.prog2.adt;

public interface MiListaEntero {

	public void agregar(int nValue);

	public int getElemento(int posicion) throws PosicionInvalida;

	public int size();

	public void eliminarElemento(int posicion);

	public boolean existeElemento(int nValor);

	public void addFirst(int Value);

	public void addLast(int Value);

}
