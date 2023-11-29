package com.wm_practice.utill;

import java.util.Objects;

public class Entry<K, V> {

	private K key;
	private V value;
	private Entry<K,V> next;
	
	public Entry(K key, V value, Entry<K, V> next) {
		this.key=key;
		this.value=value;
		this.next=next;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Entry<K, V> getNext() {
		return next;
	}

	public void setNext(Entry<K, V> next) {
		this.next = next;
	}

	@Override
	public int hashCode() {
		return Objects.hash(key, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entry other = (Entry) obj;
		return Objects.equals(key, other.key) && Objects.equals(value, other.value);
	}
	
	
}
