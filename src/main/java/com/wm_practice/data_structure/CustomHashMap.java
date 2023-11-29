package com.wm_practice.data_structure;

import com.wm_practice.utill.Entry;

public class CustomHashMap<K, V> {

	private int capacity = 16;
	private Entry<K, V>[] table;

	public CustomHashMap() {
		table = new Entry[capacity];
	}

	public CustomHashMap(int capacity) {
		this.capacity = capacity;
		table = new Entry[capacity];

	}

	/**
	 * custom put method
	 * 
	 * The put() method accepts key and value as parameters. HashMap allows one null
	 * key and multiple null values. Whenever there is no value present at a
	 * particular index, we will directly place the Entry object at that index.
	 * Else, we will traverse the LinkedList until we reach the last entry of the
	 * list and place the new entry object as the next node of the last entry
	 * object. In the process, if we find the key already exists then we simply
	 * replace its value with the new one.
	 * 
	 * TimeComplexity
	 * 
	 */
	public V put(K key, V value) {
		int index = getIndex(key);
		V val = null;
		Entry newEntry = new Entry(key, value, null);
		if (table[index] == null)
			table[index] = newEntry;
		else {
			System.out.println("====key=="+key);
			Entry<K,V> prev = null;
			Entry<K,V> curr = table[index];
			while (curr != null) {
				System.out.println("====new entry=="+newEntry.getKey());

				if (curr.getKey().equals(key)) {
					val =curr.getValue();
					curr.setValue(value);
					break;
				}
				prev = curr;
				curr = curr.getNext();
			}
			if (prev != null)
				prev.setNext(newEntry);
		}

		return val;
	}

	public V get(K key) {
		V value=null;
		int index=getIndex(key);
		Entry<K,V> curr = table[index];
		while(curr!=null) {
			if(curr.getKey().equals(key)) {
				value=curr.getValue();
				break;
			}
			curr=curr.getNext();
		}
		return value;
	}
	
	public void remove(K key) {
		int index=getIndex(key);
		Entry<K,V> entry = table[index];
		Entry<K,V> prev = null;
		
		while(entry!=null) {
			if(entry.getKey().equals(key)) {
				if(prev==null) {
					entry=entry.getNext();
					table[index]= entry;
					return;
				}else {
					prev.setNext(entry.getNext());
					return;
				}
			}
			prev=entry;
			entry=entry.getNext();
		}
	}
	
	public void display() {
		System.out.print("[");
		for(int i =0;i< capacity;i++) {
			if(table[i]!=null) {
			Entry<K,V> curr= table[i];			
			while(curr!=null) {
				System.out.print("("+curr.getKey()+","+curr.getValue()+"),");
				curr=curr.getNext();
			}			
			}			
		}
		System.out.print("]");
		System.out.println();

	}
	
	private int getIndex(K key) {
		if (key == null) {
			return 0;
		}
		int index = Math.abs(key.hashCode() % capacity);
		return index;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomHashMap<Integer, String> map = new CustomHashMap<Integer, String>();
		System.out.println("Going to add entries in map");
		map.put(null, "NA");
		map.put(1, "ETC");
		map.put(2, "John");
		System.out.println("Displaying all the entry in map");
		map.display();
		System.out.println("Removing the entry with key 2");
		map.remove(2);
		map.display();
		System.out.println("Adding duplicate key 1 in map");
		map.put(1, "CSE");
		map.put(2, "John again");
		System.out.println("Displaying all the entry in map again");
		map.display();
		System.out.println("Adding entry with key 17 in map");
		map.put(17, "CS");
		map.display();
		String s2=new String("hiii");
		String s1 =new String("hiii");

		if(s1.hashCode()==s2.hashCode())
			System.out.println("===trie"+s1.hashCode()+" =====  "+s2.hashCode() );
		else
			System.out.println("===false");

	}

}
