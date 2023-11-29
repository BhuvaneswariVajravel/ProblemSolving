package com.wm_practice.string;

/*
 * Program:  reverse a string
 * 
 * ref: https://practice.geeksforgeeks.org/problems/reverse-a-string/1/?page=1&difficulty[]=-1&difficulty[]=0&status[]=
 * unsolved&category[]=Arrays&category[]=Strings&sortBy=submissions
 * 
 * Algorithm
 * 
 * Time Complexity: O(n)
 * 
 * Auxilary Space :O(1)
 * 
 * 
 */
public class ReverseString {

	public void reverseByLeft(String str) {
		char[] arr = str.toCharArray();
		int left, right = 0;

		for (left = 0, right = arr.length - 1; left < right; left++, right--) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}
		for (char c : arr) {
			System.out.print(c);
		}
		System.out.println();
	}

	public void reverseWithString(String str) {
		String nstr = "";
		char ch;
		 for (int i=0; i<str.length(); i++)
	      {
	        ch= str.charAt(i); 
	        nstr= ch+nstr; 
	      }
	      System.out.println("Reversed word: "+ nstr);
	}
	
	   public static String reverseWord(String str)
	    {
	        // Reverse the string str
	        
	        StringBuilder sb = new StringBuilder();
	        int l = str.length();
	        
	       for(int i =l-1;i>-1;i--){
	           sb.append(str.charAt(i));
	        }
	        return sb.toString();
	    }
	   

	public static void main(String[] args) {

		String str = " Hello World";

		ReverseString rs = new ReverseString();

		rs.reverseByLeft(str);
		rs.reverseWithString(str);
System.out.println(reverseWord(str));
	}
}
