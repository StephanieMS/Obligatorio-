package uy.edu.um.prog2.adt.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStack {

	Stack s1 = new MyStack();

	@Test
	public void testPrint() {
		s1.push(2);
		s1.push(3);
		s1.push(4);
		s1.push(5);

		s1.print();
	}

	@Test
	public void testPop() {
		s1.push(2);
		s1.push(3);
		s1.push(4);
		s1.push(5);

		try {
			s1.pop();
		} catch (EmptyStackException e1) {
		}

		try {
			assertEquals(4, s1.top());
		} catch (EmptyStackException e2) {
		}

	}

	@Test
	public void testMakeEmpty() {
		s1.push(2);
		s1.push(3);
		s1.push(4);
		s1.push(5);

		s1.makeEmpty();
		s1.print();

	}
	
	@Test
	public void testIsEmpty() {
		s1.push(2);
		s1.push(3);
		s1.push(4);
		s1.push(5);

		s1.makeEmpty();
		assertTrue(s1.isEmpty());
	}
	
}
