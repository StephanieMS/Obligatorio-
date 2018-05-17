package uy.edu.um.prog2.adt;

public class MiLinkedList implements MiListaEntero {

	private Nodo primero;

	public void agregar(int nValue) {

		Nodo oItem = new Nodo(nValue);

		if (primero == null) {
			primero = oItem;
		}

		else {
			Nodo ultimo = primero;

			while (ultimo.getSiguiente() != null) {
				ultimo = ultimo.getSiguiente();
			}
			ultimo.setSiguiente(oItem);
		}

	}

	public int size() {
		Nodo oTemp = this.primero;
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

	public int getElemento(int posicion) throws PosicionInvalida {
		Nodo oTemp = this.primero;

		for (int i = 1; i < posicion; i++) {

			if (oTemp.getSiguiente() == null) {
				PosicionInvalida oError = new PosicionInvalida("Posicion Invalida");
				System.out.println("Posicion Invalida");
				throw oError;
			}
			oTemp = oTemp.getSiguiente();
		}

		return oTemp.getValor();
	}

	public void eliminarElemento(int posicion) {
		Nodo oTemp = this.primero;
		int nCount = 0;

		while (oTemp.getSiguiente().getSiguiente() != null && nCount != posicion) {
			oTemp = oTemp.getSiguiente();
			nCount++;
		}
		oTemp.setSiguiente(oTemp.getSiguiente().getSiguiente());
	}

	public boolean existeElemento(int nValor) {
		Nodo oTemp = this.primero;
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

	public void addFirst(int Value) {
		Nodo oItem = new Nodo(Value);

		primero.setValor(oItem.getValor());
		;
	}

	public void addLast(int Value) {
		Nodo oItem = new Nodo(Value);

		Nodo ultimo = primero;

		while (ultimo.getSiguiente() != null) {
			ultimo = ultimo.getSiguiente();
		}
		ultimo.setSiguiente(oItem);
	}
}
