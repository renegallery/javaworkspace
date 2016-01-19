
/**
 * 
 * @author Rene
 * This program contains in-class demo-programs in week 1.
 * 
 */

import java.util.Scanner;

public class Week1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// print will not add \n
        System.out.print("Hello World!");
        
        // print recognize numeric type
        System.out.println(3+4);
        
        // define CONSTANT, use UPPER LETTER
        final double CONSTANT = 7;
        System.out.println(CONSTANT);
        
        // you must initialize the variable before you can use it
        int Input = 8;
        int Output = Input / 2;
        System.out.println(Output);
        System.out.println(Input%2);
        
        // not allow you to parse higher type into lower type, but you can use parse
        double x, y = 2;
        x = y*7;
        x = Input;
        int Output2 = (int) x;
        
        // use Math library, in java, it contains a class(object) called Math
        int sqrt = (int) Math.sqrt(100);
        double sqrt2 = Math.sqrt(100);
        
        // another example about casting
        int i=0,j=1;
        double Output3 = (i+j)/3;
        System.out.println(Output3);

        // use a scanner, firstly import package
        Scanner myinput = new Scanner(System.in);
        System.out.print("Please enter n1 and n2:");
        int n1 = myinput.nextInt();
        // if you enter a double, then it won't automatically parse it into int but gives error
        double n2 = myinput.nextDouble();
        System.out.print("The sum of n1 and n2 is:");
        System.out.println(n2+n1);
        
        // output with format
        double price = 1.2283920;
        System.out.printf("%-10s","The format price is:");
        System.out.printf("%10.2f", price);
        System.out.print("\n");
        
        // a short cut of if statement:
        System.out.println("Please enter the floor you want to go to:");
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()){
        	int floor = input.nextInt();
            int actualfloor = floor>13? floor-1:floor;
            System.out.println("The actual floor is " + actualfloor);
        }
        else {
        	System.out.println("Error, please enter integer");
        }
	}

}
