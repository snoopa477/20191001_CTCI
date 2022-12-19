package c03_StacksAndQueues.p06_AnimalShelter;
import static java.lang.System.out;

abstract class Animal{
	
	//DETAIL: it's private because subclass will never use it when instantiation
	private int sequenceOfNewComer;
	
	//private String name;
	//DETAIL: it's protected because this is gonna used in subclass when instantiation
	protected String name;
	
	Animal( String name) {
		this.name = name;
		this.sequenceOfNewComer = 0;
	}

	//WRONG: we don't know the sequence beforehand. We know it only when it is add to shelter
//	public Animal(int sequenceOfNewComer, String name) {
//		super();
//		this.sequenceOfNewComer = sequenceOfNewComer;
//		this.name = name;
//	}
	
	
//	public int getSequenceOfNewComer() {
//		return sequenceOfNewComer;
//	}
	//REASONING: we have more specific use: compare. So general method getSequennce is not needed
	//WRONG: correction: if seq1 > seq2, seq1 is "older"
	public boolean isNewerThan( Animal otherAnimal ) {
		//return this.sequenceOfNewComer < otherAnimal.sequenceOfNewComer;
		return this.sequenceOfNewComer > otherAnimal.sequenceOfNewComer;
	}

	
	
	public void setSequenceOfNewComer(int sequenceOfNewComer) {
		this.sequenceOfNewComer = sequenceOfNewComer;
	}
	
	
}
