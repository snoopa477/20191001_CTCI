package c08_RecursionDynamicProgramming.p13_StackOfBoxes;

import java.util.Collections;
import java.util.List;
//20191107(Sun
public class StackOfBoxes_Way2 {

	
	public static int getMaxHeightOfStack(List<Box> boxes) {
		
		Collections.sort(boxes, new BoxComparator());
		
		int[] stackMap = new int[boxes.size()];
		return createStack(boxes, null,0, stackMap);
	}

	private static int createStack(List<Box> boxes, Box bottom, int offset, int[] stackMap) {
		
		if(offset >= boxes.size())
			return 0;
		
		/*height with this bottom */
		//offset, currentBoxIndex
		//newBottom, currentBottomBox
		//bottom, previousBottomBox
		//stackMapp[i]: the maxHeight when box i as bottom 
		Box newBottom = boxes.get(offset);
		
		int heightWithBottom = 0;
		if( bottom == null || newBottom.canBeAbove(bottom)) {
			
			if(stackMap[offset] ==0 ) {
				//為什麼只有在這裡才被記錄?
				stackMap[offset] = createStack(boxes, newBottom, offset + 1, stackMap);
				stackMap[offset] += newBottom.height;
			}
			heightWithBottom = stackMap[offset];
			
		}
		
		//without this bottom
		//? 
		int heightWithoutBottom = createStack(boxes, bottom, offset + 1, stackMap);
		
		//return better of two options
		return Math.max(heightWithBottom, heightWithoutBottom);
	}
	
	
}
