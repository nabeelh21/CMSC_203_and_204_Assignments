import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * This is the Concordance Data Structure Class. It is the data structure
 * class that is used with the Concordance Data Manager class.
 * This is a hash table with buckets. Your hash table will be an array of 
 * linked lists of ConcordanceDataElements. Use the hashcode for an 
 * ConcordanceDataElement to place in the hashtable.
 * Do not enter duplicate words or duplicate line numbers for a word.
 *  
 * There are approximately 500 words in the data file given you.  Determine 
 * an appropriate size for your hash table 
 * 
 * @author Nabeel Hussain
 *
 */
public class ConcordanceDataStructure implements ConcordanceDataStructureInterface {
	 
	// Since there are 500 words in the data file given to us for this assignment, I just chose to use the first prime number thats greater than 75% of 500. 
    private static final int HASHTABLE_SIZE = 379;   
    // The primary storage area
    private LinkedList<ConcordanceDataElement>[] table;

    /** 
     * Constructor which will initializes the hash table.  
     * 
     * @param word the word to be added/updated with a line number.
     * @param lineNum the line number where the word is found
     */
    @SuppressWarnings("unchecked")
    public ConcordanceDataStructure()
    {
         table = new LinkedList[HASHTABLE_SIZE];
 
            for (int i = 0; i < HASHTABLE_SIZE; i++){
                    table[i] = new LinkedList<ConcordanceDataElement>();
            }
    }
    
    
    
    /** 
    * Use the hashcode of the ConcordanceDataElement to see if it is in the hashtable.
    * 
    * If the word does not exist in the hashtable - Add the ConcordanceDataElement 
    * to the hashtable. Put the line number in the linked list
    *  
    * If the word already exists in the hashtable
    * 1. add the line number to the end of the linked list in the ConcordanceDataElement (if the line number is not currently there).  
    * 
    * @param word the word to be added/updated with a line number.
    * @param lineNum the line number where the word is found
    */
    @Override
    public void add(String word, int lineNum)
    {
    	ConcordanceDataElement dataElement = new ConcordanceDataElement(word);
        dataElement.addPage(lineNum);

        // Use the hashcode for the word to insert it into the correct storage location in the table.
        int index = Math.abs(dataElement.hashCode() % table.length);
        
        //System.out.print(index + " ");

        LinkedList<ConcordanceDataElement> current = table[index];
    	
         // If the hash location does not contain the word then add it to the table. 
        if(current.contains(dataElement.getWord()) == false)
        {
        	current.add(dataElement);
        	//System.out.println(row.toString());
        }
        
        // If the hash location of the table already contains the word, but not the page number, then add the page number to the linkedlist.  
        else
        { 	
        	for (int i = 0; i < current.size(); i++)
            {
        		ConcordanceDataElement oldElement = current.get(i);
        		
                if( oldElement.equals(dataElement))
                {
                	if (!oldElement.getList().contains(lineNum))
                	{
                		oldElement.addPage(lineNum);
                    }
                    break;
                }
            }   	
        }
    }

    /** 
     * Display the words in Alphabetical Order followed by a :,followed by the line numbers in numerical order, followed by a newline
     * here's an example:
     * after: 129, 175
	 * agree: 185
     * agreed: 37
     * all: 24, 93, 112, 175, 203
     * always: 90, 128
	   * 
     * @return an ArrayList of Strings.  Each string has one word,
     * followed by a :, followed by the line numbers in numerical order,
     * followed by a newline.
     */
    @Override
    public ArrayList<String> showAll()
    {

        ArrayList<String> showArray = new ArrayList<String>();
        
        for (int i = 0; i < table.length; i++)
        {
                LinkedList<ConcordanceDataElement> row = table[i];
                
                for (int a = 0; a < row.size(); a++)
                {
                        showArray.add(row.get(a).toString() + "\n");
                }
        }
        Collections.sort(showArray);
       
        return showArray ;
    }
}
