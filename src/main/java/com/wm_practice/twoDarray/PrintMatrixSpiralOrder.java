package com.wm_practice.twoDarray;

import java.util.ArrayList;

/**
 * Problem: Spirally traversing a matrix
 * 
 * ref :
 * https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1/
 * 
 * Sol ref : https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 * 
 * 
 * Time Complexity : O(m*n) // try to understand O(n)   logic
 *  Auxilary Space : O(1)
 *
 *
 */
public class PrintMatrixSpiralOrder {

	static ArrayList<Integer> spirallyTraverse(int a[][], int r, int c) {

		ArrayList<Integer> list = new ArrayList<>();
		int i, k = 0, l = 0;

		while (k < r && l < c) {
			for (i = l; i < c; i++) {
				list.add(a[k][i]);
			}
			k++;
			for (i = k; i < r; i++) {
				list.add(a[i][c - 1]);
			}
			c--;
			if (k < r) {
				for (i = c - 1; i >= l; i--) {
					list.add(a[r - 1][i]);
				}
				r--;
			}
			if (l < c) {
				for (i = r - 1; i >= k; i--) {
					list.add(a[i][l]);
				}
				l++;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int R = 4;
		int C = 4;
		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		// Function Call
		System.out.println(spirallyTraverse(a,R, C));
	}

}
