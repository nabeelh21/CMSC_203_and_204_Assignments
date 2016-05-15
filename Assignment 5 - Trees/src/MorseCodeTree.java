import java.util.ArrayList;

/**
 * This is a MorseCodeTree which is specifically used for the conversion of morse code to English. It relies on a root (reference to root of the tree).
 * The root is set to null when the tree is empty. The class uses an external generic TreeNode class which consists of a reference to the data and a reference
 * to the left and right child. The TreeNode is parameterized as a String, TreeNode. This class uses a private member root (reference to a TreeNode).
 * The constructor will call the buildTree method
 * 
 * @author Nabeel Hussain
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<java.lang.String>
{
	private TreeNode<String> root = null;  //root of the tree, which is set to null when the tree is empty
	
	private String fetchedLetter; // variable to hold the String letter, which the fetch method will return

		
	/**
	 * Constructor - calls the buildTree method
	 */
	public MorseCodeTree()
	{
		buildTree(); // call the buildTree method to create the tree, and place the letters for the morse code decoder in the correct position. 
	}
	
	
	/**
	 * This is a recursive method that adds element to the correct position in the tree based on the code.
	 * A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right.
	 * The code ".-" would be stored as the right child of the left child of the root.
	 * Algorithm for the recursive method:
	 * 1. if there is only one character
	 * a. if the character is '.' (dot) store to the left of the current root
	 * b. if the character is "-" (dash) store to the right of the current root
	 * c. return
	 * 
	 * 2. if there is more than one character
	 * a. if the first character is "." (dot) new root becomes the left child
	 * b. if the first character is "-" (dash) new root becomes the right child
	 * c. new code becomes all the remaining charcters in the code (beyond the first character)
	 * d. call addNode(new root, new code, letter)
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */

	@Override
	public void addNode(TreeNode<String> root, String code, String letter)
	{	
		// If there is only one character in the morse code
		if(code.length() == 1)
	    {
			// if the character is '.' (dot) store to the left of the current root
			if (code.equals("."))
			{
				root.lc = new TreeNode<String>(letter);
			}
			// else if the character is "-" (dash) store to the right of the current root
			else
			{
				root.rc = new TreeNode<String>(letter);
			}
			
			return;
	    }
	    else
	    {	
	    	// if the first character is '.' (dot) new root becomes the left child
			if(code.substring(0, 1).equals("."))
			{
				// recursively call addNode(new root, new code, letter)
				//new code becomes all the remaining characters in the code (beyond the first character)
				addNode(root.lc, code.substring(1), letter);
			}
			
			// else if the first character is "-" (dash) new root becomes the right child
			else
			{
				// recursively call addNode(new root, new code, letter)
				//new code becomes all the remaining characters in the code (beyond the first character)
				addNode(root.rc, code.substring(1), letter);		
			}		
		}	    	
	}
	
	/**
	 * Adds element to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * @param letter the letter for the new node to be added, example "r"
	 * @return
	 */
	@Override
	public MorseCodeTree insert(java.lang.String code, java.lang.String letter)
	{
		// calls the recursive method addNode
		addNode(root, code, letter);
		
		return this;		
	}

	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code.
	 * The root will have a value of "" (empty string)
	 * level one: insert(".", "e"); insert("-", "t");
	 * level two: insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m"); etc.
	 * Look at the tree and the table of codes to letters in the assignment description.
	 */
	@Override
	public void buildTree()
	{
		//The root will have a value of "" (empty string)
		root = new TreeNode<String>("");
		
		// First Level
		insert(".", "e");
		insert("-", "t");
		
		//Second Level
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		//Third Level
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");

		//Fourth Level
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");					
	}
	
	
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot()
	{
		return this.root;
	}

	
	/**
	 * sets the root of the of the MorseCodeTree
	 * 
	 * @param newNode a copy of newNode will be the new root
	 */

	@Override
	public void setRoot(TreeNode<String> newNode) {
		
		root = newNode;	
	}

	
	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the string (letter) that corresponds to the code
	 */
	@Override
	public java.lang.String fetch(java.lang.String code)
	{
		// calls the recursive method fetchNode
		String letter = fetchNode(root, code);
		
		return letter;
	}


	/**
	 * This is the recursive method that fetches the data of the TreeNode that corresponds with the code
	 * A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right.
	 * The code ".-" would fetch the data of the TreeNode stored as the right child of the left child of the root
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the string (letter) corresponding to the code
	 */
	@Override
	public java.lang.String fetchNode(TreeNode<java.lang.String> root, java.lang.String code)
	{	
		// If there is only one character in the morse code
		if(code.length() == 1)
	    {
			// if the character is '.' (dot) retrieve the data from the left child of root
			if (code.equals("."))
			{
				fetchedLetter = root.lc.getData(); 
			}
			
			// else if the character is '-' (dash) retrieve the data from the right child of root
			else
			{
				fetchedLetter =  root.rc.getData(); 
			}
		}
	    else
	    {	
			// if the first character is '.' (dot) new root becomes the left child
			if(code.substring(0, 1).equals("."))
			{
				// recursively call fetchNode(new root, new code)
				//new code becomes all the remaining characters in the code (beyond the first character)
				fetchNode(root.lc, code.substring(1));
			}
			
			// if the first character is '-' (dash) new root becomes the right child
			else
			{
				// recursively call fetchNode(new root, new code)
				//new code becomes all the remaining characters in the code (beyond the first character)
				fetchNode(root.rc, code.substring(1));		
			}		
		}
		
		// Return the corresponding letter to the morse code
		return fetchedLetter;	
	}

	
	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order. Used for testing to make sure tree is built correctly
	 * 
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public java.util.ArrayList<java.lang.String> toArrayList()
	{
		ArrayList<String> printTree = new ArrayList<String>();

		LNRoutputTraversal(root, printTree);		

		return printTree;
	}

	
	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 * 
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<java.lang.String> root, java.util.ArrayList<java.lang.String> list)
	{
		if(root != null)
		{
			// recursive method to traverse through the binary tree in LNR (Inorder)
			LNRoutputTraversal(root.lc, list);
			list.add(root.getData());
			LNRoutputTraversal(root.rc, list);
		}
	}
	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		return null;
	}

	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		return null;
	}

}
