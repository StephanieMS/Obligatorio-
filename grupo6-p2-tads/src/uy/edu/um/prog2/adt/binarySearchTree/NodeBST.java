package uy.edu.um.prog2.adt.binarySearchTree;

import uy.edu.um.prog2.adt.binarySearchTree.FindException;
import LinkedList.LinkedList;

public class NodeBST <K extends Comparable<K>, T>{

	private K key;
	private T data;
	NodeBST<K,T> leftChild;
	NodeBST<K,T> rightChild;
	
	public NodeBST(K key, T data) {
		this.key = key;
		this.data = data;
		leftChild = null;
		rightChild = null;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public NodeBST<K, T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(NodeBST<K, T> leftChild) {
		this.leftChild = leftChild;
	}

	public NodeBST<K, T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(NodeBST<K, T> rightChild) {
		this.rightChild = rightChild;
	}
	
	public T find(K key) throws FindException{
		T exit = null;
		
		if(getKey() == key) {
			exit = getData();
		}else {
			if(getKey().compareTo(key) > 0) {
				if(getLeftChild() != null) {
					exit = getLeftChild().find(key);
				}else {
					FindException e1 = new FindException("--KEY WASN'T FOUND--");
						throw e1;
				}
			}else if(getKey().compareTo(key) < 0) {
				if(getRightChild() != null) {
					exit = getRightChild().find(key);
				}else {
					FindException e1 = new FindException("--KEY WASN'T FOUND--");
					throw e1;
				}
			}
		}
		
		return exit;
	}
	
	public void insert(K key, T data) throws SameKeyException{
		
		NodeBST<K, T> toInsert = new NodeBST<>(key, data);
		
		if(getKey().compareTo(key) > 0) {
			if(getLeftChild() != null) {
				getLeftChild().insert(key, data);
			}else {
				setLeftChild(toInsert);
			}
		}else if(getKey().compareTo(key) < 0) {
			if(getRightChild() != null) {
				getRightChild().insert(key, data);
			}else {
				setRightChild(toInsert);
			}
		}else {
			SameKeyException e1 = new SameKeyException("--THE KEY ALREADY EXIST, CHANGE IT--");
			throw e1;
		}
		
	}
	
	public void delete(NodeBST<K, T> found) {
		
		NodeBST<K, T> temp = null;
		
		if(found.getLeftChild() != null) {
			temp = found.getLeftChild();
			if(temp.getRightChild() != null) {
				while(temp.getRightChild() != null) {
					temp = temp.getRightChild();
				}
				found.setData(temp.getData());
				found.setKey(temp.getKey());
				found.delete(temp);
			}
		}else if(found.getRightChild() != null) {
			temp = found.getRightChild();
			if(temp.getLeftChild() != null) {
				while(temp.getLeftChild() != null) {
					temp = temp.getLeftChild();
				}
				found.setData(temp.getData());
				found.setKey(temp.getKey());
				found.delete(temp);
			}
		}else {
			found = null;
		}
	}
	
	public NodeBST<K, T> findNode(K key) throws FindException {
		NodeBST<K, T> exit = null;
		
		if(getKey() == key) {
			exit = this;
		}else {
			if(getKey().compareTo(key) > 0) {
				if(getLeftChild() != null) {
					exit = getLeftChild().findNode(key);
				}
			}else if(getKey().compareTo(key) < 0) {
				if(getRightChild() != null) {
					exit = getRightChild().findNode(key);
				}
			}
		}
		if(exit == null) {
			FindException e1 = new FindException("--KEY WASN'T FOUND--");
			throw e1;
		}
		return exit;
	}
	
	public void inOrder(LinkedList<T> exit) {
		
		if(getLeftChild() != null) {
			getLeftChild().inOrder(exit);		
		}
		
		exit.addLast(getData());
		
		if(getRightChild() != null) {
			getRightChild().inOrder(exit);		
		}	
		
	}
	
	public void preOrder(LinkedList<T> exit) {
		
		exit.addLast(getData());
		
		if(getLeftChild() != null) {
			getLeftChild().preOrder(exit);		
		}
		
		if(getRightChild() != null) {
			getRightChild().preOrder(exit);		
		}	
		
	}
	
	public void postOrder(LinkedList<T> exit) {
		
		if(getLeftChild() != null) {
			getLeftChild().postOrder(exit);		
		}
		
		if(getRightChild() != null) {
			getRightChild().postOrder(exit);		
		}
		
		exit.addLast(getData());
		
	}
	
	
}
