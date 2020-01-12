package c08_RecursionDynamicProgramming.p13_StackOfBoxes;

import java.util.List;

//import org.graalvm.compiler.core.amd64.AMD64ArithmeticLIRGenerator.Maths;

/**
 *	2019/11/9
 *
 * 	? wat method signature I need?
 * 
 */
public class MyStackOfBoxes_Way1 {

	
	static int getMaxStackHeight(List<Box> boxes) {
		
		int maxHeight =0;
		for(int bottomIndex = 0; bottomIndex < boxes.size(); bottomIndex++) {
			
			maxHeight = Math.max(maxHeight, getMaxStackHeightFromBottomBox(boxes, bottomIndex));
			
		}
		return maxHeight;
	}
	
	
	static int getMaxStackHeightFromBottomBox(List<Box> boxes, int bottomIndex) {
		
		int maxHeight = 0;
		
		for(int nextBottomIndex = bottomIndex +1; nextBottomIndex < boxes.size()
				;nextBottomIndex ++) {
			
			Box nextBox = boxes.get(nextBottomIndex);
			Box bottomBox = boxes.get(bottomIndex);
			
			if( nextBox.canBeAbove( bottomBox ) ) {
				int nextStackHeight = getMaxStackHeightFromBottomBox(boxes, nextBottomIndex);
				maxHeight = Math.max(maxHeight, nextStackHeight);
			}
		}
		
		maxHeight += boxes.get(bottomIndex).height;
		
		return maxHeight;
	}

}
