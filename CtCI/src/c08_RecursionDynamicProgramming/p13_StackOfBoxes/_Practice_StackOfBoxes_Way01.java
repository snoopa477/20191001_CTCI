package c08_RecursionDynamicProgramming.p13_StackOfBoxes;
import static java.lang.System.out;
import java.util.*;
public class _Practice_StackOfBoxes_Way01 {

	private static final boolean IS_DEBUG_ON = true;
	
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
		
		
		return maxHeightOfStack(boxes, 0, startBottomIndexToMaxHeight) ;
	}
	
	
	/* REASONING 
	 * maxHeight of stacks, considering from box index 0 to n-1 equals to 
	 * max among ( picking 0th box maxHeight of stacks, with maxHeight of stacks considering from box index 1 to n, 
	 *  picking 1th box maxHeight of stacks-if possible when the box is smaller than underneath box-, with maxHeight of stacks considering from box index 2 to n-1,
	 *  picking 2th box maxHeight of stacks-if possible when the box is smaller than underneath box-, with maxHeight of stacks considering from box index 3 to n-1,
	 *  ...
	 *  picking n-2th box maxHeight of stacks-if possible when the box is smaller than underneath box-, with maxHeight of stacks considering from box index n-1 to n-1,
	 *  picking n-1th box -if possible when the box is smaller than underneath box-, with no following boxes
	 *  not picking nth box(this can actually ignored, it's height is 0)) 
	 */
	/* DETAIL
	 * startBottomIndex; the bottom of stack
	 */
	private static int maxHeightOfStack(ArrayList<Box> boxes, int startBottomIndex, int[] startBottomIndexToMaxHeight) {
		
		if(IS_DEBUG_ON) out.println("hi startBottomIndex " + startBottomIndex);
		
		
		//base case: consider n-1th box, there's no following box to consider, just pick this box
		if( startBottomIndex == boxes.size()-1 ) {
			if(IS_DEBUG_ON) out.println("base case: " + boxes.get(startBottomIndex).height);
			return boxes.get(startBottomIndex).height;
		}
		
		//impossible case
		//TRICKY: if I put this snippet of code behind DP, would cause out of array boundary runtim error
		//THINK_FURTHER: is there anyway to write in a straight forward way avoid of tricky part?
		if(startBottomIndex >= boxes.size()) {
			return 0;
		}
		
		
		if( startBottomIndexToMaxHeight[startBottomIndex] != -1 ) {
			if(IS_DEBUG_ON) out.println("dp: " + startBottomIndexToMaxHeight[startBottomIndex]);
			return startBottomIndexToMaxHeight[startBottomIndex];
		}
		
		
		//REASONING There might be underneath box, which is under the stack we'd like to build
		boolean hasUnderneathBox = startBottomIndex > 0 ? true : false;
		Box underNeathBox = hasUnderneathBox? boxes.get(startBottomIndex-1) : null;
		
		int maxHeight = -1;
		
		//general case
		for(int pickIndex = startBottomIndex; pickIndex < boxes.size(); pickIndex++) {
			
			Box pickedBox = boxes.get(pickIndex);
			//maxHeight = pickedBox.height;
			
			//for first call
			if( hasUnderneathBox == false ) {
				//DETAIL: we compare one by one; in a broader since, we're trying to get max among all elements in for loop
				maxHeight = Math.max(maxHeight
						//MISTAKE: I once confused startBottomIndex with pickIndex
						//, pickedBox.height + maxHeightOfStack(boxes, startBottomIndex + 1, startBottomIndexToMaxHeight));
						, pickedBox.height + maxHeightOfStack(boxes, pickIndex + 1, startBottomIndexToMaxHeight));
			}
			else {
				if( pickedBox.canBeAbove(underNeathBox) ) {
					maxHeight = Math.max(maxHeight
							, pickedBox.height + maxHeightOfStack(boxes, pickIndex + 1, startBottomIndexToMaxHeight));
				}
			}
			
			
		}
		
		
		startBottomIndexToMaxHeight[startBottomIndex] = maxHeight;
		if(IS_DEBUG_ON) out.println("startBottomIndexToMaxHeight[startBottomIndex] " + "startBottomIndexToMaxHeight[" + startBottomIndex + "] " + startBottomIndexToMaxHeight[startBottomIndex]);
		return maxHeight;
	}
	
	
	
}


