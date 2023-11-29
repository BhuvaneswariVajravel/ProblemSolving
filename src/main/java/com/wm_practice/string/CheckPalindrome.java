package com.wm_practice.string;

/*
 * Program: Check Palindrome or not
 * 
 * Algorithm : iterate array and compare both end character 
 * 
 * Time Complexity : O(n)
 * 
 * Auxilary Space : O(1)
 */

public class CheckPalindrome {

	public static void main(String[] args) {

		String str = "radar";
		boolean count = true;

		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				count = false;
				break;
			}
		}
		if (count)
			System.out.println(" given string " + str + " is palindrome");
		else
			System.out.println(" given string " + str + " is not a palindrome");

	}

}
