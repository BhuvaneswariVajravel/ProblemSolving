package com.wm_practice.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Program:Find the second repeted element in array
 * 
 * Algorithm
 * 
 * Time Complexity : O(n)
 * 
 * Auxilary Space :O(n)
 * 
 * Note 
 * try to find solution without collection 
 */
public class SecondDuplicate {
	public static void findDuplicate(int a[], int n) {

		Set<Integer> set = new HashSet<>();
		int min = -1;
		int sMin =-1;
		for (int i = a.length - 1; i >= 0; i--) {
			if (set.contains(a[i])) {
				sMin=min;
				min = i;
			}
			else
				set.add(a[i]);
		}

		if (sMin == -1)
			System.out.println("==there is no duplicate===");
		else
			System.out.println("===second repeted element is ====" + a[sMin]);

	}

	public static void main(String[] args) {

		int arr[] = {2, 1, 2, 2, 1, 3, 4, 3, 4, 4 };
		int n = arr.length;
		findDuplicate(arr, n);

	}
}
