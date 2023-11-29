package com.wm_practice.twoDarray;

/**
 * Problem:
 * Given a binary matrix mat[][] of dimensions NxM such that 1 denotes land and 0 denotes water. 
 * Find the number of closed islands in the given matrix.
 * 
 * ref:
 * https://practice.geeksforgeeks.org/problems/find-number-of-closed-islands/1/#
 * 
 * 
 * Solution ref:
 * 
 * video: Michael Vandi - Number of Closed Island | LeetCode 1254
 *
 */
public class FindIsalandSourroundedByWater {

	static  boolean isClosed(int[][] M, int i, int j)
	    {
	        
	        // Base condition
	        // if i less than 0 or j less than 0 or i greater than ROW-1 or j greater than COL-  or if M[i][j] != 1 then we will simply return
	        if (i < 0|| j < 0 || i >= M.length || j >= M[i].length)
	        {
	            return false;
	        }
	        if(M[i][j]==0) return true;
	        
	        M[i][j]=0;
	        
	        boolean bottom = isClosed(M,i+1,j); // bottom
	         boolean up = isClosed(M,i-1,j); // up
	        boolean right = isClosed(M,i,j+1); // right

	           boolean left = isClosed(M,i,j-1); // left
	           
	           return bottom && up && right && left;

	    }
	   
	    static  int closedIslands(int[][] M ,int r, int c)
	    {
	     
	        int count = 0;
	        for (int i = 0; i < r; i++)
	        {
	            for (int j = 0; j < c; j++)
	            {
	                if(M[i][j]==1){
	                   boolean closed= isClosed(M,i,j);
	                    if(closed)
	                    count++;
	                }
	                
	            }
	        }
	        return count;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   int[][] M = {{0, 0, 0, 0, 0, 0, 0, 1}, 
		           {0, 1, 1, 1, 1, 0, 0, 1}, 
		           {0, 1, 0, 1, 0, 0, 0, 1}, 
		           {0, 1, 1, 1, 1, 0, 1, 0}, 
		           {0, 0, 0, 0, 0, 0, 0, 1}} ;
	   
	        System.out.print("Number of islands is: " + closedIslands(M,M.length,M[0].length));

	}

}
