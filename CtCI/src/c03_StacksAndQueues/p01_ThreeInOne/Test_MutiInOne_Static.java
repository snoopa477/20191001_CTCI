package c03_StacksAndQueues.p01_ThreeInOne;
import static java.lang.System.out;
public class Test_MutiInOne_Static {

	public static void main(String[] args) throws Exception {
		
		MutiInOne_Static mio_s = new MutiInOne_Static(3, 4  );
		
		mio_s.showInfo();
		
		mio_s.push(1, 11);
		mio_s.push(1, 12);
		mio_s.push(1, 13);
		mio_s.push(1, 14);
		
		mio_s.push(2, 21);
		mio_s.push(2, 22);
		mio_s.push(2, 23);
		out.println("\n - - - after pushes 4 elts in stack1, 3 elts in stack2");
		mio_s.showInfo();
		
		
		mio_s.pop( 1 );
		mio_s.push(1, 15);
		out.println("\n - - - after pop and pushes 1 elts in stack1");
		mio_s.showInfo();
		
		//FullStackException
		mio_s.push(1, 16);
	}

}


