import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

/**
 * The Data Manager class, which will be used to perform the Kevin Bacon Actor Application.  
 * 
 * @author Nabeel Hussain
 */
public class ActorGraphManager implements ActorGraphManagerInterface 
{
	private ActorGraph graph = new ActorGraph(); // An Instance of the ActorGraph Object
	private ArrayList<String> movieTitles = new ArrayList<String>(); // Will hold a list of all the edges / movie names added to the graph 
	private ArrayList<String> actorNames = new ArrayList<String>();  // Will hold a list of all the vertices add to the graph

	
	/**
	 * Adds a movie with 2 actors and a movie name
	 * @param actor1 name of actor 1 (lastname, firstname)
	 * @param actor2 name of actor 2 (lastname, firstname)
	 * @param movieName name of movie
	 * @return true if the movie was added successfully
	 */
	@Override
	public boolean addMovie(String actor1, String actor2, String movieName)
	{
		Actor act1 = new Actor(actor1);
		Actor act2 = new Actor(actor2);
		
		if(graph.containsVertex(act1) && graph.containsVertex(act2))
		{
			if(graph.containsEdge(act1,act2 ) == false)
			{
				graph.addEdge(act1, act2, 1, movieName);
				
				MovieEdge movieTitle = graph.addEdge(act1, act2, 1, movieName);

				movieTitles.add(movieTitle.getMovieName());
				
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Returns the name of the movie that both actors are connected through
	 * @param actor1 name of actor 1 (lastname, firstname)
	 * @param actor2 name of actor 2 (lastname, firstname)
	 * @return name of movie if actor 1 and actor2 are in the same movie, returns null if not
	 */
	@Override
	public String getMovie(String actor1, String actor2)
	{
		Actor act1 = new Actor(actor1);
		Actor act2 = new Actor(actor2);	
		
		if(graph.containsEdge(act1,act2 ))
		{
			MovieEdge movieName = graph.getEdge(act1, act2);
			
			return movieName.getMovieName();	
		}	
		return null;	
	}

	
	/**
	 * Adds an actor to the graph
	 * @param v the actor's name  (lastname, firstname)
	 * @return true if the actor was successfully added, false if not
	 */
	@Override
	public boolean addActor(String v)
	{
		Actor newActor = new Actor(v);
		
		if(!graph.containsVertex(newActor))
		{
			graph.addVertex(newActor);
			actorNames.add(v);
			return true;
		}
		return false;
	}

	
	/**
	 * Determines if an actor is already in the graph
	 * @param v the actor's name  (lastname, firstname)
	 * @return true if the actor is in the graph, false if not
	 */
	@Override
	public boolean containsActor(String v)
	{
		Actor actor = new Actor(v);

		if(graph.containsVertex(actor))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
	/**
	 * Determines if a movie is in the graph
	 * @param actor1 name of actor 1 (lastname, firstname)
	 * @param actor2 name of actor 2 (lastname, firstname)
	 * @return true if the movie is in the graph, false if not
	 */
	@Override
	public boolean containsMovieConnection(String actor1, String actor2)
	{
		Actor act1 = new Actor(actor1);
		Actor act2 = new Actor(actor2);
		
		if(graph.containsEdge(act1,act2 ))
		{
			return true;		
		}
		else
		{
			return false;
		}
	}

	
	/**
	 * Creates an arraylist of all movie titles in sorted order
	 * @return an arraylist of all movie titles in sorted order
	 */
	@Override
	public ArrayList<String> allMovies()
	{
		ArrayList<String> sortedMovieTitles = new ArrayList<String>();
		
		sortedMovieTitles = movieTitles;
		
		Collections.sort(movieTitles);
		
		return sortedMovieTitles;
	}

	
	/**
	 * Deletes a movie from the graph
	 * @param actor1 name of actor 1 (lastname, firstname)
	 * @param actor2 name of actor 2 (lastname, firstname)
	 * @param movieName the movie name
	 * @return true if the movie was successfully deleted, false if not
	 */
	@Override
	public boolean deleteMovieConnection(String actor1, String actor2, String movieName)
	{
		Actor act1 = new Actor(actor1);
		Actor act2 = new Actor(actor2);
		
		if(graph.containsEdge(act1,act2 ) == true)
		{
			graph.removeEdge(act1, act2, 1, movieName);
			
			return true;		
		}
		else
		{
			return false;
		}
	}

	
	/**
	 * Deletes an actor from the graph
	 * @param v name of actor (lastname, firstname)
	 * @return true if the actor was successfully deleted, false if not
	 */
	@Override
	public boolean deleteActor(String v)
	
	{
		Actor actor = new Actor(v);

		if(graph.containsVertex(actor))
		{
			graph.removeVertex(actor);
			actorNames.remove(v);
			return true;
		}
		else
		{
			return false;
		}
	}

	
	/**
	 * Creates an arraylist of all actors in alphabetical order (last name, first name)
	 * @return an arraylist of all actors in alphabetical order (last name, first name)
	 */
	@Override
	public ArrayList<String> allActors()
	{
		ArrayList<String> sortedActorNames = new ArrayList<String>();
		
		sortedActorNames = actorNames;
		
		Collections.sort(sortedActorNames);
		
		return sortedActorNames;
	}

	
	/**
	 * Returns the shortest path from actor 1 to actor
	 * @param actor1 name of actor 1 (lastname, firstname)
	 * @param actor2 name of actor 2 (lastname, firstname)
	 * @return an Arraylist of Movies connecting the two actors together, null if the
	 * actors have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String actor1, String actor2)
	{
		Actor act1 = new Actor(actor1);
		Actor act2 = new Actor(actor2);
		
		if(graph.containsEdge(act1,act2 ))
		{
			return graph.shortestPath(act1, act2);
		}
		else
		{
			return null;
		}
	}
}
