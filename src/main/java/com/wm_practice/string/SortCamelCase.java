package com.wm_practice.string;

import java.util.Collections;
import java.util.Vector;

public class SortCamelCase {

	static void printArray(char[] ch ,int n) {
		System.out.print("[ ");
		for(int i =0;i<n;i++) {
			System.out.println(ch[i]+" ");
		}
		System.out.println("]");
	}
	public static void camelSort(StringBuilder sb, int n) {
		
		Vector<Character> lower = new Vector<>();
	    Vector<Character> upper = new Vector<>();
		
		for(int i=0;i<n;i++) {
			char c = sb.charAt(i);
			if(c >='a' && c <= 'z')
				lower.add(c);
			else if(c >='A' && c <= 'Z')
				upper.add(c);				
				
		}
		Collections.sort(lower);
		Collections.sort(upper);

		System.out.println(lower);
		System.out.println(upper);
		
	    int i = 0, j = 0;

	    
		for(int k = 0; k < n; k++)
	    {	       
	        if (sb.charAt(k) >='a' &&
	            sb.charAt(k) <= 'z')
	        {
	            sb.setCharAt(k, lower.elementAt(i));
	            ++i;
	        }
	 
	        // Else pick the uppercase character
	        else if (sb.charAt(k) >='A' &&
	                 sb.charAt(k) <= 'Z')
	        {
	            sb.setCharAt(k, upper.elementAt(j));
	            ++j;
	        }
	    }
System.out.println("===string===="+sb.toString());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder("heLloWRolD");
		camelSort(sb, sb.length());
	}

}
