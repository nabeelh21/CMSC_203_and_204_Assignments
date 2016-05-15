
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * This program will implement a generic double linked list class.     
 * 
 * Name: Nabeel Hussain
 * Class: CMSC204
 * Professor: Jeannette Myers Kartchner
 * Assignment 3 - DoubleLinkedList
 * Date: 2/25/2016
 * 
 * @author Nabeel Hussain
 */
public class BasicDoubleLinkedList<T> {
	
	protected ArrayList<T> list = new ArrayList<>(); // list to hold all the contents of the nodes
	protected Node<T> head; // list header - pointer to head node
	protected Node<T> tail; // list tail
	protected int size; 		// list size
	protected BasicDoubleLinkedListIterator iterator;
	
	/**
	 * Constructor, which begins the list as null     
	 */
	public BasicDoubleLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	
	/**
	 * Adds element to the front of the list. Do not use iterators to implement this method.
	 * 
	 * @param data the info of the new node that will passed into the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data)
	{
		Node<T> newNode = new Node<T>();
		newNode.data = data;
		
		// If the list has no nodes, then make the first node that is added in to be the head
		if(head == null){
            head = newNode;
			list.add(0, newNode.data);
        }
		// Otherwise, if the list is not empty, then add the new node to the front of the linked list
		else{	
			newNode.next = head;
			head.prev = newNode; 
			list.add(0,newNode.data);
        }
		
		// the new head should now be the new node that was passed in
		head = newNode;
		size++;

		return this;
	}
	
	/**
	 * Adds an element to the end of the list. Do not use iterators to implement this method.
	 * 
	 * @param data the info of the new node that will passed into the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data)
	{

		Node<T> newNode = new Node<T>();
		newNode.data = data;
		
		// If the list is empty, then make the first node that is added in to be the head
		if(tail == null){
			head = newNode;
			list.add(newNode.data);
		}
		// Otherwise,if the list is not empty, then add the new node to the end of the linked list
		else
		{
			newNode.prev = tail;
			tail.next = newNode;
			
			list.add(newNode.data);
		}
		
		// the new tail should now be the new node that was passed in
		tail = newNode;
		size++;
		
		return this;
   }

	/**
	 * Returns but does not remove the first element from the list. If there are no elements the method returns null. Do not implement this method using iterators.
	 * @return the data element or null
	 */
	public T getFirst()
	{
		// If there are no elements the method returns null
		if(head == null){
            return null;
        }
		// Otherwise, returns the first element in the list
		else{
			return head.data;
		}
	}
	
	
	/**
	 * Returns but does not remove the last element from the list. If there are no elements the method returns null. Do not implement this method using iterators.
	 * 
	 * @return the data element or null
	 */
	public T getLast()
	{
		// If there are no nodes in the list, then the method returns null
		if(head == null){
            return null;
        }
		// If there is only 1 node in the list, then method returns the head node. 
		else if(size == 1)
		{
			return head.data;
		}
		// Otherwise, returns the last element in the list
		else{
			return tail.data;	
		}
	}
	
	
	/**
	 * This method just returns the value of the instance variable you use to keep track of size. Notice you must not traverse the list to compute the size. 
	 * 
	 * @return the size of the linked list
	 */
	public int getSize()
	{
        return size;
	}
	
	
	/**
	 * Removes and returns the first element from the list. If there are no elements the method returns null. Do not implement this method using iterators. 
	 * 
	 * @return data element or null
	 */
	public T retrieveFirstElement()
	{
		Node<T> deletedNode = new Node<T>();  // Will hold the node that will be removed from the list

		if(head == null){
			
            return null;
        }
		else{
			
			list.remove(head.data);
			
			// The deletedNode data will hold the data of the first node in the list, which will be removed from the list
			deletedNode.data = head.data;
			
			// The second node that was in the list is now moved up to the head of the list. 
			head = head.next;
	
			size--;
			
			return (T) deletedNode.data;
		}
	}
	
	
	/**
	 * Removes and returns the last element from the list. If there are no elements the method returns null. Do not implement implement this method using iterators. 
	 * 
	 * @return data element or null
	 */
	public T retrieveLastElement()
	{
		Node<T> deletedNode = new Node<T>(); // Will hold the node that will be removed from the list
		
		if(head == null){
            return null;
        }
		else{
			
			list.remove(tail.data);
			// The deletedNode data will hold the data of the last node in the list, which will be removed from the list
			deletedNode.data = tail.data;
			// The second to last node that was in the list is now moved down to the tail of the list. 
			tail = tail.prev;
			size--;
			
			return (T) deletedNode.data;
		}	
	}
	
	
	/**
	 * Removes the first instance of the targetData from the list. Notice that you must remove the elements by performing a single traversal over the list.
	 * You may not use any of the other retrieval methods associated with the class in order to complete the removal process.
	 * You must use the provided comparator (do not use equals) to find those elements that match the target. Do not implement this method using iterators.
	 * 
	 * @param targetData the data element to be removed
	 * @param comparator the comparator to determine equality of data elements
	 * @return data element or null         */
	/**
	 * @param targetData the node that will be removed from the list
	 * @param comparator will determine if the node to be removed is contained in the list 
	 * @return the node to be removed
	 */
	public T remove (T targetData, Comparator<T> comparator)
	{
		T removalNode = targetData; // Will hold the node that will be removed from the list
		
		// if linkedlist is empty, return null
		if(head == null)
		{
			return null;

		}
		
		// if the node to be removed is the first node in the list
		else if( comparator.compare(removalNode, head.data) == 0 )	
		{
			list.remove(head.data);	
			removalNode = head.data;
			head = head.next;
			size--;
		}
		
		// if the node to be removed is the tail, or the last node in the list. 
		else if( tail.prev != null && comparator.compare(removalNode, tail.data) == 0 )	
		{
			list.remove(tail.data);	
			removalNode = tail.data;
			tail = tail.prev;
			size--;
		}
		
		// if the node to be removed is in the middle of the linked list
		else{
			
			Node<T> current = new Node<T>();
			
			current = head.next;
			
			if(current != null && comparator.compare(removalNode, current.data) == 0)
			{

				list.remove(current.data);	  
				size--;
				current = current.next;	

			}
			else{
				
				while(current != null && comparator.compare(removalNode, current.data) != 0)
				{
					current = current.next;

					if(comparator.compare(removalNode, current.data) == 0)
					{
	
						list.remove(current.data);	  
						size--;
						//current.prev = head.prev;
						//current = current.next;	
					}			
				}
			}
			/*
			else
			{
			Node<T> tempNode = new Node<T>();
			tempNode = head;
			
			for(int i = 0; i < list.size(); i++)
			{
				if(comparator.compare(removalNode, list.get(i)) == 0)
				{
				tempNode = tempNode.next;
				  removalNode = list.get(i);
				  list.remove(i); 
				  size--; 
				}
			}
	        */		        
		}	
		return removalNode;
	}
	
	

