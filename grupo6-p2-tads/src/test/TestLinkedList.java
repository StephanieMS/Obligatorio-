package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import LinkedList.LinkedList;

public class TestLinkedList {

	@Test
	public void testGet() {
		
		LinkedList<Integer> list = new LinkedList<>();
		
		list.addLast(10);
		list.addLast(11);
		list.addLast(12);
		list.addFirst(13);
		
		int result = list.get(3);
		
		assertEquals(12, result);
		
	}
	
	
	
	
	
	
}
