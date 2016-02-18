package PersonName;

import java.util.Scanner;

/**
   This program measures how long it takes to sort an
   array of a user-specified size with the selection
   sort algorithm.
*/
public class SelectionSortTimer
{  
   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);
      System.out.print("Enter array size: ");
      int n = in.nextInt();

      // Construct random array
   
      PersonName[] a = ArrayUtil.randomPersonNameArray(n);
      
      // Use stopwatch to time selection sort
      
      StopWatch timer = new StopWatch();
      
      timer.start();
      SelectionSorter.sort(a);
      for (int i = 0; i<a.length; i++){
          System.out.println(a[i].toString());
          }
      timer.stop();
      
      System.out.println("Elapsed time: " 
            + timer.getElapsedTime() + " milliseconds.    "
            + "Comparisons made " + SelectionSorter.getCounter());
   }
}

   
