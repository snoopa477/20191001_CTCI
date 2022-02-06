package c10_SortingAndSearching.p10_RankFromStream.textbook;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;

public class Test_RankFromStream {

	public static void main(String[] args) {
		
		HashSet<String> options = new HashSet<String>( Arrays.asList("1", "2") );
		
		if( options.contains("1") ){
			out.println("_1010_RankFromStream\n");
			
			int[] stream = {5, 1, 4, 4, 5, 9, 7, 13, 3};
			
			_1010_RankFromStream rfs = new _1010_RankFromStream();
			for(int elt: stream) {
				rfs.track(elt);
			}
			
			for( int elt : stream ) {
				out.println( elt + " : " + rfs.getRankOfNumber(elt));
			}
			out.println( 99 + " : " + rfs.getRankOfNumber(99));
			out.println( 12 + " : " + rfs.getRankOfNumber(12)); 
		}
		
		
		
		if( options.contains("2") ){
			out.println("_Practice_RankNode\n");
			
			int[] stream = {5, 1, 4, 4, 5, 9, 7, 13, 3};
			
			_Practice_RankNode rfs = new _Practice_RankNode( stream[0] );
			for( int i = 1; i < stream.length; i++ ) {
				rfs.insert(stream[i]);
			}
			
			for( int elt : stream ) {
				out.println( elt + " : " + rfs.getRank(elt));
			}
			out.println( 99 + " : " + rfs.getRank(99));
			out.println( 12 + " : " + rfs.getRank(12)); 
		}
		
		
		
	}

}
