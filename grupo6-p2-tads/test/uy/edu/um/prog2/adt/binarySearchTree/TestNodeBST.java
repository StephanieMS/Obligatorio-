package uy.edu.um.prog2.adt.binarySearchTree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestNodeBST {

	NodeBST<Integer, String> tree = new NodeBST<>(8, "F");
	
	@Test
	public void testInsert() {
		
		try {
			tree.insert(3, "B");
			tree.insert(1, "A");
			tree.insert(6, "D");
			tree.insert(10, "G");
			tree.insert(4, "C");
			tree.insert(14, "H");
			tree.insert(7, "E");
			tree.insert(13, "I");
		}catch(SameKeyException e1) {
			System.out.println(e1.getMessage());
		}
		
		assertEquals("A",tree.getLeftChild().getLeftChild().getData());
		assertEquals("D",tree.getLeftChild().getRightChild().getData());
		assertEquals("H",tree.getRightChild().getRightChild().getData());
		
	}
	
	@Test
	public void testDelete() {
		
		try {
			tree.insert(3, "B");
			tree.insert(1, "A");
			tree.insert(6, "D");
			tree.insert(10, "G");
			tree.insert(4, "C");
			tree.insert(14, "H");
			tree.insert(7, "E");
			tree.insert(13, "I");
		}catch(SameKeyException e1) {
			System.out.println(e1.getMessage());
		}
		
		tree.delete(tree.getRightChild());
		
		assertEquals("I", tree.getRightChild().getData());
		
	}
	
	
}
