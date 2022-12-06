package c03_StacksAndQueues.p01_ThreeInOne;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class MutiInOne_Static {

	
	//this is shared by all stacks
	private int[] values;
	private int[] stackNo_to_sizeVector;
	private int numberOfStacks;
	
	int capacityVector;
	
	/**
	 * REASONING:
	 * capacityVector is fixed, and is equal to every stacks, so it's shared by all stacks
	 * 
	 * the starting point of each stack is set at the beginning and never changed, so we 
	 * don't need variables to track, but compute them when needed instead.
	 */
	
	public MutiInOne_Static( int numberOfStacks, int capacity) {
		
		this.numberOfStacks = numberOfStacks;
		this.capacityVector = capacity;
		//WRONG
		//int[] values = new int[ numberOfStacks * capacity ];
		values = new int[ numberOfStacks * capacity ];
		stackNo_to_sizeVector = new int[ numberOfStacks ];
	}
	
	
	
	public void push( int stackNo, int key ) throws Exception {
		
		if( stackNo < 0 || stackNo >= numberOfStacks ) {
			throw new Exception("out of bounds of stackNo");
		}
		
		//THINK_FURTHER: if it is dynamic version, we'll try to right shift the next stack
		if( isFull(stackNo) ) {
			throw new FullStackException();
		}
		
		//else it's not full
		
		//CAREFUL the sequence
		stackNo_to_sizeVector[ stackNo ]++;
		
		int lastElementIndex = getLastElement( stackNo );
		values[ lastElementIndex ] = key;
	}
	
	
	
	private boolean isFull( int stackNo ) {
		int sizeVector = stackNo_to_sizeVector[ stackNo ];
		return sizeVector == capacityVector;
	}
	
	
	
	private int getLastElement( int stackNo ) {
		int origin = stackNo * capacityVector;
		int sizeVector = stackNo_to_sizeVector[ stackNo ];
		return origin + sizeVector -1;
	}
	
	
	
	public int pop( int stackNo ) throws Exception {
		
		if( stackNo < 0 || stackNo >= numberOfStacks ) {
			throw new Exception("out of bounds of stackNo");
		}
		
		if( isEmpty(stackNo) ) {
			throw new EmptyStackException();
		}
		
		//else it's not empty
		
		//careful the sequence
		
		int lastElementIndex = getLastElement( stackNo ); 
		int poppedValue = values[lastElementIndex];
		values[lastElementIndex] = 0;
		
		stackNo_to_sizeVector[ stackNo ]--;
		
		return poppedValue;
	}
	
	
	
	private boolean isEmpty( int stackNo ) {
		int sizeVector = stackNo_to_sizeVector[ stackNo ];
		return sizeVector == 0;
	}
	
	
	
	public int peek(int stackNo) {
		
		//degenerate version of pop; however, since no value change, no check is needed
		int lastElementIndex = getLastElement( stackNo ); 
		int poppedValue = values[lastElementIndex];
		
		return poppedValue;
	}
	
	
	
	//for testing purpose only
	public void showInfo() {
		
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		for( int i =0; i < values.length; i++ ) {
			sj.add( i + ":" + values[i] );
		}
		out.println( "values: " + sj.toString());
		
		out.println( "stackNo_to_origin: " + 
				IntStream
				.range(0, numberOfStacks)
				.map( i -> i * capacityVector )
				.boxed()
				.collect(Collectors.toList()) );
		out.println( "stackNo_to_sizeVector: " + Arrays.toString(stackNo_to_sizeVector) );
		out.println( "stackNo_to_capacityVector: " + 
				IntStream
				.range(0, numberOfStacks)
				.map( i -> capacityVector )
				.boxed()
				.collect(Collectors.toList()) );
		
	}
	
}


