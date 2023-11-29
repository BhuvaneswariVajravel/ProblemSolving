package com.wm_practice.array;

import java.util.Arrays;
import java.util.List;

/*
 * Program: Sort Array
 * 
 * Agorithom
 * 
 * Time Complexity
 * 
 * Space Complexity
 * 
 * Notes:
 * Arrays.sort time complexity is O(nlogn)
 */

public class SortArray {
	public static void sortArray(int a[], int n) {

		for (int i = 0; i < n - 1; i++) {
			System.out.println("===i===" + i + "===a[i]===" + a[i]);
			if (a[i] > a[i + 1]) {
				int temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
				i = -1;
			}
		}

		System.out.print("[ ");
		for (int i = 0; i < n - 1; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("]");

	}

	public static void main(String[] args) {

		int arr[] = { 10, 9, 8, 7, 6, 3 };
		int n = arr.length;
		sortArray(arr, n);
		List<int[]> list = Arrays.asList(arr);
		list.forEach(System.out::println);
	}
}
