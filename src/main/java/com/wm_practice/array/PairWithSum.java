package com.wm_practice.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Program: Find pair of of elements in Array with given sum
 * 
 * Agorithom :  add the integer in hashset while traversing
 * each time check whether the ( sum - integer ) available in set or not  
 * 
 *Time Complexity: O(n). 
 * As the whole array is needed to be traversed only once.
 *
 *Auxiliary Space: O(n). 
 *A hash map has been used to store array elements.
 * 
 * Notes:
 *need to find w/o collection
 */

public class PairWithSum {
	public static List<List<Integer>> printpairs(int arr[], int sum) {
		List<List<Integer>> pairs = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		System.out.println("Pair with given sum " + sum + " is ");
		for (int i = 0; i < arr.length; i++) {
			int r = sum - arr[i];
			if (set.contains(r)) {
				List<Integer> pair = new ArrayList<Integer>();
				pair.add(r);
				pair.add(arr[i]);
				pairs.add(pair);
			} else
				set.add(arr[i]);
		}
		return pairs;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 4, 2, 6, 10, 3 };
		int sum = 5;
		System.out.println(printpairs(arr, sum));
	}
}
