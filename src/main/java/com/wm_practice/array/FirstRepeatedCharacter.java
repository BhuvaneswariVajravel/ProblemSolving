package com.wm_practice.array;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedCharacter {

	static void findRepeated(String s){
		int l=s.length()-1,min=-1;
		
		Set<Character> set =new HashSet<>();
		for(int i=l;i>=0;i--) {
			if(set.contains(s.charAt(i)))
				min=i;
			else
				set.add(s.charAt(i));
		}
		System.out.println("====first repeated character is =="+s.charAt(min));
	}
	public static void findRepeatWithoutColl(String s) {
		int m=-1;
		int l=s.length();
		for(int i=0;i<l;i++) {
			for(int j=i+1;j<l;j++) {
				if(s.charAt(i)==s.charAt(j)) {
					m=i;
					break;
				}
			}
			if(m>=0) {
				System.out.println("first repeted char is "+s.charAt(m));
				break;
			}
		}
	}
	public static void main(String[] args) {
		String s="cpbapaleb";
		findRepeated(s);
		findRepeatWithoutColl(s);
	}
}
