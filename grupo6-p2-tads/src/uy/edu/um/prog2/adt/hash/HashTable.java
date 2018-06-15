package uy.edu.um.prog2.adt.hash;

import java.util.Iterator;

public interface HashTable<K extends Comparable<K>, V> {
	
	public void insertar(K clave, V valor) throws ElementoYaExistenteException;

	public boolean pertenece(K clave);

	public void borrar(K clave) throws ClaveInvalida;
	
	public V get(K clave);
	
	public int getCantElementos();
	
	public Iterator<V> iterator();
	
}
