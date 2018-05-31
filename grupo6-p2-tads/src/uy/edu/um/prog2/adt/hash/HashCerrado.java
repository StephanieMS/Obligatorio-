package uy.edu.um.prog2.adt.hash;

public class HashCerrado<K extends Comparable<K>, V> implements HashTable<K, V> {
	
	private HashNode<K, V>[] vector;
	private int size;
	int cantElementos = 0;			// para qué es necesario? si puedo hacer un vector.size();

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
			
			for(int i = pos+1; i < size; i++) {
			
				if(vector[i] != null) {
					
					if(vector[i].getEstaBorrado() == true) {
						vector[i] = nodo;
						cantElementos++;
						i = size;
					}else if(i == size-1) {
						i=0;
					}
				}else {
					vector[i] = nodo;
					cantElementos++;
					i = size;
				}	
			}
		}
		
	}

	public boolean pertenece(K clave) {
		
		boolean pertenece = false;

		int posEsperada = clave.hashCode() % size;
		
		if (vector[posEsperada] != null && vector[posEsperada].getClave().equals(clave) == true && 
				vector[posEsperada].getEstaBorrado() == false) {
			
			pertenece = true;
		
		} else {
			
			for(int i = posEsperada+1; i < size; i++) {
				
				if(vector[i] != null) {
					
					if(vector[i].getClave().equals(clave) == true && vector[i].getEstaBorrado() == false) {
						pertenece = true;
						i = size;
					}
				}else {
					i = size;
				}	
			}
		}
		return pertenece;
	}

	public void borrar(K clave) throws ClaveInvalida {

		int posEsperada = clave.hashCode() % size;
		
		if (vector[posEsperada] != null && vector[posEsperada].getClave().equals(clave) == true) {
			vector[posEsperada].setEstaBorrado(true); 
			
		} else {
			
			for(int i = posEsperada+1; i < size; i++) {
				
				if(vector[i] != null) {
					
					if(vector[i].getClave().equals(clave) == true) {
						vector[i].setEstaBorrado(true);
						i = size;
					}
				}else {
					throw new ClaveInvalida();
				}	
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
