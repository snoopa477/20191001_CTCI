package c08_RecursionDynamicProgramming._0806_TowerOfHanoi;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Stack;
public class My_TowerOfHanoi_2 {
	
	final static int NUM_TOWERS = 3;
	
	private int numDisks;
	private ArrayList<Stack<Integer>> towers;

	public My_TowerOfHanoi_2(int numDisks) {
		
		this.numDisks = numDisks;
		towers = new ArrayList<>();
		for(int i = 0; i < NUM_TOWERS; i++) {
			towers.add( new Stack<>() );
		}
		
		for(int i = 0; i < numDisks; i++) {
			//error
			//towers.get(0).push( numDisks - i );
			towers.get(0).push( numDisks - i );
		}
		
	}
	
	public void moveTower(int indexOfTower) {
		
		switch(indexOfTower) {
		case 0:
			return ;
		case 1:
			moveTower(numDisks, towers.get(0), towers.get(1), towers.get(2));
			return;
		case 2:
			moveTower(numDisks, towers.get(0), towers.get(2), towers.get(1));
			return;
			default:
				out.println("error indexing");
		}
		
	}
	
	
	public void moveTower(int numDisks, Stack<Integer> srcTower,  Stack<Integer> destTower,  Stack<Integer> bufferTower) {
		
		if(numDisks == 0) {
			return;
		}
		
		moveTower(numDisks -1, srcTower, bufferTower, destTower);
		moveDisk(numDisks, srcTower, destTower);
		moveTower(numDisks -1 , bufferTower, destTower, srcTower);
		
	}


	private void moveDisk(int numDisks, Stack<Integer> srcTower, Stack<Integer> destTower) {
		
		int disk = srcTower.pop();
		destTower.push(disk);
		
	}
	
	public ArrayList<Stack<Integer>> getTowers(){
		return towers;
	}
	
	
	
}


