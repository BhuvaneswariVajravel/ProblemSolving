package com.wm_practice.string;

/*
 * Program: 14.	Given a String S="[{(})[]" , find out whether it contains valid paranthesis or not
 * 
 * Agorithom : if open paranthesis found push into stack if closed paranthesis found peek from stack
 * 
 * Time Complexity : O(n)
 * 
 * Auxilary space: O(n) - for stack
 * 
 *
 */

import java.util.*;

public class checkParenthesis {

	static boolean checkBrackets(String str)
	{
	    Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++)
		{
			char x = str.charAt(i);

			if (x == '(' || x == '[' || x == '{')
			{
				stack.push(x);
				continue;
			}

			if (stack.isEmpty())
				return false;
			
			char check;
			
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		return (stack.isEmpty());
	}

	public static void main(String[] args)
	{
		String expr = "[{(})[]]";

		if (checkBrackets(expr))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
	}
}
