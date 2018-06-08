package uy.edu.um.prog2.adt.linkedlist;

public class MiLinkedList<V> implements MiListaEntero<V> {

	private Nodo<V> primero;
	private int contador = 0;

	public void addFirst(V nValue) {
		
		if(primero != null) {
			Nodo<V> temp = primero;
			
			primero = new Nodo<>(nValue);
			
			primero.setSiguiente(temp);
		}else {
			primero = new Nodo<>(nValue);
		}
	
	}
	
	public void addLast(V nValue) {

		Nodo<V> oItem = new Nodo<>(nValue);

		if (primero == null) {
			primero = oItem;
		}else {
			Nodo<V> ultimo = primero;

			while (ultimo.getSiguiente() != null) {
				ultimo = ultimo.getSiguiente();
			}
			ultimo.setSiguiente(oItem);
		}
		contador++;
	}

	public int size() {
		Nodo<V> oTemp = this.primero;
		int size = 0;

		if (oTemp != null) {
			size = 1;
			while (oTemp.getSiguiente() != null) {
				size++;
				oTemp = oTemp.getSiguiente();
			}
		}
		return size;
	}

	public V getElementoPorPos(int posicion) throws PosicionInvalida {
		Nodo<V> oTemp = this.primero;

		for (int i = 0; i < posicion; i++) {

			if (oTemp.getSiguiente() == null) {
				PosicionInvalida oError = new PosicionInvalida("Posicion Invalida");
				System.out.println("Posicion Invalida");
				throw oError;
			}
			oTemp = oTemp.getSiguiente();
		}

		return oTemp.getValor();
	}

	public void eliminarElemento(V value) {
		if (primero == null) {
//			System.out.println("--NO HAY ELEMENTOS CARGADOS EN LA LISTA--");
		}

		if (primero != null) {
			if (primero.getValor() == value) {
				Nodo<V> toDelete = primero;
				primero = primero.getSiguiente();
				toDelete.setSiguiente(null);
//				System.out.println("EL VALOR " + value + " HA SIDO ELIMINADO DE LA LISTA");
			}
		}

		Nodo<V> temp = primero;

		while (temp.getSiguiente() != null) {
			if ((temp.getSiguiente()).getValor() == value) {
				Nodo<V> toDelete = temp.getSiguiente();
				temp.setSiguiente(toDelete.getSiguiente());
				toDelete.setSiguiente(null);
//				System.out.println("EL VALOR " + value + " HA SIDO ELIMINADO DE LA LISTA");
			} else {
				temp = temp.getSiguiente();
			}
		}
	}

	public boolean existeElemento(V nValor) {
		Nodo<V> oTemp = this.primero;
		boolean existeElemento = false;
		boolean nCount = false;

		while (nCount == false) {

			if (oTemp.getValor() != nValor) {

				if (oTemp.getSiguiente() != null) {
					oTemp = oTemp.getSiguiente();
				} else {
					nCount = true;
				}
			} else {
				existeElemento = true;
				nCount = true;
			}
		}
		return existeElemento;
	}

	public int getContador() {
		return contador;
	}

}
