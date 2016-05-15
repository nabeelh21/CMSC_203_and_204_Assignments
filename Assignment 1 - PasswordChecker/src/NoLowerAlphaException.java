/**
* A subclass of the Exception class, which will be used if there is a NoLowerAlphaException (when the password doesn't contain a lowercase alpha character).    
* @author Nabeel Hussain 
*/
@SuppressWarnings("serial")
public class NoLowerAlphaException extends Exception {
	
	/**
	 * no-arg Constructor
	 */
	public NoLowerAlphaException()
	{	
	}
	
	/**
	 * Constructor that will take in a message, which will be displayed if NoLowerAlphaException is thrown.
	 * 
	 *  @param message the error message that will be shown if the exception is thrown
	 */
	public NoLowerAlphaException(String message)
	{	
		super(message);	
	}

}
