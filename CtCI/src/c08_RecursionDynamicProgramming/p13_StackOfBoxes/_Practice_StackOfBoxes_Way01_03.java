package c08_RecursionDynamicProgramming.p13_StackOfBoxes;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
public class _Practice_StackOfBoxes_Way01_03 {
public static int getMaxHeightOfStackOfBoxes(ArrayList<Box> boxes) {
		
	
		boxes.sort( (Box o1, Box o2) -> (o1.depth - o2.depth) * -1 );
		
		
		
		
		return maxHeightOfStack(boxes) ;
	}

 	private static int maxHeightOfStack(ArrayList<Box> boxes) {		
 		
 		int[] startBottomIndexToMaxHeight = new int[boxes.size()];
		Arrays.fill(startBottomIndexToMaxHeight, -1);
 		
 		int maxHeight = 0;
 		for(int i = 0; i < boxes.size(); i++) {
 			
 			int localMaxHeght = pickedBottomBoxMaxHeight(boxes, i, startBottomIndexToMaxHeight);
 			maxHeight = Math.max( maxHeight, localMaxHeght );
 			
 		}
 		
 		
 		return maxHeight;
 	}
 	
 	private static int pickedBottomBoxMaxHeight(ArrayList<Box> boxes, int bottomIdx, int[] bottomIndexToMaxHeight) {
 		
 		//base case
 		if( bottomIdx == boxes.size() -1 ) {
 			return boxes.get(bottomIdx).height;
 		}
 		
 		if(bottomIndexToMaxHeight[bottomIdx] != -1) {
 			
 			return bottomIndexToMaxHeight[bottomIdx];
 			
 		}
 		
 		
 		Box pickedBottomBox = boxes.get(bottomIdx);
 		
 		int maxHeight = 0;
 		
 		for( int nextBottomIdx = bottomIdx + 1; nextBottomIdx < boxes.size(); nextBottomIdx++ ) {
 			
 			Box nextPickedBottomBox = boxes.get( nextBottomIdx );
 			
 			if( nextPickedBottomBox.canBeAbove(pickedBottomBox) ) {
 				
 				int localMaxHeght = pickedBottomBoxMaxHeight( boxes, nextBottomIdx, bottomIndexToMaxHeight );
 				maxHeight = Math.max( maxHeight, localMaxHeght );
 				
 			}
 			
 		}
 		
 		maxHeight += pickedBottomBox.height;
 		
 		bottomIndexToMaxHeight[bottomIdx] = maxHeight;
 		
 		return maxHeight;
 	}
 	
 	
}


