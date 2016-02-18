package PersonName;

/**
   The sort method of this class sorts an array, using the selection 
   sort algorithm.
*/
public class SelectionSorter
{
   private static int counter;
   public static void initial_counter(){
		counter = 0;
	}
/**
      Sorts an array, using selection sort.
      @param a the array to sort
   */
   public static void sort(PersonName[] a)
   {  
      for (int i = 0; i < a.length - 1; i++)
      {  
         int minPos = minimumPosition(a, i);
         ArrayUtil.swap(a, minPos, i);
      }
   }

   /**
      Finds the smallest element in a tail range of the array.
      @param a the array to sort
      @param from the first position in a to compare
      @return the position of the smallest element in the
      range a[from] . . . a[a.length - 1]
   */
   private static int minimumPosition(PersonName[] a, int from)
   {  
      int minPos = from;
      for (int i = from + 1; i < a.length; i++)
      {
    	 counter++;
         if (a[i].compareTo(a[minPos]) < 0) { 
        	 minPos = i; 
        	 }
      }
      return minPos;
   }
   
   public static int getCounter() {
		return counter;
   }
}
