package c08_RecursionDynamicProgramming.p13_StackOfBoxes;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//21091118(Mon
public class MyStackOfBoxes_Way2 {

	
	public static int getMaxStackHeight(List<Box> boxes) {
		 
		Collections.sort(boxes, new BoxComparator());
		
		int[] bottomBoxIndexToHeight = new int[boxes.size()];
		
		return getMaxStackHeight(boxes, null, 0, bottomBoxIndexToHeight);
	}

	private static int getMaxStackHeight(List<Box> boxes, Box previousBox , int currentIndex,
			int[] bottomBoxIndexToHeight) {
		
		//最後才加的枝條, 閱讀的次要順序
		//there's no such box
		if(currentIndex >= boxes.size()) {
			return 0;
		}
		
		if(bottomBoxIndexToHeight[currentIndex]!= 0 ) {
			return bottomBoxIndexToHeight[currentIndex];
		}
			
			
		
		Box currentBox = boxes.get(currentIndex);
		//為了成就這個變數, 我可以怎麼寫, 使得這個意圖更清晰?
		int maxHeight_WithPrevBox = 0;
		if( previousBox== null || currentBox.canBeAbove(previousBox) ) {
			
			maxHeight_WithPrevBox = getMaxStackHeight(boxes, currentBox, currentIndex + 1,
					bottomBoxIndexToHeight);
			maxHeight_WithPrevBox += currentBox.height;
			bottomBoxIndexToHeight[currentIndex] = maxHeight_WithPrevBox;
		}
		
		
		//如何與前面分割, 使得兩者之間更為分明?
		//previousBox as next status previous box
		int maxHeight_WithoutPrevBox = getMaxStackHeight(boxes, previousBox, currentIndex + 1,
				bottomBoxIndexToHeight);
		
		
		return Math.max(maxHeight_WithoutPrevBox, maxHeight_WithPrevBox);
	}
	
	
}
