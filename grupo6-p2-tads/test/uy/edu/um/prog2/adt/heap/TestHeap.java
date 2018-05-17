package uy.edu.um.prog2.adt.heap;

import static org.junit.Assert.*;

import org.junit.Test;

import uy.edu.um.prog2.adt.Heap;
import uy.edu.um.prog2.adt.MyHeap;
import uy.edu.um.prog2.adt.NodoHeap;

public class TestHeap {
	MyHeap<Integer,String> lista = new Heap<>(5,1);
	
	@Test
	public void testInsert() {
		lista.insert(1,"A");
		lista.insert(2,"B");
		lista.insert(3,"C");
		lista.insert(5,"E");
		lista.insert(4,"D");
		
				
		if(lista.getLeftChild(0).getKey() != 4) {
			fail("Error");
		}
		
		if(lista.getParent(2).getKey() != 5) {
			fail("Error");
		}
		
	}
	
	@Test
	public void testDelete() {
		lista.insert(1,"A");
		lista.insert(2,"B");
		lista.insert(3,"C");
		lista.insert(5,"E");
		lista.insert(4,"D");
		
		lista.delete();
		
		if(lista.getParent(1).getKey()!=4) {
			fail("Error");
		}
	}
	

}
