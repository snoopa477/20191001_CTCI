package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

//20191219(Thur
//visualize:
// 有兩層關係: 
//1. key to value(list
//2. list to element
//因此, 往往要access element之前, 得先詢問有沒有list 的存在
//不然, 會犯下nullPointerException的錯誤
public class MyHashMapList<K,V> {
	
	private HashMap<K, ArrayList<V>> hashMapList = new HashMap<>();
	
	public void put(K key, V valueElement) {
		
//		if(hashMapList.containsKey(key) == false) {
//			hashMapList.put(key, new ArrayList<V>());
//			hashMapList.get(key).add(value);
//		}
//		else {
//			hashMapList.get(key).add(value);
//		}
		
		//我認為這段code不是一蹴可幾, 是要經過上面的code之後; 才會達到這個境界
		//先complete logic再concise code
		//但課本都是一步到位, 讓人誤導以為這是常人可以做到的
		if(hashMapList.containsKey(key) == false) {
		hashMapList.put(key, new ArrayList<V>());
		} 
		hashMapList.get(key).add(valueElement);
	}
	
	public void put(K key, ArrayList<V> value) {
		hashMapList.put(key, value);
	}
	
	public ArrayList<V> get(K key) {
		return hashMapList.get(key);
	}
	
	public boolean containsKey(K key) {
		return hashMapList.containsKey(key);
	}
	
	//用理想的狀況順利執行此method( 有list, 且list 有該element)
	//然後, 用不順利的情況來寫if statement/ impl ( 沒key, 有key 沒list, 有key 有list 沒elt)
	//不過, 我們沒有 "有key沒有list的情形"
	public boolean containsKeyValueElement(K key, V valueElement) {
		
		if(hashMapList.containsKey(key) == false)
			return false;
		
		return hashMapList.get(key).contains(valueElement);
		
	}
	
	public Set<K> keySet(){
		return hashMapList.keySet();
	}
	
	@Override
	public String toString() {
		return hashMapList.toString();
	}
	
}
