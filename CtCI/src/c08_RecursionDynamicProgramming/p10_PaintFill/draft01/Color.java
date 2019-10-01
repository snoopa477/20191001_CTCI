package c08_RecursionDynamicProgramming.p10_PaintFill.draft01;

//2019 09 17(Tue)
// 今天總是都弄懂了

//https://cms.35g.tw/coding/java-enum-example/
//https://openhome.cc/Gossip/JavaEssence/Enum.html
//https://stackoverflow.com/questions/13659217/where-is-the-documentation-for-the-values-method-of-enum

public enum Color {
	
	//imagine: Color Red = new Color("R");
	
	Red("R"),
	Orange("O"),
	Yellow("Y"),
	Green("G"),
	Blue("B"),
	Indigo("I"),
	Purple("P"),
	White("-");
	
	
	private String abbreviatoin;

	public String getAbbreviatoin() {
		return abbreviatoin;
	}

	public void setAbbreviatoin(String abbreviatoin) {
		this.abbreviatoin = abbreviatoin;
	}

	//寫public會有error
	//Illegal modifier for the enum constructor; only private is permitted.
	private Color(String abbreviatoin) {
		this.abbreviatoin = abbreviatoin;
	}
	
	
}
