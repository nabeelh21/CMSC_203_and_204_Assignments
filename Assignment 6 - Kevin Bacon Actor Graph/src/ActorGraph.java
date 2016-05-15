import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The Data Structure class, which will be used to hold the graph. 
 * 
 * @author Nabeel Hussain
 */
public class ActorGraph implements GraphInterface<Actor, MovieEdge>
{
	private Actor vertex[];             	// reference to the vertex array
	private MovieEdge edge[][];     		// reference to the adjacency matrix array
	private int numberOfVertices = 0;          		// counter to keep track on the number of vertices added to the graph
	private int maxNumberOfActors = 50; 	// Random number I choose to initialize the array.  

	public ActorGraph()
	{
		vertex = new Actor[maxNumberOfActors];
		edge = new MovieEdge[maxNumberOfActors][maxNumberOfActors];
	}
	
    /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
	@Override
	public MovieEdge addEdge(Actor sourceVertex, Actor destinationVertex, int weight, String description) 
	{
		MovieEdge movieEdge = null;
		int sourceIndex = 0;
		int destinationIndex = 0;
		
		if(this.containsVertex(sourceVertex) == true  && this.containsVertex(destinationVertex) == true)
		{	
			for(int i = 0; i < vertex.length; i++ )
			{
				if(vertex[i] !=null)
				{	
					if(vertex[i].equals(sourceVertex))
					{
						sourceIndex = i;		
					}
					
					if(vertex[i].equals(destinationVertex))
					{
						destinationIndex = i;	
					}
				}
			}	
			
			movieEdge =  new MovieEdge(sourceVertex, destinationVertex, weight, description);
			
			edge[sourceIndex][destinationIndex] = movieEdge;
			edge[destinationIndex][sourceIndex] = movieEdge;
			
			return movieEdge;
		}	
		else
		{	
			if(this.containsVertex(sourceVertex) != true  || this.containsVertex(destinationVertex) != true)
			{
				throw new IllegalArgumentException();
			}
			
			if(sourceVertex == null || destinationVertex == null)
			{
				throw new NullPointerException();
			}
			
			return null;	
		}	
		
	}
	
    /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
	public MovieEdge getEdge(Actor sourceVertex, Actor destinationVertex)
	{
		int sourceIndex = 0;
		int destinationIndex = 0;
		
		if(sourceVertex == null || destinationVertex == null)
		{
			return null;
		}
		if(this.containsVertex(sourceVertex) == true  && this.containsVertex(destinationVertex) == true)
		{	
			for(int i = 0; i < vertex.length; i++ )
			{
				if(vertex[i] !=null)
				{
					if(vertex[i].equals(sourceVertex))
					{
						sourceIndex = i;		
					}
					
					if(vertex[i].equals(destinationVertex))
					{
						destinationIndex = i;	
					}
				}
			}		
			return edge[sourceIndex][destinationIndex];
		}		
		return null;
	}

	
    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
	@Override
	public boolean addVertex(Actor v) 
	{
		if(numberOfVertices >= vertex.length )
		{
			return false;
		}
		else if(v == null)
		{
			throw new NullPointerException();
		}
		else if(this.containsVertex(v) == true)
		{
			System.out.println("Already contains vertex");
			return false;
		}
		else
		{
			vertex[numberOfVertices] = v;
			//System.out.println(vertex[numberOfVertices]);
			numberOfVertices++;		
			
			return true;
		}	
	}

	
	
