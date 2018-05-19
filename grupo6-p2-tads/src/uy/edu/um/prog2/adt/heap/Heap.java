package uy.edu.um.prog2.adt.heap;

public class Heap<K extends Comparable<K>, V> implements MyHeap<K, V> {

	private NodoHeap<K, V>[] elements;
	private int size = 0;
	private int tipoArbol;

	public Heap(int size, int tipoArbol) {
		elements = new NodoHeap[size];
		if (tipoArbol == 1 || tipoArbol == -1) {
			this.tipoArbol = tipoArbol;
		} else {
			System.out.println("Ingrese 1 o -1");
		}
	}

	public NodoHeap<K, V> getParent(int nPos) {
		NodoHeap<K, V> oResult = null;

		if (nPos > 0) {
			int nPosParent = (nPos - 1) / 2;
			oResult = elements[nPosParent];
		}

		return oResult;

	}

	public int getPosParent(int nPos) {
		int nValue = 0;
		if (nPos > 0) {
			nValue = (nPos - 1) / 2;
		}
		return nValue;
	}

	public int getPosLeftChild(int nPos) {
		int posChild = 2 * nPos + 1;
		if (posChild > size - 1) {
			posChild = 0;
		}
		return posChild;
	}

	public int getPosRightChild(int nPos) {
		int posChild = 2 * nPos + 2;
		if (posChild > size - 1) {
			posChild = 0;
		}
		return posChild;
	}

	public NodoHeap<K, V> getLeftChild(int pos) {
		NodoHeap<K, V> leftChild = null;
		if (getPosLeftChild(pos) != 0) {
			leftChild = elements[getPosLeftChild(pos)];
		}
		return leftChild;
	}

	public NodoHeap<K, V> getRightChild(int pos) {
		NodoHeap<K, V> rightChild = null;
		if (getPosRightChild(pos) != 0) {
			rightChild = elements[getPosRightChild(pos)];
		}
		return rightChild;
	}

	public void insert(K key, V value) {
		NodoHeap<K, V> nuevoNodo = new NodoHeap<>(key, value);
		int nPosActual = 0;
		nPosActual = size;
		NodoHeap<K, V> parent = elements[getPosParent(nPosActual)];
		elements[size] = nuevoNodo; // agrego el Nodo al primer lugar vacio

		// heap maximo
		if (tipoArbol == 1) {
			while (getParent(nPosActual) != null && getParent(nPosActual).getKey().compareTo(nuevoNodo.getKey()) < 0) {

				elements[getPosParent(nPosActual)] = nuevoNodo; // el nuevo nodo pasa a la posicion del padre
				elements[nPosActual] = parent; // el padre baja una posicion
				nPosActual = getPosParent(nPosActual);

			}

		}
		// heap minimo
		else {
			while (getParent(nPosActual) != null && getParent(nPosActual).getKey().compareTo(nuevoNodo.getKey()) > 0) {

				elements[getPosParent(nPosActual)] = nuevoNodo; // el nuevo nodo pasa a la posicion del padre
				elements[nPosActual] = parent; // el padre baja una posicion
				nPosActual = getPosParent(nPosActual);

			}
		}
		size++;
	}

	public void delete() {
		elements[0] = elements[size - 1];
		elements[size - 1] = null;
		size--;

		int posActual = 0;

		NodoHeap<K, V> parent = elements[posActual];

		if (tipoArbol == 1) {
			while (getLeftChild(posActual) != null
					&& parent.getKey().compareTo((K) getLeftChild(posActual).getKey()) < 0
					|| getRightChild(posActual) != null
							&& parent.getKey().compareTo((K) getRightChild(posActual).getKey()) < 0) {
				if (getRightChild(posActual).getKey().compareTo(getLeftChild(posActual).getKey()) < 0) {
					elements[posActual] = getLeftChild(posActual);
					elements[getPosLeftChild(posActual)] = parent;
					posActual = getPosRightChild(posActual);
					parent = elements[posActual];
				} else {
					elements[posActual] = getRightChild(posActual);
					elements[getPosRightChild(posActual)] = parent;
					posActual = getPosRightChild(posActual);
					parent = elements[posActual];
				}
			}
		} else {
			while (getLeftChild(posActual) != null
					&& parent.getKey().compareTo((K) getLeftChild(posActual).getKey()) > 0
					|| getRightChild(posActual) != null
							&& parent.getKey().compareTo((K) getRightChild(posActual).getKey()) > 0) {
				if (getRightChild(posActual).getKey().compareTo(getLeftChild(posActual).getKey()) > 0) {
					elements[posActual] = getLeftChild(posActual);
					elements[getPosLeftChild(posActual)] = parent;
					posActual = getPosRightChild(posActual);
					parent = elements[posActual];
				} else {
					elements[posActual] = getRightChild(posActual);
					elements[getPosRightChild(posActual)] = parent;
					posActual = getPosRightChild(posActual);
					parent = elements[posActual];
				}
			}
		}
	}
	
	public int getSize() {
		int size = 0;
		
		while(elements[size] != null && size < elements.length) {
			size++;
		}
		
		return size;
	}
}
