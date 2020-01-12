package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

//20191219(Thur
//visualize:
// ����h���Y: 
//1. key to value(list
//2. list to element
//�]��, �����naccess element���e, �o���߰ݦ��S��list ���s�b
//���M, �|�ǤUnullPointerException�����~
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
		
		//�ڻ{���o�qcode���O�@��i�X, �O�n�g�L�W����code����; �~�|�F��o�ӹҬ�
		//��complete logic�Aconcise code
		//���ҥ����O�@�B���, ���H�~�ɥH���o�O�`�H�i�H���쪺
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
	
	//�βz�Q�����p���Q���榹method( ��list, �Blist ����element)
	//�M��, �Τ����Q�����p�Ӽgif statement/ impl ( �Skey, ��key �Slist, ��key ��list �Selt)
	//���L, �ڭ̨S�� "��key�S��list������"
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
