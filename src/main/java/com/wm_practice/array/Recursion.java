package com.wm_practice.array;

/*
 * Program: Sample recursive program
 * 
 * Algorithm : method invoke itself 
 * 
 * Time Complexity : O(n)
 * 
 * Auxilary Space : O(n)
 * 
 * Notes:
 * try to find O(1)
 */

public class Recursion {

static int n1=0,n2=1,n3=0;

	public static int printFact(int n) {
	
	if(n==0)
		return 1;
	else
    return(n * printFact(n-1));    
	}
	public static void printFib(int n) {
		if(n>0) {
			n3=n2+n1;
			n1=n2;
			n2=n3;
			System.out.println(" "+n3);
			printFib(n-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//.printFact(10);
		int fact = printFact(5);   
		  System.out.println("Factorial of "+5+" is: "+fact);    
		  System.out.print(n1+" "+n2);
		  printFib(5);

	}

}
