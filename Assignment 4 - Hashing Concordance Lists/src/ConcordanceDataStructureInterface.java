import java.util.ArrayList;


/**
 * This is the Concordance Data Structure Class.  It is the data structure
 * class that is used with the Concordance Data Manager class.
 * This is a hash table with buckets.  Your hash table with be an array of 
 * linked lists of ConcordanceDataElements. Use the hashcode for an 
 * ConcordanceDataElement to place in the hashtable.
 * Do not enter duplicate words or duplicate line numbers for a word.
 *  
 * There are approximately 500 words in the data file given you.  Determine 
 * an appropriate size for your hash table 
 * 
 * @author JWISNIEW
 *
 */

   public interface ConcordanceDataStructureInterface{

	   /** 
	    * Use the hashcode of the ConcordanceDataElement to see if it is 
	    * in the hashtable.
	    * 
	    * If the word does not exist in the hashtable - Add the ConcordanceDataElement 
	    * to the hashtable. Put the line number in the linked list
	    *  
	    * If the word already exists in the hashtable
	    * 1. add the line number to the end of the linked list in the ConcordanceDataElement 
	    * (if the line number is not currently there).  
	    * 
	    * @param word the word to be added/updated with a line number.
	    * @param lineNum the line number where the word is found
	    */
      public void add(String word, int lineNum); 
      
      
      /** 
       * Display the words in Alphabetical Order followed by a :, 
       * followed by the line numbers in numerical order, followed by a newline
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
      public ArrayList<String> showAll();
      
   }// end of ConcordanceDataStructureInterface

 