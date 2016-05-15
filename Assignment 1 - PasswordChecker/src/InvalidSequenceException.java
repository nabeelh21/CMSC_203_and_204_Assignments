/**
* A subclass of the Exception class, which will be used if there is an InvalidSequenceException (when the password contains more then 2 of the same character in sequence ).    
* @author Nabeel Hussain 
*/
@SuppressWarnings("serial")
public class InvalidSequenceException extends Exception {
	
	/**
	 * no-arg Constructor
	 */
	public InvalidSequenceException()
	{	
	}
	
	/**
	 * Constructor that will take in a message, which will be displayed if InvalidSequenceException is thrown.
	 * 
	 *  @param message the error message that will be shown if the exception is thrown
	 */
	public InvalidSequenceException(String message)
	{	
		super(message);	
	}

}
