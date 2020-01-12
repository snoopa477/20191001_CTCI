package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

//20191218(Wed
//如果是自己寫的話, 問題在於
//記不起來全部應該要declare and implementation的function
//也許, 我可以自己用個interface
public class HashMapList<T, E> {

	private HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();
	
	//insert item into list at key
	//這是map從來都沒有的行為, 是新增出來的
	public void put(T key, E item) {
		
		if(!map.containsKey(key)) {
			map.put(key, new ArrayList<E>() );
		}
		map.get(key).add(item);
	}
	
	//insert list of items at key
	//這樣是把過去的value給取代掉; 也符合map 的行為
	public void put(T key, ArrayList<E> items) {
		map.put(key, items);
	}
	
	//get list of items at key
	public ArrayList<E> get(T key){
		return map.get(key);
	}
	
	//check if hashMapList contains key
	public boolean containsKey(T key) {
		return map.containsKey(key);
	}
	
	//check if list at key contains value
	public boolean containsKeyValue(T key, E value) {
		ArrayList<E> list = get(key);
		if(list == null)
			return false;
		return list.contains(value);
	}
	
	//get the list of keys
	public Set<T> keySet(){
		return map.keySet();
	}
	
	@Override
	public String toString() {
		return map.toString();
	}
	
}
