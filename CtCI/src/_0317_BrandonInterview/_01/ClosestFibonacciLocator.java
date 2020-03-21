package _0317_BrandonInterview._01;

public class ClosestFibonacciLocator {
	
	private static int MAX_VALUE = 1000000;
	
	private Fibonacci fibonacci;
	
	public ClosestFibonacciLocator() {
		fibonacci = new Fibonacci(MAX_VALUE);
	}
	
	public int getClosestDistanceToFibonacci(int key) {
		
		int left_bound = quasi_binarySearch(key);
		int right_bound = left_bound + 1;
		
		return Math.min( key - fibonacci.get(left_bound)
				, fibonacci.get(right_bound) - key);
		
	}
	
	private int quasi_binarySearch(int key) {
		int left_index = 0;
		int right_index = fibonacci.getMaxIndex();
		int middle_index = 0;
		
		while( left_index <= right_index ) {
			middle_index = left_index + (right_index - left_index)/2;
			
			int middle_value = fibonacci.get(middle_index);
			
			if( middle_value == key) {
				return middle_index;
			}
			else if( middle_value < key ) {
				left_index = middle_index + 1;
			}
			else {
				right_index = middle_index -1;
			}
			
		}
		//get RL, 
		
		return right_index;
		
	}
	
}
