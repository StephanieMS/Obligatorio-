package uy.edu.um.prog2.adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestQueue {

	Queue<String> queue = new Queue<>();
	
	@Test
	public void testEnqueueGetFirst() {
		
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		queue.enqueue("E");
		
		String result = null;
		
		try {
			result = queue.getFirst();
		}catch(EmptyQueueException e1) {
			System.out.println(e1.getMessage());
		}
		
		assertNotNull(queue);
		
		assertEquals("A", result);
		
	}
	
	@Test
	public void testDequeue() {
		
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		queue.enqueue("E");
		
		
		

		
	}
	
	
}
