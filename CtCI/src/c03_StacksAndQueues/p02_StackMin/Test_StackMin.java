package c03_StacksAndQueues.p02_StackMin;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;

import c03_StacksAndQueues.p01_ThreeInOne.EmptyStackException;

public class Test_StackMin {

	public static void main(String[] args) throws EmptyStackException {
		
		int[] inputs = { 5, 6, 3, 7 };
		
		HashSet<String> options = new HashSet<>( Arrays.asList(new String[] {"1", "2", "3"} ) );
		
		
		if( options.contains("1") ) {
			out.println("\n-----------------StackMin_01_timeCapsule");
			StackMin_01_timeCapsule s01t = new StackMin_01_timeCapsule();
			for( int input : inputs ) {
				out.println("\npush " + input + " element to stack");
				s01t.push( input );
				out.println("now the min is " + s01t.min() );
			}
			
			while( s01t.isEmpty() == false ) {
				NodeWithMin nodeWithMin =  s01t.pop();
				out.println("\npopped value " + nodeWithMin.value);
				out.println("now the min is " + nodeWithMin.min );
			}
		}
		
		
		if( options.contains("2") ) {
			out.println("\n-----------------StackMin_02_timeCapsule");
			StackMin_02_timeCapsule s02t = new StackMin_02_timeCapsule();
			for( int input : inputs ) {
				out.println("\npush " + input + " element to stack");
				s02t.push( input );
				out.println("now the min is " + s02t.min() );
			}
			
			while( s02t.isEmpty() == false ) {
				out.println("now the min is " + s02t.min() );
				out.println("\npopped value " + s02t.pop());
			}
		}
		
		
		if( options.contains("3") ) {
			out.println("\n-----------------StackMin_03_sharedMin");
			StackMin_03_sharedMin s03s = new StackMin_03_sharedMin();
			for( int input : inputs ) {
				out.println("\npush " + input + " element to stack");
				s03s.push( input );
				out.println("now the min is " + s03s.min() );
			}
			
			while( s03s.isEmpty() == false ) {
				out.println("now the min is " + s03s.min() );
				out.println("\npopped value " + s03s.pop());
			}
		}
		
	}

}


