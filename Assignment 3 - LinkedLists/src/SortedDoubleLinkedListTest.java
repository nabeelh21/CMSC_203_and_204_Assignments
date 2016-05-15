import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SortedDoubleLinkedListTest {
	SortedDoubleLinkedList<String> sortedLinkedString;
	StringComparator comparator;
	DoubleComparator comparatorD;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	

	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
		
		//STUDENT - use the SortedDoubleLinkedList<Double> for your STUDENT tests
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		sortedLinkedString = null;
		sortedLinkedDouble =null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulStringNext() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
	}
	
	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	
	
	@Test
	public void testIteratorSuccessfulDoubleNext()
	{
		sortedLinkedDouble.add(15.0);
		sortedLinkedDouble.add(100.0);
		sortedLinkedDouble.add(10.0);
		sortedLinkedDouble.add(110.0);
		
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(iterator.next(), 10.0, .001);
		assertEquals(iterator.next(), 15.0, .001);
		assertEquals(iterator.next(), 100.0, .001);
		assertEquals(true, iterator.hasNext());
	}
	
	
	@Test
	public void testIteratorSuccessfulDoublePrevious()
	{
		sortedLinkedDouble.add(15.0);
		sortedLinkedDouble.add(100.0);
		sortedLinkedDouble.add(10.0);
		sortedLinkedDouble.add(110.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
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
	public void testIteratorNoSuchElementExceptionString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("Zebra", iterator.next());
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
	public void testIteratorNoSuchElementExceptionDouble()
	{
		sortedLinkedDouble.add(15.0);
		sortedLinkedDouble.add(100.0);
		sortedLinkedDouble.add(10.0);
		sortedLinkedDouble.add(110.0);
		
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(iterator.next(), 10.0, .001);
		assertEquals(iterator.next(), 15.0, .001);
		assertEquals(iterator.next(), 100.0, .001);
		assertEquals(true, iterator.hasNext());
		assertEquals(iterator.next(), 110.0, .001);
		
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
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
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
	public void testIteratorUnsupportedOperationExceptionDouble()
	{
		sortedLinkedDouble.add(15.0);
		sortedLinkedDouble.add(100.0);
		sortedLinkedDouble.add(10.0);
		sortedLinkedDouble.add(110.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
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
	public void testAddString() {
		sortedLinkedString.add("Banana");
		sortedLinkedString.add("Elephant");
		sortedLinkedString.add("Apple");
		
		assertEquals("Apple", sortedLinkedString.getFirst());
		assertEquals("Elephant", sortedLinkedString.getLast());
		sortedLinkedString.add("Cat");
		sortedLinkedString.add("Dog");
		assertEquals("Apple", sortedLinkedString.getFirst());
		assertEquals("Elephant", sortedLinkedString.getLast());
		//deletes Elephant from linked list
		assertEquals("Elephant",sortedLinkedString.retrieveLastElement());
		assertEquals("Dog", sortedLinkedString.getLast());
	}

	@Test
	public void testAddDouble() {
		
		sortedLinkedDouble.add(100.0);
		sortedLinkedDouble.add(110.0);
		sortedLinkedDouble.add(5.0);		
		assertEquals(sortedLinkedDouble.getFirst(), 5.0, .001);
		assertEquals(sortedLinkedDouble.getLast(), 110.0, .001);
		sortedLinkedDouble.add(105.0);
		sortedLinkedDouble.add(107.0);
	
		// Check to see if they were added into the arraylist in sorted order
		assertEquals(sortedLinkedDouble.toArrayList().get(0), 5.0, .001);
		assertEquals(sortedLinkedDouble.toArrayList().get(1), 100.0, .001);
		assertEquals(sortedLinkedDouble.toArrayList().get(2), 105.0, .001);
		assertEquals(sortedLinkedDouble.toArrayList().get(3), 107.0, .001);
		assertEquals(sortedLinkedDouble.toArrayList().get(4), 110.0, .001);
		
		assertEquals(sortedLinkedDouble.getFirst(), 5.0, .001);
		assertEquals(sortedLinkedDouble.getLast(), 110.0, .001);
		//deletes 110.0 from linked list
		assertEquals(sortedLinkedDouble.retrieveLastElement(), 110.0, .001);
		//now the new last node is 107.0
		assertEquals(sortedLinkedDouble.getLast(), 107.0, .001);

	}
	
	@Test
	public void testRemoveFirstString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		assertEquals("Hello", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		sortedLinkedString.add("Begin");
		assertEquals("Begin", sortedLinkedString.getFirst());
		// remove the first
		sortedLinkedString.remove("Begin", comparator);
		assertEquals("Hello", sortedLinkedString.getFirst());
	}
	
	@Test
	public void testRemoveFirstDouble() {
		
		sortedLinkedDouble.add(100.0);
		sortedLinkedDouble.add(110.0);
		assertEquals(sortedLinkedDouble.getFirst(), 100.0, .001);
		assertEquals(sortedLinkedDouble.getLast(), 110.0, .001);
		sortedLinkedDouble.add(15.0);
		assertEquals(sortedLinkedDouble.getFirst(), 15.0, .001);
		// remove the first
		sortedLinkedDouble.remove(15.0, comparatorD);
		assertEquals(sortedLinkedDouble.getFirst(), 100.0, .001);

	}
	
	@Test
	public void testRemoveEndString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		assertEquals("Hello", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		sortedLinkedString.add("Zebra");
		assertEquals("Zebra", sortedLinkedString.getLast());
		//remove from the end of the list
		sortedLinkedString.remove("Zebra", comparator);
		assertEquals("World", sortedLinkedString.getLast());
	}
	
	@Test
	public void testRemoveEndDouble() {
		sortedLinkedDouble.add(5.0);
		sortedLinkedDouble.add(100.0);	
		assertEquals(sortedLinkedDouble.getFirst(), 5.0, .001);
		assertEquals(sortedLinkedDouble.getLast(), 100.0, .001);
		sortedLinkedDouble.add(110.0);
		assertEquals(sortedLinkedDouble.getLast(), 110.0, .001);
		//remove from the end of the list
		sortedLinkedDouble.remove(110.0,comparatorD);
		assertEquals(sortedLinkedDouble.getLast(), 100.0, .001);
	}
	
	@Test
	public void testRemoveMiddleString() {
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("World");
		assertEquals("Hello", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		sortedLinkedString.add("Begin");
		assertEquals("Begin", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		assertEquals(3,sortedLinkedString.getSize());
		//remove from middle of list
		sortedLinkedString.remove("Hello", comparator);
		assertEquals("Begin", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		assertEquals(2,sortedLinkedString.getSize());
	}
	
	@Test
	public void testRemoveMiddleDouble() {
		
		sortedLinkedDouble.add(5.0);
		sortedLinkedDouble.add(110.0);	
		assertEquals(sortedLinkedDouble.getFirst(), 5.0, .001);
		assertEquals(sortedLinkedDouble.getLast(), 110.0, .001);
		sortedLinkedDouble.add(2.0);
		assertEquals(sortedLinkedDouble.getFirst(), 2.0, .001);
		assertEquals(sortedLinkedDouble.getLast(), 110.0, .001);
		assertEquals(3, sortedLinkedDouble.getSize());
		
		//remove from middle of list
		sortedLinkedDouble.remove(5.0, comparatorD);
		assertEquals(sortedLinkedDouble.getFirst(), 2.0, .001);
		assertEquals(sortedLinkedDouble.getLast(), 110.0, .001);
		assertEquals(2, sortedLinkedDouble.getSize());



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