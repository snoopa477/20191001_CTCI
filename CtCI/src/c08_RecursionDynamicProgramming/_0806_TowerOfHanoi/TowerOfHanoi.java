package c08_RecursionDynamicProgramming._0806_TowerOfHanoi;
import static java.lang.System.out;

import java.util.Stack;
public class TowerOfHanoi {
	
	private Stack<Integer> disks;
	private int index;
	
	public TowerOfHanoi( int i ) {
		disks = new Stack<>();
		index = i;
	}
	
	public int index() {
		return index;
	}
	
	public void add(int d) {
		
		if(!disks.isEmpty() && disks.peek() <= d) {
			out.println("Error placing disk "  + d);
		}
		else {
			disks.push(d);
		}
		
	}
	
	public void moveTopTo(TowerOfHanoi t) {
		int top = disks.pop();
		t.add(top);
	}
	
	
	public void moveDisks(int n, TowerOfHanoi destination, TowerOfHanoi buffer) {
		if(n > 0) {
			
			moveDisks(n - 1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n-1, destination, this);
			
			
		}
	}
	
	public Stack<Integer> getStack(){
		return disks;
	}

}


