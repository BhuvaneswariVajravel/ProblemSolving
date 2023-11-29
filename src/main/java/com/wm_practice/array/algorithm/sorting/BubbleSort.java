package com.wm_practice.array.algorithm.sorting;

import java.util.Arrays;
import java.util.List;

/*
 * space complexity: O(1)
 * Time complexity : O(n)^2
 */
public class BubbleSort {

	public static void main(String[] args) {
		Integer[] arr ={1,4,5,3,7,6};
		List<Integer> a = Arrays.asList(arr);
		int n=a.size();
		int count=0,swaps=0;
		 for(int i=0;i<n;i++){
			 count =0;
	            for(int j=0;j<n-1;j++){
	                if(a.get(j)>a.get(j+1)){
	                    int temp=a.get(j);
	                    a.set(j,a.get(j+1));
	                    a.set(j+1,temp);
	                    count++;swaps++;
	                }
	            }
	            System.out.println(a+"===count"+count);
	            if(count==0)
	            break;
	        }
		System.out.println(a);
		System.out.println("Array is sorted in "+swaps+" swaps.");		
	}
	
}
