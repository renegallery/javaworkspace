package lab2;

public class Recursion {
	/**
	 * factorial
	 */
	public double factorial(int i){
		if (i==1 || i==0) {
			return 1;
		}
		else if (i < 0){
			System.out.println("Error input, put positive integer");
			System.exit(1);
		}
		else {
			return i*factorial(i-1);
		}
		return 0;
	}
	
	/**
	 * fibonacci
	 */
	public int fibonacci(int i){
		if (i == 1 || i == 2){
			return 1;
		}
		else if (i < 0 || i > 40){
			System.out.println("Error input, put integer between 0 and 40");
			System.exit(1);
		}
		else {
			return fibonacci(i-1)+fibonacci(i-2);
		}
		return 0;
	}
	
	/**
	 * fibonacci iterative
	 */
	public int fibonacci2(int i){
		int m=1;
		int n=1;
		int k=3;
		if (i<1){
			System.out.println("Error input, put integer between 0 and 40");
			System.exit(1);
		}
		else if (i ==1|| i==2){
			return 1;
		}
		for (; k <= i; k++){
			int temp = m+n;
			m = n;
			n = temp;
		}
		return n;
	}
	
	/**
	 * add reciprocals
	 */
	public double addReciprocals(int i){
		if (i < 1){
			System.out.println("Error input, put integer between 0 and 40");
			System.exit(1);
		}
		else if (i == 1){
			return 1;
		}
		else return (double)1/i+addReciprocals(i-1);
		return 0;
	}
	
}
