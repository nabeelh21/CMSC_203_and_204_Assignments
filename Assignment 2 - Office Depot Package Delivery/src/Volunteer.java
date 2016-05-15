
/**
* This Volunteer class holds the relevant information for a volunteer
* @author Nabeel Hussain
*/
public class Volunteer{
	
	private String volunteerName;   // Declares variable to hold the recipients name
	
	/**
	 * The Employee constructor, which will set the volunteers name
	 * @param name the volunteer name
	 */
	public Volunteer(String name)
	{
		setName(name);
	}
	
	
	/**
	 * Will take the String parameter passed in, and assign that as the name of the volunteer
	 * @param name the volunteer name
	 */
	public void setName(String name) {
		this.volunteerName = name;
	}
	
	/**
	 * Will return the name of the volunteer
	 * @return the volunteer name
	 */
	public String getName() {
		return volunteerName;
	}
	
	/**
	 * Will return a string representation of the volunteer name
	 * @return the volunteers name
	 */
	public String toString() {
		
		String name = volunteerName;
		
		return name;
	}
}
