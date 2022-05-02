package c04_TreesAndGraphs.p11_RandomNode;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
public class Test_RandomNode {

	public static void main(String[] args) {
		
		HashSet<String> options = new HashSet( Arrays.asList( "2" ) );
		
		int testNumber = 1000;
		
		if( options.contains("1") ) {
			out.println("- - - -RandomNode_01_randomRankEachCall");
			RandomNode_01_randomRankEachCall root = new RandomNode_01_randomRankEachCall( 4 );
			Arrays.asList(2, 1, 3, 6, 5, 7).forEach( key -> root.insertInOrder(key) );
			
			
			HashMap<Integer, Integer> dataToCount = new HashMap<>();
			for( int i = 0; i < testNumber; i++ ) {
				RandomNode_01_randomRankEachCall node = root.getRandomNode();
				int key = node.data;
				if( dataToCount.containsKey(key) ) {
					dataToCount.put( key, dataToCount.get(key) + 1 );
				}
				else {
					dataToCount.put( key, 1 );
				}
			}
			
			dataToCount.forEach( (data, count) -> out.printf( "{data:%4d, count:%4d}", data, count ));
		}
		
		
		if( options.contains("2") ) {
			out.println("- - - -RandomNode_02_randomRankOneCall");
			RandomNode_02_randomRankOneCall root = new RandomNode_02_randomRankOneCall( 4 );
			Arrays.asList(2, 1, 3, 6, 5, 7).forEach( key -> root.insertInOrder(key) );
			
			
			HashMap<Integer, Integer> dataToCount = new HashMap<>();
			for( int i = 0; i < testNumber; i++ ) {
				RandomNode_02_randomRankOneCall node = root.getRandomNode();
				int key = node.data;
				if( dataToCount.containsKey(key) ) {
					dataToCount.put( key, dataToCount.get(key) + 1 );
				}
				else {
					dataToCount.put( key, 1 );
				}
			}
			
			dataToCount.forEach( (data, count) -> out.printf( "{data:%4d, count:%4d}", data, count ));
		}
		
	}
	

}


