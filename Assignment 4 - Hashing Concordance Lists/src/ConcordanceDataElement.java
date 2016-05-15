import java.util.LinkedList;

/**
 * The Concordance Data element class, which holds the information of a word and the number of the lines it is contained in.   
 * 
 * @author Nabeel
 */
public class ConcordanceDataElement
{
	private String concordanceWord; 
	private LinkedList<Integer> pageNumbers;
	private int hashCodeNumber;
	/**
	 * The constructor
	 * 
	 * @param word the word for the concordance data element
	 */
	public ConcordanceDataElement(java.lang.String word)
	{
		concordanceWord = word;
		pageNumbers = new LinkedList<Integer>();
	
	}
	
	/**
	 * Returns the word followed by page numbers.
	 * 
	 * @return a string in the following format: word: page num, page num Example: after: 2,8,15
	 */
	public java.lang.String toString()
	{
		String display;

		display = concordanceWord + ": ";
		
		for(int i = 0; i < pageNumbers.size(); i++)
		{
			// add a "," after the page number up until before the last page number in the linked list. 
			if(i < pageNumbers.size() - 1)
			{
			display +=  pageNumbers.get(i) + ", ";
			}
			// do not add a "," at the end of the last page number that will be displayed. 
			else
			{
				display +=  pageNumbers.get(i);
			}
		}
		return display;		
	}
	
	
	/**
	 * Return the word portion of the Concordance Data Element
	 * 
	 * @return the word portion of the Concordance Data Element
	 */
	public java.lang.String getWord()
	{
		return concordanceWord;	
	}
	
	
	/**
	 * Returns the hashCode. You may use the String class hashCode method
	 * 
	 * @return the hashCode.
	 */
	public int hashCode()
	{
		hashCodeNumber = concordanceWord.hashCode();
		
		return hashCodeNumber;		
	}
	
	/**
	 * Returns the linked list of integers that represent the line numbers
	 * 
	 * @return the linked list of integers that represent the line numbers
	 */
	public java.util.LinkedList<java.lang.Integer> getList()
	{
		return pageNumbers;		
	}
	
	
	/**
	 *  add the page number if the number doesn't exist in the list
	 * 
	 * @param lineNum the line number to add to the linked list
	 */
	public void addPage(int lineNum)
	{
		if(!pageNumbers.contains(lineNum))
		{
			pageNumbers.addLast(lineNum);
		}
	}
}