    /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
	@Override
	public boolean containsEdge(Actor sourceVertex, Actor destinationVertex)
	{
		int sourceIndex = 0;
		int destinationIndex = 0;
		
		if(sourceVertex == null || destinationVertex == null)
		{
			return false;
		}
		if(this.containsVertex(sourceVertex) == true  && this.containsVertex(destinationVertex) == true)
		{	
			for(int i = 0; i < vertex.length; i++ )
			{
				if(vertex[i] !=null)
				{
					if(vertex[i].equals(sourceVertex))
					{
						sourceIndex = i;		
					}
					
					if(vertex[i].equals(destinationVertex))
					{
						destinationIndex = i;	
					}
				}
			}			
			if(edge[sourceIndex][destinationIndex] != null || edge[destinationIndex][sourceIndex] != null)
			{
				return true;
			}
		}	
		return false;
	}	

	
    /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Actor v)
	{
		if(v == null)
		{
			return false;
		}
		for(int u = 0; u < vertex.length; u++ )
		{
			if(vertex[u] != null)
			{
				if(vertex[u].equals(v) == true)
				{
					return true;
				}
			}
		}	
		return false;
	}

	
    /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     * @return a set of the edges contained in this graph.
     */
	@Override
	public Set<MovieEdge> edgeSet()
	{
		Set<MovieEdge> edges = new HashSet<MovieEdge>();
		
		for(int i = 0; i < 12; i ++)
		{
			for(int j = 0; j < 12; j ++)
			{
				if(edge[i][j] != null)
				{
					edges.add(edge[i][j]);
				}
			}
		}
		return edges;
	}

	
    /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public Set<Actor> vertexSet()
	{
		Set<Actor> actors = new HashSet<Actor>();
		
		for(int i = 0; i < vertex.length; i ++)
		{
			if(vertex[i] != null)
			{
				actors.add(vertex[i]);
			}
		}			
		return actors;
	}
	
	
	
    /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	@Override
	public Set<MovieEdge> edgesOf(Actor vertexx)
	{
		Set<MovieEdge> edges = new HashSet<MovieEdge>();
		
		if(this.containsVertex(vertexx) == false)
		{
			throw new IllegalArgumentException();
		}	
		if(vertexx == null)
		{
			throw new NullPointerException();
		}
	
		if(this.containsVertex(vertexx) == true)
		{		
			for(int i = 0; i < vertex.length; i ++)
			{
				if(this.containsEdge(vertexx, vertex[i]) == true)
				{
					edges.add(this.getEdge(vertexx, vertex[i]));
				}
			}	
		}
		return edges;
	}
	
    /**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public MovieEdge removeEdge(Actor sourceVertex, Actor destinationVertex, int weight, String description)
	{	
		int sourceIndex = 0;
		int destinationIndex = 0;
		
		if(sourceVertex == null || destinationVertex == null)
		{
			return null;
		}	
		if(weight > 1 || weight < 1)
		{
			return null;
		}
		if(this.containsEdge(sourceVertex, destinationVertex) == true && weight == 1 && description != null)
		{	
			for(int i = 0; i < vertex.length; i++ )
			{
				if(vertex[i] !=null)
				{	
					if(vertex[i].equals(sourceVertex))
					{
						sourceIndex = i;		
					}
					
					if(vertex[i].equals(destinationVertex))
					{
						destinationIndex = i;	
					}
				}
			}		
			if(edge[sourceIndex][destinationIndex].getMovieName().equals(description) == true && edge[sourceIndex][destinationIndex].getWeight() == 1)
			{
				edge[sourceIndex][destinationIndex] = null;
				edge[destinationIndex][sourceIndex] = null;
						
				return new MovieEdge(sourceVertex, destinationVertex, 1, description);
			}		
		}	
		return null;
	}

	
	
	 /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	@Override
	public boolean removeVertex(Actor v) {
		
		if(v == null)
		{
			return false;
		}
	
		for(int i = 0; i < vertex.length; i ++)
		{
			if(vertex[i] != null)
			{
				if(vertex[i].equals(v))
				{
					vertex[i] = null;
					numberOfVertices--;
					return true;
				}
			}
		}	
		return false;
	}

	
	
    /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex to destinationVertex
     */
	@Override
	public ArrayList<String> shortestPath(Actor sourceVertex, Actor destinationVertex)
	{
		this.dijkstraShortestPath(sourceVertex);

		
		return null;
	}

    /**
     * Dijkstra's Shortest Path Method.  Internal structures are built which hold the ability to retrieve the path,
     * shortest distance from the sourceVertex to all the other vertices in the graph, etc.
     * 
     * @param sourceVertex the vertex to find shortest path from
     */
	@Override
	public void dijkstraShortestPath(Actor sourceVertex)
	{
/*		Actor[] verticesIncluded = new Actor[maxNumberOfActors];
		String[] minPathLengths = new String[maxNumberOfActors];
		
		int numVerticesIncluded = 0;
		MovieEdge spt[][] = new MovieEdge[maxNumberOfActors][maxNumberOfActors];

		MovieEdge aCopy[][] = edge;		
		verticesIncluded[0] = sourceVertex;  // add the starting vertex to the tree;
		numVerticesIncluded = 1;  // one vertex has been added to the tree	
		
		for (int i = 0; i < numberOfVertices; i++) // eliminate edges to the starting vertex
		{
			if(this.containsEdge(sourceVertex, vertex[i]))
			{
				if(vertex[i] != null)
				{
					minPathLengths[i] = null;
					
					MovieEdge eliminateEdge = this.getEdge(sourceVertex, vertex[i]);
					
					this.removeEdge(sourceVertex, vertex[i], 1, eliminateEdge.getMovieName());
				}
			}
		} 
		
		minPathLengths[0] = null; //Set its path length or movieEdge to 0 or null;
		
		while(numVerticesIncluded < numberOfVertices) // all vertices are not in the tree
		{
			
			for(int i = 0; i < numberOfVertices; i ++)
			{
				
			}
		
		}*/
	
	}
}
