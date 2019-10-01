package c08_RecursionDynamicProgramming.p10_PaintFill.draft01;

import static java.lang.System.out;

public class TestColor {

	public static void main(String[] args) {
		
		for(Color color: Color.values()) {
			out.println("color.name(): " + color.name() + " /color.ordinal: " + color.ordinal() 
							+ " /color.getAbbreviation: " + color.getAbbreviatoin());
			
		}
		
		
	}
	
}
