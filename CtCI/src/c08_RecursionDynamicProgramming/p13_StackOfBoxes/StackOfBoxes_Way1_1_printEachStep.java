package c08_RecursionDynamicProgramming.p13_StackOfBoxes;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.System.out;

public class StackOfBoxes_Way1_1_printEachStep {

	static int createStack(ArrayList<Box> boxes) {
		
		Collections.sort(boxes, new BoxComparator());
		int maxHeight = 0;
		int[] stackMap = new int[boxes.size()];
		
		for(int i =0; i < boxes.size(); i ++) {
			int height = createStack(boxes, i, stackMap);
			maxHeight = Math.max(maxHeight, height);
		}
		return maxHeight;
	}

	private static int createStack(ArrayList<Box> boxes, int bottomIndex, int[] stackMap) {
		out.printf("%d ", bottomIndex);
		if(bottomIndex < boxes.size() && stackMap[bottomIndex] > 0) {
			out.println("hello");
			return stackMap[bottomIndex];
		}
		
		Box bottom = boxes.get(bottomIndex);
		int maxHeight = 0;
		
		for(int i = bottomIndex + 1; i < boxes.size(); i ++) {
			
			if(boxes.get(i).canBeAbove(bottom)) {
				int height = createStack(boxes, i, stackMap);
				maxHeight = Math.max(height, maxHeight);
			}
		}
		
		maxHeight += bottom.height;
		stackMap[bottomIndex] = maxHeight;
		
		return maxHeight;
	}
	
}
