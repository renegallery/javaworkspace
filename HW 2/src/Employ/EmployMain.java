package Employ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployMain {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException{
		try{
		// get file
		String EmployeeFile = "/Users/Rene/Documents/javaworkspace/HW 2/employees.txt";
		File myInputeFile = new File(EmployeeFile);
		// scan in file
		Scanner in = new Scanner(myInputeFile);
		
		// create a Employ class
		Employ employ = new Employ();
		
		while (in.hasNextLine()){
			String line = in.nextLine();
			employ.addInfo(line);
		}
		
		//-----------------------------------------------------
		//How many Employees exist in the file?
		
		System.out.println(employ.count()+" exist in the file.");
		
		//Who has the highest salary?
		String[] highest_salary = employ.highestSalary();
		System.out.println(highest_salary[0] + " has the highest salary: "+highest_salary[1]);
		
		//What is the average salary?
		DecimalFormat myFormatter = new DecimalFormat("###.##");
	    String output = myFormatter.format(employ.getAverageSalary());
		System.out.println("The average salary is: " + output);
		
		//How many employees make above the average?
		System.out.println(employ.countAboveAverage(employ.getAverageSalary()) + " employees make above the average.");
		
		//What is the average age of employees?
		employ.getAges();
	    output = myFormatter.format(employ.averageAge());
		System.out.println("The average age is: " + output);
		
		//Write to an output file the employee names sorted according to their salary? (Make sure to well format the output file)
		PrintWriter writer = new PrintWriter("sorted_employee.txt", "UTF-8");
		System.out.println("Output file: sorted_employee.txt");
		ArrayList<Integer> salary = employ.getSalary();
		ArrayList<String> name = employ.getName();
		employ.writeSortSalary(writer, name, salary);
		
		//Close writer
		writer.close();
		} 
		catch (FileNotFoundException e){
			System.out.println("Error" + e);
		}
	}
}