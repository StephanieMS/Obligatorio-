package uy.edu.um.prog2.adt.binarySearchTree;

import uy.edu.um.prog2.adt.linkedlist.MiListaEntero;

public interface MyBinarySearchTree <K extends Comparable<K>, T> {

	T find(K key);
	
	void insert(K key, T data);
	
	void delete(K key);
	
	MiListaEntero<T> preOrder();
	
	MiListaEntero<T> inOrder();
	
	MiListaEntero<T> postOrder();
	
}
