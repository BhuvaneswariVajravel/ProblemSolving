package com.wm_practice.array;

/**
 * 
 * @author Bhuvaneswari.V
 * 
 *         Interview question Q: find all non repeating elements in array
 *         without using collection or java 8
 * 
 *         we can acheive this simply using hashmap
 * 
 *         Solution :
 *         https://takeuforward.org/data-structure/find-all-the-non-repeating-elements-in-an-array/
 *
 */
public class FindUniqueElements {

	public static void printArray(int[] a, int n) {
		System.out.print("[ ");
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]);
			if (i != n - 1)
				System.out.print(",");
		}
		System.out.print("]");
	}

	public static int[] sortArray(int[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			if (a[i] > a[i + 1]) {
				int t = a[i];
				a[i] = a[i + 1];
				a[i + 1] = t;
				i = -1;
			}

		}
		return a;

	}

	public static void findUnique(int[] a, int n) {
		boolean chk;
		System.out.print("[");			
		for (int i = 0; i < n; i++) {
			chk = false;
			for (int j = 0; j < n; j++) {
				if (i != j && a[i] == a[j]) {
					chk = true;
					break;
				}
			}
			if(!chk) {System.out.print(a[i]+" ");
			}
		}
		System.out.print("]");
	}

	public static void main(String[] args) {
		int a[] = { 1, 10, 3, 2, 8, 5, 4, 6,4, 7, 6, 1, 8, 2, 9, 10 };
		//a = sortArray(a, a.length);
		findUnique(a, a.length);

	}
}
