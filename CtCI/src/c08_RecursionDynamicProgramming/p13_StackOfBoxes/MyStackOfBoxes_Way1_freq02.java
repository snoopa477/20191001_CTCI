package c08_RecursionDynamicProgramming.p13_StackOfBoxes;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//import java.util.Comparator;
//2020 1219(Sat
public class MyStackOfBoxes_Way1_freq02 {
	
	public static int getMaxHeight( ArrayList<Box> boxes ) {
		
		/*
		Collections.sort(boxes, 
			new Comparator<Box>(){ 
				@Override
				public int compare(Box o1, Box o2) {
					return o1.height - o2.height;
				}
			}
		);*/
		
		//lambda would be better
		//wrong! becuase we need sorted in descedning order, so we don't have to look back
		//Collections.sort(boxes, (o1, o2) -> o1.height - o2.height );
		Collections.sort(boxes, (o1, o2) -> o2.height - o1.height );
		
		int[] baseBox_to_maxHeight = new int[boxes.size()];
		Arrays.fill(baseBox_to_maxHeight, -1);
		
		int maxHeight = 0;
//		for(int i = 0; i <= boxes.size(); i ++) {
		for(int i = 0; i < boxes.size(); i ++) {
			//wrong
			//Math.max(maxHeight, getMaxHeight(boxes, i));
			maxHeight = Math.max(maxHeight, getMaxHeight(boxes, i, baseBox_to_maxHeight));
		}
		
		return maxHeight;
	}
	
	
	//backbone
	static int getMaxHeight( ArrayList<Box> boxes, int currentIndex, int[] baseBox_to_maxHeight) {
		
		
		if( baseBox_to_maxHeight[ currentIndex ] != -1 ) {
			return baseBox_to_maxHeight[ currentIndex ];
		}
		
		//base case, no such box
//		if(currentIndex == boxes.size()) {
//			return 0;
//		}
		
		Box baseBox = boxes.get(currentIndex);
		int baseHeight = baseBox.height;
		//out.println("base height " + baseHeight);
		
		int maxHeight = 0;
//		for(int nextIndex = currentIndex + 1; nextIndex <= boxes.size(); nextIndex++) {
		for(int nextIndex = currentIndex + 1; nextIndex < boxes.size(); nextIndex++) {
			
			//don't forget to check nextBox's validity
			//java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
//			if( nextIndex < boxes.size() ) {
				Box nextBox = boxes.get(nextIndex);
				if( nextBox.canBeAbove(baseBox) ) {
					maxHeight = Math.max(maxHeight,
						//wrong!
						//getMaxHeight(boxes, currentIndex + 1));
						getMaxHeight(boxes, nextIndex, baseBox_to_maxHeight ));
				}
//			}
//			else {
//				maxHeight = Math.max(maxHeight,
//					//getMaxHeight(boxes, currentIndex + 1));
//					getMaxHeight(boxes, nextIndex ));
//				}
			
		}
		maxHeight += baseHeight;
		baseBox_to_maxHeight[ currentIndex ] = maxHeight;
		return maxHeight;
	}

}


