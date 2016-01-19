package lab1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class bankapp {
	// default as public so you can see it 
	static double balance = 0;
	private static ArrayList<String> trans = new ArrayList<String>();
	
	public static void main(String[] args) {
		/* welcome page:
		 * deposit: check for enter
		 * withdraw
		 * transaction
		 * until exit with q
		 */
		Scanner scan = new Scanner(System.in);
		while(true){
			printMenu();
			// check if it has next input, it could be removed
			if (scan.hasNext()) {
				if (scan.hasNext("q")) {
					System.out.println("System exiting");
					break;
				}
				// check if the next input is an integer
				else if (scan.hasNextInt()){
					// if it is integer, switch gives the int to decide case
					switch(scan.nextInt()){
					case 1: 
						// deposit use scan as an input, scan is a Scanner object that
						// has been defined before, so every time system.in, scan will
						// also be refreshed.
						deposit(scan);
						break;
					case 2: 
						withdraw(scan);
						break;
					case 3: 
						printTrans();
						if (scan.hasNextLine()){
							scan.nextLine();
						}
						break;
					default: 
						printError("No valid input detected");
						if (scan.hasNextLine()){
							scan.nextLine();
						}
						break;
					}
				}
				else {
					printError("no valid input detected");
				}
			}
			
		}
	}

	/**
	 * This function print out historical transactions.
	 */
	private static void printTrans() {
		for (String t : trans) {
			System.out.println(t);
		}
	}
	/**
	 * This function allows withdraw from balance
	 * @param scan
	 */
	private static void withdraw(Scanner scan) {
		if (scan.hasNextLine()){
			scan.nextLine();
		}
		System.out.println("Enter the amount you want to withdraw");
		//burn it
		if (scan.hasNextDouble()){
			//checking negative
			double value = scan.nextDouble();
			if (value >= 0 && value <= balance){
				balance -= value;
				// you can also call balance from Bank.balance if it is not within the same class
				String tempTime = getCurrentTime();
				trans.add("type: withdraw, time: "+tempTime+"amount "+value+"running balance "+balance);
			}
			else {
				printError("Invalid number entered in withdraw");
			}
		}
		else {
			printError("Invalid number entered in withdraw");
		}
		
		// burn it if has next line()
		if (scan.hasNextLine()){
			scan.nextLine();
		}
	}
	/** This function gives current time
	 * @return
	 */
	private static String getCurrentTime() {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(cal.getTime());
	}

	/**
	 * This function allows deposit
	 * @param scan
	 */
	private static void deposit(Scanner scan) {
		if (scan.hasNextLine()){
			scan.nextLine();
		}
		System.out.println("Enter the amount you want to deposit");
		//burn it
		if (scan.hasNextDouble()){
			//checking negative
			double value = scan.nextDouble();
			if (value >= 0){
				balance += value;
				String tempTime = getCurrentTime();
				trans.add("type: deposit, time " +tempTime + " amount: " + value + " running balance " + balance);
				
				// you can also call balance from Bank.balance if it is not within the same class
			}
			else {
				printError("Invalid number entered in deposit");
			}
		}
		else {
			printError("Invalid number entered in deposit");
		}
		
		// burn it if has next line()
		if (scan.hasNextLine()){
			scan.nextLine();
		}
	}
	/**
	 * This function print out welcome menu
	 */
	public static void printMenu(){
		System.out.println("Welcome!");
		System.out.println("Current balance: "+ balance);
		System.out.println("enter 1 to deposit");
		System.out.println("enter 2 to withdraw");
		System.out.println("enter 3 to transaction");
		System.out.println("enter q to exit");
	}
	
	/**
	 * print error
	 */
	public static void printError(String s){
		System.out.println("ERROR: "+ s);
	}
}
