package com.wm_practice.string;


/*
 * Program:Count of strings where adjacent characters are of difference one 
 * 
 * Algorithm
 * 
 * Time Complexity : O(n^2)
 * 
 * Auxilary Space 
 */

public class CountString {
	
	static void printArray(long[][] dp, int n) {
		
		System.out.print("[ ");
		  for (int i = 0; i < n + 1; i++)
	        {
	            for (int j = 0; j < 27; j++)
	            {
System.out.print( dp[i][j]+" ");
	            }
	    		System.out.print("]\n[ ");

	        }
	 
	}

	  static long countStrs(int n)
	    {
	        long[][] dp = new long[n + 1][27];
	 
	        for (int i = 0; i < n + 1; i++)
	        {
	            for (int j = 0; j < 27; j++)
	            {
	                dp[i][j] = 0;
	            }
	        }
	 
	        System.out.println("====after - init===");
	        printArray(dp,n);
	        
	        for (int i = 0; i <= 25; i++)
	        {
	            dp[1][i] = 1;
	        }
	        System.out.println("====after - set 1===");

	        printArray(dp,n);

	        for (int i = 2; i <= n; i++)
	        {
	             
	            for (int j = 0; j <= 25; j++) 
	           	            {
	                if (j == 0)
	                {
	    	        	System.out.println("===dp[i - 1][j + 1]===="+dp[i - 1][j + 1]);

	                    dp[i][j] = dp[i - 1][j + 1];
	                }
	                else
	                {
	    	        	System.out.println("=== (dp[i - 1][j - 1]\rdp[i - 1][j + 1])===="+ (dp[i - 1][j - 1]
	                            + dp[i - 1][j + 1]));

	                    dp[i][j] = (dp[i - 1][j - 1]
	                            + dp[i - 1][j + 1]);
	                }
	            }
	        }
	 
	        System.out.println("====after - logic ===");

	        printArray(dp,n);
	        long sum = 0;
	        for (int i = 0; i <= 25; i++)
	        {
	        	//System.out.println("===dp[n][i]===="+dp[n][i]);
	            sum = (sum + dp[n][i]);
	        }
	        return sum;
	    }
	 
	    public static void main(String[] args)
	    {
	        int n = 3;
	        System.out.println("Total strings are : " +
	                                        countStrs(n));
	    }
}
