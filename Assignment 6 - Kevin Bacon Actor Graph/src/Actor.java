/**
 * Data class to represent the vertices for the Graph assignment
 * 
 * @author Nabeel Hussain
 */
public class Actor implements Comparable<Actor>
{
	private String actorName;
	
	/**
	 * Constructor for Actor.
	 * 
	 * @param name the name of the Actor in format: LastName, FirstName
	 */
	public Actor(java.lang.String name)
	{
		actorName = name;
	}
	
	
	/**
	 * Returns the name of the Actor
	 * 
	 * @return name of Actor
	 */
	public java.lang.String getName()
	{
		return this.actorName;
	}
	
	
	/**
	 * Compare two Actor objects compare by name in following format: LastName, FirstName
	 * 
	 * @param o the Actor object that is being compared
	 */
	@Override
	public int compareTo(Actor o)
	{
		// If the actor name is less than the other actor name being compared, then return -1
		if(this.getName().compareTo(o.getName()) < 0)
		{
			return -1;
		}
		// If the actor name is equal to the other actor name, then return 0
		else if(this.getName().compareTo(o.getName()) == 0)
		{
			return 0;
		}
		// return a 1 in all other scenarios, which will signify that the actor name is greater than the other actor name being compared. 
		else
		{
			return 1;
		}
	}
	
	
	/**
	 * Determines if two Actor objects are equals to each other
	 * 
	 * @param obj the Actor object that is being compared
	 * @return true if the Actors being compared are equal, and false otherwise. 
	 */
	public boolean equals(java.lang.Object obj)
	{
		Actor other = (Actor) obj;

		if(other == null)
		{
			return false;
		}
		
		if(actorName.compareTo(other.getName()) == 0)
		{
			return true;
		}
				
		return false;	
	}
	
	
	/**
	 * String representation of Actor object
	 * 
	 * @return String representation of Actor object

	 */
	public java.lang.String toString()
	{
		String name = actorName;

		return name;
	}
}
