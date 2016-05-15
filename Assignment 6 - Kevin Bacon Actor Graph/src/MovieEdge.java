/**
 * Data class for Edges in Graph Assignment
 * 
 * @author Nabeel Hussain
 */
public class MovieEdge implements java.lang.Comparable<MovieEdge>
{
	
	Actor sourceActor;
	Actor destinationActor;
	int edgeWeight;
	String movieNameConnection;

	/**
	 * Constructor for MovieEdge
	 * 
	 * @param source Actor object - one end of edge
	 * @param destination Actor object - other end of edge
	 * @param weight use 1 for all MovieEdge objects
	 * @param movieName name of movie that connects these two Actors
	 */
	MovieEdge(Actor source, Actor destination, int weight, java.lang.String movieName) 
	{
		sourceActor = source;
		destinationActor = destination;
		edgeWeight = weight;
		movieNameConnection = movieName;
	}
	
	
	/**
	 * compare the weights of the edges
	 * 
	 * @param o object class to compare against
	 * @return  1 if o is smaller, -1 if o is larger, 0 if same
	 */
	@Override
	public int compareTo(MovieEdge o)
	{
		// If the current edge weight is less than the other edge weight that is being compared, then return -1
		if(this.getWeight() < o.getWeight())
		{
			return -1;
		}
		// If the current edge weight is equal to the other edge weight that is being compared, then return 0
		else if(this.getWeight() == o.getWeight())
		{
			return 0;
		}
		// return a 1 in all other scenarios, which will signify that the current edge weight is greater than the other edge weight that is being compared 
		else
		{
			return 1;
		}
	}
	
	
	/**
	 * Return the first end of the edge
	 * 
	 * @return first end of edge
	 */
	public Actor getSource()
	{
		return sourceActor;	
	}
	
	
	/**
	 * Return the second end of the edge
	 * 
	 * @return second end of the edge
	 */
	public Actor getDestination()
	{
		return destinationActor;	
	}
	
	
	/**
	 * Return the weight of this edge. Use 1 for finding movie paths
	 * 
	 * @return weight of edge
	 */
	public int getWeight()
	{
		return edgeWeight;		
	}
	
	
	/**
	 * Return the movie name that connects these two Actors together
	 * 
	 * @return the movie name
	 */
	public java.lang.String getMovieName()
	{
		return movieNameConnection;	
	}
	
	
	/**
	 * Considered an equal edge if source = source && destination = destination or if source = destination && destination = source
	 * @param obj the Actor object that is being compared
	 * @return true if the edges being compared are equal, and false otherwise. 
	 */
	public boolean equals(java.lang.Object o)
	{	
		MovieEdge other = (MovieEdge) o;
		
		if((this.getSource().compareTo(other.getSource()) == 0 && this.getDestination().compareTo(other.getDestination()) == 0)
				|| this.getSource().compareTo(other.getDestination()) == 0 && this.getDestination().compareTo(other.getSource()) == 0 )
		{
			return true;
		}	
		return false;	
	}
	
	
	/**
	 * String representation of this class in the follow format: source + " to " + destination + " via " + movieName
	 * 
	 * @return string
	 */
	public java.lang.String toString()
	{
		String output;
		
		output = sourceActor + " to " + destinationActor + " via " + movieNameConnection;
								
		return output;	
	}
}
