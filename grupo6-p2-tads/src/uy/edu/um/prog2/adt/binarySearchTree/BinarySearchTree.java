package uy.edu.um.prog2.adt.binarySearchTree;

import uy.edu.um.prog2.adt.binarySearchTree.FindException;
import uy.edu.um.prog2.adt.linkedlist.MiLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MiListaEntero;

public class BinarySearchTree <K extends Comparable<K>,T> implements MyBinarySearchTree<K,T>{

	private NodeBST<K, T> root;
	
	public T find(K key) {
		T exit = null;
		
		try {
			exit = root.find(key);
		}catch(FindException e1) {
//			System.out.println(e1.getMessage());
		}
		
		return exit;
	}
	
	public void insert(K key, T data) {
		
		if(root == null) {
			root = new NodeBST<>(key, data);
		}else {
			try {
				root.insert(key, data);
			}catch(SameKeyException e1) {
	//			System.out.println(e1.getMessage());
			}
		}
	}

	public void delete(K key) {
		NodeBST<K, T> found = null;
		try {
			found = root.findNode(key);
		}catch(FindException e1) {
			System.out.println(e1.getMessage());
		}
		root.delete(found);
		
	}
	
	public MiListaEntero<T> inOrder() {
		
		MiListaEntero<T> exit = new MiLinkedList<>();
		
		root.inOrder(exit);
		
		return exit;
	}
	
	public MiListaEntero<T> preOrder() {
		
		MiListaEntero<T> exit = new MiLinkedList<>();
		
		root.preOrder(exit);
		
		return exit;
	}
	
	public MiListaEntero<T> postOrder() {
		
		MiListaEntero<T> exit = new MiLinkedList<>();
		
		root.postOrder(exit);
		
		return exit;
	}


	
}
