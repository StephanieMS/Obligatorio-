package LinkedList;

public class LinkedList<V> implements Lista<V>{
	
	private Nodo<V> primero;
	private Nodo<V> ultimo;
	
	public LinkedList() {
		primero = null;
		ultimo = null;
	}

	public void addLast(V value) {
		Nodo<V> temp = new Nodo<>(value);
		
		if(primero == null) {
			primero = temp;
			ultimo = temp;
		}else {
//			ultimo = primero;
//			while(ultimo.getNext() != null) {
//				ultimo = ultimo.getNext();
//			}
			ultimo.setNext(temp);
			ultimo = temp;
		}
	}
	
	public void addFirst(V value) {
		Nodo<V> temp = new Nodo<>(value);
		
		if(primero == null) {
			primero = temp;
		}else {
			 temp.setNext(primero);
			 primero = temp;
		}	
	}
	
	public void print() {
		Nodo<V> temp = primero;
		
		while(temp != null) {
			System.out.println(temp.getValue());
			temp = temp.getNext();
		}
	}

	public void delete(V value) {
		
		if(primero == null) {
			System.out.println("--NO HAY ELEMENTOS CARGADOS EN LA LISTA--");
		}
		
		if(primero != null) {
			if(primero.getValue() == value) {
				Nodo<V> toDelete = primero;
				primero = primero.getNext();
				toDelete.setNext(null);
				System.out.println("EL VALOR :" + value + " HA SIDO ELIMINADO DE LA LISTA");
			}
		}
		
		Nodo<V> temp = primero;
		
		while(temp.getNext() != null) {
			if((temp.getNext()).getValue() == value) {
				Nodo<V> toDelete = temp.getNext();
				temp.setNext(toDelete.getNext());
				toDelete.setNext(null);
				System.out.println("EL VALOR :" + value + " HA SIDO ELIMINADO DE LA LISTA");
			}else {
				temp = temp.getNext();
			}
		}
	}

	public V get(int pos){
		
		V info = null;
		int x = 0;
		Nodo<V> temp = primero;
		
		if(temp == null) {
			System.out.println("--NO HAY ELEMENTOS EN LA LISTA--");
		}
		
		if(temp != null) {
			while(x != pos && temp.getNext() != null) {
				temp = temp.getNext();
				x++;
			}
			if(x == pos) {
				info = temp.getValue();
			}else {
				System.out.println("--POSICION ERRONEA--");
			}
		}
		return info;
	}

	public int size() {
		int exit = 0;
		
		Nodo<V> temp = primero;
		
		while(temp != null) {
			exit++;
		}
		
		return exit;
	}
	
	
	
	//	EXTRA
	
	public void setNextList(LinkedList<V> toSet) {
		ultimo.setNext(toSet.getFirstNode());
	}
	
	public Nodo<V> getFirstNode(){
		Nodo<V> exit = null;
		
		if(primero != null) {
			exit = primero;
		}
		return exit;
	}

	
}
