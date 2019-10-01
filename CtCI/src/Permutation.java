
public class Permutation {
	
	public static void main(String[] args) {
		
		char[] characters= {'a','b','c','d'};
		//char[] characters= {'a','b','c'};
		//char[] characters= {'a','b'};
		
		permutate(characters, characters.length);
		//System.out.println(characters.length);
	}
	
	private static void permutate(char[] characters, int n) {
		if( n > 1 ) {
			
			for(int i =0; i < n ; i++) {
				swap( characters, i, n -1 );
				permutate(characters, n - 1 );
				swap( characters, i, n -1 );
			}
		}
		else if( n == 1 ){
			printCharacters(characters);
		}
		
	}
	
	private static void swap(char[] characters, int indexI, int indexJ) {
		char temporary = characters[indexI];
		characters[indexI] = characters[indexJ];
		characters[indexJ] = temporary;
	}
	
	private static void printCharacters(char[] characters) {
		for(int i=0; i< characters.length; i ++) {
			System.out.printf("%c ", characters[i]);
		}
		System.out.println();
	}
}
