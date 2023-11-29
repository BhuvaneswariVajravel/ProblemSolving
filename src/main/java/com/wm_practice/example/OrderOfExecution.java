package com.wm_practice.example;

public class OrderOfExecution {


	    public static void myMethod()   
	    {  
	    System.out.println("static Method");  
	    }  
	      
	    {  
	    System.out.println(" Instance Block");  
	    } 
	    OrderOfExecution(){
	                System.out.println("Hello, World!");

	    }
	        static {  
	        System.out.println("static block");  
	    } 
	    public static void main(String[] args) {
	        System.out.println("main method");
            OrderOfExecution ob = new OrderOfExecution();

            OrderOfExecution.myMethod();

	        
	    }
	}