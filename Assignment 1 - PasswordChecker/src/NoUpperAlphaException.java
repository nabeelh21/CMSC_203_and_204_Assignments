/**
* A subclass of the Exception class, which will be used if there is a NoUpperAlphaException (when the password doesn't contain an uppercase alpha character).    
* @author Nabeel Hussain 
*/
@SuppressWarnings("serial")
public class NoUpperAlphaException extends Exception {
	
	/**
	 * no-arg Constructor
	 */
	public NoUpperAlphaException()
	{	
	}
	
	/**
	 * Constructor that will take in a message, which will be displayed if NoUpperAlphaException is thrown.
	 * 
	 *  @param message the error message that will be shown if the exception is thrown
	 */
	public NoUpperAlphaException(String message)
	{	
		super(message);	
	}

}
