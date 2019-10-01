package c08_RecursionDynamicProgramming.p13_StackOfBoxes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


//20190911(Wed
//Thought: when I have intuition to have answer without considering Java Syntax(Comparator)
//nor Data structure, then I can start coding
//and when start coding, start to take those into consideration
public class StackOfBoxes_Way1 {

	public static int createStack(ArrayList<Box> boxes) {
		
		//sort in decending order by height
		Collections.sort(boxes, new BoxComparator());
		
		int maxHeight = 0;
		
		for(int i =0; i < boxes.size(); i++) {
			int height = createStack(boxes, i);
			maxHeight = Math.max(maxHeight, height);
		}
		
		return 0;
	}

	private static int createStack(ArrayList<Box> boxes, int bottomIndex) {
		
		Box bottom = boxes.get(bottomIndex);
		int maxHeight = 0;
		
		//±Æ°£ªk
		//After sorting, the location/index has special meaning relates to value height
		//due to descending sorting, box bottomIndex height is smaller than box j height,
		//where j < bottomIndex
		//Therefore, there's no need to check those boxes if we can create stack
		
		//wat is this figure for? for index, or some meaningful purpose
		
		for(int i = bottomIndex + 1; i < boxes.size(); i ++) {
			if( boxes.get(i).canBeAbove(bottom) ) {
				int height = createStack(boxes, i );
				maxHeight = Math.max(height, maxHeight);
			}
		}
		
		maxHeight += bottom.height;
		
		return maxHeight;
	}
	
}



class BoxComparator implements Comparator<Box>{

	@Override
	public int compare(Box o1, Box o2) {
		return (int)(o2.height - o1.height);
	}
	
	
}
