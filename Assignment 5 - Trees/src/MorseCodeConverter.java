import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the utility class, which contains a static MorseCodeTree object and constructs (calls the constructor for) the MorseCodeTree.
 * 
 * This class has two static methods convertToEnglish to convert from morse code to English. One method is passed a string object
 * (“.-.. --- ...- . / .-.. --- --- -.- ...”). The other method is passed a file to be converted. These static methods use the MorseCodeTree
 * to convert from morse code to English characters.  Each method returns a string object of English characters.
 * There is also a static printTree method that is used for testing purposed – to make sure the tree for MorseCodeTree was built properly.
 * 
 * @author Nabeel Hussain
 */
public class MorseCodeConverter
{
	// Instance of the MorseCodeTree class, which will be used to perform the morse code translation
	private static MorseCodeTree t = new MorseCodeTree();
	
	
	public MorseCodeConverter()
	{
		
	}

		
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’. 
	 * Example: 
	 * code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." 
	 * string returned = "Hello World"
	 * 
	 * @param code the morse code
	 * @return the English translation
	 */
	public static java.lang.String convertToEnglish(java.lang.String code)
	{
		String output = "";
		String[] word; // will hold each singular word from
		String[] letter; // will hold each singular word from
		
		// split each word in the current line into a new array. 
		word = code.split(" / ");

		// loop through the array containing all the words of a line
		for(int i = 0; i < word.length; i++)
		{	
			//System.out.print(word[i]);
			
			// split each letter in the current word into a new array. 
			letter = word[i].split(" ");
			
			for(int j = 0; j < letter.length; j++)
			{
				//System.out.println(letter[j]);
		
				output += t.fetch(letter[j]);	
			}
			
			//add a space after each word has been translated
			output += " ";
		}	
		
		// take off preceeding or succedding spaces
		output = output.trim();
		
		return output;
	}
	
	
	
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’. 
	 * Example: 
	 * code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." 
	 * string returned = "Hello World"
	 * 
	 * @param codefile name of the File that contains Morse Code
	 * @return the English translation of the file
	 * @throws java.io.FileNotFoundException
	 */
	public static java.lang.String convertToEnglish(java.io.File codeFile) throws java.io.FileNotFoundException
	{
		String output = "";
		ArrayList<String> line = new ArrayList<String>();
		String[] word; // will hold each singular word from
		String[] letter; // will hold each singular word from
		
		Scanner inputFile;
		inputFile = new Scanner(codeFile);
		
		// Read each content, line by line from the .txt file into a String ArrayList
		while (inputFile.hasNext())
		{	
			line.add(inputFile.nextLine());
		}
			
		inputFile.close();
		
		// loop through the ArrayList containing all the lines
		for(int i = 0; i < line.size(); i++)
		{
			//System.out.print(line.get(i));

			// split each word in the current line into a new array. 
			word = line.get(i).split(" / ");
			
			// loop through the array containing all the words of a line
			for(int j = 0; j < word.length; j++)
			{
				
				//System.out.print(word[j]);

				// split each letter in the current word into a new array. 
				letter = word[j].split(" ");
				
				for(int k = 0; k < letter.length; k++)
				{
					//System.out.println(word[j]);

					output += t.fetch(letter[k]);	
				}
				
				//add a space after each word has been translated
				output += " ";
			}
		}
		// take off preceeding or succedding spaces
		output = output.trim();
		
		return output;
	}

	
	/**
	 * Returns a string with all the data in the tree in LNR order with an space in between them. Uses the toArrayList method in MorseCodeTree.
	 * It should return the data in this order: "h s v i f u e l r a p w j  b d x n c k y t z g q m o" 
	 * Note the extra space between j and b - that is because there is an empty string that is the root, and in the LNR traversal, the root would
	 * come between the right most child of the left tree (j) and the left most child of the right tree (b). This is used for testing purposes to make
	 * sure the MorseCodeTree has been built properly
	 * 
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static java.lang.String printTree()
	{
		ArrayList<String> treeData = new ArrayList<String>();
		
		treeData = t.toArrayList();
		
		String print = "";
		
		for(int i = 0; i < treeData.size(); i ++)
		{
			print += treeData.get(i) + " ";	
		}
		
		return print;
	}
}








