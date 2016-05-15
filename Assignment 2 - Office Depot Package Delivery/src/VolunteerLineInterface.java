import java.util.NoSuchElementException;

/**
 * VolunteerLine Interface represents the interface for the VolunteerLine Class

* The class that uses this  interface uses a Queue of Volunteers to simulate queuing and dequeuing volunteers to and from the 
* VolunteerLine.
* @author khandan Monshi
*
*/
public interface VolunteerLineInterface
{
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully , false if queue is full
	 */
	public boolean  addNewVoluneer(Volunteer v);
	 
	/**
	 * removes volunteer from the volunteer queue line
	 * @return Volunteer Object
	 * @throws NoSuchElementException if queue is empty
	 */
	public  Volunteer volunteerTurn () throws NoSuchElementException;
	  
	/**
	 * checks if there are volunteers in line 
	 * @return true if volunteer line is empty, true otherwise
	 */
	public boolean volunteerLineEmpty();
	/**
	 * Returns an array of the Volunteers in the queue
	 * @return an array of the volunteers in the queue
	 */
	public Object[] toArrayVolunteer();
	

}
