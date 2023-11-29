package com.wm_practice.array;

import java.util.HashMap;
import java.util.Map;
/*
 * Program:
 * 
 * Algorithm
 * 
 * Time Complexity
 * 
 * Auxilary Space 
 */
public class Test {
    public static void leastFreq(int a[],int n){
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : a){
            int key = i;
            if(map.containsKey(i))
                map.put(key,map.get(key)+1);
            else
                map.put(key,1);
        }
        		System.out.println(map);

  int min_count = n+1, res = -1;
        for(Map.Entry<Integer,Integer> val : map.entrySet())
        {
            if (min_count >= val.getValue())
            {
                res = val.getKey();
                min_count = val.getValue();
                		System.out.println(res);

            }
        }
 
        }
	public static void main (String[] args) {
	
		int arr[] = {1,2,2,1,3,4,3,4,4};
		int n=8;
		leastFreq(arr,n);
		
	}
}

