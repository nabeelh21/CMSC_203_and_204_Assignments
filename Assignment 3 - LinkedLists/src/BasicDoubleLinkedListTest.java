import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedListTest {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	StringComparator comparator;
	DoubleComparator comparatorD;

	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Hello");
		linkedString.addToEnd("World");
		comparator = new StringComparator();
		
		//STUDENT: Use the linkedDouble for the STUDENT tests
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(15.0);
		linkedDouble.addToEnd(100.0);
		comparatorD = new DoubleComparator();
		
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedString.getSize());
		assertEquals(2,linkedDouble.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
	}

	@Test
	public void testAddToEndSTUDENT(){
		//test addToEnd for the linkedDouble

		assertEquals(linkedDouble.getLast(), 100.0, .001);
		linkedDouble.addToEnd(110.0);
		assertEquals(linkedDouble.getLast(), 110.0, .001);
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("Begin");
		assertEquals("Begin", linkedString.getFirst());
	}

	@Test
	public void testAddToFrontSTUDENT(){
		//test addToFront for the linkedDouble
		
		assertEquals(linkedDouble.getFirst(), 15.0, .001);
		linkedDouble.addToFront(10.0);
		assertEquals(linkedDouble.getFirst(), 10.0, .001);
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
	}
	
	@Test
	public void testGetFirstSTUDENT(){
		//test getFirst for the linkedDouble
		
		assertEquals(linkedDouble.getFirst(), 15.0, .001);
		linkedDouble.addToFront(10.0);
		assertEquals(linkedDouble.getFirst(), 10.0, .001);
	}

	@Test
	public void testGetLast() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
	}

	@Test
	public void testGetLastSTUDENT(){
		//test getLast for the linkedDouble

		assertEquals(linkedDouble.getLast(), 100.0, .001);
		linkedDouble.addToEnd(110.0);
		assertEquals(linkedDouble.getLast(), 110.0, .001);
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<String> list;
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		list = linkedString.toArrayList();
		assertEquals("Begin", list.get(0));
		assertEquals("Hello", list.get(1));
		assertEquals("World", list.get(2));
		assertEquals("End", list.get(3));
	}
	
	@Test
	public void testToArraySTUDENT(){
		//test toArray for the linkedDouble

		ArrayList<Double> list;
		linkedDouble.addToFront(10.0);
		linkedDouble.addToEnd(110.0);
		list = linkedDouble.toArrayList();
		assertEquals( list.get(0), 10.0, .001);
		assertEquals(list.get(1), 15.0, .001);
		assertEquals(list.get(2), 100.0, .001);
		assertEquals(list.get(3), 110.0, .001);
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("End", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	
	@Test
	public void testIteratorSuccessfulSTUDENT(){
		//test the iterator for the linkedDouble
		//be throughal, use the preceeding test method as an example

		linkedDouble.addToFront(10.0);
		linkedDouble.addToEnd(110.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(iterator.next(), 10.0, .001);
		assertEquals(iterator.next(), 15.0, .001);
		assertEquals(iterator.next(), 100.0, .001);
		assertEquals(true, iterator.hasPrevious());
		assertEquals(iterator.previous(), 110.0, .001);
		assertEquals(iterator.previous(), 100.0, .001);
		assertEquals(iterator.previous(), 15.0, .001);
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
		try{
			//no more elements in list
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("End", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
		assertEquals("Begin", iterator.previous()); // Since this is the head, there is no more previous nodes in the list, so the next time it is called, it will throw an exception. 

		try{
			//no more elements in list
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionSTUDENT(){
		//test the iterator for the linkedDouble.  Exception raised
		//when next is called after last element.
		//be throughal, use the preceeding test method as an example

		linkedDouble.addToFront(10.0);
		linkedDouble.addToEnd(110.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(iterator.next(), 10.0, .001);
		assertEquals(iterator.next(), 15.0, .001);
		assertEquals(iterator.next(), 100.0, .001);		
		assertEquals(true, iterator.hasPrevious());
		assertEquals(iterator.previous(), 110.0, .001);
		assertEquals(iterator.previous(), 100.0, .001);
		assertEquals(iterator.previous(), 15.0, .001);
		assertEquals(iterator.previous(), 10.0, .001); 

		try{
			//no more elements in list
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
		
		try{
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}

	@Test
	public void testIteratorUnsupportedOperationExceptionSTUDENT(){
		//test the remove method for the iterator for the linkedDouble
		//be throughal, use the preceeding test method as an example

		linkedDouble.addToFront(10.0);
		linkedDouble.addToEnd(110.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(iterator.next(), 10.0, .001);
		assertEquals(iterator.next(), 15.0, .001);
		assertEquals(iterator.next(), 100.0, .001);		
		assertEquals(true, iterator.hasNext());
		assertEquals(iterator.next(), 110.0, .001);
		
		try{
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	@Test
	public void testRemove() {
		// remove the first
		assertEquals("Hello", linkedString.getFirst());
		assertEquals("World", linkedString.getLast());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		linkedString.remove("New", comparator);
		assertEquals("Hello", linkedString.getFirst());
		
		//remove from the end of the list
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
		linkedString.remove("End", comparator);
		assertEquals("World", linkedString.getLast());
		
		//remove from middle of list
		linkedString.addToFront("Begin");
		assertEquals("Begin", linkedString.getFirst());
		assertEquals("World", linkedString.getLast());
		assertEquals(3, linkedString.getSize());
		linkedString.remove("Hello", comparator);
		assertEquals(2, linkedString.getSize());
		assertEquals("Begin", linkedString.getFirst());
		assertEquals("World", linkedString.getLast());
		
	}
	
	@Test
	public void testRemoveSTUDENT(){
		//test the remove method for the linkedDouble
		//be through, remove from the front of the list, the
		//end of the list and the middle of the list, 
		//use the preceding test method as an example

		// remove the first
		assertEquals(linkedDouble.getFirst(), 15.0, .001);
		assertEquals(linkedDouble.getLast(), 100.0, .001);
		linkedDouble.addToFront(10.0);
		assertEquals(linkedDouble.getFirst(), 10.0, .001);
		linkedDouble.remove(10.0, comparatorD);
		assertEquals(linkedDouble.getFirst(), 15.0, .001);
				
		//remove from the end of the list
		linkedDouble.addToEnd(110.0);
		assertEquals(linkedDouble.getLast(), 110.0, .001);
		linkedDouble.remove(110.0, comparatorD);
		assertEquals(linkedDouble.getLast(), 100.0, .001);
		
		//remove from middle of list
		linkedDouble.addToFront(10.0);
		linkedDouble.addToFront(5.0);
		assertEquals(linkedDouble.getFirst(), 5.0, .001);
		assertEquals(linkedDouble.getLast(), 100.0, .001);
		
		assertEquals(linkedDouble.toArrayList().get(0), 5.0, .001);
		assertEquals(linkedDouble.toArrayList().get(1), 10.0, .001);
		assertEquals(linkedDouble.toArrayList().get(2), 15.0, .001);
		assertEquals(linkedDouble.toArrayList().get(3), 100.0, .001);
		
		// remove the third node in the list, which is 15
		linkedDouble.remove(15.0, comparatorD); 
	
		// Display the new list after 15 has been removed
		assertEquals(linkedDouble.toArrayList().get(0), 5.0, .001);
		assertEquals(linkedDouble.toArrayList().get(1), 10.0, .001);
		assertEquals(linkedDouble.toArrayList().get(2), 100.0, .001);

		// remove the middle node in the list, which is 10
		linkedDouble.remove(10.0, comparatorD);
		
		assertEquals(linkedDouble.toArrayList().get(0), 5.0, .001);
		assertEquals(linkedDouble.toArrayList().get(1), 100.0, .001);	
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		assertEquals("New", linkedString.retrieveFirstElement());
		assertEquals("Hello",linkedString.getFirst());
		assertEquals("Hello", linkedString.retrieveFirstElement());
		assertEquals("World",linkedString.getFirst());
		
	}
	
	@Test
	public void testRetrieveFirstElementSTUDENT(){
		//test retrieveLastElement for linkedDouble

		assertEquals(linkedDouble.getFirst(), 15.0, .001);
		linkedDouble.addToFront(10.0);
		assertEquals(linkedDouble.getFirst(), 10.0, .001);
		assertEquals(linkedDouble.retrieveFirstElement(), 10.0, .001);
		assertEquals(linkedDouble.getFirst(), 15.0, .001);
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		assertEquals("New", linkedString.retrieveLastElement());
		assertEquals("World",linkedString.getLast());
	}
	
	@Test
	public void testRetrieveLastElementSTUDENT(){
		//test retrieveLastElement for linkedDouble

		assertEquals(linkedDouble.getLast(), 100.0, .001);
		linkedDouble.addToEnd(110.0);
		assertEquals(linkedDouble.getLast(), 110.0, .001);
		assertEquals(linkedDouble.retrieveLastElement(), 110.0, .001);
		assertEquals(linkedDouble.getLast(), 100.0, .001);
	}

	
	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
}