import java.util.Comparator;

/**
 * This program will implement a generic sorted double linked list class. It's a sub class of the BasicDoubleLinkedList class.      
 * 
 * Name: Nabeel Hussain
 * Class: CMSC204
 * Professor: Jeannette Myers Kartchner
 * Assignment 3 - DoubleLinkedList
 * Date: 2/25/2016
 * 
 * @author Nabeel Hussain
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>
{
	protected Comparator<T> comp;

	/**
	 * Constructor, which creates an empty list that is associated with the specified comparator. 
	 * 
	 * @param comparator2 Comparator to compare data elements
	 */
	SortedDoubleLinkedList(java.util.Comparator<T> comparator2)
	{
		this.comp = comparator2;
	}
	
	
	/**
	 * Inserts the specified element at the correct position in the sorted list. Notice we can insert the same element several times.
	 * Your implementation must traverse the list only once in order to perform the insertion. Do not implement this method using iterators.
	 * Notice that you don't need to call any of the super class methods in order to implement this method.
	 * 
	 * @param data the data to be added to the list.
	 * @return a reference to the current object 
	*/
	public SortedDoubleLinkedList<T> add(T data)
	{
		Node<T> newNode = new Node<T>(); // The new node that will be added to the list
		Node<T> current = new Node<T>();  // Nodes to keep track of the nth and nth+1 node, while traversing through the list, to see if the newNow should be placed between them.

		newNode.data = data;
		
		// if linkedlist is empty, add node as the head
		if(size == 0)
		{
			head = newNode;
			tail = head;
			size++;
			list.add(0, newNode.data);
			return this;
		}
		else
		{
			// if the node being added is less than the head, then make it the new head
			if ((comp.compare(data, head.data) < 0))
			{
				newNode.next = head;
				head.prev = newNode;

				head = newNode;
				size++;
				list.add(0, newNode.data);
				return this;
			}
			else{
				
				current = head.next;
				
				// Traverse through the list starting from the second node. If the new node that is being added is less than or equal to the
				// current node in the traversal, then insert it before that node. 
				while( current != null)
				{	
					if(comp.compare(newNode.data, current.data) <= 0)
					{
						
						newNode.next = current;
						newNode.prev = current.prev;
	                    current.prev = newNode;
	                    size++;
	    				list.add(newNode.data);
	    				
	    				// make sure the Array list is also being sorted. 
	    				list.sort(comp);
	                    return this;
					}
					
	                current = current.next;
				}				
			    
				
				// Otherwise, if the new node is not less than or equal to all the current nodes in the list, then insert it as the new tail.  
				newNode.prev = tail;
				tail.next = newNode;
	            tail = newNode;
				list.add(newNode.data);
	            size++;
	            return this;
			}
		}		
	}
	
	/**
	 * This operation is invalid for a sorted list.
	 * An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
	 *
	 * @param data the data for the Node within the linked list
	 * @return reference to the current object 
	 * @throws java.lang.UnsupportedOperationException if method is called
	*/ 
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) throws java.lang.UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
		
	}
	
	
	/**
	 * This operation is invalid for a sorted list.
	 * An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
	 *
	 * @param data the data for the Node within the linked list
	 * @return reference to the current object 
	 * @throws java.lang.UnsupportedOperationException if method is called
	*/
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) throws java.lang.UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list.");	
		
	}
	
	
	/**
	 * Overrides the super class method for iterator.
	 * 
	 * @return an iterator positioned at the head of the list
	*/
	@Override
	public java.util.ListIterator<T> iterator()
	{
		return super.iterator();
		
	}
}
