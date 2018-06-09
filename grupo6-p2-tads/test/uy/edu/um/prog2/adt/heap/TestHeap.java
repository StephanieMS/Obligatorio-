package uy.edu.um.prog2.adt.heap;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestHeap {
	
	MyHeap<Integer,String> lista = new Heap<>(5,1);
	
	MyHeap<Integer,String> min = new Heap<>(5,-1);
	
	@Test
	public void testInsertMax() {
		
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
		
		if(lista.getParent(3).getKey() != 4) {
			fail("Error");
		}
		
	}
	
	@Test
	public void testInsertMin() {
		
		min.insert(3,"C");
		min.insert(2,"B");
		min.insert(5,"E");
		min.insert(1,"A");
		min.insert(4,"D");
			
		if(min.getLeftChild(0).getKey() != 2) {
			fail("Error");
		}
		
		if(min.getParent(2).getKey() != 1) {
			fail("Error");
		}
		
		if(min.getParent(3).getKey() != 2) {
			fail("Error");
		}
		
	}
	
	
	@Test
	public void testDelete() throws HeapVacio {
		
		lista.insert(1,"A");
		lista.insert(2,"B");
		lista.insert(3,"C");
		lista.insert(5,"E");
		lista.insert(4,"D");
		
		assertEquals("E",lista.findAndDelete());
		
		if(lista.getParent(1).getKey() != 4) {
			fail("Error");
		}
		
		min.insert(3,"C");
		min.insert(2,"B");
		min.insert(5,"E");
		min.insert(1,"A");
		min.insert(4,"D");
		
		assertEquals("A", min.findAndDelete());
		
		if(min.getParent(1).getKey() != 2) {
			fail("Error");
		}
	}
	
	@Test
	public void testSize() {
		
		lista.insert(1,"A");
		lista.insert(2,"B");
		lista.insert(3,"C");
		lista.insert(5,"E");
		lista.insert(4,"D");
		
		assertEquals(5, lista.getSize());
		
	}
	

}
