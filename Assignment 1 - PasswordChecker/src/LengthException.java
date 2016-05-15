/**
* This is a newly created subclass of the Exception class, which will be used if there is a LengthException ( when the password is less then 8 chracters).    
* @author Nabeel Hussain 
*/ 

@SuppressWarnings("serial")
public class LengthException extends Exception
{
	/**
	 * no-arg Constructor
	 */
	public LengthException()
	{
	}
	
	/**
	 * Constructor that will take in a message, which will be displayed if LengthException is thrown.
	 * 
	 *  @param message the error message that will be shown if the exception is thrown
	 */
	public LengthException(String message)
	{	
		super(message);	
	}
}
