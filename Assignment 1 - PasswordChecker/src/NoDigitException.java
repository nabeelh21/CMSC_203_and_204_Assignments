/**
* A subclass of the Exception class, which will be used if there is a NoDigitException (when the password doesn't contain a numeric character).    
* @author Nabeel Hussain 
*/
@SuppressWarnings("serial")
public class NoDigitException extends Exception {
	
	/**
	 * no-arg Constructor
	 */
	public NoDigitException()
	{	
	}
	
	/**
	 * Constructor that will take in a message, which will be displayed if NoDigitException is thrown.
	 * 
	 *  @param message the error message that will be shown if the exception is thrown
	 */
	public NoDigitException(String message)
	{	
		super(message);	
	}

}
