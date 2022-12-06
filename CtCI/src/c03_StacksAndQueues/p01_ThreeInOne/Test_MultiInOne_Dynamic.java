package c03_StacksAndQueues.p01_ThreeInOne;
import static java.lang.System.out;
public class Test_MultiInOne_Dynamic {
	
	public static void main(String[] args) throws Exception {
		
		MutiInOne_Dynamic.IS_DEBUG = false;
		
		MutiInOne_Dynamic mio_d = new MutiInOne_Dynamic(3, 4  );
		
		
		out.println("\n - - - ");
		mio_d.showInfo();
		
		mio_d.push(1, 11);
		mio_d.push(1, 12);
		mio_d.push(1, 13);
		mio_d.push(1, 14);
		
		mio_d.push(2, 21);
		mio_d.push(2, 22);
		mio_d.push(2, 23);
		out.println("\n - - - after pushes 4 elts in stack1, 3 elts in stack2");
		mio_d.showInfo();
		
		
		mio_d.push(1, 15);
		out.println("\n - - - after pushes 1 elts in stack1");
		mio_d.showInfo();
		
		
		mio_d.push(1, 16);
		out.println("\n - - - after pushes 1 elts in stack1");
		mio_d.showInfo();
		
		
		mio_d.push(0, 1);
		mio_d.push(0, 2);
		mio_d.push(0, 3);
		out.println("\n - - - after pushes 3 elts in stack0");
		mio_d.showInfo();
		
		mio_d.pop(1);
		mio_d.push(0, 4);
		out.println("\n - - - after pop 1 elt in stack 1, pushes 1 elts in stack0");
		mio_d.showInfo();
		
		//Exception in thread "main" c03_StacksAndQueues.p01_ThreeInOne.FullStackException
		mio_d.push(1,4);
	}

}


