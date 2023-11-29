 package com.wm_practice.array;

/*
 * Program: find the third largest number
 * 
 * Algorithm : iterate array and compare with first, second, third variable
 * 
 * Time Complexity : O(n)
 * 
 * Auxilary Space : O(1)
 */

public class ThirdLargestNumber {

	public static void largeNumber(int[] arr) {
		int first = 0,second = 0,third=0;
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");

			if(arr[i]>first) {
				third=second;
				second=first;
				first=arr[i];
			}else if(arr[i]>second) {
				third=second;
				second=arr[i];
			}else if(arr[i]>third) {
				third=arr[i];
			}
		}		
		System.out.println("third largest number is ==="+third);
	}
	public static void main(String[] args) {

		int arr[] = {9,8,1,2,3,1,3,7,6};

		largeNumber(arr);
	}

}
