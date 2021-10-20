package c10_SortingAndSearching.p02_GroupAnagrams;

import java.util.Arrays;

import static java.lang.System.out;
//20191212(Thur)
public class TestGroupAnagram {

	public static void main(String[] args) {
		
		
		final String[] input_original = {"12345", "asdf", "geoeaijgr", "jifjawe","fdas", "fasd", "fdsa"};
		String[] input;
		
		input= Arrays.copyOf(input_original, input_original.length);
		Arrays.sort(input, new AnagramComparator());
		printArr(input);
		
		input= Arrays.copyOf(input_original, input_original.length);
		Sort.sort(input);
		printArr(input);
		
		
		out.println("AnagramSorter");
		
		input= Arrays.copyOf(input_original, input_original.length);
		printArr(input);
		
		input= Arrays.copyOf(input_original, input_original.length);
		Sort.sort(input);
		printArr(input);
		
		out.println("-----------------my part");
		
		input= Arrays.copyOf(input_original, input_original.length);
		Arrays.sort(input, new MyAnagramComparator());
		printArr(input);
		
		input= Arrays.copyOf(input_original, input_original.length);
		MySort.sort(input);
		printArr(input);
		
		
		out.println("MyAnagramComparator_freq02");
		input= Arrays.copyOf(input_original, input_original.length);
		Arrays.sort(input, new MyAnagramComparator_freq02());
		printArr(input);
		
		input= Arrays.copyOf(input_original, input_original.length);
		printArr(input);
		
		
		out.println("MyAnagramSorter_freq02");
		input= Arrays.copyOf(input_original, input_original.length);
		input = MyAnagramSorter_freq02.sort(input);
		printArr(input);
		
		input= Arrays.copyOf(input_original, input_original.length);
		printArr(input);
		
		out.println("end");
		
		
	}
	
	public static void printArr(String[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			out.printf("%s ", arr[i]);
		}
		out.println();
		
	}

}
