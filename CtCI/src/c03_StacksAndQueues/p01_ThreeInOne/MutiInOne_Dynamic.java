package c03_StacksAndQueues.p01_ThreeInOne;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.StringJoiner;

public class MutiInOne_Dynamic {
	
	public static boolean IS_DEBUG = false;
	
	private int[] values;
	private int[] stackNo_to_sizeVector;
	private int numberOfStacks;
	
	/**
	 *Compared to static,
	 *capacityVector and Origin of each stack may vary during the whole application 
	 *due to 'shift', so we need further variables to keep track of them  
	 */
	//int capacityVector;
	
	private int[] stackNo_to_capacityVector;
	private int[] stackNo_to_origin;
	
	
	
	public MutiInOne_Dynamic( int numberOfStacks, int capacity) {
		
		this.numberOfStacks = numberOfStacks;
		
		values = new int[ numberOfStacks * capacity ];
		stackNo_to_sizeVector = new int[ numberOfStacks ];
		stackNo_to_origin = new int[ numberOfStacks ];
		//WRONG forget to add
		for( int i = 0; i < numberOfStacks; i++) {
			stackNo_to_origin[i] = i * capacity;
		}
		//WRONG forget to add
		stackNo_to_capacityVector = new int[ numberOfStacks ];
		//WRONG forget to add
		Arrays.fill(stackNo_to_capacityVector, capacity);
	}
	
	
	
	public void push( int stackNo, int key ) throws Exception {
		
		if( stackNo < 0 || stackNo >= numberOfStacks ) {
			throw new Exception("out of bounds of stackNo");
		}
		
		if( isAllStacksFull() ) {
			throw new FullStackException();
		}
		
		if( isStackFull(stackNo) ) {
			expandByOneElemnt(stackNo);
		}
		
		//reaching here meaning there must have enough space for pushing
		int origin = stackNo_to_origin[ stackNo ];
		int sizeVector = stackNo_to_sizeVector[ stackNo ];
		values[ origin + sizeVector ] = key;
		stackNo_to_sizeVector[ stackNo ]++;
		
	}



	private boolean isAllStacksFull() {
		
		for( int i = 0; i < numberOfStacks; i++ ) {
			if( isStackFull( i ) == false ) {
				return false;
			}
		}
		return true;
	}



	private boolean isStackFull(int stackNo) {
		if( IS_DEBUG ) out.println("isStackFull()");
		
		//WRONG: typo
		//return stackNo_to_capacityVector[ stackNo ] == stackNo_to_capacityVector[ stackNo ];
		return stackNo_to_sizeVector[ stackNo ] == stackNo_to_capacityVector[ stackNo ];
	}
	
	
	
	//under the premise that it's not all stacks are full
	private void expandByOneElemnt(int stackNo) {
		
		if( IS_DEBUG ) out.println("expandByOneElemnt()");
		
		rightShiftByOne( nextStackNo( stackNo )  );
		//assume it successfully move by one
		stackNo_to_capacityVector[ stackNo ]++;
		
	}
	

