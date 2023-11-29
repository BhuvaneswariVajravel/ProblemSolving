package com.wm_practice.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Program: Sort the list by number of occurrence of the element
 * 
 * Algorithm : sort using the hashmap ,  array list 
 * 
 * Time Complexity : O(n) 
 * 
 * Auxilary Space : O(n) for hash map ,list
 * 
 * Notes: try to find w/o collection
 */

public class sortArrayByFrequency {

	public static void sortArrayElementsByFrequency(int[] inputArray) {

		Map<Integer, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < inputArray.length; i++) {

			map.put(inputArray[i], map.getOrDefault(inputArray[i], 0) + 1);

		}
		List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

		Collections.sort(list, (l1, l2) -> l1.getValue().compareTo(l2.getValue()));
		System.out.print("[ ");
		list.forEach(l -> {
			int freq = l.getValue();
			while (freq >= 1) {
				System.out.print(l.getKey() + " ");
				freq--;
			}
		});
		System.out.print("]");

	}

	public static void main(String[] args) {
		sortArrayElementsByFrequency(new int[] { 7, 1, 4, 7, 1, 7, 1, 4, 5 });
	}

}
