package com.wm_practice.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.*;
import java.util.stream.Collectors;

/*
 * Program: Remove duplicate value from an array without using internal function
 * 
 * Algorithm
 * 
 * Time Complexity : O(n) (need to check time complexity for backtracking sorting)
 * 
 * Auxilary Space : O(1)
 * 
 * Notes:
 * we can use hashset, hashmap, stream().distinct() to remove duplicates
 * but that time auxilary space will be increase from O(1)
 * 
 * if we use Arrays.sort()- time complexity increased from O(n) to O(nlogn)
 */

public class RemoveDuplicates {
	
	public static void removeDuplicates(int[] arr, int n) {
		
		int j=0;
		for(int i=0;i<n-1;i++) {
			if(arr[i]!=arr[i+1]) {
				arr[j++]=arr[i];
			}
		}
		arr[j++]=arr[n-1];
				
		printArray(arr,j);
	}
	
	public static void printArray(int[] arr, int j) {
		System.out.print("[ ");
		for(int i =0;i<j;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.print("]");
	}
	public static int[] sortArray(int[] a, int n) {
	   for(int i=0;i<n-1;i++){
	       if(a[i]>a[i+1]){
	           int temp= a[i];
	           a[i]=a[i+1];
	           a[i+1]=temp;
	           i=-1;
	       }
	   }
		printArray(a,n);

	   return a;
	}
	public static void removeDuplicateUsingStream(int[]arr, int n) {
		
	       int[] res= Arrays.stream(arr).distinct().toArray();
	          Arrays.stream(res).forEach(System.out::print);
	          
	          Arrays.stream(arr).distinct().forEach(System.out::println);

	}
	public static void removeDupUsingCollection(int[]arr) {
		Set<Integer> s =new HashSet<>();
		for(int i =0;i<arr.length;i++) {
			s.add(arr[i]);
		}
		
	}
	public static void main(String[] args) {
		int arr[] = {7, 1, 7, 3, 1, 7, 1, 4, 4, 1};
		int n= arr.length;
		removeDuplicates(sortArray(arr,n),n);
		
		removeDuplicateUsingStream(arr,n); // aux space - O(n)
	}

}
