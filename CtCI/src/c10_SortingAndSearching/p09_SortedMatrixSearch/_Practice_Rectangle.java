package c10_SortingAndSearching.p09_SortedMatrixSearch;
import static java.lang.System.out;

//PURPOSE rectangle can be defined by upper left point and down right point
public class _Practice_Rectangle {
	
	//point at upper left side
	private _Practice_Coordinate point_UpLt;
	private _Practice_Coordinate point_DnRt;
	
	
	
	public _Practice_Rectangle(_Practice_Coordinate point_UpLt, _Practice_Coordinate point_DnRt) throws Exception {
		if( point_UpLt.rowCompare(point_DnRt) > 0 || point_UpLt.colCompare(point_DnRt) > 0 ) {
			throw new Exception();
		}
		this.point_UpLt = point_UpLt;
		this.point_DnRt = point_DnRt;
	}



	public _Practice_Coordinate getPoint_UpLt() {
		return point_UpLt;
	}

	
	
	public _Practice_Coordinate getPoint_DnRt() {
		return point_DnRt;
	}

	
	
}


