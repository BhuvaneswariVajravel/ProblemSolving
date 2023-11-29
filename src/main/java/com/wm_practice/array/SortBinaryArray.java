package com.wm_practice.array;

/*
 * Program: Move all the 1's to the left, without changing the order of other elements or binary search
 * 
 * Algorithm
 * 
 * Time Complexity : O(n)
 * 
 * Auxilary Space : O(1)
 */

public class SortBinaryArray {

	public static void pushZerosToLeftWithVariable(int[] arr, int n) {
		int j = -1;

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				j++;
				int t = arr[j];
				arr[j] = arr[i];
				arr[i] = t;
			}
		}
	}

	public static void pushZerosToLeft(int[] arr, int n) {
		int count = n - 1;
		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] != 0) {
				arr[count--] = arr[i];
			}
		}
		while (count >= 0)
			arr[count--] = 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1 };
		int n = arr.length;
		pushZerosToLeft(arr, n);
		
		System.out.println("Sol 1: Array after pushing zeros to the left: ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");

		pushZerosToLeftWithVariable(arr, n);

		System.out.println("\n\nSol 2 Array after pushing zeros to the left: ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

}
