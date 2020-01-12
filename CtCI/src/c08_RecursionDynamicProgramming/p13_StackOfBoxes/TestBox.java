package c08_RecursionDynamicProgramming.p13_StackOfBoxes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;

public class TestBox {

	public static void main(String[] args) {
		
		ArrayList<Box> boxes = generateBoxesRandomly(3, 20, 20, 20);
		showBoxes(boxes);
		
		
		out.println("StackOfBoxes_Way1 " + StackOfBoxes_Way1.createStack(boxes));
		out.println("MyStackOfBoxes_Way1 " + MyStackOfBoxes_Way1.getMaxStackHeight(boxes));
		out.println("StackOfBoxes_Way1_1_printEachStep " + StackOfBoxes_Way1_1_printEachStep.createStack(boxes));
		out.println("StackOfBoxes_Way2 " + StackOfBoxes_Way2.getMaxHeightOfStack(boxes));
		out.println("MyStackOfBoxes_Way2 " + MyStackOfBoxes_Way2.getMaxStackHeight(boxes));
	}
	
	private static ArrayList<Box> generateBoxesRandomly(int num,int widthBound
			, int depthBound, int heightBound){
		
		ArrayList<Box> result = new ArrayList<>();
		
		Random random = new Random();
		
		for(int i =0;i < num; i++) {
			Box box = new Box(random.nextInt(widthBound)+1, random.nextInt(depthBound)+1,
					random.nextInt(heightBound)+1);
			result.add(box);
		}
		return result;
	}
	
	private static void showBoxes(List<Box> boxes) {
		
		for(int i =0; i < boxes.size(); i++) {
			out.println("seq: " + i + " box: "+ boxes.get(i));
		}
		
	}

}