	/**
	 * Scenario 1
	 * 
	 * [ A1 A2 A3 ][ B1 B2 - ]
	 * push to stackA:
	 * 	if stackB not full
	 * 		stackB rightShiftValuesByOne
	 * 		stackB shrinkLeftside
	 * 
	 * 		stackA expands
	 * 		stackA push
	 * 
	 * [ A1 A2 A3 ][ B1 B2 -- ]		
	 * [ A1 A2 A3 ][ -- B1 B2 ]
	 * 
	 * [ A1 A2 A3 ] --[ B1 B2 ]
	 * [ A1 A2 A3 -- ][ B1 B2 ]
	 * [ A1 A2 A3 A4 ][ B1 B2 ]
	 * 
	 * 
	 * Scenario 2
	 * [ A1 A2 A3 ][ B1 B2 B3 ][ C1 C2 - ]
	 * push to stackA:
	 * 	if stackB IS full 
	 * 		(and stackC is NOT full):
	 * 		
	 * 		stackC rightShiftValuesByOne
	 * 		stackC shrinkLeftside
	 * 
	 * 		stackB enlarge its capacity
	 * 		stackB rightShiftValuesByOne
	 * 		stackB shrinkLeftside
	 * 		
	 * 		stackA expands
	 * 		stackA push
	 * 
	 * [ A1 A2 A3 ][ B1 B2 B3 ][ C1 C2 -- ]
	 * [ A1 A2 A3 ][ B1 B2 B3 ][ -- C1 C2 ]
	 * [ A1 A2 A3 ][ B1 B2 B3 ] --[ C1 C2 ]
	 * [ A1 A2 A3 ][ B1 B2 B3 -- ][ C1 C2 ]
	 * [ A1 A2 A3 ][ -- B1 B2 B3 ][ C1 C2 ]
	 * [ A1 A2 A3 ] --[ B1 B2 B3 ][ C1 C2 ]
	 * [ A1 A2 A3 -- ][ B1 B2 B3 ][ C1 C2 ]
	 * [ A1 A2 A3 A4 ][ B1 B2 B3 ][ C1 C2 ]
	 * 
	 * THINK_FURTHER:
	 * Under the premise that not all stacks are full,
	 * there might be a calling chain that
	 * 	stack1 calls rightShfitByOne on stack2
	 * 		stack2 calls rightShfitByOne on stack3...
	 * 			...
	 * 			stackN-1 calls rightShfitByOne on stackN...
	 * 	stackI is full, where 1<= I <= N-1
	 *  the last node of calling chain, stackN-1 is not full
	 *  
	 * The first caller of rightShiftByOne, which is called by expandByOneElemnt, its
	 * size is enlarged by 1 so it can have room to push new elements
	 * 
	 * The following callees of rightShiftByOne due to its full capacity, it first enlarge
	 * its size by 1 at right side so it have room to rightShift all its element; at the end, it decrease
	 * its size by 1 at left, giving away that room to previous stack ( for either push or right shift purpose)
	 * In sum, its capacity keeps the same
	 * 
	 * the last node of calling chain, which is not full, will rightShift all its element 
	 * right away( because it's not full it doesn't need to borrow a room from other)
	 * and decrease it's size by 1 at left.
	 * In sum, its capacity decrease by 1.
	 * 
	 * in the calling chain, except the first node(stack), all the other stacks right shift by one
	 * in the calling chain, the first stack enlarges its size by one, because the last stack decreases its
	 * size by one, giving away its 1 capacity, passing down to the first stack. 
	 * 
	 */
	private void rightShiftByOne(int stackNo) {
		
		if( IS_DEBUG ) out.println("rightShiftByOne()");
		
		if( isStackFull(stackNo) ) {
			rightShiftByOne( nextStackNo( stackNo )  );
			//WRONG: forget to add
			stackNo_to_capacityVector[ stackNo ]++;
		}
		
		//reaching here meaning there exist at least one free space
		//PURPOSE: move all right by one 
		
		/*
		 * [ O1 O2 O3 -- -- ]
		 * [ -- O1 O2 O3 -- ]
		 *  -- [O1 O2 O3 -- ]
		 */
		
		int index = lastElementIndex( stackNo );
		index = nextIndex( index );
		
		while( isWithinStack(stackNo, index) ) {
			//move right by one element
			int nextIndex = nextIndex( index );
			values[ nextIndex ] = values[ index ];
			index = preivousIndex( index );
		}
		
		int origin = stackNo_to_origin[ stackNo ];
		//clear
		values[origin] = 0;
		//WRONG: forget to add
		stackNo_to_origin[ stackNo ] = nextIndex(stackNo_to_origin[ stackNo ]);
		stackNo_to_capacityVector[ stackNo ]--;
		
	}
	
	
	
	private boolean isWithinStack( int stackNo, int index ) {
		
		int capacityVector = stackNo_to_capacityVector[ stackNo ];
		int origin = stackNo_to_origin[ stackNo ];
		
		//under the premise that index is greater than origin 
		int contiguousIndex = index < origin? index + values.length : index;
		int contiguousEnd = origin + capacityVector;
		
		return origin <= contiguousIndex && contiguousIndex < contiguousEnd;
		
	}
	
	
	
	private int lastElementIndex( int stackNo ) {
		int sizeVector = stackNo_to_sizeVector[ stackNo ];
		int origin = stackNo_to_origin[ stackNo ];
		
		return ( (origin + sizeVector - 1) % values.length + values.length) % values.length;
	}
	
	
	
	private int nextStackNo( int stackNo ) {
		return (stackNo + 1) % numberOfStacks;
	}
	
	
	
	private int nextIndex( int index ) {
		return ( index + 1 ) % values.length;
	}
	
	
	
	private int preivousIndex(int index ) {
		return ( ( index - 1) % values.length + values.length) % values.length;
	}
	
	
	
	public int pop( int stackNo ) throws Exception {
		
		if( isStackEmpty(stackNo) ) {
			throw new EmptyStackException();
		}
		
		int lastIndex = lastElementIndex(stackNo);
		int poppedValue = values[ lastIndex ];
		values[ lastIndex ] = 0;
		stackNo_to_sizeVector[ stackNo ]--;
		
		return poppedValue;
	}
	
	
	
	private boolean isStackEmpty( int stackNo ) {
		return stackNo_to_sizeVector[ stackNo ] == 0;
	}
	
	
	
	public int peek( int stackNo ) throws EmptyStackException {
		
		if( isStackEmpty(stackNo) ) {
			throw new EmptyStackException();
		}
		
		int lastIndex = lastElementIndex(stackNo);
		int peekedValue = values[ lastIndex ];
		
		return peekedValue;
	}
	
	
	
	//Only for testing purpose
	public void showInfo() {
		
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		for( int i =0; i < values.length; i++ ) {
			sj.add( i + ":" + values[i] );
		}
		out.println( "values: " + sj.toString());
		
		out.println( "stackNo_to_origin: " + Arrays.toString(stackNo_to_origin) );
		out.println( "stackNo_to_sizeVector: " + Arrays.toString(stackNo_to_sizeVector) );
		out.println( "stackNo_to_capacityVector: " + Arrays.toString(stackNo_to_capacityVector) );
		
	}
	
}


