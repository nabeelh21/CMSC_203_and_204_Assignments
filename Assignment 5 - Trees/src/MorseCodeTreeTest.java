import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeTreeTest {
	
	MorseCodeTree tree = new MorseCodeTree();

	@Before
	public void setUp() throws Exception {
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		tree = null;
	}


	@Test
	public void testInsert() {
		
		// Since this method calls the recursive method addNode, it will act as a test for the addNode method as well. 
		
		
		// I will add the number 1 into the binary tree, since all the letters have already been added in the initialization of the MorseCodeTree.
		// The code for the number 1 is ".----"
		// This will create a 5th level in the binary tree, which will store the number 1
		
		tree.insert(".----", "1");
		
		// Now use the morse code for the number 1, to see if it fetches the correct number from the tree. This will let us know
		// if it was added into the tree or not.
		String letterFetched = tree.fetch(".----");
			
		assertEquals("1", letterFetched);
	}

	@Test
	public void testGetRoot() {
		
		String root;
		
		root = tree.getRoot().getData();
		
		assertEquals("", root);
		
	}

	@Test
	public void testSetRoot() {
				
		String newRoot;
		
		// the root is initially an empty string
		assertEquals("", tree.getRoot().getData());
		
		// Create a new node, which will be use to set as the new root
		TreeNode<String> name = new TreeNode <String> ("Nabeel");
		
		// Set the root to be the new node that was created
		tree.setRoot(name);
		
		newRoot = tree.getRoot().getData();
		
		assertEquals("Nabeel", newRoot);
	}

	@Test
	public void testFetch() {
		
		// Since this method calls the recursive method fetchNode, it will act as a test for the fetchNode method as well. 

		
		String letterFetched;
		
		// "-." is the morse code for the letter n.
		letterFetched = tree.fetch("-.");
		
		assertEquals("n", letterFetched);
		
		
		
		String letterFetched2;
		
		// "--.-" is the morse code for the letter q.
		letterFetched2 = tree.fetch("--.-");
		
		assertEquals("q", letterFetched2);

	}


	@Test
	public void testToArrayList() {
		
		// Since this method calls the LNRoutputTraversal method to arrange the ArrayList in inorder, it will act as a test for the LNRoutputTraversal method as well.  
		
		ArrayList<String> list = new  ArrayList<String>();
		
		list = tree.toArrayList();
		
		assertEquals("h", list.get(0));
		assertEquals("s", list.get(1));
		assertEquals("v", list.get(2));
		assertEquals("i", list.get(3));
		assertEquals("f", list.get(4));
		assertEquals("u", list.get(5));
		assertEquals("e", list.get(6));
		assertEquals("l", list.get(7));
		assertEquals("r", list.get(8));
		assertEquals("a", list.get(9));
		assertEquals("p", list.get(10));
		assertEquals("w", list.get(11));
		assertEquals("j", list.get(12));
		assertEquals("", list.get(13));
		assertEquals("b", list.get(14));
		assertEquals("d", list.get(15));
		assertEquals("x", list.get(16));
		assertEquals("n", list.get(17));
		assertEquals("c", list.get(18));
		assertEquals("k", list.get(19));
		assertEquals("y", list.get(20));
		assertEquals("t", list.get(21));
		assertEquals("z", list.get(22));
		assertEquals("g", list.get(23));
		assertEquals("q", list.get(24));
		assertEquals("m", list.get(25));
		assertEquals("o", list.get(26));

	}
}
