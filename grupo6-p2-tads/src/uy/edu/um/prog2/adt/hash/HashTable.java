package uy.edu.um.prog2.adt.hash;

public interface HashTable<K extends Comparable<K>, V> {
	
	public void insertar(K clave, V valor) throws ElementoYaExistenteException;

	public boolean pertenece(K clave);

	public void borrar(K clave) throws ClaveInvalida;
	
}
