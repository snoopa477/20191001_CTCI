package c08_RecursionDynamicProgramming._0806_TowerOfHanoi;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import util.StackPrinter;
import java.util.Stack;
public class Test_0806 {
	
	private static final int NUM_TOWERS = 3;
	
	public static void main(String[] args) {
		
		String[] chosenOptions = { "1", "4"};
		HashSet<String> options = new HashSet<>( Arrays.asList(chosenOptions) );
		
		if(options.contains("1"))
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
		
		if(options.contains("2"))
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
		
		if(options.contains("3"))
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
		
		
		if(options.contains("4"))
		{
			out.println("\ncase 4: _Practice_TowerOfHanoi");
			int numPlates = 5;
			_Practice_TowerOfHanoi sourceTower = new _Practice_TowerOfHanoi(numPlates, "A");
			_Practice_TowerOfHanoi bufferTower = new _Practice_TowerOfHanoi("B");
			_Practice_TowerOfHanoi destTower = new _Practice_TowerOfHanoi("C");
			
			
			out.println("before: ");
			out.print("sourceTower: ");
			sourceTower.printDisks();
			out.print("bufferTower: ");
			bufferTower.printDisks();
			out.print("destTower: ");
			destTower.printDisks();
			
			
			sourceTower.moveDisksToTower(5, destTower, bufferTower);
			
			out.println("after: ");
			out.print("sourceTower: ");
			sourceTower.printDisks();
			out.print("bufferTower: ");
			bufferTower.printDisks();
			out.print("destTower: ");
			destTower.printDisks();
		
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


