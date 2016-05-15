import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing the methods of MyStack
 * 
 * @author Nabeel Hussain
 */
public class MyStackTest {
	
	// A Stack will be created using donation packages as the elements to be stacked
	MyStack<DonationPackage> stack1;
	
	// A second DonationPackage Stack to test
	MyStack<DonationPackage> stack2;
	
	
	@Before
	public void setUp() throws Exception {
		
		stack1 = new MyStack<DonationPackage>();
		stack2 = new MyStack<DonationPackage>();

	}

	@After
	public void tearDown() throws Exception {
		
		stack1 = null;
		stack2 = null;
	}
	
	/**
	 * Test isEmpty() method to see if it correctly tells whether the stack is empty or not. 
	 */
	@Test
	public void testIsEmpty() {
		
		// Stack1 test
		assertEquals(stack1.isEmpty(),true ); // Stack will always be empty at start
		stack1.push(new DonationPackage("Books", 10)); // Push a package to the stack
		assertEquals(stack1.isEmpty(),false ); // Stack should now not be empty anymore

		
		// Stack2 test
		assertEquals(stack2.isEmpty(),true );
		stack2.push(new DonationPackage("Rulers", 5));
		stack2.push(new DonationPackage("Paper", 10));
		stack2.pop();
		assertEquals(stack2.isEmpty(),false); //There is still one package left, so it's not empty
	}

	/**
	 * Test push() method to see if it correctly adds an element to the stack 
	 */
	@Test
	public void testPush() {
		
		// Stack1 test
		stack1.push(new DonationPackage("Books", 10));
		assertEquals(stack1.toArray()[0].toString(), "Books");
		stack1.push(new DonationPackage("Paper", 10));
		assertEquals(stack1.toArray()[0].toString(), "Paper");  	// Paper is now on the top of the stack
		stack1.push(new DonationPackage("Binders", 5));
		assertEquals(stack1.toArray()[0].toString(), "Binders");	// Binders is now on the top of the stack
		stack1.push(new DonationPackage("Pens", 18));
		assertEquals(stack1.toArray()[0].toString(), "Pens");    	// Binders is now on the top of the stack
		stack1.push(new DonationPackage("Erasers", 18));
		assertEquals(stack1.toArray()[0].toString(), "Erasers");  	// Erasers is now on the top of the stack
		stack1.push(new DonationPackage("Stamps", 18));     		// It wont add Stamps to the container, because it is full
		assertEquals(stack1.toArray()[0].toString(), "Erasers");    // Erasers is still on the top of the stack
		
		
		
		// Stack2 test
		stack2.push(new DonationPackage("Rulers", 10));
		assertEquals(stack2.toArray()[0].toString(), "Rulers");  // Rulers is at the top of the stack
		stack2.push(new DonationPackage("Black Boards", 10));
		assertEquals(stack2.toArray()[0].toString(), "Black Boards");  	// Black Boards is now on the top of the stack
		stack2.push(new DonationPackage("Binders", 5));
		assertEquals(stack2.toArray()[0].toString(), "Binders");    // Binders is now on the top of the stack
			
	}
	
	
	/**
	 * Test isFull() method to see if it correctly tells whether the stack is full or not. 
	 */
	@Test
	public void testIsFull() {
		
		// Stack1 test
		assertEquals(stack1.isFull(),false ); // Stack will always start empty, so it will not be full.
		stack1.push(new DonationPackage("Books", 10)); // Push a package to the stack
		stack1.push(new DonationPackage("Pens", 5)); // Push another package to the stack
		assertEquals(stack1.isFull(),false ); // Stack should still not be full, as it needs to contain 5 packages to be full

		
		
		// Stack2 test
		assertEquals(stack2.isFull(),false);
		stack2.push(new DonationPackage("Rulers", 5));
		stack2.push(new DonationPackage("Paper", 10));
		stack2.push(new DonationPackage("Rulers", 5));
		stack2.push(new DonationPackage("Paper", 10));
		assertEquals(stack2.isFull(),false); 
		stack2.push(new DonationPackage("Rulers", 5));
		assertEquals(stack2.isFull(),true); // If stack contains 5 packages, then it will be full
		stack2.push(new DonationPackage("Paper", 10));
		assertEquals(stack2.isFull(),true);
	}

	/**
	 * Test pop() method to see if it correctly removes an element from the stack 
	 */
	@Test
	public void testPop() {
		
		
		// Stack1 test
		stack1.push(new DonationPackage("Books", 10));		
		stack1.push(new DonationPackage("Paper", 10));		
		stack1.push(new DonationPackage("Binders", 5));		
		stack1.push(new DonationPackage("Pens", 18));   // Pens, was the last one entered, so it is at the top of the stack		
		stack1.pop(); // Will remove pens, which is at the top of the stack	
		assertEquals(stack1.toArray()[0].toString(), "Binders");    // Binders is now at the top of the stack, because Pens was pushed out.
		
		
		
		
		// Stack2 test
		stack2.push(new DonationPackage("Books", 10));		
		stack2.pop(); 
		assertEquals(stack2.isEmpty(), true);    // Binders was the only package in the container, and after it was popped out, the container is now empty. 
	}


}