	/**
	 * Returns an arraylist of the items in the list from head of list to tail of list 
	 * 
	 * @return an arraylist of the items in the list
	 */
	public java.util.ArrayList<T> toArrayList()
	{
		return list;	
	}
	
	
	/**
	 * This method must be implemented using an inner class that implements ListIterator and defines the methods of hasNext(), next(), hasPrevious() and previous().
	 * Remember that we should be able to call the hasNext() method as many times as we want without changing what is considered the next element. 
	 * 
	 * @throws java.lang.UnsupportedOperationException - You don't need to implement the ListIterator's remove(), add(), nextIndex() and previousIndex() and set() methods, throw UnsupportedOperationException if called.
	 * @throws java.util.NoSuchElementException - Your next() method should throw NoSuchElementException if there are no more elements (at the end of the list and calling next() or at the beginning of the list and calling previous()).
	 * 
	 * @return an iterator positioned at the head of the list
	 */
	public java.util.ListIterator<T> iterator() throws java.lang.UnsupportedOperationException, java.util.NoSuchElementException
	{
		iterator = new  BasicDoubleLinkedListIterator();
		
		return iterator;
	}
	
	
	
	
	
	
	/**
	 * Inner node class 
	 */
	@SuppressWarnings("hiding")
	public class Node <T>
	{
		protected T data;
		protected Node<T> next;	
		protected Node<T> prev;
		
		public Node()
		{		
		}
	}
	
	
	
	/**
	 * an inner class that implements ListIterator and defines the methods of hasNext(), next(), hasPrevious() and previous().
	 *
	 */
	public class BasicDoubleLinkedListIterator implements ListIterator <T>
	{
		protected Node<T> iteratorHead = new Node<T>();
		protected Node<T> iteratorTail = new Node<T>();
		int counter; // Keeps track of all the iterations of the next() method
		int counter2; // Keeps track of all the iterations of the previous() method
		
		
		/**
		 * Constructor for the iterator of the double linked list
		 *
		 */
		public BasicDoubleLinkedListIterator()
		{
			iteratorHead = head;
			iteratorTail = tail;
		}

		
		/**
		 * finds the next node in the list
		 *
		 * @return the next node in the list if there is another after it 
		 */
		@Override
		public T next() {

			if (!hasNext())
			{
		         throw new NoSuchElementException();
			}
			else if(counter == 0)
			{
				counter++;
				return iteratorHead.data;	
			}
			else
			{
				iteratorHead = iteratorHead.next;
				counter++;
				return iteratorHead.data;
			}
		}

		/**
		 * determines if there is a next node in the list
		 *
		 * @return true if the list has another node that is located after the current node, and false if not. 
		 */
		@Override
		public boolean hasNext() {
			if(iteratorHead.next != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		
		/**
		 * finds the previous node in the list
		 *
		 * @return the previous node in the list if there is another before it
		 */
		@Override
		public T previous()
		{
			// If there is no previous, then throw a NoSuchElementException()
			if (!hasPrevious())
			{
		         throw new NoSuchElementException();
			}
			// If calling this method for the first time, then display the last element of the list first
			else if(counter2 == 0)
			{
				counter2++;
				return iteratorTail.data;	
			}
			else 
			{
				iteratorTail = iteratorTail.prev;
				counter2++;
				return iteratorTail.data;
			}

		}
		
		/**
		 * determines if there is a previous node in the list
		 *
		 * @return true if the list has another node that is located before the current node, and false if not. 
		 */
		@Override
		public boolean hasPrevious() {
			
			// It will return true, if the previous node is not null 
			if(iteratorTail.prev != null )
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		
		
		// All the other methods will not be implemented and they will throw a UnsupportedOperationException() if called
		
		@Override
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		

		@Override
		public void add(T arg0) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		
		@Override
		public int nextIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}		
		
		@Override
		public int previousIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T arg0) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
	}
}
