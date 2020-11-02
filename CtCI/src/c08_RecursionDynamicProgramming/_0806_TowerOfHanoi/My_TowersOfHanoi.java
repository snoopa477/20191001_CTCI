package c08_RecursionDynamicProgramming._0806_TowerOfHanoi;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Stack;
public class My_TowersOfHanoi {
	
	private final static int NUM_TOWERS = 3;
	
	//private Stack<Integer>[] towers;
	private ArrayList<Stack<Integer>> towers;
	
	private int numOfPlates;

	public My_TowersOfHanoi(int numOfPlates) {
		
		this.numOfPlates = numOfPlates;
		
		//Cannot create a generic array of Stack<Integer>
		//towers = new Stack<Integer>[NUM_TOWERS];
		towers = new ArrayList<>();
		for(int i = 0 ; i < NUM_TOWERS; i++) {
			towers.add( new Stack<>() );
		}
		
		Stack<Integer> tower_0 = towers.get(0);
		
		for(int plateIndex = numOfPlates-1; plateIndex >= 0; plateIndex--) {
			tower_0.push(plateIndex);
		}
	}
	
	public void movePlates(int dest_towerIndex) {
		int source_towerIndex = 0;
		
		switch( dest_towerIndex ) {
		case 0:
			return;
		case 1:
			movePlates( numOfPlates, source_towerIndex , dest_towerIndex, 2  );
			//don't forget return!
			return;
		case 2:
			movePlates( numOfPlates, source_towerIndex , dest_towerIndex, 1  );
			return;
		default:
			out.println("Error destTowerIndex");
			return;
		}
		
	}
	
	public void movePlates( int numPlates, int source_TowerIndex, int dest_towerIndex, int temp_towerIndex  ) {
		
		//base case
		if(numPlates == 0) {
			return ;
		}
		
		movePlates(numPlates -1 , source_TowerIndex, temp_towerIndex, dest_towerIndex);
		moveTopPlate(source_TowerIndex, dest_towerIndex);
		//moveTopPlate(numPlates -1, source_TowerIndex, dest_towerIndex);
		movePlates(numPlates -1 , temp_towerIndex, dest_towerIndex, source_TowerIndex);
		
	}
	
	public void moveTopPlate(int source_TowerIndex, int dest_TowerIndex) {
	//public void moveTopPlate(int numPlate, int source_TowerIndex, int dest_TowerIndex) {
		
		
		
		Stack<Integer> dest_tower = towers.get(dest_TowerIndex);
		Stack<Integer> source_tower = towers.get(source_TowerIndex);
		
		/*
		if( source_tower.isEmpty() == false 
			&& ( (dest_tower.isEmpty() == false && source_tower.peek() > dest_tower.peek())
					|| (dest_tower.isEmpty() ))) {
			int plate = source_tower.pop();
			dest_tower.push(plate);
		}
		else {
			out.println("Error placing plate ");
		}
		*/
		
		int plate = source_tower.pop();
		dest_tower.push(plate);
		
	
	}
	
	public Stack<Integer> getTower(int index){
		return towers.get(index);
	}
	
	public ArrayList<Stack<Integer>> getTowers(){
		return towers;
	}
	
	

}


