/**
 * A Generic Stack class, which will be used by the container class to add and remove elements from the container. 
 * 
 *  @author Nabeel Hussain
 */
public class MyStack <T> implements StackInterface<T> {
	
	private int size; 	// Declares variable to hold the size of the stack
	private int top; 	// Declares variable to hold the position of the element at the top of the stack
    private T[] data;   // Declares a generic array, which will be used to hold the contents of a type to be specified, in the queue. 
    
    
    /**
     * Constructor, which will initialize the size of the stack to hold 5 elements.
     */
	@SuppressWarnings("unchecked")
	public MyStack()
    {
    	size = 5;
    	top = -1;
    	data = (T[]) new Object[size];
    }
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty() {
		if(top == - 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
    
    
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	public boolean push(T e)
	{
		if(top == size - 1)
		{
			return false;  // ** overflow error **
		}
		else
		{
			top = top + 1;
			
			data[top] = e;
			
			return true;  // push operation successful
		}
	}

	
	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull() {
		if(top == size -1)
		{
			return true;
		}
		else{
			return false;
		}
	}

	
	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	public T pop()
	{
		int topLocation;
		
		if(top == -1)
		{
			return null;  // ** underflow error **
		}
		else
		{
			topLocation = top;
			top = top - 1;
			
			return data[topLocation]; 
		}                                          	
	}

	
	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size() {
		
		return top + 1;
	}


	/**
	 * Returns the elements of the Stack in an array, [0] is top of Stack, [1] is next in Stack, etc.
	 * @return an array of the Objects in the Stack
	 */
	public Object[] toArray() {
		
		// Initialize the array to hold 5 empty elements to begin with. 
		Object[] elements =  {" ", " ", " ", " ", " "};

		for(int i = 0; i < top + 1; i++)
		{	
			elements[i] = data[top - i];				
		}
	
		return elements;
	}

}
