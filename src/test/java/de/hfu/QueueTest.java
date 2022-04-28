package de.hfu;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QueueTest {
	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void testeMinLaenge() {
		Queue fail = new Queue(0);
	}
	
	Queue myQueue = new Queue(3);
	
	@Test(expected=IllegalStateException.class, timeout=1000)
	public void testeQueueLeer() {
		myQueue.dequeue();
	}
	
	@Test
	public void testeElementEinfuegen() {
		myQueue.enqueue(2);
		myQueue.enqueue(4);
		myQueue.enqueue(5);
		assertTrue(myQueue.dequeue() == 2);
		myQueue.enqueue(6);
		myQueue.enqueue(7);
		assertTrue(myQueue.dequeue() == 4);
		assertTrue(myQueue.dequeue() == 5);
		assertTrue(myQueue.dequeue() == 7);
	}

}
