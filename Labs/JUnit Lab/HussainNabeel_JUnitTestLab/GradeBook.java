/**
 * This program contains the methods that will be used by a gradebook to hold grades and perform calculations.
 * 
 * Name: Nabeel Hussain
 * Class: CMSC204
 * Professor: Jeannette Myers Kartchner
 * JUnit Test Lab 
 * Date: 1/23/2016
 */

public class GradeBook
{
   private double[] scores;
   private int scoresSize;

   /**
      Constructs a gradebook with no scores and a given capacity.
      @capacity the maximum number of scores in this gradebook
   */
   public GradeBook(int capacity)
   {
      scores = new double[capacity];
      scoresSize = 0;
   }

   /**
      Adds a score to this gradebook.
      @param score the score to add
      @return true if the score was added, false if the gradebook is full
   */
   public boolean addScore(double score)
   {
      if (scoresSize < scores.length)
      {
         scores[scoresSize] = score;
         scoresSize++;
         return true;
      }
      else
         return false;      
   }

   /**
      Computes the sum of the scores in this gradebook.
      @return the sum of the scores
   */
   public double sum()
   {
      double total = 0;
      for (int i = 0; i < scoresSize; i++)
      {
         total = total + scores[i];
      }
      return total;
   }
      
   /**
      Gets the minimum score in this gradebook.
      @return the minimum score, or 0 if there are no scores.
   */
   public double minimum()
   {
      if (scoresSize == 0) return 0;
      double smallest = scores[0];
      for (int i = 1; i < scoresSize; i++)
      {
         if (scores[i] < smallest)
         {
            smallest = scores[i];
         }
      }
      return smallest;
   }

   /**
      Gets the final score for this gradebook.
      @return the sum of the scores, with the lowest score dropped if 
      there are at least two scores, or 0 if there are no scores.
   */
   public double finalScore() 
   {
      if (scoresSize == 0)
         return 0;
      else if (scoresSize == 1)
         return scores[0];
      else
         return sum() - minimum();
   }
   
   /**
	Gets the scoresSize.
	@return the scoresSize
  */
  public int getScoreSize()
  {   
	   return scoresSize;
  }
 
 /**
	Displays a string of each score in the scores array separated by a space.
	@return the scores in string format
 */ 
 public String toString()
 {
	  String theScores = "";
	  
	  for (int i = 0; i < scoresSize; i++)
	  {
		  theScores += scores[i] + " ";
	  }
	  
	  return theScores;
 }
}


