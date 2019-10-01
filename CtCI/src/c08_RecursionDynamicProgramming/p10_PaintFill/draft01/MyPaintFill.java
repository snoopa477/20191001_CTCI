package c08_RecursionDynamicProgramming.p10_PaintFill.draft01;

import static java.lang.System.out;

//20190918(Wed
//我覺得很多想法並不衝突; 也就是事情很多面像. 然而, 一般而言, 挑選most general and important idea當做entry point
//1. DFS
//	1.1: Format: 此層有for, 開始call itself
//	1.2: 

//2. Chain想法, 揚棄一氣呵成的念頭
//	2.1: 以某個層面來看, 相信可以透過環環相扣的方式完成
//	2.2: 完成一個環, 假設其他環自動完成(然後依賴數學歸納法造成骨牌效應)

//3. recursion:
//	3.1: types: 
//		3.1.a: 利用return value of subProblem結果才能結算此層結果. e.g.: balanced tree
//		3.1.b: 不需要return value of subProblem也能繼續下去. e.g.: 此題

//4. 切入點
//	4.1: 假設能用recursion做, 然後中途才能發現到底可不可行(死馬當活馬醫; 因為若是不做下去, 得先證明那很耗時間
public class MyPaintFill {

	
	//Representation
	//given we have enum Color, we use array with 2 dimension of enum Color to represent a picture
	
	//goal?
	//replace the target color with our new color
	public static void paintFill(Color[][] picture, int rowIndex, int colIndex, Color oldColor, Color newColor) {
		
		paintFillHelper(picture,rowIndex, colIndex, oldColor, newColor);
		
	}
	
	//where am I?
	public static void paintFillHelper(Color[][] picture, int rowIndex
			, int colIndex, Color oldColor, Color newColor) {
		
		//out of boundary
		if( rowIndex < 0 || rowIndex > picture.length-1 || colIndex <0 || colIndex > picture[0].length-1 )
			return ;
		
		if( picture[rowIndex][colIndex] == oldColor ) {
			
			picture[rowIndex][colIndex] = newColor;
			showPicture(picture);
			
			//up
			paintFillHelper(picture, rowIndex -1, colIndex, oldColor, newColor);
			//down
			paintFillHelper(picture, rowIndex +1, colIndex, oldColor, newColor);
			//left
			paintFillHelper(picture, rowIndex, colIndex -1, oldColor, newColor);
			//rifht
			paintFillHelper(picture, rowIndex, colIndex +1, oldColor, newColor);
			
		}
		else {
			//do nothing
		}
		
	}
	
	
	public static void showPicture(Color[][] picture) {
		
		out.println("");
		
		for(int i =0; i < picture.length; i++) {
			for(int j =0; j < picture[0].length; j++) {
				
				out.print(picture[i][j].getAbbreviatoin() + " ");
			}
			out.println("");
		}
		
	}
	
}
