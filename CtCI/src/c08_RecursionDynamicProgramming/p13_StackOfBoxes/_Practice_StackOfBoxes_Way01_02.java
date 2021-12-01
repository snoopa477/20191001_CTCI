package c08_RecursionDynamicProgramming.p13_StackOfBoxes;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
public class _Practice_StackOfBoxes_Way01_02 {
	private static final boolean IS_DEBUG_ON = false;
	
	public static int getMaxHeightOfStackOfBoxes(ArrayList<Box> boxes) {
		
		//REPLACED
		/*
		 * 
		boxes.sort( new Comparator<Box>() {
			@Override
			public int compare(Box o1, Box o2) {
				return (o1.depth - o2.depth) * -1;
			}
		} );
		*/
		
		//REPLACED BY lambda expression under one condition: the interface 'Comparator<Box>' only has one function: int compare(Box o1, Box o2)
		//REASONING Sorting one dimension( depth or width) descending is the prerequisite of stacking boxes 
		boxes.sort( (Box o1, Box o2) -> (o1.depth - o2.depth) * -1 );
		
		int[] startBottomIndexToMaxHeight = new int[boxes.size()];
		Arrays.fill(startBottomIndexToMaxHeight, -1);
		
		
		return maxHeightOfStack(boxes, null, 0, startBottomIndexToMaxHeight) ;
	}
	
	
	/* REASONING 
	 * maxHeight of stacks, considering from box index 0 to n-1 equals to 
	 * max among ( picking 0th box, with its height, and with maxHeight of stacks considering from box index 1 to n, 
	 *  picking 1th box, with its height-if possible when the box is smaller than underneath box-, with maxHeight of stacks considering from box index 2 to n-1,
	 *  picking 2th box, with its height-if possible when the box is smaller than underneath box-, with maxHeight of stacks considering from box index 3 to n-1,
	 *  ...
	 *  picking n-2th box, with its height-if possible when the box is smaller than underneath box-, with maxHeight of stacks considering from box index n-1 to n-1,
	 *  picking n-1th box -if possible when the box is smaller than underneath box-, with no following boxes
	 *  not picking nth box(this can actually ignored, it's height is 0)) 
	 */

	
	/* DETAIL
	 * pivotIndex: the maxHeight from box starting from pivotIndex to n-1 box equals to
	 * pick pivitIndex th box, with maxHeight from box starting from pivotIndex+1 to n-1 box 
	 * pick pivitIndex+1 th, with maxHeight from box starting from pivotIndex+2 to n-1 box
	 * pick pivitIndex+2  box, with maxHeight from box starting from pivotIndex+3 to n-1 box
	 * ...
	 * pick n-2 box, with maxHeight from box starting from n-1 to n-1 box
	 * pick n-1 box, ( no following box ) base case
	
	 */
	private static int maxHeightOfStack(ArrayList<Box> boxes, Box underNeathBox, int pivotIndex, int[] startBottomIndexToMaxHeight) {	
		
		
		//base case
		if( pivotIndex == boxes.size()  ) {
			//return boxes.get(pivotIndex).height;
			//MISTAKE
			//WRONG Concept
			//out.println("base case: " + underNeathBox.height );
			return 0;
		}
		
		if( startBottomIndexToMaxHeight[pivotIndex] != -1 ) {
			if(IS_DEBUG_ON) out.println( "startBottomIndexToMaxHeight[" + pivotIndex + "]: " + startBottomIndexToMaxHeight[pivotIndex]);
			return startBottomIndexToMaxHeight[pivotIndex];
		}
		
		
		//int maxHeight = -1;
		int maxHeight = 0;
		for(int pickIndex = pivotIndex ; pickIndex < boxes.size(); pickIndex++) {
			if(IS_DEBUG_ON) out.println();
			
			Box pickedBox = boxes.get(pickIndex);
			int nextPivotIndex = pickIndex + 1;
			
			
			
			//if( pickedBox.canBeAbove(underNeathBox) ) {
			if( underNeathBox == null || pickedBox.canBeAbove(underNeathBox) ) {
				
				/*
				if(underNeathBox !=null)
					out.println( "pickedBox: " + pickedBox.toString() + " ;underNeathBox: " + underNeathBox.toString());
				else
					out.println( "pickedBox: " + pickedBox.toString() + " ;underNeathBox: is null" );
				*/
				
				
				int subFunc =  maxHeightOfStack(boxes, pickedBox, nextPivotIndex, startBottomIndexToMaxHeight);
				int localMaxHeight = pickedBox.height + subFunc;
				
				
				maxHeight = Math.max(maxHeight, localMaxHeight);
				
				if(IS_DEBUG_ON) {
					out.println("pivotIndex: " + pivotIndex + "; pickedIndex: " + pickIndex);
					if(underNeathBox !=null) {
						out.println( "pickedBox: " + pickedBox.toString() + " ;underNeathBox: " + underNeathBox.toString());
					}
					else {
					out.println( "pickedBox: " + pickedBox.toString() + " ;underNeathBox: is null" );
					}
					
					out.println("localMxHeight: " + localMaxHeight + " = " + pickedBox.height + " + " + subFunc + "; maxHeight: " + maxHeight);
				}
			}
			
		}

		
		startBottomIndexToMaxHeight[pivotIndex] = maxHeight;
		return maxHeight;
	}
	

	
}


