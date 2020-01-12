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
		
		//�̫�~�[���K��, �\Ū�����n����
		//there's no such box
		if(currentIndex >= boxes.size()) {
			return 0;
		}
		
		if(bottomBoxIndexToHeight[currentIndex]!= 0 ) {
			return bottomBoxIndexToHeight[currentIndex];
		}
			
			
		
		Box currentBox = boxes.get(currentIndex);
		//���F���N�o���ܼ�, �ڥi�H���g, �ϱo�o�ӷN�ϧ�M��?
		int maxHeight_WithPrevBox = 0;
		if( previousBox== null || currentBox.canBeAbove(previousBox) ) {
			
			maxHeight_WithPrevBox = getMaxStackHeight(boxes, currentBox, currentIndex + 1,
					bottomBoxIndexToHeight);
			maxHeight_WithPrevBox += currentBox.height;
			bottomBoxIndexToHeight[currentIndex] = maxHeight_WithPrevBox;
		}
		
		
		//�p��P�e������, �ϱo��̤����󬰤���?
		//previousBox as next status previous box
		int maxHeight_WithoutPrevBox = getMaxStackHeight(boxes, previousBox, currentIndex + 1,
				bottomBoxIndexToHeight);
		
		
		return Math.max(maxHeight_WithoutPrevBox, maxHeight_WithPrevBox);
	}
	
	
}
