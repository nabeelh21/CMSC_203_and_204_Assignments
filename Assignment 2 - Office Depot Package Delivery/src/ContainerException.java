/**
* A subclass of the Exception class, which will be used if there is a ContainerException (If the user attempts to add new Donation Package
* and the Container line is full (5 packages)).
* @author Nabeel Hussain 
*/
@SuppressWarnings("serial")
public class ContainerException extends Exception {
	
	/**
	 * no-arg Constructor
	 */
	public ContainerException()
	{	
	}
	
	/**
	 * Constructor that will take in a message, which will be displayed if ContainerException is thrown.
	 * 
	 *  @param message the error message that will be shown if the exception is thrown
	 */
	public ContainerException(String message)
	{	
		super(message);	
	}

}
