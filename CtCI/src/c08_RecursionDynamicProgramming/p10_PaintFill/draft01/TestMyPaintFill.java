package c08_RecursionDynamicProgramming.p10_PaintFill.draft01;

import static java.lang.System.out;
public class TestMyPaintFill {

	public static void main(String[] args) {
		
		Color[][] picture = { 
				 {Color.White, Color.White, Color.White, Color.White, Color.Red  }
				,{Color.White, Color.White, Color.Red  , Color.White, Color.White}
				,{Color.Red  , Color.Red  , Color.Red  , Color.Red  , Color.White}
				,{Color.White, Color.Red  , Color.Red  , Color.Red  , Color.White}
				,{Color.White, Color.White, Color.White, Color.Red  , Color.White}};
		
	
	
		MyPaintFill.paintFill(picture, 2, 2, Color.Red, Color.Green);
	
	}
}
