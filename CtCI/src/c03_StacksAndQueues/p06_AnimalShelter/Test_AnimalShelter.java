package c03_StacksAndQueues.p06_AnimalShelter;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//That's inner class, cannot be used in other classes
//import c03_StacksAndQueues.p06_AnimalShelter.AnimalShelter_01_differntQueueSameTimer.Dog;
public class Test_AnimalShelter {

	public static void main(String[] args) {
		
		List<Dog> dogs = getDogs( "dog1", "dog2", "dog3", "dog4" );
		//TYPO
//		List<Dog> cats = getDogs( "cat1", "cat2", "cat3", "cat4" );
		List<Cat> cats = getCats( "cat1", "cat2", "cat3", "cat4" );
		int dogIndex = 0;
		int catIndex = 0;
		
		AnimalShelter_01_differntQueueSameTimer.IS_DEBUG = true;
		
		AnimalShelter_01_differntQueueSameTimer animalSheter = new AnimalShelter_01_differntQueueSameTimer();
		
		animalSheter.addStrayAnimal(dogs.get(dogIndex++));
		
		animalSheter.addStrayAnimal(cats.get(catIndex++));
		
		animalSheter.addStrayAnimal(dogs.get(dogIndex++));
		animalSheter.addStrayAnimal(dogs.get(dogIndex++));
		
		animalSheter.addStrayAnimal(cats.get(catIndex++));
		
		animalSheter.addStrayAnimal(dogs.get(dogIndex++));
		
		animalSheter.addStrayAnimal(cats.get(catIndex++));
		animalSheter.addStrayAnimal(cats.get(catIndex++));
		
		//Now: dog1 cat1 dog2 dog3 cat2 dog4 cat3 cat4
		
		out.println( animalSheter.getAnimalOldest().name );
		out.println( animalSheter.getDogOldest().name );
		out.println( animalSheter.getCatOldest().name );
		out.println( animalSheter.getAnimalOldest().name );
	}
	
	
	
	public static List<Dog> getDogs(String... names) {
		
		ArrayList<Dog> dogs = new ArrayList<>();
		/*
		 No enclosing instance is accessible. Must qualify the allocation with an enclosing 
		 instance of type (e.g. x.new A() where x is an instance of ) [duplicate] 
		 */
		/*
		 Solution
		 https://stackoverflow.com/questions/47541459/no-enclosing-instance-is-accessible-must-qualify-the-allocation-with-an-enclosi
		 You declared you SimpleCircle class as inner class for TestSimpleCircle. You need either 
		 move it into a separate file or declare it as 
		 */
		Arrays.asList(names).forEach(name -> dogs.add( new Dog(name) ));
		
		return dogs;
	}
	
	
	
	public static List<Cat> getCats(String... names) {
		
		ArrayList<Cat> cats = new ArrayList<>();
		Arrays.asList(names).forEach(name -> cats.add( new Cat(name) ));
		
		return cats;
	}
	
	
}


