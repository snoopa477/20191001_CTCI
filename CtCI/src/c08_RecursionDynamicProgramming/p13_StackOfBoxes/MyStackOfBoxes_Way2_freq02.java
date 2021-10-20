package c08_RecursionDynamicProgramming.p13_StackOfBoxes;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;

//2020 1219(Sat
public class MyStackOfBoxes_Way2_freq02 {

	public static int maxHeight(ArrayList<Box> boxes) {
		
		//order by descending order
		Collections.sort(boxes, (o1, o2) -> o2.height - o1.height);
		
		return maxHeight(boxes, 0, -1);
	}
	
	//backbone
	static int maxHeight(ArrayList<Box> boxes, int currentIndex, int prevIndex) {
		
		//don't forget the end case
		if( currentIndex >= boxes.size() ) {
			return 0;
		}
		
		Box currentBox = boxes.get(currentIndex);
		//I feel like this line is kinda danger
		//Box prevBox = boxes.get(prevIndex);
		
		int maxHeight_currentBox_taken  = 0;
		
		//wrong! cuz this will exlude the case when prevIndex = -1, with current box taken
		//prevent boxes.get(-1) from throwing exception
		//if( prevIndex >= 0 ) {
			
		Box prevBox = prevIndex == -1? null: boxes.get(prevIndex);
		if( prevBox == null || 
				currentBox.canBeAbove( prevBox ) ) {
			maxHeight_currentBox_taken = currentBox.height;
			maxHeight_currentBox_taken += maxHeight(boxes, currentIndex + 1, currentIndex);
		}
		//}
		
		int maxHeight_without_currentBox = 0;
		maxHeight_without_currentBox = maxHeight(boxes, currentIndex + 1, prevIndex);
			
		int maxHeight = Math.max(maxHeight_currentBox_taken, maxHeight_without_currentBox);
		return maxHeight;
	}
	
}


