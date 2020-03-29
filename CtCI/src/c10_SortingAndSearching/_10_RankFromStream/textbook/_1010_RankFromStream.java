package c10_SortingAndSearching._10_RankFromStream.textbook;

public class _1010_RankFromStream {

	RankNode root = null;
	
	public void track(int number) {
		
		if( root == null) {
			root = new RankNode(number);
		}
		else {
			root.insert(number);
		}
	}
	
	int getRankOfNumber(int number) {
		return root.getRank(number);
	}
	
}
