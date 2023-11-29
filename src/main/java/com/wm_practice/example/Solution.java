package com.wm_practice.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	 //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int sum) 
    {
    	  ArrayList<Integer> list = new ArrayList<>();
          // Your code here
          int start=0,currentSum=arr[0];
        for (int i = 1; i <= n; i++) {
              // If currentSum exceeds the sum,
              // then remove the starting elements
      	  System.out.println("===i==="+i+"==start=="+start+"===sum="+sum+"===curr=="+currentSum);

              while (currentSum > sum && start < i - 1) {
                  currentSum = currentSum - arr[start];
                  start++;
              }

   
              // If currentSum becomes equal to sum,
              // then return true
              if (currentSum == sum) {
                  int p = i - 1;
            	  System.out.println("====p===="+p);

                      list.add(start);
                      list.add(p);
                      break;
              }
   
              // Add this element to curr_sum
              if (i < n)
                  currentSum = currentSum + arr[i];
          }
          return list;
    }
    public static void main(String[] args)
    {
        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int n = arr.length;
        int sum = 23;
        System.out.println(Solution.subarraySum(arr, n, sum));
        
        checkString("a i u e o t m n s w");
    }
    
    static void checkString(String s)
    {
        int v=0;
        int c=0;
        
        //Your code here
Set<Character> str = new HashSet<>(5);
str.add('a');
str.add('e');
str.add('i');
str.add('o');
str.add('u');

for(int i=0;i<s.length();i++){
	  char ch=s.charAt(i);
	    if(ch!=' '){
	    if(str.contains(ch))
	    v++;
	    else
	    c++;
	    }
}

        if(v>c)
        System.out.print("Yes");
        else if(c>v)
        System.out.print("No");
        else
       System.out.print("Same");
        
        System.out.println();
    }
}