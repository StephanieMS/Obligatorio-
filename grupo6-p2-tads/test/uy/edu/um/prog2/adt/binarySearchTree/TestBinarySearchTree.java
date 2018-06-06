package uy.edu.um.prog2.adt.binarySearchTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import uy.edu.um.prog2.adt.linkedlist.MiLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MiListaEntero;
import uy.edu.um.prog2.adt.linkedlist.PosicionInvalida;

public class TestBinarySearchTree {

	BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();

	
	@Test
	public void testFind() {
		
		tree.insert(8, "F");
		tree.insert(3, "B");
		tree.insert(1, "A");
		tree.insert(6, "D");
		tree.insert(10, "G");
		tree.insert(4, "C");
		tree.insert(14, "H");
		tree.insert(7, "E");
		tree.insert(13, "I");
		
		String value1 = tree.find(10);
		String value2 = tree.find(13);
		
		assertEquals("G", value1);
		assertEquals("I", value2);
		
	}
	
	@Test
	public void testDelete() {
		
		tree.insert(8, "F");
		tree.insert(3, "B");
		tree.insert(1, "A");
		tree.insert(6, "D");
		tree.insert(10, "G");
		tree.insert(4, "C");
		tree.insert(14, "I");
		tree.insert(7, "E");
		tree.insert(13, "H");
	
		tree.delete(10);
		
		assertNull(tree.find(10));
		
	}
	
	@Test
	public void testInOrder() {
		
		tree.insert(8, "F");
		tree.insert(3, "B");
		tree.insert(1, "A");
		tree.insert(6, "D");
		tree.insert(10, "G");
		tree.insert(4, "C");
		tree.insert(14, "I");
		tree.insert(7, "E");
		tree.insert(13, "H");
		
		MiListaEntero<String> searchTree = tree.inOrder();
		
		MiListaEntero<String> toCompare = new MiLinkedList<>();
		
		toCompare.addLast("A");
		toCompare.addLast("B");
		toCompare.addLast("C");
		toCompare.addLast("D");
		toCompare.addLast("E");
		toCompare.addLast("F");
		toCompare.addLast("G");
		toCompare.addLast("H");
		toCompare.addLast("I");
		
		for(int i = 0; i < searchTree.size(); i++) {
			try {
				assertEquals(toCompare.getElemento(i), searchTree.getElemento(i));
			} catch (PosicionInvalida e) {
			}
		}
			
	}
	
	@Test
	public void testPreOrder() {
		
		tree.insert(8, "F");
		tree.insert(3, "B");
		tree.insert(1, "A");
		tree.insert(6, "D");
		tree.insert(10, "G");
		tree.insert(4, "C");
		tree.insert(14, "I");
		tree.insert(7, "E");
		tree.insert(13, "H");
		
		MiListaEntero<String> searchTree = tree.preOrder();
		
		MiListaEntero<String> toCompare = new MiLinkedList<>();
		
		toCompare.addLast("F");
		toCompare.addLast("B");
		toCompare.addLast("A");
		toCompare.addLast("D");
		toCompare.addLast("C");
		toCompare.addLast("E");
		toCompare.addLast("G");
		toCompare.addLast("I");
		toCompare.addLast("H");
		
		for(int i = 0; i < searchTree.size(); i++) {
			try {
				assertEquals(toCompare.getElemento(i), searchTree.getElemento(i));
			} catch (PosicionInvalida e) {
			}
		}
			
	}
	
	@Test
	public void testPostOrder() {
		
		tree.insert(8, "F");
		tree.insert(3, "B");
		tree.insert(1, "A");
		tree.insert(6, "D");
		tree.insert(10, "G");
		tree.insert(4, "C");
		tree.insert(14, "I");
		tree.insert(7, "E");
		tree.insert(13, "H");
		
		MiListaEntero<String> searchTree = tree.postOrder();
		
		MiListaEntero<String> toCompare = new MiLinkedList<>();
		
		toCompare.addLast("A");
		toCompare.addLast("C");
		toCompare.addLast("E");
		toCompare.addLast("D");
		toCompare.addLast("B");
		toCompare.addLast("H");
		toCompare.addLast("I");
		toCompare.addLast("G");
		toCompare.addLast("F");
		
		for(int i = 0; i < searchTree.size(); i++) {
			try {
				assertEquals(toCompare.getElemento(i), searchTree.getElemento(i));
			} catch (PosicionInvalida e) {
			}
		}
			
	}
	
}
