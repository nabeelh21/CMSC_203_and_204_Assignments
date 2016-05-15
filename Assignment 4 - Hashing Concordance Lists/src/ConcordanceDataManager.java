import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program makes a concordance for a file or a String.  
 * A concordance lists all the words that occur in the file or String,
 * along with all the line numbers on which each word occurs.
 * (Words of length less than 3 are omitted, "and" and "the" are omitted.)
 * Strip out all punctuation, except apostrophes that occur in the 
 * middle of a word, i.e. let’s, we’d, etc.
 * 
 * Uses an object that implements ConcordanceDataStructureInterface
 * 
 * @author Nabeel Hussain
 *
 */
public class ConcordanceDataManager implements ConcordanceDataManagerInterface
{
		
	private ConcordanceDataStructure x = new ConcordanceDataStructure();

	   /**
	    * 
	    * Display the words in Alphabetical Order followed by a :, 
	    * followed by the line numbers in numerical order, followed by a newline
	    * here's an example:
	    * after: 129, 175
	    * agree: 185
	    * agreed: 37
	    * all: 24, 93, 112, 175, 203
	    * always: 90, 128
	    * 
	    * @param input a String (usually consist of several lines) to 
	    * make a concordance of
	    * 
	    * @return an ArrayList of Strings.  Each string has one word,
	    * followed by a :, followed by the line numbers in numerical order,
	    * followed by a newline.
	    */
	@Override
	public ArrayList<String> createConcordanceArray(String input)
	{
		String[] line; // will hold the contents of each line in the string passed in
		String[] word; // will hold each singular word from
		int lineNum = 0;
		
		//split each line of the string into an array
		 line = input.split("\n");
		 //System.out.println(line[1]);
		
		// loop through the array containing each line of text
		for(int i = 0; i < line.length; i++)
		{
			// split each word in the current line into a new array. 
			word = line[i].split(" ");

			lineNum = i + 1; // keep track of the current line number

			// loop through the array containing all the words of a line
			for(int j = 0; j < word.length; j++)
			{
				// "don't include the words "the" or “and” in your concordance.
				// Strip out all punctuation, except apostrophes that occur in the middle of a word, i.e. let’s, we’d, etc."
				if( !word[j].equals("the") && !word[j].equals("and") && word[j].length() >= 3 )
				{
					// Strip out all punctuation, except apostrophes that occur in the middle of a word, i.e. let’s, we’d, etc."
					word[j] = word[j].replaceAll("[.:,']","");
					word[j] = word[j].replaceAll("_","");
					word[j] = word[j].replaceAll("\"","");
					// Also make the word all lowercase
					word[j] = word[j].toLowerCase();
					
					//Also, do not include words that have length less than 3.
					if(word[j].length() >= 3 )
					{
						//System.out.println(word[j] + ": " + lineNum);
						// Add each word into the ConcordanceDataStrcuture structure, for it to store the word in the correct concordance position
						x.add(word[j], lineNum);			
					}
				}		
			}
		}
		ArrayList<String> concordance = x.showAll();
		
		return concordance;
	}


	   /**
	    * Creates a file that holds the concordance  
	    * 
	    * @param input the File to read from
	    * @param output the File to write to
	    *  
	    * Following is an example:
	    * 
		* about: 24, 210
		* abuse: 96
		* account: 79
		* acknowledged: 10
		* 
	    * @return true if the concordance file was created successfully.
	    * @throws FileNotFoundException if file not found
	    */
	@SuppressWarnings("resource")
	@Override
	public boolean createConcordanceFile(File input, File output) throws FileNotFoundException
	{
		ArrayList<String> dataFile = new ArrayList<>();  // Will hold the contents of each line in the string passed in 
		
		String inputData = "";
		String[] line;
		String[] word;
		int lineNum = 0;

		
		if( !input.canRead() || !output.canWrite() )
		{
			throw new FileNotFoundException();
		}
		
		Scanner inputFile;
		inputFile = new Scanner(input);
		
		// Read each content, line by line from the .txt file into a String ArrayList
		while (inputFile.hasNext())
		{	
			dataFile.add(inputFile.nextLine());
		}
			
		inputFile.close();
		
		// loop through the ArrayList containing all the lines
		for(int i = 0; i < dataFile.size(); i++)
		{
			// split each word in the current line into a new array. 
			word = dataFile.get(i).split(" ");
			lineNum = i + 1; // keep track of the current line number
			
			// loop through the array containing all the words of a line
			for(int j = 0; j < word.length; j++)
			{
				// "don't include the words "the" or “and” in your concordance.
				if( !word[j].equals("the") && !word[j].equals("and") && word[j].length() >= 3)
				{
					// Strip out all punctuation, except apostrophes that occur in the middle of a word, i.e. let’s, we’d, etc."
					word[j] = word[j].replaceAll("[.:,']","");
					word[j] = word[j].replaceAll("_","");
					word[j] = word[j].replaceAll("\"","");
					// Also make the word all lowercase
					word[j] = word[j].toLowerCase();	
					
					//Also, do not include words that have length less than 3.
					if(word[j].length() >= 3 )
					{
						// Add each word into the ConcordanceDataStrcuture structure, for it to store the word in the correct concordance position
						x.add(word[j], lineNum);			
					}
				}		
			}
			
			ArrayList<String> concordanceOutputData = x.showAll();
			
			// Will use the output file that is passed into this method to write the concordance into it. 
			PrintWriter outFile = new PrintWriter(output);

			for(int k = 0; k < concordanceOutputData.size(); k++)
			{	
				// Print the words that have been arranged into concordance into the output file.  
				outFile.print(concordanceOutputData.get(k));		
			}
			outFile.close();
			inputFile.close();
		}
		return true;
	}
}
