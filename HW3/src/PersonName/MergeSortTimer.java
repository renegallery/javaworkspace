package PersonName;

import java.util.Scanner;

/**
   This program measures how long it takes to sort an
   array of a user-specified size with the merge
   sort algorithm.
*/
public class MergeSortTimer
{  
   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);
      System.out.print("Enter array size: ");
      int n = in.nextInt();

      // Construct random personName array
   
      PersonName[] a = ArrayUtil.randomPersonNameArray(n);
      
      // Use stopwatch to time merge sort

      StopWatch timer = new StopWatch();

      timer.start();
      MergeSorter.sort(a);
      for (int i = 0; i<a.length; i++){
      System.out.println(a[i].toString());
      }
      timer.stop();
      
      // counting the number of comparisons, create a counter
      System.out.println("Elapsed time: " 
            + timer.getElapsedTime() + " milliseconds.    "
            + "Comparisons made " + MergeSorter.getCounter());
   }
}

   
