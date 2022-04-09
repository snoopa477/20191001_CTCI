package c04_TreesAndGraphs.p07_BuildOrder;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;

import c04_TreesAndGraphs.p07_BuildOrder._0407_00_BuildOrder.Project;
import util.MyStack;
public class Test_BuildOrder {

	public static void main(String[] args) {
		
	
		HashSet<String> options = new HashSet( Arrays.asList( "4" ) );
		
		String[] projects01 = { "A", "B", "C", "D", "E", "F", "G" };
		String[][] dependnecies01 = { 
				{"F", "C"}, { "F", "A" }, { "F", "B" }, { "C", "A" }
				, { "B", "A" }, { "B", "E" }, { "A", "E" }, { "D", "G" } };
		
		String[] projects02 = { "A", "B", "C", "D", "E", "F" };
		String[][] dependnecies02 = { 
				{"F", "A"}, { "F", "B" }, { "A", "D" }, { "B", "D" }
				, { "D", "C" } };
		
		
		//This has cycle
		String[] projects03 = { "A", "B", "C", "D", "E", "F", "G" };
		String[][] dependnecies03 = { 
				{"F", "C"}, { "F", "A" }, { "F", "B" }, { "C", "A" }
				, { "B", "A" }, { "B", "E" }, { "A", "E" }, { "D", "G" }, { "A", "F"} };
		
		if(options.contains("1")) {
			
			out.println("test _0407_00_BuildOrder ------------------- ");
			
			_0407_00_BuildOrder buildOrderer01 = new _0407_00_BuildOrder();
			Project[] order01 = buildOrderer01.findBuildOrder( projects01, dependnecies01 );
			Arrays.asList( order01 ).forEach( node -> out.printf("%s ", node.getName()) );
			out.println();
			
			_0407_00_BuildOrder buildOrderer02 = new _0407_00_BuildOrder();
			Project[] order02 = buildOrderer02.findBuildOrder( projects02, dependnecies02 );
			Arrays.asList( order02 ).forEach( node -> out.printf("%s ", node.getName()) );
			out.println();
			
		}
		
		if(options.contains("2")) {
			
			out.println("test _0407_01_BuildOrder ------------------- ");
			
			_0407_01_BuildOrder buildOrderer01 = new _0407_01_BuildOrder();
//			buildOrderer01.findBuildOrder(projects01, dependnecies01);
			MyStack< c04_TreesAndGraphs.p07_BuildOrder._0407_01_BuildOrder.Project > order01 
				= buildOrderer01.findBuildOrder( projects01, dependnecies01 );
			while( order01.isEmpty() == false ) {
				out.printf("%s ", order01.pop().getName());
			}
			
			out.println();
			
			_0407_01_BuildOrder buildOrderer02 = new _0407_01_BuildOrder();
			MyStack< c04_TreesAndGraphs.p07_BuildOrder._0407_01_BuildOrder.Project > order02 
				= buildOrderer02.findBuildOrder( projects02, dependnecies02 );
			while( order02.isEmpty() == false ) {
				out.printf("%s ", order02.pop().getName());
			}
			out.println();
		}
		if(options.contains("3")) {
			
			out.println("test BuildOrder_01_Status ------------------- ");
			out.println("test graph01 - - - - - - - - - - -");
			String[] buildOrder = BuildOrder_01_Status.buildOrder(projects01, dependnecies01);
			if( buildOrder != null ) {
				Arrays.asList(buildOrder).forEach(str -> out.printf("%s ", str));
			}
			else {
				out.println("empty");
			}
			
			out.println("\n\ntest graph03 - - - - - - - - - - -");
			buildOrder = BuildOrder_01_Status.buildOrder(projects03, dependnecies03);
			if( buildOrder != null ) {
				Arrays.asList(buildOrder).forEach(str -> out.printf("%s ", str));
			}
			else {
				out.println("empty");
			}
			out.println();
			
			
		}
		
		
		if(options.contains("4")) {
			
			out.println("test BuildOrder_02_Depednecy ------------------- ");
			out.println("test graph01 - - - - - - - - - - -");
			String[] buildOrder = BuildOrder_02_Depednecy.buildOrder(projects01, dependnecies01);
			if( buildOrder != null ) {
				Arrays.asList(buildOrder).forEach(str -> out.printf("%s ", str));
			}
			else {
				out.println("empty");
			}
			
			out.println("\n\ntest graph03 - - - - - - - - - - -");
			buildOrder = BuildOrder_02_Depednecy.buildOrder(projects03, dependnecies03);
			if( buildOrder != null ) {
				Arrays.asList(buildOrder).forEach(str -> out.printf("%s ", str));
			}
			else {
				out.println("empty");
			}	
			out.println();
			
			
		}
		
	}

}





