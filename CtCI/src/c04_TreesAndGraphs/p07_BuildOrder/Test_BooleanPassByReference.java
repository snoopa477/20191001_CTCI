package c04_TreesAndGraphs.p07_BuildOrder;
import static java.lang.System.out;
public class Test_BooleanPassByReference {

	public static void main(String[] args) {
	
		Boolean b = true;
		changeBoolean( b );
		//boolean true
		out.println("boolean " + b.toString() );
		
		Boolean b02 = true;
		changeBoolean02( b02 );
		//boolean true
		out.println("boolean " + b02.toString() );
		
		
		Integer i = 1;
		changeInteger( i );
		//Integer 1
		out.println("Integer " + i.toString() );
		
		
		MutableBoolean mutableBoolean = new MutableBoolean();
		mutableBoolean.b = true;
		changeMutableBoolean( mutableBoolean );
		//mutableBoolean false
		out.println("mutableBoolean " + mutableBoolean.b.toString() );
	}
	
	
	
	private static void changeBoolean( Boolean b ) {
		b = false;
	}
	
	
	
	private static void changeBoolean02( Boolean b ) {
		b = new Boolean(false);
	}

	
	
	private static void changeInteger( Integer i ) {
		i = 2;
	}
	
	
	
	private static void changeMutableBoolean( MutableBoolean b ) {
		b.b = false;
	}
	
	
}

class MutableBoolean{
	public Boolean b = false;
}
