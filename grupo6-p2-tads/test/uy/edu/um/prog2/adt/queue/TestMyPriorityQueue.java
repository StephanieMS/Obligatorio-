package uy.edu.um.prog2.adt.queue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMyPriorityQueue {

	MyPriorityQueue<String> priorityQ = new MyPriorityQueue<>();
	
	@Test
	public void testInsertWithPriority() {
		
		priorityQ.enqueue("A");
		priorityQ.enqueue("B");
		priorityQ.enqueue("C");
		
		String result1 = null;
		try {
			result1 = priorityQ.getFirst();
		}catch(EmptyQueueException e1) {
			System.out.println(e1.getMessage());
		}
		
		assertEquals("A", result1);
		
		priorityQ.insertWithPriority("Z", 2);
		
		String result2 = null;
		try {
			result2 = priorityQ.getFirst();
		}catch(EmptyQueueException e1) {
			System.out.println(e1.getMessage());
		}
		
		assertEquals("Z", result2);
		
	}
	
	
	
}
