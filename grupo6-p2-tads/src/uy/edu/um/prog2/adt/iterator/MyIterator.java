package uy.edu.um.prog2.adt.iterator;

import java.util.Iterator;
import uy.edu.um.prog2.adt.hash.HashNode;

public class MyIterator<K,T> implements Iterator<T> {

	protected int posicion = 0;
	protected HashNode<K, T>[] vectorHash;

	public MyIterator(HashNode<K,T>[] vector) {
		
		vectorHash=vector;
		
		while ((vector[posicion] == null || vector[posicion].getEstaBorrado()) && posicion < vector.length - 1) {
			posicion++;
		}
		if(posicion==vector.length-1 && (vector[posicion] == null || vector[posicion].getEstaBorrado())) {
			posicion=0;
		}
	}

	
	public boolean hasNext() {
		
		boolean bExit=false;
		
		int count = posicion;
		 while(!bExit && count < vectorHash.length) {
			 
			 if(vectorHash[count]!=null && !vectorHash[count].getEstaBorrado()) {
				 bExit = true;
			 }
			 count++;
		 }
		
		return bExit;
	}


	public T next() {
		
		T	oExit=null;
	
		
		while( oExit == null && posicion<vectorHash.length) {
			
			if(vectorHash[posicion]!=null && !vectorHash[posicion].getEstaBorrado()) {
				oExit=vectorHash[posicion].getValor();
			}
			posicion++;
			
		}
		return oExit;
	}

}
