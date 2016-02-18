package PersonName;

import java.util.Scanner;

/* This is the main function of HW 3, only run this.
 * The program runs two kinds of sorting in the same array of person
 * for given size of array.
 * Result will give you a table comparing time and count each algorithm
 * gives.
 * 
 * ps:MergeSortTimer and SelectionSortTimer also contain main,
 * but those 2 are just for trial, don't run it
 */

public class MainPersonName {
	public static void main(String[] args) {
		
		printHead();
		// define the size of each array you want to try on
		int[] ARRAYLENGTH = {10,100,1000,10000};
		
		// start looping through all sizes given and compare
		for (int n : ARRAYLENGTH){
	    // Construct random personName array and copy it to another array
	    PersonName[] a = ArrayUtil.randomPersonNameArray(n);
	    PersonName[] b = a.clone();
	    
	    // Use stopwatch to time merge sort
	    StopWatch timer1 = new StopWatch();
	    StopWatch timer2 = new StopWatch();
	    
	    // Merge Sorting
	    timer1.start();
	    MergeSorter.sort(a);
	    timer1.stop();
	    
	    
	    // Selection Sorting
	    timer2.start();
	    SelectionSorter.sort(b);
	    timer2.stop();
	   
	    // print out time and count in this loop
	    System.out.print("|");
	    System.out.printf("%,12d", n);
	    System.out.print("|");
	    System.out.printf("%,7d", timer1.getElapsedTime());
	    System.out.print("|");
	    System.out.printf("%,11d", MergeSorter.getCounter());
	    System.out.print("|");
	    System.out.printf("%,8d", timer2.getElapsedTime());
	    System.out.print("|");
	    System.out.printf("%,12d", SelectionSorter.getCounter());
	    System.out.println("|");
	    System.out.println("|------------------------------------------------------|");
	    
	    MergeSorter.initial_counter();
	    SelectionSorter.initial_counter();
		}
		
	}
	
	/**
	 * print out header
	 */
	public static void printHead(){
		System.out.println("|------------------------------------------------------|");
		System.out.println("| Array Size | Merge Sort        | Selection Sort      |");
		System.out.println("|------------------------------------------------------|");
		System.out.println("|            | Time  | Count     | Time   | Count      |");
		System.out.println("|------------------------------------------------------|");
	}
}
