package lab2;

import java.util.Arrays;

public class RecursionMain {
	public static void main(String[] args){
		//remove duplicates
		removeDuplicate();
	}
	public static void removeDuplicate(){
		int[] intTest = {1,1,2,3,4,4,4,5,1,3,2,4};
		RemoveDuplicate rd = new RemoveDuplicate();
		System.out.println(Arrays.toString(rd.remove(intTest)));
		int[] result = {1,2,3,5};
	}
	public static void recursionCall(){
		Recursion fun = new Recursion();
		System.out.println(fun.factorial(4));
		System.out.println(fun.fibonacci(6));
		System.out.println(fun.fibonacci2(6));
		System.out.println(fun.addReciprocals(3));
	}
}
