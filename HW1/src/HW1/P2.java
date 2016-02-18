package HW1;

import java.util.Scanner;

public class P2 {

	public static void main(String[] args) {
		/*
		 * This program is a currency converter
		 * Main menu:
		 * 1. Enter USD/JPY Exchange Rate:
		 *  
		 * 2. Convert Money
		 * 
		 * the sentinel character entry is "X"
		 */
		float Rate = -1;

		while (true){
			 // welcome page info
			 printMenu();
		    
			 // scan input
			 Scanner input1 = new Scanner(System.in);
			 String newenter1 = input1.next();
			 
			 // check input
			 if (StopCheck(newenter1)) { 
				 return;
			 }
			 
			 // if entry = 1, change rate
			 else if (newenter1.equals("1")){
				 Rate = changeRate(Rate);
				 if (Rate == 0){
					 return;
				 }
			 }
			 
			 // if entry = 2, convert money
			 else if (newenter1.equals("2")){
				 int Message = convertMoney(Rate);
				 if (Message==3){
				 }
				 else if (Message==1){
					return;
				 }
				 else if (Message==2){
					 continue;
				 }
			 }
		 }
	}
/**
 * This function convert money with current currency rate
 * @param Rate
 */
private static int convertMoney(float Rate) {
	while(true){
		 if (Rate <0){
			 System.out.println("Please return to main menu and enter exchange rate first.");
			 return 2;
		 }
		 else {
			// entry convert money welcome page
			 System.out.println(" ============================================= ");
			 System.out.println("|  2. convert money                           |");
			 System.out.println("| ------------------------------------------- |");
			 System.out.println("|    Enter M to return to main menu           |");
			 System.out.println("|    Enter X any time to stop execution       |");
			 System.out.println("|    Enter 1 to convert USD to JPY            |");
			 System.out.println("|    Enter 2 to convert JPY to USD            |");
			 System.out.println("|=============================================|");
			 
			 // scan input
			 Scanner input3 = new Scanner(System.in);
			 String newenter3 = input3.next();
			 
			 // check entry
			 if (newenter3.equals("X")) {
				 return 1;
			 }
			 else if (newenter3.equals("M")) {
				 return 2;
			 }
			 else if (newenter3.equals("1")) {
				 // USD to JPY
				 System.out.println("Please enter the price you want to convert in USD:");
				 // scan input
				 Scanner input4 = new Scanner(System.in);
				 // if float continues
				 if (input4.hasNextFloat()){
					 float Price = input4.nextFloat();
					 if (Price > 0) {
						 float Money = Price*Rate;
						 System.out.printf("%.2f", Price);
						 System.out.print(" USD = ");
						 System.out.printf("%.2f", Money);
						 System.out.println(" JPY.");
						 break;
					 }
					 else {
						 System.out.println("The price you enter must be greater than 0.");
						 break;
					 }
				 }
				 else {
					 System.out.println("Price must be in right format.");
					 break;
				 }
			 }
			 else if (newenter3.equals("2")) {
				 // JPY to USD
				 System.out.println("Please enter the price you want to convert in JPY:");
				 // scan input
				 Scanner input4 = new Scanner(System.in);
		         // if float continues
				 if (input4.hasNextFloat()){
					 float Price = input4.nextFloat();
					 if (Price > 0) {
						 float Money = Price*1/Rate;
						 System.out.printf("%.2f", Price);
						 System.out.print(" JPY = ");
						 System.out.printf("%.2f", Money);
						 System.out.println(" USD.");
						 break;
					 }
					 else {
						 System.out.println("The price you enter must be greater than 0.");
					 }
				 }
				 else {
					 System.out.println("Price must be in right format.");
					 break;
				 }
			 }
			 else {
				 System.out.println("Please re-enter a right entry.");
			 }
			 
		 }
		
	 }
	return 3;
}
/**
 * This function gives a welcome page asking for exchange rate
 * @param Rate
 */
@SuppressWarnings("resource")
private static float changeRate(float Rate) {
	while (true){
		 if (Rate > 0){
			 System.out.println("The current exchange rate is 1 USD = "+Rate+" JPY.");
		 }
		 // entry exchange rate welcome page
		 System.out.println(" ============================================= ");
		 System.out.println("|  1. change USD/JPY Exchange Rate            |");
		 System.out.println("| ------------------------------------------- |");
		 System.out.println("|    Enter M to return to main menu           |");
		 System.out.println("|    Enter X any time to stop execution       |");
		 System.out.println("|    Please enter exchange rate:              |");
		 System.out.println("|=============================================|");
		 
		 // scan input
		 Scanner input2 = new Scanner(System.in);
		 
		 // check input
		 if (input2.hasNextFloat()){
			 Rate = input2.nextFloat();
			 if (Rate > 0 ){
				 System.out.println("The current exchange rate is: " + Rate);
				 return Rate;
			 }
			 else {
				 System.out.println("Rate must be greater than 0.");
			 } 
		 }
		 else {
			 String newenter2 = input2.next();
			 if (StopCheck(newenter2)) {
				 return 0;
			 }
			 else if (newenter2.equals("M")) {
				 break;
			 }
		 }
	 }
	return Rate;
	}
/**
 * This function print Welcome message of main menu
 */
    private static void printMenu() {
    	
	   System.out.println(" ============================================= ");
	   System.out.println("|  This is a main menu of Currency Exchange   |");
	   System.out.println("| ------------------------------------------- |");
	   System.out.println("|    Enter 1 to change USD/JPY Exchange Rate  |");
	   System.out.println("|    Enter 2 to convert money                 |");
	   System.out.println("|    Enter X any time to stop execution       |");
	   System.out.println("|=============================================|"); 
    }

/**
 * This function checks if entry is sentinel character
 */
    public static Boolean StopCheck(String newenter){
		return (newenter.equals("X"));
    }

}
