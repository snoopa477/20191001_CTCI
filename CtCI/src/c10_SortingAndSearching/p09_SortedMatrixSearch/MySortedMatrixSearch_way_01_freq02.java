package c10_SortingAndSearching.p09_SortedMatrixSearch;
//import static java.lang.System.out;

//2021 0124(Sun)
public class MySortedMatrixSearch_way_01_freq02 {

	public static Coordinate findElement(int[][] sortedMatrix, int key) {
		
		final int maxRowIndex = sortedMatrix.length -1;
		final int minColIndex = 0; 
		
		int rowCurrIndex = 0;
		int colCurrIndex = sortedMatrix[0].length -1 ;
		
		while( rowCurrIndex <= maxRowIndex && colCurrIndex >= minColIndex ) {
			
			int valueCurr = sortedMatrix[rowCurrIndex][colCurrIndex];
			if( valueCurr == key ) {
				Coordinate result = new Coordinate(rowCurrIndex, colCurrIndex);
				return result;
			}
			else if( valueCurr < key ) {
				rowCurrIndex++;
			}
			//else if ( valueCurr > key )
			else {
				colCurrIndex--;
			}
		}
		
		return null;
	}
	
}


