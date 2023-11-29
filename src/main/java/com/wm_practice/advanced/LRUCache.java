package com.wm_practice.advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * Least Recently Used Cache - LRU cahce implementation
 * 
 * The Least Recently Used (LRU) cache is a cache eviction algorithm that
 * organizes elements in order of use. In LRU, as the name suggests, the element
 * that hasn't been used for the longest time will be evicted from the cache.
 *
 * Notes: All operations should run in order of O(1) The cache has a limited
 * size If the cache is full, adding a new item must invoke the LRU strategy
 *
 * the LRU cache is nothing but a combination of the DoublyLinkedList and the
 * HashMap as using hashmap we can retrive data in constant time deletion can be
 * done quickly in doubly linked list
 *
 *
 *
 * Algorithm the LRU algorithm is pretty easy! If the key is present in HashMap,
 * it's a cache hit; else, it's a cache miss.
 *
 * We'll follow two steps after a cache miss occurs: Add a new element in front
 * of the list. Add a new entry in HashMap and refer to the head of the list.
 *
 * And, we'll do two steps after a cache hit: Remove the hit element and add it
 * in front of the list. Update HashMap with a new reference to the front of the
 * list.
 *
 *
 */

public class LRUCache {

	class Node {

		int key;
		int value;
		Node pre;
		Node next;

		Node(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}
	}

	private Map<Integer, Node> map;
	private int capacity, count;
	private Node head, tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<Integer, Node>();
		this.head = new Node(0, 0);
		this.tail = new Node(0, 0);
		head.next = tail;
		tail.pre = head;
		head.pre = null;
		tail.next = null;
	}

	public int get(int key) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			int value = node.value;
			deleteNode(node);
			addToHead(node);
			return value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			node.value = value;
			deleteNode(node);
			addToHead(node);
		} else {
			Node node = new Node(key, value);
			map.put(key, node);
			if (count < capacity) {
				count++;
				addToHead(node);
			} else {

				map.remove(tail.pre.key);
				deleteNode(tail.pre);
				addToHead(node);
			}
		}
	}

	private void deleteNode(Node node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	private void addToHead(Node node) {
		node.next = head.next;
		node.next.pre = node;
		node.pre = head;
		head.next = node;
	}

	public void display() {
		for(Entry<Integer, Node> entry : map.entrySet()) {
			System.out.print("["+entry.getKey()+" , "+entry.getValue().value+"] ");
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
		cache.put(1, 10);
		cache.put(2, 20);
		System.out.println("value of key is " + cache.get(1));
		cache.put(3, 30);
		cache.put(4, 40);
		cache.put(3, 50);
		cache.put(7, 70);
		cache.put(8, 80);
		cache.put(9, 90);

		cache.display();
	}

}
