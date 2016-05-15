/**
 * The external Tree Node for Linked Trees
 * 
 * @author Nabeel Hussain
 * @param <T>
 */
public class TreeNode<T>
{
	protected T data;
	protected TreeNode<T> lc;	
	protected TreeNode<T> rc;
	
	/**
	 * The constructor, which creates a new TreeNode with left and right child set to null and data set to the dataNode.
	 * 
	 * @param dataNode the data to be stored in the TreeNode
	 */
	public TreeNode (T dataNode)
	{	
		this.data = dataNode;
		this.lc = null;
		this.rc = null;
	}
	
	
	/**
	 * The constructor, which which will be used for making deep copies
	 * 
	 * @param node the node to make copy of
	 */
	public TreeNode (TreeNode<T> node)
	{
		new TreeNode<T>(node);
	}
	
	
	/**
	 * Return the data within this TreeNode
	 * 
	 * @return the data within the TreeNode
	 */
	public T getData()
	{
		return data;
	}
	
}
