package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

//20191218(Wed
//�p�G�O�ۤv�g����, ���D�b��
//�O���_�ӥ������ӭndeclare and implementation��function
//�]�\, �ڥi�H�ۤv�έ�interface
public class HashMapList<T, E> {

	private HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();
	
	//insert item into list at key
	//�o�Omap�q�ӳ��S�����欰, �O�s�W�X�Ӫ�
	public void put(T key, E item) {
		
		if(!map.containsKey(key)) {
			map.put(key, new ArrayList<E>() );
		}
		map.get(key).add(item);
	}
	
	//insert list of items at key
	//�o�ˬO��L�h��value�����N��; �]�ŦXmap ���欰
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
