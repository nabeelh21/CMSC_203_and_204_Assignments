/**
 * A Generic Queue class, which will be used by the VolunteerLine and RecipientLine classes to add and remove elements from a queue line.
 * 
 *  @author Nabeel Hussain
 */
public class MyQueue<T> implements QueueInterface<T>
{
	
	private T[] data;       // Declares a generic array, which will be used to hold the contents of a type to be specified, in the queue.  
	private int size;       // Declares variable to hold the size of the queue
	private int numOfNodes; // Declares variable to hold the number of elements in the queue. 
	private int front;      // Declares variable to hold the position of the first element thats in queue
	private int rear;       //  Declares variable to hold the position of the last element thats in queue

	/**
     * Constructor, which will initialize the size of the queue to hold 5 elements.
     */
	@SuppressWarnings("unchecked")
	public MyQueue(){
		size = 5;      	 
		numOfNodes = 0;	
		front = 0;
		rear = 0;
		data = (T[]) new Object[size];
	}
	
	/**
	 * Determines if the Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty() {
		if(numOfNodes == 0)
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	
	/**
	 * Determines if the Queue is full
	 * @return true if Queue is full, false if not
	 */
	public boolean isFull() {
		if(numOfNodes == size)
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	public boolean enqueue(T e)
	{
		if(numOfNodes == size)
		{
			return false;  // ** overflow error **
		}
		else
		{
			numOfNodes = numOfNodes + 1;
			data[rear] = e;
			rear = (rear + 1) % size; // % keeps rear in bounds
			return true;  // Enqueue operation successful
		}
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	public T dequeue() {
		int frontLocation;
		if(numOfNodes == 0)
		{
			return null;
		}
		else
		{
			frontLocation = front;
			front = (front + 1) % size;
			numOfNodes = numOfNodes - 1;
			
			return data[frontLocation];
		}
	}
	

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size() {
		
		return numOfNodes;
	}


	
	/**
	 * Returns the elements of the Queue in an array, [0] is front of Queue, [1] is next in Queue, etc.
	 * @return an array of the Object elements in the Queue
	 */
	public Object[] toArray() {
		
		// Initialize the array to hold 5 empty elements to begin with. 
		Object[] elements =  {" ", " ", " ", " ", " "};

		for(int i = 0; i < numOfNodes ; i++)
		{	
			elements[i] = data[(front + i) % size];	// Use the % size, to keep the array from going out of bounds
		}
		return elements;
	}
}
	