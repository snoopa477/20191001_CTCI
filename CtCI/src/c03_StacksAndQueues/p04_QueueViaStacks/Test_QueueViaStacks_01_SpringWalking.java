package c03_StacksAndQueues.p04_QueueViaStacks;
import static java.lang.System.out;
public class Test_QueueViaStacks_01_SpringWalking {

	public static void main(String[] args) {
		
		QueueViaStacks_01_SpringWalking.IS_DEBUG = true;
		
		QueueViaStacks_01_SpringWalking queue = new QueueViaStacks_01_SpringWalking();
		
		out.println("add(1)");
		queue.add(1);
		out.println("add(2)");
		queue.add(2);
		out.println("add(3)");
		queue.add(3);
		
		out.println("remove() " + queue.remove());
		
		out.println("add(4)");
		queue.add(4);
		out.println("add(5)");
		queue.add(5);
		
		out.println("remove() " + queue.remove());
		out.println("remove() " + queue.remove());
		out.println("remove() " + queue.remove());
		
		out.println("size() " + queue.size());
		
	}

}


