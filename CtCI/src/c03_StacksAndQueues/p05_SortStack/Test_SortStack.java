package c03_StacksAndQueues.p05_SortStack;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.StringJoiner;

import util.MyStack;
public class Test_SortStack {

	public static void main(String[] args) {
		
		Integer[] inputs = { 1, 7, 10, 5, 3, 12, 8 };
		
		{
			out.println("\n-----------------------SortStack_01_onlyByOtherStack");
			out.println( "inputs: " + Arrays.toString(inputs) );
			MyStack<Integer> inputStack = getInputStack(inputs);
			SortStack_01_onlyByOtherStack.sort(inputStack);
			
			StringJoiner sj = new StringJoiner(", ");
			while( inputStack.isEmpty() == false ) {
				sj.add( String.valueOf( inputStack.pop() ) );
			}
			out.println("outputs from stack pop()s: " + sj.toString()) ;
		}
		
		
		{
			out.println("\n-----------------------SortStack_02_SingleResponsibilityPrinciple");
			out.println( "inputs: " + Arrays.toString(inputs) );
			MyStack<Integer> inputStack = getInputStack(inputs);
			SortStack_02_SingleResponsibilityPrinciple.sort(inputStack);
			
			StringJoiner sj = new StringJoiner(", ");
			while( inputStack.isEmpty() == false ) {
				sj.add( String.valueOf( inputStack.pop() ) );
			}
			out.println("outputs from stack pop()s: " + sj.toString()) ;
		}
		
	}
	
	
	
	public static MyStack<Integer> getInputStack(Integer... inputs){
		
		MyStack<Integer> inputStack = new MyStack<Integer>();
		
		for( int i = inputs.length -1; i>=0 ;i-- ) {
			inputStack.push( inputs[i] );
		}
		
		return inputStack;
	}

}


