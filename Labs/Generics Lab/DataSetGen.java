/**
 * Computes the average of a set of data values.
 * 
 * Name: Nabeel Hussain
 * Class: CMSC204
 * Professor: Jeannette Myers Kartchner
 * Generics Lab
 * Date: 2/08/2016
 * 
 * @author Nabeel Hussain
 */

// The type variables will be constrained by the Measurable interface bound, in order for it to call the getMeasure() method. Otherwise the add method will not compile. 
public class DataSetGen <T extends Measurable> 
{
   private double sum;
   private T t;
   private int count;

   /**
      Constructs an empty data set.
   */
   public DataSetGen()
   {
      sum = 0;
      count = 0;
      t = null;
   }

   /**
      Adds a data value to the data set.
      @param x a generic data value
   */
   public void add(T x)
   {
      sum += x.getMeasure();
      if (count == 0 || t.getMeasure() < x.getMeasure())
         t = x;
      count++;
   }

   /**
      Gets the average of the added data.
      @return the average or 0 if no data has been added
   */
   public double getAverage()
   {
      if (count == 0) return 0;
      else return sum / count;
   }

   /**
      Gets the largest of the added data.
      @return the maximum or 0 if no data has been added
   */
   public T getMaximum()
   {
      return t;
   }
}