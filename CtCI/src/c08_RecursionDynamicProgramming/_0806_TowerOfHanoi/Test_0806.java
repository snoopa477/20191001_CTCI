package c08_RecursionDynamicProgramming._0806_TowerOfHanoi;
import static java.lang.System.out;
import java.util.ArrayList;
import util.StackPrinter;
import java.util.Stack;
public class Test_0806 {
	
	private static final int NUM_TOWERS = 3;
	
	public static void main(String[] args) {
		
		{
			out.println("case 1: textbook");
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
		
		{
			out.println("\ncase 2: My_TowersOfHanoi");
			int numPlates = 5;
			My_TowersOfHanoi towersOfHanoi = new My_TowersOfHanoi(numPlates);
			
			
			out.println("before: ");
			printTowers(towersOfHanoi.getTowers());
			
			towersOfHanoi.movePlates(2);
			
			out.println("after: ");
			printTowers(towersOfHanoi.getTowers());
		
		}
		
		{
			out.println("\ncase 3: My_TowersOfHano2");
			int numPlates = 5;
			My_TowerOfHanoi_2 towersOfHanoi = new My_TowerOfHanoi_2(numPlates);
			
			
			out.println("before: ");
			printTowers(towersOfHanoi.getTowers());
			
			towersOfHanoi.moveTower( 2 );
			
			out.println("after: ");
			printTowers(towersOfHanoi.getTowers());
		
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
	
	public static void printTowers(ArrayList<Stack<Integer>> towers) {
		
		int size = towers.size();
		
		for(int i = 0 ; i < size; i++) {
			out.println("tower " + i);
			StackPrinter.print(towers.get(i));
		}
	}

}


