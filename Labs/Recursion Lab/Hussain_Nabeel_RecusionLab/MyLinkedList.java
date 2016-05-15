import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class implements a recursive method to find the largest value in a singly linked list.
 * It inherits from the class LinkedList<String> and adds the recursive method public String findLargest().
 * It uses the iterator to access each node of the linkedlist.
 * 
 * @author Nabeel Hussain
*/

@SuppressWarnings("serial")
public class MyLinkedList extends LinkedList<String>
{
	
	Iterator<String> iterator = null;
	String largest = "";

	public String findLargest()
	{
	    if (iterator == null)
	    {
	    	iterator = super.iterator(); 
	    }   
	    
	    // If the linked list is empty or has no next element, then return the the string that is currently the largest.  
	    if (!iterator.hasNext())
	    {
	    	iterator = null;
	    	
	        return largest;
	    } 
	    else{
	    	
	        String currentNode = iterator.next(); 
	        
	        // if the current node of the iterator in the linked list is greater than the largest node, then make it the new largest. Otherwise, if it's not, then recursively call the
	        // findLargest method, to check if the next node is larger, until there is no more nodes in the list to check. 
	        if(largest.compareTo(currentNode) < 0)
	        {
	            largest = currentNode;
	        }
	        
	        findLargest();
	    }
	    return largest;
	}
}