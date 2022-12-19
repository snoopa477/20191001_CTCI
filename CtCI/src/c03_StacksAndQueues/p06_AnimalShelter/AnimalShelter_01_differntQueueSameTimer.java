package c03_StacksAndQueues.p06_AnimalShelter;
import static java.lang.System.out;

import java.util.LinkedList;
import java.util.Queue;
public class AnimalShelter_01_differntQueueSameTimer {
	
	public static boolean IS_DEBUG = false;
	
	private Queue<Dog> dogs;
	private Queue<Cat> cats;
	private int sequenceOfNewComer;
	
	
	
	public AnimalShelter_01_differntQueueSameTimer() {
		dogs = new LinkedList<>();
		cats = new LinkedList<>();
		sequenceOfNewComer = 0;
	}
	
	
	public void addStrayAnimal( Animal animal ) {
		
		animal.setSequenceOfNewComer(sequenceOfNewComer);
		sequenceOfNewComer++;
		
		if( animal instanceof Dog ) {
			if( IS_DEBUG ) out.println("animal instanceof Dog, seq=" + sequenceOfNewComer);
			dogs.add( (Dog) animal );
		}
		else {
			if( IS_DEBUG ) out.println("animal instanceof Cat, seq=" + sequenceOfNewComer);
			cats.add( (Cat) animal );
		}
		
	}


	
	//IMAGINATION: it's similar to merge sort
	public Animal getAnimalOldest() {
		
		Animal dogOldest = dogs.peek();
		Animal catOldest = cats.peek();
		//Animal animalOldest = dogOldest.isNewerThan(catOldest) ? catOldest : dogOldest;
		Animal animalOldest = dogOldest.isNewerThan(catOldest) ? (Animal)cats.poll() : (Animal)dogs.poll();
		
		return animalOldest;
	}
	
	
	
	//REASONING: the queue data structure ensures the removed one is the oldest
	public Dog getDogOldest() {
		return dogs.remove();
	}
	
	
	
	public Cat getCatOldest() {
		return cats.remove();
	}
		

}







