package c08_RecursionDynamicProgramming.p10_PaintFill;

//�ڪ��Q���O, Black�OReference var name; ���̥������ӬOdeclare�bclass���~��. 
//���Lenum�O�S��;
//�N��@�Oenum �O�S��class, �i�H���[�ۤv
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
