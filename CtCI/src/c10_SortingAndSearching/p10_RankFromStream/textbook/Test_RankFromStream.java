package c10_SortingAndSearching.p10_RankFromStream.textbook;

import static java.lang.System.out;

public class Test_RankFromStream {

	public static void main(String[] args) {
		
		{
			
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
		
	}

}
