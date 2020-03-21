package _0317_BrandonInterview._01;

import static java.lang.System.out;

import java.util.ArrayList;

public class Test_0317_01 {

	public static void main(String[] args) {
		
		Fibonacci fibonacci = new Fibonacci(10000);
		out.println( fibonacci );
		
		ClosestFibonacciLocator cloesetFibonacciLocator = new ClosestFibonacciLocator();
		
		int[] inputs = { 15, 1, 13, 300, 1000, 10000, 1000000 };
		
		for(int input: inputs) {
			out.println( input + " : " +  cloesetFibonacciLocator.getClosestDistanceToFibonacci(input));
		}
		
		
	}
	
}
