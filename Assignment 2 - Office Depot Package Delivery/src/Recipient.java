/**
* This Recipient class holds the relevant information for a recipient
* @author Nabeel Hussain
*/
public class Recipient{
	
	private String recipientName;   // Declares variable to hold the recipients name
	
	/**
	 * The Employee constructor, which will set the recipients name
	 * @param name the recipient name
	 */
	public Recipient(String name)
	{
		setName(name);
	}
	
	
	/**
	 * Will take the String parameter passed in, and assign that as the name of the recipient
	 * @param name the recipient name
	 */
	public void setName(String name) {
		this.recipientName = name;
	}
	
	/**
	 * Will return the name of the recipient
	 * @return the recipient name
	 */
	public String getName() {
		return recipientName;
	}
	
	/**
	 * Will return a string representation of the recipient name
	 * @return the recipients name
	 */
	public String toString() {
		
		String name = recipientName;
		
		return name;
	}
	
}
