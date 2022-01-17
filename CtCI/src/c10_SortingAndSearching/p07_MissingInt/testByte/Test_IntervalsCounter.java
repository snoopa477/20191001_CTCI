package c10_SortingAndSearching.p07_MissingInt.testByte;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
public class Test_IntervalsCounter {

	public static void main(String[] arg) {
		int valueRange; 
		
		{
			valueRange = 10;
			IntervalsCounter intervalsCounter = new IntervalsCounter(valueRange);
			//MISTAKE: Cannot infer type arguments for HashSet<>
			//HashSet<Integer> numbers = new HashSet<>(  Arrays.asList( new int[]{56, 76} )   );
			
			HashSet<Integer> badNumbers = new HashSet<Integer>( 
				new ArrayList<Integer>( 
					Arrays.asList( 
						//MISTAKE: The constructor ArrayList<Integer>(Arrays.asList(new int[]{56, 76, 77, 23, 71})) is undefined
						//new int[]{56, 76, 77, 23, 71 } )  )  );
						new Integer[]{56, 70, 76, 77, 80, 23, 71 } )  )  );
			
			int maxNumber = 101;
			
			for( int i =0; i <= maxNumber; i++) {
				if( badNumbers.contains(i) == false ) {
					intervalsCounter.addToCounter(i);
				}
			}
			
			for( int idx = 0; idx < maxNumber / valueRange + 1; idx++ ) {
				out.printf("idx is %3d, valueMin is %5d, valueMax is %5d, counter is %5d\n"
					,idx, intervalsCounter.get_MinValueAtInterval(idx)
					, intervalsCounter.get_MaxValueAtInterval(idx), intervalsCounter.getCounterAtInterval(idx) );
			}
			
		}
		
	}
	
	
}


