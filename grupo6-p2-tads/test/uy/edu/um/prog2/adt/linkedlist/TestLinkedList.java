package uy.edu.um.prog2.adt.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLinkedList {
	
	MiListaEntero<Integer> lista = new MiLinkedList<>();
	
	@Test
	public void testAgregar() {
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(3);
		lista.addLast(4);
		
		try {
			if(lista.getElementoPorPos(2)!= 3) {
					fail();
			}
		} catch (PosicionInvalida e) {
			fail("Posicion Invalida");
		}	
	}
	
	@Test
	public void testEliminarElemento() {
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(3);
		lista.addLast(4);
		
		
		try {
			lista.eliminarElemento(3);
			if(lista.getElementoPorPos(2)!= 4) {
				fail();
			}
		} catch (PosicionInvalida e) {
			fail("Posicion Invalida");
		} 
		
		assertFalse(lista.existeElemento(3));
	}
	
	@Test
	public void testAddLast() {
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(3);
		
		try {
			if(lista.getElementoPorPos(2)!= 3) {
				fail();
			}
		} catch (PosicionInvalida e) {
			fail("Posicion Invalida");
		}
		
	}
	
	@Test
	public void testAddFirst() {
		lista.addLast(1);
		lista.addLast(2);
		lista.addFirst(3);
		
		try {
			if(lista.getElementoPorPos(0)!=3) {
				fail();
			}
		} catch (PosicionInvalida e) {
			fail("Posicion Invalida");
		}
	}
	
	@Test
	public void testSize() {
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(3);
		lista.addLast(4);
		
		assertEquals(4, lista.size());
	}

}
