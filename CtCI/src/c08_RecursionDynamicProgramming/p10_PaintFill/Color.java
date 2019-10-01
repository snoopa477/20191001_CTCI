package c08_RecursionDynamicProgramming.p10_PaintFill;

//我的想像是, Black是Reference var name; 它們本來應該是declare在class之外的. 
//不過enum是特例;
//就當作是enum 是特殊class, 可以內涵自己
public enum Color {
	
	//it's equivalent syntax would be like:
	//and we remove the word 'Color', 'new', '=', 
	//replacing ';' with ',' indicating it's enumerating.
	
	//Color Black = new Color("B");
	//Color White = new Color("-");
	//Color Red = new Color("R");
	//Color Yellow = new Color("Y");
	//Color Green = new Color("G");
	
	Black("B"), 
	White("-"), 
	Red("R"), 
	Yellow("Y"), 
	Green("G");
	
	private String str;
	
	Color(String str) {
		this.str = str;
	}
	
	public String str() {
		return str;
	}
	

}
