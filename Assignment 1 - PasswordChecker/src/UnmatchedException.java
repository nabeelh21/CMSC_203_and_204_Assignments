/**
* A subclass of the Exception class, which will be used if there is an UnmatchedException (when the password and retyped password entered by the user does not match).    
* @author Nabeel Hussain 
*/ 

@SuppressWarnings("serial")
public class UnmatchedException extends Exception {
	
	/**
	 * no-arg Constructor
	 */
	public UnmatchedException()
	{	
	}
	
	/**
	 * Constructor that will take in a message, which will be displayed if UnmatchedException is thrown.
	 * 
	 *  @param message the error message that will be shown if the exception is thrown
	 */
	public UnmatchedException(String message)
	{	
		super(message);	
	}

}
