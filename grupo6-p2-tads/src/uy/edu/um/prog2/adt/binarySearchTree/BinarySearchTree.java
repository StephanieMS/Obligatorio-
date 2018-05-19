package uy.edu.um.prog2.adt.binarySearchTree;

import uy.edu.um.prog2.adt.binarySearchTree.FindException;
import LinkedList.LinkedList;

public class BinarySearchTree <K extends Comparable<K>,T> implements MyBinarySearchTree<K,T>{

	private NodeBST<K, T> root;
	
	public BinarySearchTree(K key, T data) {
		root = new NodeBST<>(key, data);
	}
	
	public T find(K key) {
		T exit = null;
		
		try {
			exit = root.find(key);
		}catch(FindException e1) {
			System.out.println(e1.getMessage());
		}
		
		return exit;
	}
	
	public void insert(K key, T data) {
		try {
			root.insert(key, data);
		}catch(SameKeyException e1) {
			System.out.println(e1.getMessage());
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
	
	public LinkedList<T> inOrder() {
		
		LinkedList<T> exit = new LinkedList<>();
		
		root.inOrder(exit);
		
		return exit;
	}
	
	public LinkedList<T> preOrder() {
		
		LinkedList<T> exit = new LinkedList<>();
		
		root.preOrder(exit);
		
		return exit;
	}
	
	public LinkedList<T> postOrder() {
		
		LinkedList<T> exit = new LinkedList<>();
		
		root.postOrder(exit);
		
		return exit;
	}


	
}
