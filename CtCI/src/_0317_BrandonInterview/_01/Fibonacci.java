package _0317_BrandonInterview._01;

import java.util.ArrayList;

public class Fibonacci {

	private int max_Index;
	private ArrayList<Integer> sequence;
	
	public Fibonacci(int maxValueThatFibonacciHas) {
		
		super();
		generateFibonacciSequence(maxValueThatFibonacciHas);
	}
	
	public int getMaxIndex() {
		return max_Index;
	}
	
	
	public int get(int index) {
		return sequence.get(index );
	}
	
	public ArrayList<Integer> getSequence() {
		return sequence;
	}
	
	private void generateFibonacciSequence(int max_Value){
		sequence = new ArrayList<>();
		
		//maxIndex = 0
		sequence.add(0);
	
		max_Index = 1;
		sequence.add(1);
		
		while( sequence.get(max_Index) < max_Value ) {
			max_Index++;
			sequence.add( sequence.get(max_Index-1) + sequence.get(max_Index -2) );
		}
		max_Index++;
		sequence.add( sequence.get(max_Index-1) + sequence.get(max_Index -2) );
		
	}
	
	public String toString() {
		
		 StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < max_Index; i++) {
			sb.append(sequence.get(i));
			sb.append(" ");
		}
		
		return sb.toString();
		
	}
}

