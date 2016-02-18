package Employ;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Employ {
	
	private ArrayList<String> name;
	private ArrayList<String> DOB;
	private ArrayList<Integer> salary;
	private ArrayList<Integer> age;
	/** 
	 * create a constructor for Employ with empty arraylist
	 */
	public Employ(){
		// use 3 Arraylist to store Employee name, DOB, salary
		this.name = new ArrayList<String>();
		this.DOB = new ArrayList<String>();
		this.salary = new ArrayList<Integer>();
		this.age = new ArrayList<Integer>();
	}
	
	/**
	 * add employ info
	 */
	public void addInfo (String line){
		String[] lineSplit = line.split(",");
		if (lineSplit.length<3) {
			// invalid line, throw it away
			return;
		}
		try {
			this.salary.add(Integer.parseInt(lineSplit[2]));
			this.name.add(lineSplit[0]);
			this.DOB.add(lineSplit[1]);
		}
		catch (NumberFormatException e){
			System.out.println("Error" + e);
		}
	}
	
	/**
	 * count employees 
	 */
	public int count(){
		return name.size();
	}
	/**
	 * get highest salary and name of the employee
	 * @return
	 */
	public String[] highestSalary() {
		int temp_max = 0;
		int temp_max_index = 0;
		int i = 0;
		if (salary.size()==0){
			System.out.println("No salary record, get age first or check the file");
			String[] temp = null;
			temp[0]="error";
			temp[1]="error";
			return temp;
		}
		while (i<salary.size()){
			if (salary.get(i) > temp_max) {
				temp_max = salary.get(i);
				temp_max_index = i;
			}
			i++;
		}
		String[] max = new String[2];
		max[0] =  name.get(temp_max_index);
		max[1] = String.valueOf(temp_max);
		return max;
	}
	/**
	 * get average salary
	 * @return
	 */
	public double getAverageSalary() {
		double sum = 0;
		int len = salary.size();
		int i = 0;
		if (len==0){
			System.out.println("No salary record, get age first or check the file");
			return 0;
		}
		while (i < len) {
			sum = sum + salary.get(i);
			i++;
		}
		return sum/len;
	}
	/**
	 * get counts above average salary
	 * @param average
	 * @return
	 */
	public int countAboveAverage(double average) {
		int count = 0;
		int len = salary.size();
		int i = 0;
		if (len==0){
			System.out.println("No salary record, get age first or check the file");
			return 0;
		}
		while (i < len) {
			if (salary.get(i)>=average){
				count++;
			}
			i++;
		}
		return count;
	}
	/**
	 * get average age of the employees
	 * @return
	 */
	public double averageAge() {
		double sum = 0;
		int len = age.size();
		int i = 0;
		if (len==0){
			System.out.println("No age record, get age first or check the file");
			return 0;
		}
		while (i < len) {
			sum = sum + age.get(i);
			i++;
		}
		return sum/len;
	}
	/**
	 * get age from DOB
	 */
	public void getAges() {
		int i = 0;
		if (DOB.size()==0){
			System.out.println("No age record, get age first or check the file");
			return;
		}
		else {
			while (i<DOB.size()){
				int temp_age = employAge(DOB.get(i));
				//System.out.println(temp_age);
				age.add(temp_age);
				i++;
			}	
			
		}
	}

	public int employAge(String string) {
		// get current month and year
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String DATE_STRING = dateFormat.format(date);
		String[] DATE_STRING_ARRAY = DATE_STRING.split("/");
		int CURRENT_MONTH = Integer.parseInt(DATE_STRING_ARRAY[0]);	
		int CURRENT_YEAR = Integer.parseInt(DATE_STRING_ARRAY[2]);
		// get year and month of birth
		String[] BIRTH_STRING_ARRAY = string.split("/");
		if (BIRTH_STRING_ARRAY.length<3){
			System.out.println("DOB wrong format");
			return 0;
		}
		int BIRTH_MONTH = Integer.parseInt(BIRTH_STRING_ARRAY[0]);
		int BIRTH_YEAR = Integer.parseInt(BIRTH_STRING_ARRAY[2]);
		
		int age_year = CURRENT_YEAR - BIRTH_YEAR;
		int age_month = CURRENT_MONTH - BIRTH_MONTH;
		if (age_month<0){
			age_year--;
		}
		return age_year;
	}
	/**
	 * get name list
	 * @return
	 */
	public ArrayList<String> getName(){
		return name;
	}
	/**
	 * get salary list
	 * @return
	 */
	public ArrayList<Integer> getSalary(){
		return salary;
	}
	
	public void writeSortSalary(PrintWriter writer, ArrayList<String> name, ArrayList<Integer> salary ){
		writer.println("rank, initial_row, name, salary");
		ArrayList<Integer> salary_store = new ArrayList<Integer>(salary); 
		// may need to be new ArrayList(salary)
		
		//sort salary
		Collections.sort(salary,Collections.reverseOrder());
		
		//get initial indexes of sorted salary
		int[] indexes = new int[salary.size()];
		for (int n = 0; n < salary.size(); n++){
		    indexes[n] = salary_store.indexOf(salary.get(n));
		    /* because there are duplicate value, in order to get the unique result, set 
		     * the passed one to null to avoid next visit
		     */
		    salary_store.set(salary_store.indexOf(salary.get(n)), null);
		    // write to file
		    writer.println((n+1)+ ", " + (indexes[n]+1) + ", " + name.get(indexes[n]) + ", " + salary.get(n));
		}
	}
}
