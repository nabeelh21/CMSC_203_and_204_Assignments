import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing the methods of MyQueue
 *
 * @author Nabeel Hussain
 */
public class MyQueueTest {
	
	// A Queue will be created using volunteers as the elements to be queued
	MyQueue<Volunteer> volQueue;
	
	// A Queue will be created using recipients as the elements to be queued
	MyQueue<Recipient> recipQueue;
	
	
	@Before
	public void setUp() throws Exception {
		
		volQueue = new MyQueue<Volunteer>();
		recipQueue = new MyQueue<Recipient>();
	
	}

	@After
	public void tearDown() throws Exception {
		
		volQueue = null;
		recipQueue = null;
	}

	
	/**
	 * Test isEmpty() method to see if it correctly tells whether the Queue is empty or not. 
	 */
	@Test
	public void testIsEmpty() {
		
		// Testing the volunteer Queue
		assertEquals(volQueue.isEmpty(),true ); // Queue will always be empty at start
		volQueue.enqueue(new Volunteer("Nabeel")); // add a volunteer to the queue 
		assertEquals(volQueue.isEmpty(),false ); // Queue should not be empty anymore now

		
		// Testing the recipient Queue
		assertEquals(recipQueue.isEmpty(),true );
		recipQueue.enqueue(new Recipient("UMBC"));
		recipQueue.enqueue(new Recipient("UMD"));
		recipQueue.dequeue();
		assertEquals(recipQueue.isEmpty(),false); //There is still one volunteer left, so it's not empty
	}

	
	/**
	 * Test enqueue() method to see if it correctly adds an element to the queue 
	 */
	@Test
	public void testEnqueue() {
		
		// Testing the volunteer Queue
		volQueue.enqueue(new Volunteer("Ashley"));
		assertEquals(volQueue.toArray()[0].toString(), "Ashley");		
		volQueue.enqueue(new Volunteer("Mark"));  // Mark is added as the 2nd person in queue
		assertEquals(volQueue.toArray()[1].toString(), "Mark"); 		
		volQueue.enqueue(new Volunteer("Joe"));	  // Joe is added as the 3rd person in queue
		assertEquals(volQueue.toArray()[2].toString(), "Joe");   		
		volQueue.enqueue(new Volunteer("Austin"));
		assertEquals(volQueue.toArray()[0].toString(), "Ashley");  // No matter how many people are added, the person added the first, will always be first in queue 
		
		
		// Testing the recipient Queue		
		recipQueue.enqueue(new Recipient("MC"));
		assertEquals(recipQueue.toArray()[0].toString(), "MC");		
		recipQueue.enqueue(new Recipient("Kim"));  
		assertEquals(recipQueue.toArray()[0].toString(), "MC");    		
		recipQueue.enqueue(new Recipient("Keith"));
		assertEquals(recipQueue.toArray()[0].toString(), "MC");  

	}
	
	/**
	 * Test isEmpty() method to see if it correctly tells whether the Queue is empty or not. 
	 */
	@Test
	public void testIsFull() {
		
		// Testing the volunteer Queue
		assertEquals(volQueue.isFull(), false ); // Queue will always be empty at start
		volQueue.enqueue(new Volunteer("Nabeel"));
		volQueue.enqueue(new Volunteer("Keith"));
		volQueue.enqueue(new Volunteer("Kim"));
		volQueue.enqueue(new Volunteer("Joe"));
		volQueue.enqueue(new Volunteer("Jake"));
		assertEquals(volQueue.isFull(),true ); // Queue should be full now, after adding the maximum 5 volunteers to the queue

		
		// Testing the recipient Queue
		assertEquals(recipQueue.isFull(),false );
		recipQueue.enqueue(new Recipient("MC"));
		recipQueue.enqueue(new Recipient("UMD"));
		recipQueue.dequeue(); 
		assertEquals(recipQueue.size(),1); 
		assertEquals(recipQueue.isFull(),false); //There is only 1 recipient left in queue, so the queue is still not full
	}
	
	
	/**
	 * Test dequeue() method to see if it correctly removes an element from the queue 
	 */
	@Test
	public void testDequeue() {
		
		// Testing the volunteer Queue
		volQueue.enqueue(new Volunteer("Nabeel"));
		volQueue.enqueue(new Volunteer("Keith"));
		volQueue.enqueue(new Volunteer("Kim"));		
		volQueue.enqueue(new Volunteer("Foster"));
		volQueue.enqueue(new Volunteer("Josh")); 
		assertEquals(volQueue.size(),5); 
		
		volQueue.dequeue();     // Will remove Nabeel from the queue
		volQueue.dequeue();     // Will remove Keith from the queue
		volQueue.dequeue();     // Will remove Kim from the queue
		assertEquals(volQueue.size(),2); 
		assertEquals(volQueue.toArray()[0].toString(),"Foster"); // Foster should now be at the top of the queue.
		
		
		// Testing the recipient Queue
		recipQueue.enqueue(new Recipient("Maryland"));
		recipQueue.enqueue(new Recipient("MC"));  
		assertEquals(recipQueue.size(),2); 
		recipQueue.dequeue();     // Will remove Maryland from the queue	
		assertEquals(recipQueue.toArray()[0].toString(),"MC"); // MC should now be at the top of the queue.
	
	}
}
