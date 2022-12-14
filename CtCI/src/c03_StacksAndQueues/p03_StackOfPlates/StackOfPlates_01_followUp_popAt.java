package c03_StacksAndQueues.p03_StackOfPlates;
import static java.lang.System.out;
public class StackOfPlates_01_followUp_popAt extends StackOfPlates_01 {

	
	public StackOfPlates_01_followUp_popAt(int capacityForEachStack) {
		super(capacityForEachStack);
	}
	
	
	
	/**
	 * given capacity is 3
	 * s0: a0 a1 a2
	 * s1: b0 b1 b2
	 * s2: c0 c1 c2
	 * s3: d0 
	 * 
	 * popAt(1):
	 *  
	 * return b2
	 * s0: a0 a1 a2
	 * s1: b0 b1 c0
	 * s2: c1 c2 d0
	 * s3 <- deleted
	 * @throws Exception 
	 * 
	 */
	public int popAt( int stackIndex ) throws Exception {
		
		//WRONG: Typo
		//if( ( 0 < stackIndex && stackIndex < stacks.size() ) == false  ) {
		if( ( 0 <= stackIndex && stackIndex < stacks.size() ) == false  ) {
			throw new Exception("wrong stackIndex");
		}
		
		return leftShiftByPoppingFromBottom( stackIndex, true );
	}

	
	
	/**
	 *  
	 * step1
	 *  if caller: 
	 *  	pop the current stack's top, to fulfill the request
	 *  else
	 *  	pop the current stack's bottom
	 *  		(p.s. if stack becomes empty due to pop, delete the stack container ) 
	 * 
	 * step2
	 *  left shift the following stacks
	 *  get the bottom element from next stack ( p.s. next stack is within following stacks)
	 *  put the element on top
	 *  return the popped element
	 * 
	 * @return current stack's bottom element 
	 * @throws Exception 
	 */
	private int leftShiftByPoppingFromBottom( int stackIndex, boolean isFromPopAt ) throws Exception {
		
		
		MyStack stack = stacks.get( stackIndex );
		
		//PURPOSE: step1
		int poppedValue;
		if( isFromPopAt ) {
			poppedValue = stack.pop();
		}
		else {
			poppedValue = stack.removeFromBottom();
		}
		
		
		if( stack.isEmpty() ) {
			stacks.remove( stackIndex );
		}
		
		
		//PURPOSE: step2
		if( stackIndex < stacks.size() -1 ) {
			int refillFromNextStack = leftShiftByPoppingFromBottom( stackIndex + 1, false );
			stack.push( refillFromNextStack );
		}
		
		
		return poppedValue;
	}
	
	
	
	/**
	+- +- +-
	0 th stack: 1 <- 2 <- 3
	1 th stack: 10 <- 20 <- 30
	2 th stack: 100 <- 200
	+- +- +-
	0 th stack: 1 <- 2 <- 3
	1 th stack: 10 <- 20 <- 100
	2 th stack: 200
	+- +- +-
	0 th stack: 1 <- 2 <- 10
	1 th stack: 20 <- 100 <- 200
	 */
	public static void main(String[] args) throws Exception {
		
		StackOfPlates_01_followUp_popAt stackOfPlates = new StackOfPlates_01_followUp_popAt(3);
		
		stackOfPlates.push(1);
		stackOfPlates.push(2);
		stackOfPlates.push(3);
		
		stackOfPlates.push(10);
		stackOfPlates.push(20);
		stackOfPlates.push(30);
		
		stackOfPlates.push(100);
		stackOfPlates.push(200);
		
		out.println( stackOfPlates );
		
		stackOfPlates.popAt(1);
		out.println( stackOfPlates );
		
		stackOfPlates.popAt(0);
		out.println( stackOfPlates );
		
	}
	
}


