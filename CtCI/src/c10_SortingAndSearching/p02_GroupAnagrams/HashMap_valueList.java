package c10_SortingAndSearching.p02_GroupAnagrams;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashMap_valueList<K,E> {
	//K for key, E for list element
	
	private HashMap<K, ArrayList<E>> map_valueList = new HashMap<>();
	
	public void put( K key, E listElement ) {
		
		if( map_valueList.containsKey(key) == false) {
			map_valueList.put( key, new ArrayList<>() );
			map_valueList.get(key).add( listElement );
		}
		else {
			map_valueList.get(key).add(listElement);
		}
	}
	
	
	public void put( K key, ArrayList<E>  list) {
		map_valueList.put(key, list);
	}
	
	
	public boolean contains( K key) {
		return map_valueList.containsKey(key);
	}
	
	
	public boolean contains( K key, E listElement) {
		
		if( map_valueList.containsKey(key) == false ) {
			return false;
		}
		
		return map_valueList.get( key ).contains(listElement);
	}
	
	
	public ArrayList<E> get( K key ){
		return map_valueList.get(key);
	}
	
	
	public Set<K> keySet(){
		return map_valueList.keySet();
	}
	
	
	@Override
	public String toString() {
		return map_valueList.toString();
	}
	

}


