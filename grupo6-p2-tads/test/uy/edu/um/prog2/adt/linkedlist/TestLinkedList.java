package uy.edu.um.prog2.adt.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLinkedList {
	
	MiListaEntero<Integer> lista = new MiLinkedList<>();
	
	@Test
	public void testAgregar() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		lista.agregar(4);
		
		try {
			if(lista.getElemento(2)!= 3) {
					fail();
			}
		} catch (PosicionInvalida e) {
			fail("Posicion Invalida");
		}	
	}
	
	@Test
	public void testEliminarElemento() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		lista.agregar(4);
		
		
		try {
			lista.eliminarElemento(3);
			if(lista.getElemento(2)!= 4) {
				fail();
			}
		} catch (PosicionInvalida e) {
			fail("Posicion Invalida");
		} 
		
		assertFalse(lista.existeElemento(3));
	}
	
	@Test
	public void testAddLast() {
		lista.agregar(1);
		lista.agregar(2);
		lista.addLast(3);
		
		try {
			if(lista.getElemento(2)!= 3) {
				fail();
			}
		} catch (PosicionInvalida e) {
			fail("Posicion Invalida");
		}
		
	}
	
	@Test
	public void testAddFirst() {
		lista.agregar(1);
		lista.agregar(2);
		lista.addFirst(3);
		
		try {
			if(lista.getElemento(0)!=3) {
				fail();
			}
		} catch (PosicionInvalida e) {
			fail("Posicion Invalida");
		}
	}
	
	@Test
	public void testSize() {
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		lista.agregar(4);
		
		assertEquals(4, lista.size());
	}

}
