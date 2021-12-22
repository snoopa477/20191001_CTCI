package c10_SortingAndSearching.p02_GroupAnagrams;

import java.util.Arrays;
import java.util.HashSet;

import static java.lang.System.out;
//20191212(Thur)
public class TestGroupAnagram {

	public static void main(String[] args) {
		
		
		final String[] input_original = {"12345", "asdf", "geoeaijgr", "jifjawe","fdas", "13524", "fasd", "fdsa"};
		String[] input;
		
		
		String[] chosenOptions = { "1", "5", "6"};
		HashSet<String> options = new HashSet<>( Arrays.asList(chosenOptions) );
		
		if(options.contains("1")) {}
		/*
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
		printArr(input);*/
		
		
		
		if(options.contains("5")) {
			out.println("\n_Practice_GroupAnagrams_way01_Sorting");
			out.println("before");
			printArr(input_original);
			String[] results = _Practice_GroupAnagrams_way01_Sorting.group(input_original);
			out.println("after");
			printArr(results);
		}
		
		if(options.contains("6")) {
			out.println("\n_Practice_GroupAnagrams_way02_map");
			out.println("before");
			printArr(input_original);
			String[] results = _Practice_GroupAnagrams_way01_Sorting.group(input_original);
			out.println("after");
			printArr(results);
		}
		
		out.println("end");
		
		
	}
	
	public static void printArr(String[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			out.printf("%s ", arr[i]);
		}
		out.println();
		
	}

}
