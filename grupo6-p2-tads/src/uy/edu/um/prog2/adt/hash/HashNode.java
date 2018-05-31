package uy.edu.um.prog2.adt.hash;

public class HashNode<K, V> {
	private K clave;
	private V valor;
	private boolean estaBorrado;
	
	public HashNode(K clave, V valor) {
		this.clave = clave;
		this.valor = valor;
	}
	public K getClave() {
		return clave;
	}
	public void setClave(K clave) {
		this.clave = clave;
	}
	public V getValor() {
		return valor;
	}
	public void setValor(V valor) {
		this.valor = valor;
	}
	public boolean getEstaBorrado() {
		return estaBorrado;
	}
	public void setEstaBorrado(boolean estaBorrado) {
		this.estaBorrado = estaBorrado;
	}
	
	
	
	
}
