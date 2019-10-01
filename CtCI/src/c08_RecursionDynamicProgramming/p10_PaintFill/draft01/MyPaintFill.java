package c08_RecursionDynamicProgramming.p10_PaintFill.draft01;

import static java.lang.System.out;

//20190918(Wed
//��ı�o�ܦh�Q�k�ä��Ĭ�; �]�N�O�Ʊ��ܦh����. �M��, �@��Ө�, �D��most general and important idea��entry point
//1. DFS
//	1.1: Format: ���h��for, �}�lcall itself
//	1.2: 

//2. Chain�Q�k, ����@����������Y
//	2.1: �H�Y�Ӽh���Ӭ�, �۫H�i�H�z�L�����ۦ����覡����
//	2.2: �����@����, ���]��L���۰ʧ���(�M��̿�ƾ��k�Ǫk�y�����P����)

//3. recursion:
//	3.1: types: 
//		3.1.a: �Q��return value of subProblem���G�~�൲�⦹�h���G. e.g.: balanced tree
//		3.1.b: ���ݭnreturn value of subProblem�]���~��U�h. e.g.: ���D

//4. ���J�I
//	4.1: ���]���recursion��, �M�ᤤ�~�~��o�{�쩳�i���i��(����������; �]���Y�O�����U�h, �o���ҩ����ܯӮɶ�
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
