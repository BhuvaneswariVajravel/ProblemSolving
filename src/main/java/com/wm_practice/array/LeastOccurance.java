package com.wm_practice.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Program: Find First number with least occurrence
 * 
 * Algorithm: while iterating array adding element into hashmap, find first duplicate using first variable
 * 
 * Time Complexity : O(n)
 * 
 * Auxilary Space O(n)
 * 
 * Notes
 * need to find w/o collection
 */
public class LeastOccurance {

	public static void leastFreq(int a[], int n) {

		Map<Integer, Integer> map = new LinkedHashMap<>();
		int first = n;
		for (int i : a) {
			int key = i;
//			if (map.containsKey(key)) {
//				map.put(key, map.get(key) + 1);
//				
//			} else
//				map.put(key, 1);
			map.put(key,map.getOrDefault(key, 0)+1);
		}
		System.out.println(map);

		int prevkey=a[0];
		int prevValue=map.get(prevkey);
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			if(entry.getValue()<prevValue && entry.getValue()!=1) {
				prevkey=entry.getKey();
				prevValue=entry.getValue();
			}
		}

			System.out.println("===least occured repeted element===="+prevkey);
	}

	public static void main(String[] args) {
		int arr[] = { 3,2,1,3, 2,5, 1, 3, 4,  4, 4 };
		int n = arr.length;
		leastFreq(arr, n);

	}

}
