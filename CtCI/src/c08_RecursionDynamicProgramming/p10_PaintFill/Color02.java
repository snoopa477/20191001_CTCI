package c08_RecursionDynamicProgramming.p10_PaintFill;
import static java.lang.System.out;
public enum Color02 {
	
	/* Imagine
	 * final static Color02 White = new Color02(ordinal = 1, name = "White", symbol = "-");
	 * */
	White("-"), 
	Green("G"), 
	Black("B"), 
	Red("R"), 
	Yellow("Y");
	
	
	private String symbol;

	//DETAIL once I decide to implement this constructor, the following go wrong:
	//The constructor Color02() is undefined
	//White, Green, Black, Red, Yellow;
	private Color02(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
}


