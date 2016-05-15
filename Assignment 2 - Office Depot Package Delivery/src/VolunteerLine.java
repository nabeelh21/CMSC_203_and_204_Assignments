import java.util.NoSuchElementException;

/**
* The VolunteerLine class holds the relevant information to simulate adding volunteers to a queue, and removing them.  
* @author Nabeel Hussain
*/
public class VolunteerLine implements VolunteerLineInterface {
	
	private MyQueue<Volunteer> node = new MyQueue<Volunteer>();
	
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully , false if queue is full
	 */
	public boolean addNewVoluneer(Volunteer v)
	{
		if(node.size() < 5)
		{
			node.enqueue(v);
			
			return true;
			
		}
		else{
			return false;	
		}
	}

	/**
	 * removes volunteer from the volunteer queue line
	 * @return Volunteer Object
	 * @throws NoSuchElementException if queue is empty
	 */
	public Volunteer volunteerTurn() throws NoSuchElementException {
		
		if(node.isEmpty() == true)
		{
			throw new NoSuchElementException();
		}
		else
		{
			
			return node.dequeue();
		}
	}

	/**
	 * checks if there are volunteers in line 
	 * @return true if volunteer line is empty, false otherwise
	 */
	public boolean volunteerLineEmpty() {
		if(node.isEmpty() == true)
		{
			return true;
		}
		else{
			return false;	
		}
	}

	/**
	 * Returns an array of the Volunteers in the queue
	 * @return an array of the volunteers in the queue
	 */
	public Object[] toArrayVolunteer() {

		return node.toArray();
	}

}
