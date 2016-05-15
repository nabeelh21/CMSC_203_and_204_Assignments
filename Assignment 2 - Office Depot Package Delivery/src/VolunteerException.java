/**
* A subclass of the Exception class, which will be used if there is a VolunteerException (If the user attempts to add new Volunteer
* and the volunteer line is full (5 volunteers)).
* @author Nabeel Hussain 
*/
@SuppressWarnings("serial")
public class VolunteerException extends Exception {
	
	/**
	 * no-arg Constructor
	 */
	public VolunteerException()
	{	
	}
	
	/**
	 * Constructor that will take in a message, which will be displayed if VolunteerException is thrown.
	 * 
	 *  @param message the error message that will be shown if the exception is thrown
	 */
	public VolunteerException(String message)
	{	
		super(message);	
	}

}
