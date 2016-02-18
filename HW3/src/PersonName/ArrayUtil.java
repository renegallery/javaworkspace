package PersonName;

import java.util.Random;

/**
   This class contains utility methods for array manipulation.
*/  
public class ArrayUtil
{ 
   private static Random generator = new Random();
   // for purpose of string generator
   static final String AB = "abcdefghijklmnopqrstuvwxyz";
   
  /**
   * generate random string with length len
   * @param len
   * @return
   */
   public String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( generator.nextInt(AB.length()) ) );
	   return sb.toString();
	}
   /**
    * generate a person name array with size
    * @param size
    * @return
    */
   public static PersonName[] randomPersonNameArray(int size) {
	   PersonName[] a = new PersonName[size];
	   ArrayUtil str = new ArrayUtil();
	   for (int i = 0; i < size; i++)
	   {
		   // randomly pick a size of first/middle/last name, avoid it to be 0
		   int sizeFirst = generator.nextInt(10) + 1;
		   int sizeMiddle = generator.nextInt(10) + 1;
		   int sizeLast = generator.nextInt(10) + 1;
		   // string generator
		   String First = str.randomString(sizeFirst);
		   String Middle = str.randomString(sizeMiddle);
		   String Last = str.randomString(sizeLast);
		   // set names
		   // must initialize a[i], or it would be a reference, not an instance
		   a[i] = new PersonName();
		   a[i].setFirstName(First);
		   a[i].setMiddleName(Middle);
		   a[i].setLastName(Last);
	   }
	   return a;
   }
   /**
      Creates an array filled with random values.
      @param length the length of the array
      @param n the number of possible random values
      @return an array filled with length numbers between
      0 and n - 1
   */
   
   public static int[] randomIntArray(int length, int n)
   {  
      int[] a = new int[length];      
      for (int i = 0; i < a.length; i++)
      {
         a[i] = generator.nextInt(n);
      }
      
      return a;
   }

   /**
      Swaps two entries of an array.
      @param a the array
      @param i the first position to swap
      @param j the second position to swap
   */
   public static void swap(PersonName[] a, int i, int j)
   {
      PersonName temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }
}
      
