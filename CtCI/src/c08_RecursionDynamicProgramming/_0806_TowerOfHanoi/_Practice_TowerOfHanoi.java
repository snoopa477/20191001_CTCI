package c08_RecursionDynamicProgramming._0806_TowerOfHanoi;
import static java.lang.System.out;

import java.util.Stack;
public class _Practice_TowerOfHanoi {

	private static final boolean IS_DEBUG_ON = false;
	//PURPOSE: to differentiate between towers.
	private String tag;
	
	private Stack<Integer> tower = null;

	public _Practice_TowerOfHanoi(String tag) {
		this.tag = tag;
		//MISTAKE don't miss this line
		this.tower = new Stack<>();
	}
	
	
	
	/**
	 * create Hanoi tower of number of given number of disks
	 */
	public _Practice_TowerOfHanoi(int numberOfDisk, String tag) {
		this.tag = tag;
		//MISTAKE
		this.tower = new Stack<>();
		//MISTAKE: >= 0 => total number is numberOfDisk + 1
		//for(int diskIndex = numberOfDisk; diskIndex >=0; diskIndex--) {
		for(int diskIndex = numberOfDisk; diskIndex >=1; diskIndex--) {
			//make use of method we've defined
			tower.add(diskIndex);
		}
		
	}
	
	
	
	//PURPOSE define basic operation, meeting Hanoi definition
	public void add(int diskIndex) {
		
		if( tower.isEmpty() ) {
			tower.add(diskIndex);
			//WRONG missing this line would cause whole program to go wrong 
			return ;
		}
		
		//PURPOSE check if diskIndex meet Hanoi definition
		//DETAIL before using peek(), check if exist. as if we're a[i].peek()
		/*REPLACED we check isEmpty before reaching here, meaning that here must not be empty
		 * if( tower.isEmpty() == false && tower.peek() >= diskIndex ) {
		 */
		if( tower.peek() >= diskIndex ) {
			tower.add(diskIndex);
		}
		else {
			out.println("it's invalid operation because disk you're tring to add is bigger than top of Hanoi tower's disk. top disk " + tower.peek() + " disk to add " + diskIndex);
		}
	}
	
	
	
	/**
	 * DETAIL 'this' is sourceTower, which is implicit and invisible
	 * PURPOSE move number of disks from sourceTower, to destTower, which means we ultimately pops n disks from sourceDisk, and add n disks to destTower. 
	 * bufferTower is used to place disks we won't use it yet. 
	 */
	public void moveDisksToTower( int numberOfDisks, _Practice_TowerOfHanoi destTower, _Practice_TowerOfHanoi bufferTower ) {
		
		//base case
		if( numberOfDisks == 0 ) {
			return ;
		}
		
		if(IS_DEBUG_ON) {
			out.print("tower " + tag + " :");
			printDisks();
		}
		
		/*PURPOSE
		 * based on Hanoi definition, we have to place bottom disk to destTower. we place disks that's above bottom disk to somewhere temporarily
		 */
		
		
		//PURPOSE we place disks that's above bottom disk to bufferTowre temporarily
		//DETAIL 'this' can be omitted of course, but I want to remind myself there 3 towers take participate int this Hanoi moving
		this.moveDisksToTower(numberOfDisks - 1, bufferTower, destTower);
		//REASONING now, the last disk's above has nothing left, we may move it from Source to dest 
		this.moveTopDiskToTower( destTower );
		//PURPOSE once bottom disk is moved, it's now to handle disks I've placed aside
		bufferTower.moveDisksToTower(numberOfDisks - 1, destTower, this);
		
	}

	
	
	private void moveTopDiskToTower(_Practice_TowerOfHanoi destTower) {
		
		if(this.tower.isEmpty() == true ) {
			return ;
		}
		int topDiskIndex = this.tower.pop();
		destTower.add(topDiskIndex);
	}
	
	
	
	//I don't know if I should, since the operation is inefficient
	public void printDisks() {
		Stack<Integer> buffer = new Stack<>();
		
		while( tower.isEmpty() == false ) {
			out.print(" " + tower.peek());
			buffer.add(tower.pop());
		}
		
		//put it back
		while( buffer.isEmpty() == false ) {
			tower.add(buffer.pop());
		}
		out.println();
		
	}
	
	
	
}


