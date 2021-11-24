package c08_RecursionDynamicProgramming.p13_StackOfBoxes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;

public class TestBox {

	public static void main(String[] args) {
		
		String[] chosenOptions = { "1" , "8" };
		HashSet<String> options = new HashSet<>( Arrays.asList(chosenOptions) );
		
		ArrayList<Box> boxes = generateBoxesRandomly(4, 20, 20, 20);
		showBoxes(boxes);
		
		if(options.contains("1"))
		{
			out.println("StackOfBoxes_Way1 " + StackOfBoxes_Way1.createStack(boxes));
		}
		if(options.contains("2"))
		{
			out.println("MyStackOfBoxes_Way1 " + MyStackOfBoxes_Way1.getMaxStackHeight(boxes));
		}
		if(options.contains("3"))
		{
			out.println("StackOfBoxes_Way1_1_printEachStep " + StackOfBoxes_Way1_1_printEachStep.createStack(boxes));
		}
		if(options.contains("4"))
		{
			out.println("StackOfBoxes_Way2 " + StackOfBoxes_Way2.getMaxHeightOfStack(boxes));
		}
		if(options.contains("5"))
		{
			out.println("MyStackOfBoxes_Way2 " + MyStackOfBoxes_Way2.getMaxStackHeight(boxes));
		}
		if(options.contains("6"))
		{
			out.println("MyStackOfBoxes_Way1_freq02 " + MyStackOfBoxes_Way1_freq02.getMaxHeight(boxes)); 
		}
		if(options.contains("7"))
		{
			out.println("MyStackOfBoxes_Way2_freq02 " + MyStackOfBoxes_Way2_freq02.maxHeight(boxes));
		}
		
		if(options.contains("8"))
		{
			out.println("_Practice_StackOfBoxes_Way01 " + _Practice_StackOfBoxes_Way01.getMaxHeightOfStackOfBoxes(boxes));
			showBoxes(boxes);
		}
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
