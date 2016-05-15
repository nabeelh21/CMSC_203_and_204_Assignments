/**
* A subclass of the Exception class, which will be used if there is a RecipientException (If the user attempts to add new Recipient
* and the recipient line is full (5 recipients)).    
* @author Nabeel Hussain 
*/
@SuppressWarnings("serial")
public class RecipientException extends Exception {
	
	/**
	 * no-arg Constructor
	 */
	public RecipientException()
	{	
	}
	
	/**
	 * Constructor that will take in a message, which will be displayed if RecipientException is thrown.
	 * 
	 *  @param message the error message that will be shown if the exception is thrown
	 */
	public RecipientException(String message)
	{	
		super(message);	
	}

}
