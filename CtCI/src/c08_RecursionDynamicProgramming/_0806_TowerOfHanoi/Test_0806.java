package c08_RecursionDynamicProgramming._0806_TowerOfHanoi;
import static java.lang.System.out;

import util.StackPrinter;
public class Test_0806 {
	
	private static final int NUM_TOWERS = 3;
	
	public static void main(String[] args) {
		
		{
			
			int numPlates = 5;
			
			TowerOfHanoi[] towers = new TowerOfHanoi[NUM_TOWERS];
			for(int i = 0; i < NUM_TOWERS; i++) {
				towers[i] = new TowerOfHanoi(i);
			}
			
			for( int i = numPlates -1; i >=0; i-- ) {
				towers[0].add(i);
			}
			out.println("before: ");
			printTowers(towers);
			
			towers[0].moveDisks(numPlates, towers[2], towers[1]);
			
			out.println("after: ");
			printTowers(towers);
		
		}
		
		out.println("end");
		
	}
	
	public static void printTowers(TowerOfHanoi[] towers) {
		
		int size = towers.length;
		
		for(int i = 0 ; i < size; i++) {
			out.println("tower " + i);
			StackPrinter.print(towers[i].getStack());
		}
		
	}

}


