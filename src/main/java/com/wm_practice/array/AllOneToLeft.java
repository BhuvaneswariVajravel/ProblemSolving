package com.wm_practice.array;

/*
 * Program: Move all the 1's to the left in binary/or any  array
 * 
 * Algorithm
 * 
 * Time Complexity : O(n)
 * 
 * Auxilary Space : O(1)
 */

/**
 * Logic:
 * First we are iterating the array and initialize count =n-1 check if a[i]!=1 
 * if it true then store a[i] in a[count--] which is store the a[i] which is 
 * not equal to 1 in a[count] and decrement count value . so that all the value 
 * not equal to 1 move to right side 
 * 
 *  after that we can store 1 in a[count] untill count become >=0.
 *  
 *  
 *  if we want to move 1's t right side we can start count as 0 and start the array 
 *  from 0 and store a[i] in a[count++]
 *
 */
public class AllOneToLeft {

	public static void pushOneToLeft(int[] arr, int n) {
		int count=n-1;
		for(int i =n-1;i>=1;i--) {
			//System.out.println("===i==="+i+"==="+arr[i]+"===count=="+count+"===  a[count]="+arr[count]);
			if(arr[i]!=1) {
				arr[count]=arr[i];
				count--;
				//System.out.println("====="+arr[count]);
			}
		}
		System.out.println("\n===before count");
		 for (int i=0; i<n; i++)
	            System.out.print(arr[i]+" ");
		 while(count>=0) 
			arr[count--]=1;
		
	}
	public static void pushOneToRight(int[] a,int n) {
		int c=0;
		for(int i=0;i<n;i++) {
			if(a[i]!=1) {
				a[c++]=a[i];
			}
		}
		while(c<n)
			a[c++]=1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,1,1,2,2,1,3,2,1};
        int n = arr.length;
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
        pushOneToLeft(arr, n);
        System.out.println("\nArray after pushing ones to the left: ");
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
        int a[]= {1,1,5,1,6,3,4,51,6,7,1,3,4,5};
        pushOneToRight(a,a.length);
        System.out.println("\nArray after pushing ones to the right: ");
        for (int i=0; i<a.length; i++)
            System.out.print(a[i]+" ");

	}

}
