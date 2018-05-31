package uy.edu.um.prog2.adt.hash;

public class HashCerrado<K extends Comparable<K>, V> implements HashTable<K, V> {
	private HashNode<K, V>[] vector;
	private int size;
	int cantElementos = 0;

	public HashCerrado(int sizeInicial) {
		this.size = sizeInicial;
		vector = new HashNode[sizeInicial];
	}

	public void insertar(K clave, V valor) throws ElementoYaExistenteException {
		if (cantElementos == size) {
			agrandarHash();
		}
		
		int pos = clave.hashCode() % size;
		HashNode<K, V> nodo = new HashNode<>(clave, valor);

		if (vector[pos] == null || vector[pos].getEstaBorrado() == true) {
			vector[pos] = nodo;
			cantElementos++;
		} else {
			int posAux = pos;
			while (vector[posAux] != null && vector[posAux].getEstaBorrado() == true) {
					posAux++;

				if (posAux >= size) {
					posAux = 0;
				}
			}
			vector[posAux] = nodo;

		}
		cantElementos++;
	}

	public boolean pertenece(K clave) {
		boolean pertenece = false;

		int posEsperada = clave.hashCode() % size;
		if (vector[posEsperada] != null) {
			if (vector[posEsperada].getClave().equals(clave) == true && vector[posEsperada].getEstaBorrado() == false) {
				pertenece = true;
			} else {
				posEsperada++;
				while (posEsperada < vector.length
						&& (vector[posEsperada] != null && vector[posEsperada].getClave().equals(clave) == false)) {
					posEsperada++;
				}
			}
		}
		return pertenece;
	}

	public void borrar(K clave) throws ClaveInvalida {
		for (int i = 0; i < size; i++) {
			if (vector[i].getClave() == clave) {
				vector[i].setEstaBorrado(true);
				cantElementos--;
			} else {
				throw new ClaveInvalida();
			}
		}
	}

	private void agrandarHash() {
		int nuevoSize = 2 * size;

		HashNode<K, V>[] vectorNuevo;
		vectorNuevo = new HashNode[nuevoSize];

		for (int i = 0; i < size; i++) {
			K claveAux = vector[i].getClave();

			int pos = claveAux.hashCode() % nuevoSize;

			if (vectorNuevo[pos] == null) {
				vectorNuevo[pos] = vector[i];
			} else {
				int posAux = pos;
				while (vectorNuevo[posAux] != null) {
					if (posAux >= nuevoSize) {
						posAux = 0;
					} else {
						posAux++;
					}
				}
				vectorNuevo[posAux] = vector[i];
			}

		}

		size = nuevoSize;
		vector = vectorNuevo;

	}

}
