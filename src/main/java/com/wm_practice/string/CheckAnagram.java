package com.wm_practice.string;

import java.util.HashMap;
import java.util.Map;

/*
 * Program: Check Anagram or not
 * 
 * Algorithm : iterate string and store first array in hashmap and remove second array from map 
 * 
 * Time Complexity : O(n)
 * 
 * Auxilary Space : O(n) -> hashmap
 */

public class CheckAnagram {

	public static boolean checkAnagram(String str1, String str2) {

		if (str1.length() != str2.length()) {
			return false;
		} else {
			Map<Character, Integer> map = new HashMap<>();

			for (int i = 0; i < str1.length(); i++) {
				char key = str1.charAt(i);
				if (map.containsKey(key))
					map.put(key, map.get(key) + 1);
				else
					map.put(key, 1);
			}
			
			for (int j = 0; j < str2.length(); j++) {
				char key = str2.charAt(j);
				if(map.containsKey(key))
					map.put((char) key,map.get(key)-1);				
			}
			  for (Character key : map.keySet()) {
		            if (map.get(key) != 0) {
		                return false;
		            }
		        }
		}
		return true;

	}

	public static void main(String[] args) {

		String str1 = "radar";
		String str2 = "darar";

		boolean flag = checkAnagram(str1, str2);
if(flag)
	System.out.println("===given two strings are anagram====");
else
	System.out.println("===given two strings are not anagram");

	}

}
