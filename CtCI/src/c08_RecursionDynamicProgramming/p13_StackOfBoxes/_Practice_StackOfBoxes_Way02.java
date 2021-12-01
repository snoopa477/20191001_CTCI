package c08_RecursionDynamicProgramming.p13_StackOfBoxes;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
public class _Practice_StackOfBoxes_Way02 {
		
	public static int getMaxHeightOfStackOfBoxes(ArrayList<Box> boxes) {
		
		//REASONING Sorting one dimension( depth or width) descending is the prerequisite of stacking boxes 
		boxes.sort( (Box o1, Box o2) -> (o1.depth - o2.depth) * -1 );
		
		int[] startBottomIndexToMaxHeight = new int[boxes.size()];
		Arrays.fill(startBottomIndexToMaxHeight, -1);
		
		int maxHeight = getMaxHeight(boxes, null, 0,  null);
		
	return maxHeight;
	//	return maxHeightOfStack(boxes) ;
	}
	
	private static int getMaxHeight(ArrayList<Box> boxes, Box underneathBox, int currentIdx, int[] bottomIndexToMaxHeight) {
		
		
		//base case
		/*
		if( currentIdx == boxes.size() -1 ) {
			
			Box finalBox = boxes.get(currentIdx);
			
			if( underneathBox == null || finalBox.canBeAbove(underneathBox) ) {
				return finalBox.height;
			}
			return 0;
		}*/
		
		if( currentIdx >= boxes.size()) {
			return 0;
		}
		
		
		int maxHeight = 0;
		
		//general case
		Box pickedBox = boxes.get(currentIdx);
		int maxHeight_withBox = 0;
		//MISTAKE : typo
		//if( underneathBox == null || pickedBox.canBeAbove(pickedBox) ) {
		if( underneathBox == null || pickedBox.canBeAbove(underneathBox) ) {
			maxHeight_withBox = pickedBox.height + getMaxHeight(boxes, pickedBox, currentIdx + 1, bottomIndexToMaxHeight);
		}
		
		
		int maxHeight_noBox = 0;
		maxHeight_noBox = getMaxHeight(boxes, underneathBox, currentIdx + 1, bottomIndexToMaxHeight);
		
		maxHeight = Math.max(maxHeight_withBox, maxHeight_noBox);
		
		
		//temp
		return maxHeight;
	}
	
}


